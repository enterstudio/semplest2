using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using Newtonsoft.Json;
using SemplestModel;

namespace Semplest.SharedResources.Services
{
    public class ServiceClientWrapper
    {
        private static string ADENGINESERVICE = "semplest.server.service.adengine.SemplestAdengineService";
        private static String SERVICEOFFERED = "semplest.service.keywords.lda.KeywordGeneratorService";
        private static String MAILSERVICEOFFERED = "semplest.server.service.mail.SemplestMailService";
        private static String _baseURLTest = "http://VMJAVA1:9898/semplest";
        private static String timeoutMS = "3200000";

        public ServiceClientWrapper()
        {
            SemplestEntities dbContext = new SemplestEntities();
            _baseURLTest = dbContext.Configurations.First().ESBWebServerURL;
        }

        public List<string> GetCategories(string companyName, string searchTerm, string description, string[] adds,
                                          string url)
        {
            string returnData = string.Empty;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("companyName", companyName);
                jsonHash.Add("searchTerm", searchTerm);
                string jsonAdds = JsonConvert.SerializeObject(adds, Formatting.Indented);
                jsonHash.Add("adds", jsonAdds);
                jsonHash.Add("description", description);
                jsonHash.Add("url", url);
                string jsonstr = JsonConvert.SerializeObject(jsonHash);

                returnData = string.Empty;
                try
                {
                    returnData = runMethod(_baseURLTest, SERVICEOFFERED, "getCategories", jsonstr, timeoutMS);
                }
                catch (Exception ex)
                {
                    string errmsg = ex.Message;
                    throw;
                }
                //return JsonConvert.DeserializeObject<List<string>>(returnData);

                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                if (jsonstrlist == "Service Timeout")
                {

                    throw new Exception("Service Timeout for GetCategories");
                }
                return JsonConvert.DeserializeObject<List<string>>(jsonstrlist);
            }
            catch
            {
                if (string.IsNullOrEmpty(returnData))
                    throw;
                else
                    throw new Exception(returnData);
            }
        }


