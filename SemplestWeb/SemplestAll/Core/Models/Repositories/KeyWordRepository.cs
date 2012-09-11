using System;
using System.Collections.Generic;
using System.Linq;
using Semplest.SharedResources.Services;
using SemplestModel;
using System.Data.SqlClient;
using System.Data;
using System.Data.Entity.Infrastructure;


namespace Semplest.Core.Models.Repositories
{
    public class KeyWordRepository : IKeyWordRepository
    {
        private readonly SemplestModel.Semplest _dbcontext;

        public KeyWordRepository(SemplestModel.Semplest dbcontext)
        {
            _dbcontext = dbcontext;
        }

        public List<CampaignSetupModel.KeywordsModel> SaveNegativeKeywords(SmartWordSetupModel model, int customerFk, Promotion promo)
        {
            if (model.NegativeKeywords.Any())
            {
                //GoogleViolation[] gv = ValidateGoogleNegativeKeywords(model.AdModelProp.NegativeKeywords);
                //if (gv.Length > 0)
                //    throw new Exception(gv.First().shortFieldPath + ": " + gv.First().errorMessage);
            }
                if (!promo.IsLaunched)
                { RefreshKeywords(model, promo); }
                else
                {
                    var addKiops = new List<KeywordIdRemoveOppositePair>();
                    var addNewKiops = new List<string>();
                    var addDeletedKiops = new List<int>();
                    var qpka = promo.PromotionKeywordAssociations.ToList();
                    //check negative keywords that have been added to the gui
                    if (model.NegativeKeywords != null)
                    {
                        foreach (string negativeKeyword in model.NegativeKeywords)
                        {
                            var kiop = new KeywordIdRemoveOppositePair();
                            var pka = qpka.SingleOrDefault(key => key.Keyword.Keyword1 == negativeKeyword);
                            if (pka != null)
                            {
                                //means if the keyword existied and was positive it needs to be removed and added as a negative. 
                                //if the keyword is already negative then do nothing because we've already added it
                                kiop.keywordId = pka.KeywordFK;
                                if (!pka.IsNegative)
                                {
                                    kiop.removeOpposite = true;
                                    addKiops.Add(kiop);
                                }
                            }
                            else
                            {
                                var kw = _dbcontext.Keywords.SingleOrDefault(key => key.Keyword1 == negativeKeyword);
                                if (kw != null)
                                {
                                    kiop.keywordId = kw.KeywordPK;
                                    kiop.removeOpposite = false;
                                    addKiops.Add(kiop);
                                }
                                else//this keyword doesn't exist in the database so when we call the stored proc get the id so it can be sent to the api
                                    addNewKiops.Add(negativeKeyword);
                            }
                        }
                    }

                    //check for negative keywords that have been removed from the gui
                    foreach (PromotionKeywordAssociation k in qpka.Where(key => key.IsNegative == true).ToList())
                    {
                        if (!model.NegativeKeywords.Contains(k.Keyword.Keyword1))
                            addDeletedKiops.Add(k.Keyword.KeywordPK);
                    }

                    List<int> deletedKeywords = new List<int>();
                    var op = new System.Data.Objects.ObjectParameter("NegativeKeywordID", typeof(int));
                    var op2 = new System.Data.Objects.ObjectParameter("Exists", typeof(int));
                    foreach (string kw in model.NegativeKeywords)
                    {
                        //keywords that need to be deleted
                        var snr = _dbcontext.SetNegativeKeyword(kw, promo.PromotionPK, op, op2).ToList();
                        if (snr.Any())
                        {
                            deletedKeywords.AddRange(snr.Select(ids => ids.KeywordPK));
                        }

                        if (!string.IsNullOrEmpty(op.Value.ToString()))
                        {
                            var kop = new KeywordIdRemoveOppositePair { keywordId = int.Parse(op.Value.ToString()), removeOpposite = bool.Parse(op2.Value.ToString()) };
                            addKiops.Add(kop);
                        }
                    }
                    foreach (int dk in addDeletedKiops)
                        promo.PromotionKeywordAssociations.Single(kw => kw.KeywordFK == dk).IsDeleted = true;
                    _dbcontext.SaveChanges();
                    var sw = new ServiceClientWrapper();
                    var adEngines = new List<string>();
                    adEngines.AddRange(
                        promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    if (addDeletedKiops.Any())
                        sw.DeleteNegativeKeywords(promo.PromotionPK, addDeletedKiops, adEngines);
                    if (addKiops.Any())
                        sw.AddNegativeKeywords(promo.PromotionPK, addKiops, adEngines);
                    if (deletedKeywords.Any())
                        sw.DeleteKeywords(promo.PromotionPK, deletedKeywords, adEngines);
                }
                model.AllKeywords.Clear();
                model.AllKeywords.AddRange(
                    promo.PromotionKeywordAssociations.Where(key => !key.IsDeleted && !key.IsNegative).Select(
                        key =>
                        new CampaignSetupModel.KeywordsModel { Name = key.Keyword.Keyword1, Id = key.Keyword.KeywordPK }));
            return model.AllKeywords;
        }

        public void SetKeywordsDeleted(List<int> keywordIds, int promoId)
        {
            foreach (int keywordId in keywordIds)
                _dbcontext.PromotionKeywordAssociations.Where(key => key.KeywordFK == keywordId).First(
                    key => key.PromotionFK == promoId).IsDeleted = true;
            _dbcontext.SaveChanges();
        }

        private void RefreshKeywords(SmartWordSetupModel model, Promotion promo)
        {
            IEnumerable<PromotionKeywordAssociation> qry =
                _dbcontext.PromotionKeywordAssociations.Where(key => key.PromotionFK == promo.PromotionPK).ToList();
            var kpos = new List<KeywordProbabilityObject>();
            KeywordProbabilityObject kpo;

            foreach (PromotionKeywordAssociation pka in qry)
            {
                kpo = new KeywordProbabilityObject
                          {
                              keyword = pka.Keyword.Keyword1,
                              semplestProbability =
                                  pka.SemplestProbability == null ? 0 : pka.SemplestProbability.Value,
                              isTargetMSN = pka.IsTargetMSN,
                              isTargetGoogle = pka.IsTargetGoogle,
                              isDeleted = pka.IsDeleted,
                              id = pka.KeywordFK
                          };
                kpos.Add(kpo);
            }
            SaveKeywords(promo.PromotionPK, kpos, model.NegativeKeywords,
                         model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
        }

        private void SaveKeywords(int promotionId, List<KeywordProbabilityObject> kpos, List<string> negativeKeywords,
                                string productGroupName, string promotionName)
        {
            var stationIds = new DataTable();
            stationIds.Columns.Add("Keyword", typeof(string));
            stationIds.Columns.Add("IsActive", typeof(Boolean));
            stationIds.Columns.Add("IsDeleted", typeof(Boolean));
            stationIds.Columns.Add("IsNegative", typeof(Boolean));
            stationIds.Columns.Add("SemplestProbability", typeof(float));
            stationIds.Columns.Add("IsTargetMSN", typeof(Boolean));
            stationIds.Columns.Add("IsTargetGoogle", typeof(Boolean));
            var negativeKeywordsToBeInserted = new List<string>();
            if (negativeKeywords != null)
                negativeKeywordsToBeInserted.AddRange(negativeKeywords);
            foreach (var kpo in kpos)
            {
                if (!kpo.isDeleted)
                {
                    kpo.isDeleted = IsDeletedKeyword(kpo.keyword.Trim(), negativeKeywords);
                }

                var dr = stationIds.NewRow();
                dr["Keyword"] = kpo.keyword.Trim();
                dr["IsActive"] = "true";
                dr["IsDeleted"] = kpo.isDeleted;
                if (IsNegativeKeyword(kpo.keyword.Trim(), negativeKeywords))
                {
                    dr["IsNegative"] = true;
                    negativeKeywordsToBeInserted.Remove(kpo.keyword.Trim());
                }
                else
                    dr["IsNegative"] = false;
                dr["SemplestProbability"] = kpo.semplestProbability;
                dr["IsTargetMSN"] = kpo.isTargetMSN;
                dr["IsTargetGoogle"] = kpo.isTargetGoogle;
                stationIds.Rows.Add(dr);
                //System.Diagnostics.Debug.WriteLine("insert into @kwa (keyword,IsActive,IsDeleted,IsNegative,IsTargetGoogle,IsTargetMSN) values ('" + dr["Keyword"].ToString() + "',1,0,1,0,0)");
            }
            foreach (string s in negativeKeywordsToBeInserted)
            {
                var dr = stationIds.NewRow();
                dr["Keyword"] = s.Trim();
                dr["IsActive"] = "true";
                dr["IsNegative"] = true;
                dr["IsDeleted"] = false;
                dr["IsTargetMSN"] = 0;
                dr["IsTargetGoogle"] = 0;
                stationIds.Rows.Add(dr);
            }
            if (stationIds.Rows.Count > 0)
            {
                var parameter = new SqlParameter("kwa", stationIds) { SqlDbType = SqlDbType.Structured, TypeName = "PromotionKeywordTableType" };


                var parameter2 = new SqlParameter("@PromotionId", promotionId) { SqlDbType = SqlDbType.Int };

                var parameters = new object[] { parameter, parameter2 };
                    ((IObjectContextAdapter)_dbcontext).ObjectContext.CommandTimeout = 100;
                    _dbcontext.Database.ExecuteSqlCommand("exec sp_UpdateKeywords @kwa, @PromotionId", parameters);

                    //set keyword id's back in the model
                    int userid =
                        ((Credential)
                         System.Web.HttpContext.Current.Session[SharedResources.SEMplestConstants.SESSION_USERID]).
                            UsersFK;
                    var firstOrDefault = _dbcontext.Users.FirstOrDefault(key => key.UserPK == userid);
                    if (firstOrDefault != null)
                    {
                        var promotion =
                            firstOrDefault.Customer.ProductGroups.First(key => key.ProductGroupName == productGroupName)
                                .Promotions.FirstOrDefault(key => key.PromotionName == promotionName);
                        if (promotion != null)
                        {
                            var pkas = promotion.PromotionKeywordAssociations;
                            foreach (PromotionKeywordAssociation pka in pkas)
                            {
                                PromotionKeywordAssociation pka1 = pka;
                                var qry = kpos.Where(key => key.keyword == pka1.Keyword.Keyword1).ToList();
                                if (qry.Any())
                                    qry.First().id = pka.Keyword.KeywordPK;
                            }
                        }
                    }
            }
        }

        private bool IsDeletedKeyword(string keyword, List<string> negativeKeywords)
        {
            if (negativeKeywords == null)
                return false;
            string k = keyword.ToUpper();
            return (negativeKeywords.Any(key => k.Contains(key.ToUpper() + " ")) ||
                    negativeKeywords.Any(key => k.Contains(" " + key.ToUpper())) ||
                    negativeKeywords.Any(key => k.Contains(" " + key.ToUpper() + " ")));
        }

        private bool IsNegativeKeyword(string keyword, List<string> negativeKeywords)
        {
            if (negativeKeywords == null || String.IsNullOrEmpty(keyword))
                return false;
            return negativeKeywords.Any(key => keyword.ToUpper().Equals(key.ToUpper()));
        }
    }
}