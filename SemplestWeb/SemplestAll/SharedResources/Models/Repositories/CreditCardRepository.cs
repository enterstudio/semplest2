using System;
using Semplest.SharedResources.Services;
using SemplestModel;
using SharedResources.Helpers;

namespace SharedResources.Models.Repositories
{
    public class CreditCardRepository : ICreditCardRepository
    {
        private readonly SemplestModel.Semplest _dbcontext;

        public CreditCardRepository(SemplestModel.Semplest dbcontext)
        {
            _dbcontext = dbcontext;
        }

        public ReturnState ChargeCreditCard(CustomerObject co, Promotion promo, int payTypeFk, decimal budget)
        {
            var sw = new ServiceClientWrapper();
            var gr = sw.CreateProfile(co);
            if (gr != null && gr.isGood && !gr.isError)
            {
                var refNum = gr.CustomerRefNum;
                gr = sw.AuthorizeAndCapture(refNum, double.Parse(budget.ToString()));
                if (gr != null && gr.isApproved && !gr.isError && gr.ResponseCode == "00")
                {
                    var tr = new TransactionRepository(_dbcontext);
                    var amount = decimal.Parse(gr.amountRedeemedNoDecimal);
                    var cp =
                        _dbcontext.CreditCardProfiles.Add(new CreditCardProfile
                                                              {
                                                                  CustomerRefNum = refNum,
                                                                  CustomerFK = promo.ProductGroup.CustomerFK
                                                              });
                    var tran = _dbcontext.Transactions.Add(new Transaction
                                                               {
                                                                   CreatedDate = DateTime.Now,
                                                                   Amount = amount,
                                                                   CreditCardProfileFK = cp.CreditCardProfilePK,
                                                                   AuthCode = gr.AuthCode,
                                                                   TxRefNum = gr.TxRefNum
                                                               });
                    tran.SemplestTransactions.Add(new SemplestTransaction
                                                      {
                                                          CreatedDate = DateTime.Now,
                                                          Amount = amount,
                                                          TransactionTypeFK = tr.GetTransactionTypeCode("MediaSpend")
                                                      });
                    promo.RemainingBudgetInCycle += amount;
                    promo.StartBudgetInCycle += amount;
                    promo.CreditCardProfileFK = cp.CreditCardProfilePK;
                    _dbcontext.PromotionBudgets.Add(new PromotionBudget
                                                        {
                                                            TransactionsFK = tran.TransactionsPK,
                                                            PromotionFK = promo.PromotionPK,
                                                            BudgetCarryOverAmount = 0,
                                                            BudgetToAddAmount = amount,
                                                            BudgetToAddDate = DateTime.Now,
                                                            CreatedDate = DateTime.Now,
                                                            IsValid = true,
                                                            IsAppliedToPromotion = true
                                                        });
                }
                else
                {
                    return gr == null ? new ReturnState(true, false, "Server Exception", null) : new ReturnState(true, true, gr.Message, null);
                }
            }
            else
            {
                return gr == null ? new ReturnState(true, false, "Server Exception", null) : new ReturnState(true, true, "Card Declined", null);
            }
            return new ReturnState(false, false, string.Empty, null);
        }
    }
}