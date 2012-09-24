using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Semplest.SharedResources.Services;
using SemplestModel;

namespace SharedResources.Models.Repositories
{
    public class CreditCardRepository : ICreditCardRepository
    {
        private readonly SemplestModel.Semplest _dbcontext;

        public CreditCardRepository(SemplestModel.Semplest dbcontext)
        {
            _dbcontext = dbcontext;
        }

        public bool ChargeCreditCard(CustomerObject co, int customerFk, int payTypeFk)
        {
            var sw = new ServiceClientWrapper();
            var gr = sw.CreateProfile(co);
            if (gr.isGood && !gr.isError)
            {
                _dbcontext.CreditCardProfiles.Add(new CreditCardProfile {CustomerRefNum = gr.CustomerRefNum});
                gr = sw.AuthorizeAndCapture(gr.CustomerRefNum, 1000);
                if (gr.isApproved && !gr.isDeclined)
                {
                    var tran = _dbcontext.Transactions.Add(new Transaction
                                                               {
                                                                   CreatedDate = DateTime.Now,
                                                                   Amount = decimal.Parse(gr.amountRedeemedNoDecimal),
                                                                   TransactionTypeFK = 1,
                                                                   PayTypeFK = payTypeFk,
                                                                   CustomerFK = customerFk
                                                               });
                    tran.SemplestTransactions.Add(new SemplestTransaction
                                                      {CreatedDate = DateTime.Now, Amount = 1, TransactionTypeFK = 1});
                    tran.SemplestTransactions.Add(new SemplestTransaction
                                                      {CreatedDate = DateTime.Now, Amount = 1, TransactionTypeFK = 2});
                }
            }
            return true;
        }
    }
}