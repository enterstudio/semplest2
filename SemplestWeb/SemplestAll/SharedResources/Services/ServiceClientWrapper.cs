using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using Newtonsoft.Json;
using System.Threading;
using System.Web;

namespace Semplest.SharedResources.Services
{
    public class ServiceClientWrapper
    {
        private const string Adengineservice = "semplest.server.service.adengine.SemplestAdengineService";
        private const String Serviceoffered = "semplest.service.keywords.lda.KeywordGeneratorService";
        private const String Mailserviceoffered = "semplest.server.service.mail.SemplestMailService";
        private const string Chaseorbitalservice = "semplest.service.chaseorbitalgateway.ChaseOrbitalGatewayService";
        private static String _baseURLTest = "http://VMJAVA1:9898/semplest";
        private const String TimeoutMs = "3200000";

        public ServiceClientWrapper()
        {
            var dbContext = new SemplestModel.Semplest();
            _baseURLTest = dbContext.Configurations.First().ESBWebServerURL;
        }

        public List<string> GetCategories(string companyName, string searchTerm, string description, string[] adds,
                                          string url)
        {
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
                var dict = RunMethod(_baseURLTest, Serviceoffered, "getCategories", jsonstr);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                return JsonConvert.DeserializeObject<List<string>>(jsonstrlist);
            }
            catch(Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return null;
        }


        public KeywordProbabilityObject[] GetKeywords(List<string> categories, string companyName,
                                                      string[] searchEngines,
                                                      string searchTerm, string description, string[] adds, string url,
                                                      GeoTargetObject[] gt)
        {
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
                Int32[] nGrams = new[] {300, 300, 100};
                string jsonNgrams = JsonConvert.SerializeObject(nGrams);
                jsonHash.Add("nGrams", jsonNgrams);
                string jsonstr = JsonConvert.SerializeObject(jsonHash);
                var dict = RunMethod(_baseURLTest, Serviceoffered, "getKeywords", jsonstr);
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<KeywordProbabilityObject[]>(jsonstrlist);
                foreach (var kpolis in listoflist)
                    kpolis.keyword = kpolis.keyword.Trim();
                return listoflist;
            }
            catch(Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return null;
        }

        #region AdEngine

        public bool schedulePromotion(int promoId, string[] adds,
                                      SEMplestConstants.SchedulePromotionType st)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promoId.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adds, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            string jsonstr = JsonConvert.SerializeObject(jsonHash);
            string requestedService;
            switch (st)
            {
                case SEMplestConstants.SchedulePromotionType.Unpause:
                    requestedService = "UnpausePromotion";
                    break;
                case SEMplestConstants.SchedulePromotionType.Pause:
                    requestedService = "PausePromotion";
                    break;
                case SEMplestConstants.SchedulePromotionType.Delete:
                    requestedService = "DeletePromotion";
                    break;
                case SEMplestConstants.SchedulePromotionType.End:
                    requestedService = "EndPromotion";
                    break;
                default:
                    throw new Exception("Invalid Promotion Schedule Type");
                    break;
            }
            return runBooleanMethod(Adengineservice, requestedService, jsonstr);

        }

