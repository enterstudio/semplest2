using System;
using System.IO;
using System.Net;
using System.Text;

namespace SemplestWebApp.Helpers
{
    public static class ServiceHelper
    {
        public static void CallSemplestTestGetMethod()
        {
            //"http://vmjava1:9898/semplest?service=semplest.test.TestService&method=TestMethod&jsonStr=hello"
            // Restful service URL
            //string url = "http://vmjava1:9898/semplest?service=semplest.test.TestService&method=TestMethod&jsonStr=hello";

            string url =
                "http://vmjava1:9898/semplest?service=semplest.service.keywords.lda.KeywordGeneratorService&method=getCategories&jsonStr=hello";

            string strResult = string.Empty;

            // declare httpwebrequet wrt url defined above
            var webrequest = (HttpWebRequest) WebRequest.Create(url);
            // set method as post
            webrequest.Method = "GET";
            // set content type
            webrequest.ContentType = "text/Json";
            // declare & read response from service
            var webresponse = (HttpWebResponse) webrequest.GetResponse();
            // set utf8 encoding
            Encoding enc = Encoding.GetEncoding("utf-8");
            // read response stream from response object
            var loResponseStream = new StreamReader(webresponse.GetResponseStream(), enc);
            // read string from stream data
            strResult = loResponseStream.ReadToEnd();
            // close the stream object
            loResponseStream.Close();
            // close the response object
            webresponse.Close();
            // assign the final result to text box
            Console.WriteLine(strResult);
        }
    }
}