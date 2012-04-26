using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Practices.EnterpriseLibrary.Logging;
using Semplest.SharedResources.Services;

namespace Semplest.Core.Models.Repositories
{
    public class CampaignRepository : ICampaignRepository
    {
        public int Save(string data)
        {
           // var jss = new JavaScriptSerializer();
         //   var myDynamic = jss.Deserialize(data, typeof(object));

            return 0;
        }


        public CampaignSetupModel GetCategories(CampaignSetupModel model)
        {
            var scw = new ServiceClientWrapper();

            // create AdCopy array
            List<string> adtitletextList = new List<string>();
            foreach (SemplestModel.PromotionAd pad in model.AdModelProp.Ads)
            {
                adtitletextList.Add(pad.AdTitle + " " + pad.AdText);
            }

            // get categories or classifications
            var categories = scw.GetCategories(null, model.ProductGroup.ProductPromotionName,
                                        model.ProductGroup.Words, adtitletextList.ToArray(), model.AdModelProp.Url);

            // create categories list that will be displayed in a multiselect list box
            if (categories != null && categories.Count > 0)
            {
                for (var i = 0; i < categories.Count; i++)
                {
                    var cm = new CampaignSetupModel.CategoriesModel { Id = i, Name = categories[i] };
                    model.AllCategories.Add(cm);
                }
            }
            else
            {
                var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "Could not get Categories from web service" };
                Logger.Write(logEnty);
            }
            return model;
            // save this some how while getting the keywords this is becoming null
        }

        public CampaignSetupModel GetKeyWords(CampaignSetupModel model)
        {
            if (model.AllCategories.Count == 0)
            {
                //model.AllCategories = (List<CampaignSetupModel.CategoriesModel>)Session["AllCategories"];
            }

            var catList = new List<string>();

            foreach (var cat in model.AllCategories)
            {
                catList.AddRange(from t in model.CategoryIds where cat.Id == t select cat.Name);
            }

            var scw = new ServiceClientWrapper();
            // create AdCopy array
            List<string> adtitletextList = new List<string>();
            foreach (SemplestModel.PromotionAd pad in model.AdModelProp.Ads)
            {
                adtitletextList.Add(pad.AdTitle + " " + pad.AdText);
            }

            // get keywords from the web service
            //List<string> keywords = scw.GetKeywords(catList, null, "coffee machine", null, null, "http://www.wholelattelove.com", null);
            var keywords = scw.GetKeywords(catList, null, model.ProductGroup.ProductPromotionName,
                                            model.ProductGroup.Words, adtitletextList.ToArray(), model.AdModelProp.Url, null);
            if (keywords != null && keywords.Count > 0)
            {
                foreach (var kwm in keywords.Select(key => new CampaignSetupModel.KeywordsModel { Name = key }))
                {
                    model.AllKeywords.Add(kwm);
                }
            }
            else
            {
                var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "Could not get Keywords from web service" };
                Logger.Write(logEnty);
            }
            return model;
        }
    }
}