        public bool ScheduleAddPromotionToAdEngine(int customerID, int productGroupId, int promoId,
                                                   string[] adEngineList)
        {
            var retVal = false;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("customerID", customerID.ToString());
                jsonHash.Add("productGroupID", productGroupId.ToString());
                jsonHash.Add("promotionID", promoId.ToString());
                string jsonAdds = JsonConvert.SerializeObject(adEngineList, Formatting.Indented);
                jsonHash.Add("adEngines", jsonAdds);
                string jsonstr = JsonConvert.SerializeObject(jsonHash);
                retVal = runBooleanMethod(Adengineservice, "scheduleAddPromotionToAdEngine", jsonstr);
            }
            catch
            {
            }
            return true;
        }

        public bool scheduleAds(int promotionID, List<int> promotionAdIds, List<String> adEngines,
                                SEMplestConstants.PromotionAdAction actionType)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            jsonAdds = JsonConvert.SerializeObject(promotionAdIds, Formatting.Indented);
            jsonHash.Add("promotionAdIds", jsonAdds);

            if (actionType == SEMplestConstants.PromotionAdAction.Add)
                runBooleanMethod(Adengineservice, "AddAds", JsonConvert.SerializeObject(jsonHash));
            else if (actionType == SEMplestConstants.PromotionAdAction.Delete)
                runBooleanMethod(Adengineservice, "DeleteAds", JsonConvert.SerializeObject(jsonHash));
            else
                runBooleanMethod(Adengineservice, "UpdateAds", JsonConvert.SerializeObject(jsonHash));
            return true;
        }

        public bool scheduleUpdateGeoTargeting(int promotionID, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(Adengineservice, "UpdateGeoTargeting", JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleChangePromotionStartDate(int promotionID, DateTime newStartDate,
                                                     List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            jsonHash.Add("newStartDate", newStartDate.ToString("yyyymmdd"));
            return runBooleanMethod(Adengineservice, "ChangePromotionStartDate",
                                    JsonConvert.SerializeObject(jsonHash));
        }

        public bool scheduleUpdateBudget(int promotionID, Decimal changeInBudget, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promotionID.ToString());
            jsonHash.Add("changeInBudget", changeInBudget.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(Adengineservice, "UpdateBudget", JsonConvert.SerializeObject(jsonHash));
        }

        public bool DeleteKeywords(int promotionID, List<int> keywordIds, List<string> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(keywordIds, Formatting.Indented);
            jsonHash.Add("keywordIds", jsonAdds);
            jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(Adengineservice, "DeleteKeywords", JsonConvert.SerializeObject(jsonHash));
        }

        public bool AddNegativeKeywords(int promotionID,
                                        List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs,
                                        List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(keywordIdRemoveOppositePairs, Formatting.Indented);
            jsonHash.Add("keywordIdRemoveOppositePairs", jsonAdds);
            jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(Adengineservice, "AddNegativeKeywords",
                                    JsonConvert.SerializeObject(jsonHash));
        }

        public bool DeleteNegativeKeywords(int promotionID,
                                           List<int> keywordIds,
                                           List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(keywordIds, Formatting.Indented);
            jsonHash.Add("keywordIds", jsonAdds);
            jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(Adengineservice, "DeleteNegativeKeywords",
                                    JsonConvert.SerializeObject(jsonHash));
        }


        public bool scheduleRefreshSiteLinks(int promotionID, List<String> adEngines)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("promotionID", promotionID.ToString());
            string jsonAdds = JsonConvert.SerializeObject(adEngines, Formatting.Indented);
            jsonHash.Add("adEngines", jsonAdds);
            return runBooleanMethod(Adengineservice, "RefreshSiteLinks", JsonConvert.SerializeObject(jsonHash));
        }

        #endregion

        #region validate

        public GoogleViolation[] ValidateGoogleAd(String landingPageURL, String displayURL, List<GoogleAddAdRequest> ads)
        {
            try
            {
                Dictionary<String, String> jsonHash = new Dictionary<String, String>();
                jsonHash.Add("landingPageURL", landingPageURL);
                jsonHash.Add("displayURL", displayURL);
                String adsStr = JsonConvert.SerializeObject(ads, Formatting.Indented);
                jsonHash.Add("ads", adsStr);
                var dict = RunMethod(_baseURLTest, Adengineservice, "validateGoogleAd",
                                       JsonConvert.SerializeObject(jsonHash));
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<GoogleViolation[]>(jsonstrlist);
                return listoflist;
            }
            catch (Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return null;
        }

        public GoogleViolation[] ValidateGoogleRefreshSiteLinks(List<GoogleSiteLink> sl)
        {
            try
            {
                var jsonHash = new Dictionary<string, string>();
                String slStr = JsonConvert.SerializeObject(sl, Formatting.Indented);
                jsonHash.Add("siteLinks", slStr);
                var dict = RunMethod(_baseURLTest, Adengineservice, "validateGoogleRefreshSiteLinks", JsonConvert.SerializeObject(jsonHash));
                var lis = dict.Values.ToList();
                var jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<GoogleViolation[]>(jsonstrlist);
                return listoflist;
            }
            catch (Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return null;
        }

        public GoogleViolation[] ValidateGoogleGeoTargets(List<GeoTargetObject> gto)
        {
            try
            {
                var jsonHash = new Dictionary<string, string>();
                String gtoStr = JsonConvert.SerializeObject(gto, Formatting.Indented);
                jsonHash.Add("geoTargets", gtoStr);
                var dict = RunMethod(_baseURLTest, Adengineservice, "validateGoogleGeoTargets",
                                       JsonConvert.SerializeObject(jsonHash));
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<GoogleViolation[]>(jsonstrlist);
                return listoflist;
            }
            catch (Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return null;
        }

        public GoogleViolation[] ValidateGoogleNegativeKeywords(List<string> negativeKeywords)
        {
            try
            {
                var jsonHash = new Dictionary<string, string>();
                String negativeKeywordsStr = JsonConvert.SerializeObject(negativeKeywords, Formatting.Indented);
                jsonHash.Add("negativeKeywords", negativeKeywordsStr);
                var dict = RunMethod(_baseURLTest, Adengineservice, "validateGoogleNegativeKeywords", JsonConvert.SerializeObject(jsonHash));
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<GoogleViolation[]>(jsonstrlist);
                return listoflist;
            }
            catch (Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return null;
        }

        #endregion


        public bool SendAccountActivationEmail(int userId)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("userID", userId.ToString());
            return runBooleanMethod(Adengineservice, "sendAccountActivationEmail", JsonConvert.SerializeObject(jsonHash));
        }

        public bool ValidateAccountActivationToken(string token)
        {
            bool rval = false;
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("ecryptedToken", token);
                var dict = RunMethod(_baseURLTest, Adengineservice, "validateAccountActivation",
                                              JsonConvert.SerializeObject(jsonHash));
                List<string> lis = dict.Values.ToList();
                string jsonstrlist = lis[0];
                var listoflist = JsonConvert.DeserializeObject<string[]>(jsonstrlist);
                rval = true;
            }
            catch (Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return rval;
        }

        private Thread _workerThread;

        private bool runBooleanMethod(string serviceRequested, string methodRequested, string jsonStr)
        {
            var dbContext = new SemplestModel.Semplest();
            var retVal = false;
            if (!dbContext.Configurations.First().DoNotLaunchAdServices)
            {
                string returnData = string.Empty;
                try
                {
                    var dict = RunMethod(_baseURLTest, serviceRequested, methodRequested, jsonStr);
                    List<string> lis = dict.Values.ToList();
                    retVal = bool.Parse(lis[0]);
                }
                catch (Exception ex)
                {
                    var stemp = new System.Text.StringBuilder();
                    stemp.Append("Json Passed:");
                    stemp.Append(jsonStr);
                    stemp.Append(Environment.NewLine);
                    stemp.Append("Service Requested:");
                    stemp.Append(serviceRequested);
                    stemp.Append(Environment.NewLine);
                    stemp.Append("Method Requested:");
                    stemp.Append(methodRequested);
                    stemp.Append(Environment.NewLine);
                    stemp.Append("Json Returned:");
                    stemp.Append(returnData);
                    stemp.Append(Environment.NewLine);
                    stemp.Append(ex.ToString());
                    Helpers.ExceptionHelper.LogException(new Exception(stemp.ToString()));
                    throw new Exception(returnData);
                }
            }
            return retVal;
        }

        public GatewayReturnObject CreateProfile(CustomerObject customerObject)
        {
            try
            {
                var jsonHash = new Dictionary<string, string>();
                var jsonAdds = JsonConvert.SerializeObject(customerObject, Formatting.None);
                jsonHash.Add("customerObject", jsonAdds);
                var jsonstr = JsonConvert.SerializeObject(jsonHash, Formatting.None);
                var dict = RunMethod(_baseURLTest, Chaseorbitalservice, "CreateProfile", jsonstr);
                var objval = JsonConvert.DeserializeObject<Dictionary<string, string>>((dict.Values.ToList()[0]));
                return new GatewayReturnObject
                           {
                               isGood = Convert.ToBoolean(objval["isGood"]),
                               isError = Convert.ToBoolean(objval["isError"]),
                               isApproved = Convert.ToBoolean(objval["isApproved"]),
                               isDeclined = Convert.ToBoolean(objval["isDeclined"]),
                               Status = objval["Status"],
                               Message = objval["Message"],
                               CustomerRefNum = objval["CustomerRefNum"]
                           };
            }
            catch (Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return null;
        }

        public GatewayReturnObject AuthorizeAndCapture(string customerProfileRefNumber, double amount)
        {
            try
            {
                var jsonHash = new Dictionary<string, string>();
                jsonHash.Add("customerProfileRefNumber", customerProfileRefNumber);
                jsonHash.Add("Amount", amount.ToString());
                string jsonstr = JsonConvert.SerializeObject(jsonHash, Formatting.None);
                    var dict = RunMethod(_baseURLTest, Chaseorbitalservice, "AuthorizeAndCapture", jsonstr);
                var objval = JsonConvert.DeserializeObject<Dictionary<string, string>>((dict.Values.ToList()[0]));
                return new GatewayReturnObject
                                                    {
                                                        isGood = Convert.ToBoolean(objval["isGood"]),
                                                        isError = Convert.ToBoolean(objval["isError"]),
                                                        isApproved = Convert.ToBoolean(objval["isApproved"]),
                                                        isDeclined = Convert.ToBoolean(objval["isDeclined"]),
                                                        ResponseCode = objval["ResponseCode"],
                                                        Status = objval["Status"],
                                                        Message = objval["Message"],
                                                        TxRefNum = objval["TxRefNum"],
                                                        AuthCode = objval["AuthCode"],
                                                        amountRedeemedNoDecimal = objval["amountRedeemedNoDecimal"],
                                                        amountRequestedNoDecimal = objval["amountRequestedNoDecimal"]
                                                    };
            }
            catch(Exception ex)
            {
                Helpers.ExceptionHelper.LogException(ex);
            }
            return null;
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
                var dict = RunMethod(_baseURLTest, Mailserviceoffered, "SendEmail", jsonstr);
                string boolResult = dict.Values.First();
                return Convert.ToBoolean(boolResult);
            }
            catch (Exception ex)
            {
                Semplest.SharedResources.Helpers.ExceptionHelper.LogException(ex, false);
            }
            return false;
        }

        public Dictionary<string, string> RunMethod(String baseURL, String serviceName, String methodName, String jsonStr)
        {
            string returnData = string.Empty;
            try
            {
                jsonStr = HttpUtility.UrlEncode(jsonStr);
                var client = new WebClient();
                client.QueryString.Add("jsonStr", jsonStr);
                client.QueryString.Add("service", serviceName);
                client.QueryString.Add("method", methodName);
                client.QueryString.Add("timeout", TimeoutMs);
                client.BaseAddress = baseURL;
                Stream data = client.OpenRead(baseURL);
                var reader = new StreamReader(data);
                returnData = reader.ReadToEnd();
                if (returnData.ToLower().Contains("service timeout"))
                    throw new Exception("Service Timeout");
                if (returnData.ToLower().Contains("no service for"))
                    throw new Exception("Service not available");

                var resultMap = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
                if (resultMap.ContainsKey("errorID"))
                    throw new Exception(returnData);
                return resultMap;
            }
            catch (Exception ex)
            {
                {
                    var stemp = new System.Text.StringBuilder();
                    stemp.Append(ex.Message);
                    stemp.Append("Json Passed:");
                    stemp.Append(jsonStr);
                    stemp.Append(Environment.NewLine);
                    stemp.Append("Service Requested:");
                    stemp.Append(serviceName);
                    stemp.Append(Environment.NewLine);
                    stemp.Append("Method Requested:");
                    stemp.Append(methodName);
                    stemp.Append(Environment.NewLine);
                    throw new Exception(stemp.ToString());
                }
            }
        }
    }

    public class GeoTargetObject
        {
            public String address
            {
                get; set;
            }

            public String city
            {
                get;set;
            }

            public String state
            {
                get; set;
            }
        
            public String zip
            {
                get; set;
            }

            public Double? latitude
            {
                get; set;
            }

            public Double? longitude
            {
                get; set;
            }

            public Double? radius
            {
                get; set;
            }

        }

    public class GoogleSiteLink
    {
        public string LinkText { get; set; }
        public string LinkURL { get; set; }
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
            public int keywordId { get; set; }
            public bool removeOpposite { get; set; }
        }

        public class CustomerObject
        {
            //this object is passed to the semplest CC API service
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
        {
            //this object is received from the semplest CC API service calls
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
