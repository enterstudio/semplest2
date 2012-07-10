using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using Newtonsoft.Json;
using SemplestModel;
using System.Threading;
using Semplest.SharedResources;
using System.Web;

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
            var dbContext = new SemplestModel.Semplest();
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


        public KeywordProbabilityObject[] GetKeywords(List<string> categories, string companyName,
                                                      string[] searchEngines,
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
                nGrams = new[] {300, 300, 100};
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
                nGrams = new[] {50, 50};
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

        #region AdEngine

        public bool schedulePromotion(int customerId, int promoId, string[] adds, bool shouldResume)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerId.ToString());
            jsonHash.Add("promotionID", promoId.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adds, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            string jsonstr = JsonConvert.SerializeObject(jsonHash);

            if (shouldResume)
                return runBooleanMethod(ADENGINESERVICE, "scheduleUnpausePromotion", jsonstr);
            else
                return runBooleanMethod(ADENGINESERVICE, "schedulePausePromotion", jsonstr);
        }

        public bool scheduleAddPromotionToAdEngine(int customerID, int productGroupId, int promoId,
                                                   string[] adEngineList)
        {
            string returnData = string.Empty;
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("productGroupID", productGroupId.ToString());
            jsonHash.Add("promotionID", promoId.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngineList, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            string jsonstr = JsonConvert.SerializeObject(jsonHash);
            return runBooleanMethod(ADENGINESERVICE, "scheduleAddPromotionToAdEngine", jsonstr);
        }

        public bool scheduleAds(int customerID, int promotionID, List<int> promotionAdIds, List<String> adEngines,
                                SEMplestConstants.PromotionAdAction actionType)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            jsonAdds = JsonConvert.SerializeObject(promotionAdIds, Formatting.Indented);
            jsonHash.Add("promotionAdIds", jsonAdds);

            if (actionType == SEMplestConstants.PromotionAdAction.Add)
                return runBooleanMethod(ADENGINESERVICE, "scheduleAddAds", JsonConvert.SerializeObject(jsonHash));
            else if (actionType == SEMplestConstants.PromotionAdAction.Delete)
                return runBooleanMethod(ADENGINESERVICE, "scheduleDeleteAds", JsonConvert.SerializeObject(jsonHash));
            else
                return runBooleanMethod(ADENGINESERVICE, "scheduleUpdateAds", JsonConvert.SerializeObject(jsonHash));
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

        public bool scheduleChangePromotionStartDate(int customerID, int promotionID, DateTime newStartDate,
                                                     List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            jsonHash.Add("newStartDate", newStartDate.ToString("yyyymmdd"));
            return runBooleanMethod(ADENGINESERVICE, "scheduleChangePromotionStartDate",
                                    JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleUpdateBudget(int customerID, int promotionID, Decimal changeInBudget, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            jsonHash.Add("changeInBudget", changeInBudget.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(ADENGINESERVICE, "scheduleUpdateBudget", JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleNegativeKeywords(int customerID, int promotionID,
                                             List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs,
                                             List<String> adEngines, bool isAdd)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(keywordIdRemoveOppositePairs, Formatting.Indented);
            jsonHash.Add("keywordIdRemoveOppositePairs", jsonAdds);
            jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            if (isAdd)
                return runBooleanMethod(ADENGINESERVICE, "scheduleAddNegativeKeywords",
                                        JsonConvert.SerializeObject(jsonHash));
            else
                return runBooleanMethod(ADENGINESERVICE, "scheduleDeleteNegativeKeywords",
                                        JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleRefreshSiteLinks(int customerID, int promotionID, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("customerID", customerID.ToString());
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(ADENGINESERVICE, "scheduleRefreshSiteLinks", JsonConvert.SerializeObject(jsonHash));
        }

        #endregion

        #region validate

        public GoogleViolation[] ValidateGoogleAd(String landingPageURL, String displayURL, List<GoogleAddAdRequest> ads)
        {
            String returnData = string.Empty;
            try
            {
            Dictionary<String, String> jsonHash = new Dictionary<String, String>();
            jsonHash.Add("landingPageURL", landingPageURL);
            jsonHash.Add("displayURL", displayURL);
            String adsStr = JsonConvert.SerializeObject(ads, Formatting.Indented);
            jsonHash.Add("ads", adsStr);
            returnData = runMethod(_baseURLTest, ADENGINESERVICE, "validateGoogleAd",
                                          JsonConvert.SerializeObject(jsonHash), timeoutMS);
            var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
            List<string> lis = dict.Values.ToList();
            string jsonstrlist = lis[0];
            var listoflist = JsonConvert.DeserializeObject<GoogleViolation[]>(jsonstrlist);
            return listoflist;
                        }
            catch(Exception ex)
            {
                throw new Exception(returnData + ex.ToString());
            }
        }

        public GoogleViolation[] ValidateGoogleRefreshSiteLinks(int promotionID)
        {
            String returnData = string.Empty;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("promotionID", promotionID.ToString());
                returnData = runMethod(_baseURLTest, ADENGINESERVICE, "validateGoogleRefreshSiteLinks",
                                              JsonConvert.SerializeObject(jsonHash), timeoutMS);
                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<GoogleViolation[]>(jsonstrlist);
                return listoflist;
            }
            catch (Exception ex)
            {
                throw new Exception(returnData + ex.ToString());
            }
        }

        public GoogleViolation[] ValidateGoogleGeoTargets(int promotionID)
        {
            String returnData = string.Empty;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("promotionID", promotionID.ToString());
                returnData = runMethod(_baseURLTest, ADENGINESERVICE, "validateGoogleGeoTargets",
                                              JsonConvert.SerializeObject(jsonHash), timeoutMS);
                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<GoogleViolation[]>(jsonstrlist);
                return listoflist;
            }
            catch (Exception ex)
            {
                throw new Exception(returnData + ex.ToString());
            }
        }

        public GoogleViolation[] ValidateGoogleNegativeKeywords(List<string> negativeKeywords)
        {
            String returnData = string.Empty;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                String negativeKeywordsStr = JsonConvert.SerializeObject(negativeKeywords, Formatting.Indented);
                jsonHash.Add("negativeKeywords", negativeKeywordsStr);
                returnData = runMethod(_baseURLTest, ADENGINESERVICE, "validateGoogleNegativeKeywords",
                                              JsonConvert.SerializeObject(jsonHash), timeoutMS);
                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<GoogleViolation[]>(jsonstrlist);

                return listoflist;
            }
            catch(Exception ex)
            {
                throw new Exception(returnData + ex.ToString());
            }
        }
         
        #endregion

        private Thread _workerThread;
        private bool runBooleanMethod(string serviceRequested, string methodRequested, string jsonStr)
        {
            var dbContext = new SemplestModel.Semplest();
            if (!dbContext.Configurations.First().DoNotLaunchAdServices)
            {
                ThreadData tData = new ThreadData(serviceRequested, methodRequested, jsonStr);
                _workerThread = new Thread(new ParameterizedThreadStart(runBooleanMethodAsync));
                _workerThread.Start(tData);
            }
            return true;
        }

        private void runBooleanMethodAsync(object data)
        {
            ThreadData param = (ThreadData) data;

            string returnData = string.Empty;
            try
            {
                returnData = runMethod(_baseURLTest, param.ServiceRequested, param.MethodRequested, param.JsonStr, timeoutMS);
                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                //this should be the case but we are always going to return true so this line has been commented out
                if(!bool.Parse(lis[0]))
                    throw new Exception("Json Call returned a false");
            }
            catch (Exception ex) {
                System.Text.StringBuilder stemp = new System.Text.StringBuilder();
                stemp.Append("Json Passed:");
                stemp.Append(param.JsonStr);
                stemp.Append(Environment.NewLine);
                stemp.Append("Service Requested:");
                stemp.Append(param.ServiceRequested);
                stemp.Append(Environment.NewLine);
                stemp.Append("Method Requested:");
                stemp.Append(param.MethodRequested);
                stemp.Append(Environment.NewLine);
                stemp.Append("Json Returned:");
                stemp.Append(returnData);
                stemp.Append(Environment.NewLine);
                stemp.Append(ex.ToString());
                Semplest.SharedResources.Helpers.ExceptionHelper.LogException(stemp.ToString()); 
            }
            
        }

         private class ThreadData
        {
            public string ServiceRequested{get;set;}
            public string MethodRequested { get; set; }
            public string JsonStr { get; set; }

            public ThreadData(string serviceRequested, string methodRequested, string jsonStr)
            {
                ServiceRequested = serviceRequested;
                MethodRequested = methodRequested;
                JsonStr = jsonStr;
            }
        }

        public GatewayReturnObject CreateProfile(CustomerObject customerObject)
        {
            string returnData;
            GatewayReturnObject ReturnGatewayReturnObject = new GatewayReturnObject();
            try
            {
                var jsonHash = new Dictionary<string, string>();


                string jsonAdds = JsonConvert.SerializeObject(customerObject, Formatting.None);
                jsonHash.Add("customerObject", jsonAdds);

                string jsonstr = JsonConvert.SerializeObject(jsonHash, Formatting.None);
                try
                {

                    returnData = runMethod("http://VMDEVJAVA1:9898/semplest", "semplest.service.chaseorbitalgateway.ChaseOrbitalGatewayService", "CreateProfile", jsonstr, "0");
                }
                catch (Exception ex)
                {
                    string errmsg = ex.Message;
                    throw;
                }


                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();



                var objval = JsonConvert.DeserializeObject<Dictionary<string, string>>((dict.Values.ToList()[0].ToString()));

                ReturnGatewayReturnObject.isGood = Convert.ToBoolean(objval["isGood"]);
                ReturnGatewayReturnObject.isError = Convert.ToBoolean(objval["isError"]);
                ReturnGatewayReturnObject.isApproved = Convert.ToBoolean(objval["isApproved"]);
                ReturnGatewayReturnObject.isDeclined = Convert.ToBoolean(objval["isDeclined"]);
                ReturnGatewayReturnObject.Status = objval["Status"];
                ReturnGatewayReturnObject.Message = objval["Message"];
                ReturnGatewayReturnObject.CustomerRefNum = objval["CustomerRefNum"];


            }
            catch
            {
                if (ReturnGatewayReturnObject == null)
                    throw;
                else
                    throw new Exception();
            }
            return ReturnGatewayReturnObject;
        }

        //

        // 

        public GatewayReturnObject AuthorizeAndCapture(string customerProfileRefNumber, double amount)
        {
            string returnData;
            GatewayReturnObject ReturnGatewayReturnObject = new GatewayReturnObject();
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("customerProfileRefNumber", customerProfileRefNumber);
                jsonHash.Add("Amount", amount.ToString());
                string jsonstr = JsonConvert.SerializeObject(jsonHash, Formatting.None);
                try
                {

                    returnData = runMethod("http://VMDEVJAVA1:9898/semplest", "semplest.service.chaseorbitalgateway.ChaseOrbitalGatewayService", "AuthorizeAndCapture", jsonstr, "0");
                }
                catch (Exception ex)
                {
                    string errmsg = ex.Message;
                    throw;
                }


                var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                List<string> lis = dict.Values.ToList();

                var objval = JsonConvert.DeserializeObject<Dictionary<string, string>>((dict.Values.ToList()[0].ToString()));

                ReturnGatewayReturnObject.isGood = Convert.ToBoolean(objval["isGood"]);
                ReturnGatewayReturnObject.isError = Convert.ToBoolean(objval["isError"]);
                ReturnGatewayReturnObject.isApproved = Convert.ToBoolean(objval["isApproved"]);
                ReturnGatewayReturnObject.isDeclined = Convert.ToBoolean(objval["isDeclined"]);
                ReturnGatewayReturnObject.Status = objval["Status"];
                ReturnGatewayReturnObject.Message = objval["Message"];
                ReturnGatewayReturnObject.CustomerRefNum = objval["CustomerRefNum"];


            }
            catch
            {
                if (ReturnGatewayReturnObject == null)
                    throw;
                else
                    throw new Exception();
            }
            return ReturnGatewayReturnObject;
        }

        //




        public Boolean SendEmail(String subject, String from, String recipient, String msgTxt)
        {
            try
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
            catch  { }
            return false;
        }

        public String runMethod(String baseURL, String serviceName, String methodName, String jsonStr, String timeoutMS)
        {
            jsonStr = HttpUtility.UrlEncode(jsonStr);
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

    public class KeywordIdRemoveOppositePair
    {
        public int KeywordId { get; set; }
        public bool RemoveOpposite { get; set; }
    }

    public class CustomerObject
    { //this object is passed to the semplest CC API service
        public String FirstName { get; set; }
        public String LastName { get; set; }
        public String Address1 { get; set; }
        //public String Address2 { get; set; }
        public String City { get; set; }
        public String StateAbbr { get; set; }
        public String ZipCode { get; set; }
        public String Email { get; set; }
        public String Phone { get; set; }
        public String creditCardNumber { get; set; }
        public String ExpireDateMMYY { get; set; }
    }

    public class GatewayReturnObject
    { //this object is received from the semplest CC API service calls
        public String xmlReturn = null;
        public Boolean isGood;
        public Boolean isError;
        public Boolean isQuickResponse;
        public Boolean isApproved;
        public Boolean isDeclined;
        public String AuthCode;
        public String TxRefNum;
        public String ResponseCode;
        public String Status;
        public String Message;
        public String AVSCode;
        public String CVV2ResponseCode;
        //New Order
        public String OrderID = null;
        public String amountRequestedNoDecimal = null;
        public String amountRedeemedNoDecimal = null;
        public String remainingBalanceNoDecimal = null;
        //Profile
        public String CustomerRefNum = null;
    }

    public class GoogleAddAdRequest
    {
        public int promotionAdID { get; set; } //NOTE SET THIS TO null for validation
        public String headline { get; set; }
        public String description1 { get; set; }
        public String description2 { get; set; }
    }

    public class GoogleViolation
    {
        public String errorType { get; set; }
        public String errorMessage { get; set; }
        public String fieldPath { get; set; }
        public String shortFieldPath { get; set; }
        public Boolean isPolicyViolationError { get; set; }
        public String policyName { get; set; }
        public String policyDescription { get; set; }
        public string policyViolatingText { get; set; }
    }

}