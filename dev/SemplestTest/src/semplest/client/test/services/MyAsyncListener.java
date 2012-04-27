package semplest.client.test.services;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

import org.apache.log4j.Logger;

public class MyAsyncListener implements AsyncListener {  

     private static final Logger logger =  

         Logger.getLogger(MyAsyncListener.class);  

    

     // Public constructor is required by servlet spec  
     public MyAsyncListener() {    }  

     public void onComplete(AsyncEvent ae) {  

         logger.info("AsyncListener: onComplete for request: " +  

             ae.getAsyncContext().getRequest().getParameter("id"));  

     }  

     public void onTimeout(AsyncEvent ae) {  

         logger.info("AsyncListener: onTimeout for request: " +  

             ae.getAsyncContext().getRequest().getParameter("id"));  

     }  

     public void onError(AsyncEvent ae) {  

         logger.info("AsyncListener: onError for request: " +  

             ae.getAsyncContext().getRequest().getParameter("id"));  

     }  

     public void onStartAsync(AsyncEvent ae) {  

         logger.info("AsyncListener: onStartAsync");  

     }  

 } 

