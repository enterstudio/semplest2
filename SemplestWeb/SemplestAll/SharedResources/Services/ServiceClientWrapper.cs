using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using Newtonsoft.Json;

namespace Semplest.SharedResources.Services
{
    public class ServiceClientWrapper
    {
        private static String SERVICEOFFERED = "semplest.service.keywords.lda.KeywordGeneratorService";
        private static String MAILSERVICEOFFERED = "semplest.server.service.mail.SemplestMailService";
        private static String BASEURLTEST = "http://VMJAVA1:9898/semplest";
        private static String timeoutMS = "40000";

        public List<string> GetCategories(string companyName, string searchTerm, string description, string[] adds,
                                          string url)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("companyName", companyName);
            jsonHash.Add("searchTerm", searchTerm);
            string jsonAdds = JsonConvert.SerializeObject(adds, Formatting.Indented);
            jsonHash.Add("adds", jsonAdds);
            jsonHash.Add("description", description);
            jsonHash.Add("url", url);
            string jsonstr = JsonConvert.SerializeObject(jsonHash);

            string returnData = string.Empty;
            try
            {
                returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "getCategories", jsonstr, timeoutMS);
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


        public List<KeywordProbabilityObject> GetKeywords(List<string> categories, string companyName, string[] searchEngines,
                                string searchTerm, string description, string[] adds, string url,
                                GeoTargetObject[] gt, Int32[] nGrams)
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
            string returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "getKeywords", jsonstr, timeoutMS);
            var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
            List<string> lis = dict.Values.ToList();
            string jsonstrlist = lis[0];

            //var listoflist = JsonConvert.DeserializeObject<List<List<string>>>(jsonstrlist);
            //var listoflist = JsonConvert.DeserializeObject<List<KeywordProbabilityObject>>(jsonstrlist);
            var listoflist = JsonConvert.DeserializeObject<KeywordProbabilityObject[]>(jsonstrlist);
            var newKPOlist = new List<KeywordProbabilityObject>();

            foreach (var kpolis in listoflist)
            {
                newKPOlist.Add(kpolis);
            }

            return newKPOlist;
        }

        public List<string> GetKeywords(List<string> categories, string companyName, string searchTerm,
                                        string description, string[] adds, string url, Int32[] nGrams)
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

            //string returnData = string.Empty;
            string returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "getKeywords", jsonstr, timeoutMS);
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

        public Boolean SendEmail(String subject, String from, String recipient, String msgTxt)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("subject", subject);
            jsonHash.Add("from", from);
            jsonHash.Add("recipient", recipient);
            jsonHash.Add("msgTxt", msgTxt);
            string jsonstr = JsonConvert.SerializeObject(jsonHash);
            string returnData = runMethod(BASEURLTEST, MAILSERVICEOFFERED, "SendEmail", jsonstr, timeoutMS);
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
        public string keyword { get; set; }
        public double semplestProbability { get; set; }
        public bool isTargetMSN { get; set; }
        public bool isTargetGoogle { get; set; }
    }

}