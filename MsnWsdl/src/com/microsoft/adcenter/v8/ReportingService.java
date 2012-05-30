

/**
 * ReportingService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.v8;

    /*
     *  ReportingService java interface
     */

    public interface ReportingService {
          

        /**
          * Auto generated method signature
          * 
                    * @param submitGenerateReportRequest6
                
                    * @param applicationToken7
                
                    * @param customerAccountId8
                
                    * @param customerId9
                
                    * @param developerToken10
                
                    * @param password11
                
                    * @param userName12
                
             * @throws com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SubmitGenerateReportResponse submitGenerateReport(

                        com.microsoft.adcenter.v8.SubmitGenerateReportRequest submitGenerateReportRequest6,com.microsoft.adcenter.v8.ApplicationToken applicationToken7,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId8,com.microsoft.adcenter.v8.CustomerId customerId9,com.microsoft.adcenter.v8.DeveloperToken developerToken10,com.microsoft.adcenter.v8.Password password11,com.microsoft.adcenter.v8.UserName userName12)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param submitGenerateReportRequest6
            
                * @param applicationToken7
            
                * @param customerAccountId8
            
                * @param customerId9
            
                * @param developerToken10
            
                * @param password11
            
                * @param userName12
            
          */
        public void startsubmitGenerateReport(

            com.microsoft.adcenter.v8.SubmitGenerateReportRequest submitGenerateReportRequest6,com.microsoft.adcenter.v8.ApplicationToken applicationToken7,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId8,
                com.microsoft.adcenter.v8.CustomerId customerId9,
                com.microsoft.adcenter.v8.DeveloperToken developerToken10,
                com.microsoft.adcenter.v8.Password password11,
                com.microsoft.adcenter.v8.UserName userName12,
                

            final com.microsoft.adcenter.v8.ReportingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param pollGenerateReportRequest14
                
                    * @param applicationToken15
                
                    * @param customerAccountId16
                
                    * @param customerId17
                
                    * @param developerToken18
                
                    * @param password19
                
                    * @param userName20
                
             * @throws com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.PollGenerateReportResponse pollGenerateReport(

                        com.microsoft.adcenter.v8.PollGenerateReportRequest pollGenerateReportRequest14,com.microsoft.adcenter.v8.ApplicationToken applicationToken15,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId16,com.microsoft.adcenter.v8.CustomerId customerId17,com.microsoft.adcenter.v8.DeveloperToken developerToken18,com.microsoft.adcenter.v8.Password password19,com.microsoft.adcenter.v8.UserName userName20)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param pollGenerateReportRequest14
            
                * @param applicationToken15
            
                * @param customerAccountId16
            
                * @param customerId17
            
                * @param developerToken18
            
                * @param password19
            
                * @param userName20
            
          */
        public void startpollGenerateReport(

            com.microsoft.adcenter.v8.PollGenerateReportRequest pollGenerateReportRequest14,com.microsoft.adcenter.v8.ApplicationToken applicationToken15,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId16,
                com.microsoft.adcenter.v8.CustomerId customerId17,
                com.microsoft.adcenter.v8.DeveloperToken developerToken18,
                com.microsoft.adcenter.v8.Password password19,
                com.microsoft.adcenter.v8.UserName userName20,
                

            final com.microsoft.adcenter.v8.ReportingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    