        public KeywordProbabilityObject[] GetKeywords(List<string> categories, string companyName, string[] searchEngines,
                                string searchTerm, string description, string[] adds, string url,
                                GeoTargetObject[] gt, Int32[] nGrams)
        {
            string returnData = string.Empty;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                String jsonCategories = JsonConvert.SerializeObject(categories);
                jsonHash.Add("categories", jsonCategories);
                jsonHash.Add("companyName", companyName);
                jsonHash.Add("searchTerm", searchTerm);
                string jsonAdds = JsonConvert.SerializeObject(adds, Formatting.Indented);
                jsonHash.Add("adds", jsonAdds);
                string jsonSEngines = JsonConvert.SerializeObject(searchEngines);
                jsonHash.Add("searchEngines", jsonSEngines);
                string jsonGt = JsonConvert.SerializeObject(gt);
                jsonHash.Add("gt", jsonGt);
                jsonHash.Add("description", description);
                jsonHash.Add("url", url);
                nGrams = new[] { 50, 50 };
                //nGrams = new Int32[] { 1,2,3 };
                string jsonNgrams = JsonConvert.SerializeObject(nGrams);
                jsonHash.Add("nGrams", jsonNgrams);
                string jsonstr = JsonConvert.SerializeObject(jsonHash);

                //string returnData = string.Empty;
                returnData = runMethod(_baseURLTest, SERVICEOFFERED, "getKeywords", jsonstr, timeoutMS);
                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                if (jsonstrlist == "Service Timeout")
                {
                    throw new Exception("Service Timeout for GetKeywords");
                }

                //var listoflist = JsonConvert.DeserializeObject<List<List<string>>>(jsonstrlist);
                //var listoflist = JsonConvert.DeserializeObject<List<KeywordProbabilityObject>>(jsonstrlist);
                var listoflist = JsonConvert.DeserializeObject<KeywordProbabilityObject[]>(jsonstrlist);

                foreach (var kpolis in listoflist)
                {
                    kpolis.keyword = kpolis.keyword.Trim();
                }


                return listoflist;
            }
            catch 
            {
                if (string.IsNullOrEmpty(returnData))
                    throw;
                else
                    throw new Exception(returnData);
            }
        }

        public List<string> GetKeywords(List<string> categories, string companyName, string searchTerm,
                                        string description, string[] adds, string url, Int32[] nGrams)
        {
            string returnData = string.Empty;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                String jsonCategories = JsonConvert.SerializeObject(categories);
                jsonHash.Add("categories", jsonCategories);
                jsonHash.Add("companyName", companyName);
                jsonHash.Add("searchTerm", searchTerm);
                string jsonAdds = JsonConvert.SerializeObject(adds, Formatting.Indented);
                jsonHash.Add("adds", jsonAdds);
                jsonHash.Add("description", description);
                jsonHash.Add("url", url);
                nGrams = new[] { 50, 50 };
                //nGrams = new Int32[] { 1,2,3 };
                string jsonNgrams = JsonConvert.SerializeObject(nGrams);
                jsonHash.Add("nGrams", jsonNgrams);
                string jsonstr = JsonConvert.SerializeObject(jsonHash);

                returnData = runMethod(_baseURLTest, SERVICEOFFERED, "getKeywords", jsonstr, timeoutMS);
                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];

                var listoflist = JsonConvert.DeserializeObject<List<List<string>>>(jsonstrlist);
                var newstrlist = new List<string>();

                foreach (var strlis in listoflist)
                {
                    newstrlist.AddRange(strlis);
                }

                return newstrlist;
            }
            catch 
            {
                if (string.IsNullOrEmpty(returnData))
                    throw;
                else
                    throw new Exception(returnData);
            }
        }

        public bool schedulePromotion(int customerId, int promoId, string[] adds, bool shouldResume)
        {
            string returnData = string.Empty;
            bool retVal;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("customerID", customerId.ToString());
                jsonHash.Add("promotionID", promoId.ToString());
                string jsonAdds = JsonConvert.SerializeObject(adds, Formatting.Indented);
                jsonHash.Add("adEngines", jsonAdds);
                string jsonstr = JsonConvert.SerializeObject(jsonHash);

                returnData = string.Empty;
                try
                {
                    if (shouldResume)
                        returnData = runMethod(_baseURLTest, ADENGINESERVICE, "scheduleUnpausePromotion", jsonstr, timeoutMS);
                    else
                        returnData = runMethod(_baseURLTest, ADENGINESERVICE, "schedulePausePromotion", jsonstr, timeoutMS);
                }
                catch (Exception ex)
                {
                    string errmsg = ex.Message;
                    throw;
                }
                //return JsonConvert.DeserializeObject<List<string>>(returnData);

                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                if (jsonstrlist == "Service Timeout")
                {
                    throw new Exception("Service Timeout for schedulePausePromotion");
                }
                retVal = bool.Parse(lis[0]);
            }
            catch
            {
                if (string.IsNullOrEmpty(returnData))
                    throw;
                else
                    throw new Exception(returnData);
            }
            return retVal;
        }

        public bool scheduleAddPromotionToAdEngine(int customerID, int productGroupId, int promoId, string[] adEngineList)
        {
            string returnData = string.Empty;
            bool retVal;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("customerID", customerID.ToString());
                jsonHash.Add("productGroupID", productGroupId.ToString());
                jsonHash.Add("promotionID", promoId.ToString());
                string jsonAdds = JsonConvert.SerializeObject(adEngineList, Formatting.Indented);
                jsonHash.Add("adEngineList", jsonAdds);
                string jsonstr = JsonConvert.SerializeObject(jsonHash);


                returnData = string.Empty;
                try
                {
                    returnData = runMethod(_baseURLTest, ADENGINESERVICE, "scheduleAddPromotionToAdEngine", jsonstr, timeoutMS);
                }
                catch (Exception ex)
                {
                    string errmsg = ex.Message;
                    throw;
                }
                //return JsonConvert.DeserializeObject<List<string>>(returnData);

                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                if (jsonstrlist == "Service Timeout")
                {
                    throw new Exception("Service Timeout for schedulePausePromotion");
                }
                retVal = bool.Parse(lis[0]);
            }
            catch
            {
                if (string.IsNullOrEmpty(returnData))
                    throw;
                else
                    throw new Exception(returnData);
            }
            return retVal;

        }

        public bool scheduleAds(int customerID, int promotionID, List<int> promotionAdIds, List<String> adEngines, bool isAdd)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            jsonAdds = JsonConvert.SerializeObject(promotionAdIds, Formatting.Indented);
            jsonHash.Add("promotionAdIds", jsonAdds);
            
            if (isAdd)
                return runBooleanMethod(ADENGINESERVICE, "scheduleAddAds", JsonConvert.SerializeObject(jsonHash));
            else
                return runBooleanMethod(ADENGINESERVICE, "scheduleDeleteAds", JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleUpdateGeoTargeting(int customerID, int promotionID, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(ADENGINESERVICE, "scheduleUpdateGeoTargeting", JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleChangePromotionStartDate(int customerID, int promotionID, DateTime newStartDate, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            jsonHash.Add("newStartDate", newStartDate.ToString());
            return runBooleanMethod(ADENGINESERVICE, "scheduleChangePromotionStartDate", JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleUpdateBudget(int customerID, int promotionID, Double changeInBudget, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            jsonHash.Add("changeInBudget", changeInBudget.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(ADENGINESERVICE, "scheduleUpdateBudget", JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleNegativeKeywords(int customerID, int promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<String> adEngines, bool isAdd)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(keywordIdRemoveOppositePairs, Formatting.Indented);
            jsonHash.Add("keywordIdRemoveOppositePairs", jsonAdds);
            jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            if (isAdd)
                return runBooleanMethod(ADENGINESERVICE, "scheduleAddNegativeKeywords", JsonConvert.SerializeObject(jsonHash));
            else
                return runBooleanMethod(ADENGINESERVICE, "scheduleDeleteNegativeKeywords", JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleRefreshSiteLinksForAd(int customerID, int promotionID, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(ADENGINESERVICE, "scheduleRefreshSiteLinksForAd", JsonConvert.SerializeObject(jsonHash));
        }



        private bool runBooleanMethod(string serviceRequested, string methodRequested, string jsonStr)
        {
            string returnData = string.Empty;
            try
            {
                returnData = runMethod(_baseURLTest, serviceRequested, methodRequested, jsonStr, timeoutMS);
            }
            catch (Exception ex)
            {
                string errmsg = ex.Message;
                throw;
            }
            //return JsonConvert.DeserializeObject<List<string>>(returnData);

            var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
            List<string> lis = dict.Values.ToList();
            string jsonstrlist = lis[0];
            if (jsonstrlist == "Service Timeout")
            {
                throw new Exception("Service Timeout for schedulePausePromotion");
            }
            return bool.Parse(lis[0]);
        }

        

        //
        //GatewayReturnObject CreateProfile(CustomerObject customerObject, String creditCardNumber, String ExpireDateMMYY) throws Exception;


        public bool CreateProfile(CustomerObject customerObject, string creditCardNumber, string ExpireDateMMYY)
        {
            string returnData = string.Empty;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                
                jsonHash.Add("creditCardNumber", creditCardNumber);
                jsonHash.Add("ExpireDateMMYY", ExpireDateMMYY);
                
                //jsonHash.Add("customerObject", customerObject);
                
                string jsonAdds = JsonConvert.SerializeObject(customerObject, Formatting.Indented);
                jsonHash.Add("customerObject", jsonAdds);


                string jsonstr = JsonConvert.SerializeObject(jsonHash);

                returnData = string.Empty;
                try
                {
                    returnData = runMethod("http://VMJAVA1:9898/semplest", "semplest.service.keywords.lda.KeywordGeneratorService", "CreateProfile", jsonstr, "0");
               }
                catch (Exception ex)
                {
                    string errmsg = ex.Message;
                    throw;
                }
                //return JsonConvert.DeserializeObject<List<string>>(returnData);

                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                if (jsonstrlist == "Service Timeout")
                {

                    throw new Exception("Service Timeout for schedulePausePromotion");
                }
                Console.WriteLine(jsonstrlist);
                Console.ReadLine();
            }
            catch
            {
                if (string.IsNullOrEmpty(returnData))
                    throw;
                else
                    throw new Exception(returnData);
            }
            return false;
        }



        //
        //




        public Boolean SendEmail(String subject, String from, String recipient, String msgTxt)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("subject", subject);
            jsonHash.Add("from", from);
            jsonHash.Add("recipient", recipient);
            jsonHash.Add("msgTxt", msgTxt);
            jsonHash.Add("msgType", "text/html; charset=utf-8;"); //"text/plain
            string jsonstr = JsonConvert.SerializeObject(jsonHash);
            string returnData = runMethod(_baseURLTest, MAILSERVICEOFFERED, "SendEmail", jsonstr, timeoutMS);
            var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
            string boolResult = dict.Values.First();
            return Convert.ToBoolean(boolResult);
        }

        public String runMethod(String baseURL, String serviceName, String methodName, String jsonStr, String timeoutMS)
        {
            var client = new WebClient();
            client.QueryString.Add("jsonStr", jsonStr);
            client.QueryString.Add("service", serviceName);
            client.QueryString.Add("method", methodName);

            if (timeoutMS != null)
            {
                client.QueryString.Add("timeout", timeoutMS);
            }

            client.BaseAddress = baseURL;
            string qs = client.QueryString.ToString();
            Stream data = client.OpenRead(baseURL);
            var reader = new StreamReader(data);
            string s = reader.ReadToEnd();

            //WebResource webResource = client.resource(baseURL);
            //return webResource.queryParams(queryParams).get(String.class);
            return s;
        }

    }

    public class GeoTargetObject
    {
        private String address;
        private String city;
        private String state;
        private String zip;
        private Double latitude;
        private Double longitude;
        private Double radius;
        public String getAddress()
        {
            return address;
        }
        public void setAddress(String address)
        {
            this.address = address;
        }
        public String getCity()
        {
            return city;
        }
        public void setCity(String city)
        {
            this.city = city;
        }
        public String getState()
        {
            return state;
        }
        public void setState(String state)
        {
            this.state = state;
        }
        public String getZip()
        {
            return zip;
        }
        public void setZip(String zip)
        {
            this.zip = zip;
        }
        public Double getLatitude()
        {
            return latitude;
        }
        public void setLatitude(Double latitude)
        {
            this.latitude = latitude;
        }
        public Double getLongitude()
        {
            return longitude;
        }
        public void setLongitude(Double longitude)
        {
            this.longitude = longitude;
        }
        public Double getRadius()
        {
            return radius;
        }
        public void setRadius(Double radius)
        {
            this.radius = radius;
        }
    }

    public class KeywordProbabilityObject
    {
        public int id { get; set; }
        public string keyword { get; set; }
        public double semplestProbability { get; set; }
        public bool isTargetMSN { get; set; }
        public bool isTargetGoogle { get; set; }
        public bool isDeleted { get; set; }
    }



    public class CustomerObject
    {
        public String FirstName { get;set; }
        public String LastName { get; set; }
        public String Address1 { get; set; }
        public String Address2 { get; set; }
        public String City { get; set; }
        public String StateAbbr { get; set; }
        public String ZipCode { get; set; }
        public String Email { get; set; }
        public String Phone { get; set; }
    }

    public class KeywordIdRemoveOppositePair
    {
    }
}