

/**
 * AdIntelligenceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.v8;

    /*
     *  AdIntelligenceService java interface
     */

    public interface AdIntelligenceService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getHistoricalKeywordPerformanceRequest78
                
                    * @param applicationToken79
                
                    * @param customerAccountId80
                
                    * @param customerId81
                
                    * @param developerToken82
                
                    * @param password83
                
                    * @param userName84
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse getHistoricalKeywordPerformance(

                        com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest getHistoricalKeywordPerformanceRequest78,com.microsoft.adcenter.v8.ApplicationToken applicationToken79,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId80,com.microsoft.adcenter.v8.CustomerId customerId81,com.microsoft.adcenter.v8.DeveloperToken developerToken82,com.microsoft.adcenter.v8.Password password83,com.microsoft.adcenter.v8.UserName userName84)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getHistoricalKeywordPerformanceRequest78
            
                * @param applicationToken79
            
                * @param customerAccountId80
            
                * @param customerId81
            
                * @param developerToken82
            
                * @param password83
            
                * @param userName84
            
          */
        public void startgetHistoricalKeywordPerformance(

            com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest getHistoricalKeywordPerformanceRequest78,com.microsoft.adcenter.v8.ApplicationToken applicationToken79,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId80,
                com.microsoft.adcenter.v8.CustomerId customerId81,
                com.microsoft.adcenter.v8.DeveloperToken developerToken82,
                com.microsoft.adcenter.v8.Password password83,
                com.microsoft.adcenter.v8.UserName userName84,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKeywordCategoriesRequest86
                
                    * @param applicationToken87
                
                    * @param customerAccountId88
                
                    * @param customerId89
                
                    * @param developerToken90
                
                    * @param password91
                
                    * @param userName92
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetKeywordCategoriesResponse getKeywordCategories(

                        com.microsoft.adcenter.v8.GetKeywordCategoriesRequest getKeywordCategoriesRequest86,com.microsoft.adcenter.v8.ApplicationToken applicationToken87,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId88,com.microsoft.adcenter.v8.CustomerId customerId89,com.microsoft.adcenter.v8.DeveloperToken developerToken90,com.microsoft.adcenter.v8.Password password91,com.microsoft.adcenter.v8.UserName userName92)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKeywordCategoriesRequest86
            
                * @param applicationToken87
            
                * @param customerAccountId88
            
                * @param customerId89
            
                * @param developerToken90
            
                * @param password91
            
                * @param userName92
            
          */
        public void startgetKeywordCategories(

            com.microsoft.adcenter.v8.GetKeywordCategoriesRequest getKeywordCategoriesRequest86,com.microsoft.adcenter.v8.ApplicationToken applicationToken87,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId88,
                com.microsoft.adcenter.v8.CustomerId customerId89,
                com.microsoft.adcenter.v8.DeveloperToken developerToken90,
                com.microsoft.adcenter.v8.Password password91,
                com.microsoft.adcenter.v8.UserName userName92,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getHistoricalKeywordPerformanceByDeviceRequest94
                
                    * @param applicationToken95
                
                    * @param customerAccountId96
                
                    * @param customerId97
                
                    * @param developerToken98
                
                    * @param password99
                
                    * @param userName100
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse getHistoricalKeywordPerformanceByDevice(

                        com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest getHistoricalKeywordPerformanceByDeviceRequest94,com.microsoft.adcenter.v8.ApplicationToken applicationToken95,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId96,com.microsoft.adcenter.v8.CustomerId customerId97,com.microsoft.adcenter.v8.DeveloperToken developerToken98,com.microsoft.adcenter.v8.Password password99,com.microsoft.adcenter.v8.UserName userName100)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getHistoricalKeywordPerformanceByDeviceRequest94
            
                * @param applicationToken95
            
                * @param customerAccountId96
            
                * @param customerId97
            
                * @param developerToken98
            
                * @param password99
            
                * @param userName100
            
          */
        public void startgetHistoricalKeywordPerformanceByDevice(

            com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest getHistoricalKeywordPerformanceByDeviceRequest94,com.microsoft.adcenter.v8.ApplicationToken applicationToken95,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId96,
                com.microsoft.adcenter.v8.CustomerId customerId97,
                com.microsoft.adcenter.v8.DeveloperToken developerToken98,
                com.microsoft.adcenter.v8.Password password99,
                com.microsoft.adcenter.v8.UserName userName100,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKeywordDemographicsRequest102
                
                    * @param applicationToken103
                
                    * @param customerAccountId104
                
                    * @param customerId105
                
                    * @param developerToken106
                
                    * @param password107
                
                    * @param userName108
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetKeywordDemographicsResponse getKeywordDemographics(

                        com.microsoft.adcenter.v8.GetKeywordDemographicsRequest getKeywordDemographicsRequest102,com.microsoft.adcenter.v8.ApplicationToken applicationToken103,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId104,com.microsoft.adcenter.v8.CustomerId customerId105,com.microsoft.adcenter.v8.DeveloperToken developerToken106,com.microsoft.adcenter.v8.Password password107,com.microsoft.adcenter.v8.UserName userName108)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKeywordDemographicsRequest102
            
                * @param applicationToken103
            
                * @param customerAccountId104
            
                * @param customerId105
            
                * @param developerToken106
            
                * @param password107
            
                * @param userName108
            
          */
        public void startgetKeywordDemographics(

            com.microsoft.adcenter.v8.GetKeywordDemographicsRequest getKeywordDemographicsRequest102,com.microsoft.adcenter.v8.ApplicationToken applicationToken103,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId104,
                com.microsoft.adcenter.v8.CustomerId customerId105,
                com.microsoft.adcenter.v8.DeveloperToken developerToken106,
                com.microsoft.adcenter.v8.Password password107,
                com.microsoft.adcenter.v8.UserName userName108,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKeywordLocationsRequest110
                
                    * @param applicationToken111
                
                    * @param customerAccountId112
                
                    * @param customerId113
                
                    * @param developerToken114
                
                    * @param password115
                
                    * @param userName116
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetKeywordLocationsResponse getKeywordLocations(

                        com.microsoft.adcenter.v8.GetKeywordLocationsRequest getKeywordLocationsRequest110,com.microsoft.adcenter.v8.ApplicationToken applicationToken111,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId112,com.microsoft.adcenter.v8.CustomerId customerId113,com.microsoft.adcenter.v8.DeveloperToken developerToken114,com.microsoft.adcenter.v8.Password password115,com.microsoft.adcenter.v8.UserName userName116)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKeywordLocationsRequest110
            
                * @param applicationToken111
            
                * @param customerAccountId112
            
                * @param customerId113
            
                * @param developerToken114
            
                * @param password115
            
                * @param userName116
            
          */
        public void startgetKeywordLocations(

            com.microsoft.adcenter.v8.GetKeywordLocationsRequest getKeywordLocationsRequest110,com.microsoft.adcenter.v8.ApplicationToken applicationToken111,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId112,
                com.microsoft.adcenter.v8.CustomerId customerId113,
                com.microsoft.adcenter.v8.DeveloperToken developerToken114,
                com.microsoft.adcenter.v8.Password password115,
                com.microsoft.adcenter.v8.UserName userName116,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getEstimatedBidByKeywordIdsRequest118
                
                    * @param applicationToken119
                
                    * @param customerAccountId120
                
                    * @param customerId121
                
                    * @param developerToken122
                
                    * @param password123
                
                    * @param userName124
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse getEstimatedBidByKeywordIds(

                        com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest getEstimatedBidByKeywordIdsRequest118,com.microsoft.adcenter.v8.ApplicationToken applicationToken119,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId120,com.microsoft.adcenter.v8.CustomerId customerId121,com.microsoft.adcenter.v8.DeveloperToken developerToken122,com.microsoft.adcenter.v8.Password password123,com.microsoft.adcenter.v8.UserName userName124)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEstimatedBidByKeywordIdsRequest118
            
                * @param applicationToken119
            
                * @param customerAccountId120
            
                * @param customerId121
            
                * @param developerToken122
            
                * @param password123
            
                * @param userName124
            
          */
        public void startgetEstimatedBidByKeywordIds(

            com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest getEstimatedBidByKeywordIdsRequest118,com.microsoft.adcenter.v8.ApplicationToken applicationToken119,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId120,
                com.microsoft.adcenter.v8.CustomerId customerId121,
                com.microsoft.adcenter.v8.DeveloperToken developerToken122,
                com.microsoft.adcenter.v8.Password password123,
                com.microsoft.adcenter.v8.UserName userName124,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param suggestKeywordsForUrlRequest126
                
                    * @param applicationToken127
                
                    * @param customerAccountId128
                
                    * @param customerId129
                
                    * @param developerToken130
                
                    * @param password131
                
                    * @param userName132
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse suggestKeywordsForUrl(

                        com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest suggestKeywordsForUrlRequest126,com.microsoft.adcenter.v8.ApplicationToken applicationToken127,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId128,com.microsoft.adcenter.v8.CustomerId customerId129,com.microsoft.adcenter.v8.DeveloperToken developerToken130,com.microsoft.adcenter.v8.Password password131,com.microsoft.adcenter.v8.UserName userName132)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param suggestKeywordsForUrlRequest126
            
                * @param applicationToken127
            
                * @param customerAccountId128
            
                * @param customerId129
            
                * @param developerToken130
            
                * @param password131
            
                * @param userName132
            
          */
        public void startsuggestKeywordsForUrl(

            com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest suggestKeywordsForUrlRequest126,com.microsoft.adcenter.v8.ApplicationToken applicationToken127,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId128,
                com.microsoft.adcenter.v8.CustomerId customerId129,
                com.microsoft.adcenter.v8.DeveloperToken developerToken130,
                com.microsoft.adcenter.v8.Password password131,
                com.microsoft.adcenter.v8.UserName userName132,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getEstimatedBidByKeywordsRequest134
                
                    * @param applicationToken135
                
                    * @param customerAccountId136
                
                    * @param customerId137
                
                    * @param developerToken138
                
                    * @param password139
                
                    * @param userName140
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse getEstimatedBidByKeywords(

                        com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest getEstimatedBidByKeywordsRequest134,com.microsoft.adcenter.v8.ApplicationToken applicationToken135,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId136,com.microsoft.adcenter.v8.CustomerId customerId137,com.microsoft.adcenter.v8.DeveloperToken developerToken138,com.microsoft.adcenter.v8.Password password139,com.microsoft.adcenter.v8.UserName userName140)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEstimatedBidByKeywordsRequest134
            
                * @param applicationToken135
            
                * @param customerAccountId136
            
                * @param customerId137
            
                * @param developerToken138
            
                * @param password139
            
                * @param userName140
            
          */
        public void startgetEstimatedBidByKeywords(

            com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest getEstimatedBidByKeywordsRequest134,com.microsoft.adcenter.v8.ApplicationToken applicationToken135,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId136,
                com.microsoft.adcenter.v8.CustomerId customerId137,
                com.microsoft.adcenter.v8.DeveloperToken developerToken138,
                com.microsoft.adcenter.v8.Password password139,
                com.microsoft.adcenter.v8.UserName userName140,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getEstimatedPositionByKeywordsRequest142
                
                    * @param applicationToken143
                
                    * @param customerAccountId144
                
                    * @param customerId145
                
                    * @param developerToken146
                
                    * @param password147
                
                    * @param userName148
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse getEstimatedPositionByKeywords(

                        com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest getEstimatedPositionByKeywordsRequest142,com.microsoft.adcenter.v8.ApplicationToken applicationToken143,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId144,com.microsoft.adcenter.v8.CustomerId customerId145,com.microsoft.adcenter.v8.DeveloperToken developerToken146,com.microsoft.adcenter.v8.Password password147,com.microsoft.adcenter.v8.UserName userName148)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEstimatedPositionByKeywordsRequest142
            
                * @param applicationToken143
            
                * @param customerAccountId144
            
                * @param customerId145
            
                * @param developerToken146
            
                * @param password147
            
                * @param userName148
            
          */
        public void startgetEstimatedPositionByKeywords(

            com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest getEstimatedPositionByKeywordsRequest142,com.microsoft.adcenter.v8.ApplicationToken applicationToken143,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId144,
                com.microsoft.adcenter.v8.CustomerId customerId145,
                com.microsoft.adcenter.v8.DeveloperToken developerToken146,
                com.microsoft.adcenter.v8.Password password147,
                com.microsoft.adcenter.v8.UserName userName148,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getHistoricalSearchCountRequest150
                
                    * @param applicationToken151
                
                    * @param customerAccountId152
                
                    * @param customerId153
                
                    * @param developerToken154
                
                    * @param password155
                
                    * @param userName156
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse getHistoricalSearchCount(

                        com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest getHistoricalSearchCountRequest150,com.microsoft.adcenter.v8.ApplicationToken applicationToken151,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId152,com.microsoft.adcenter.v8.CustomerId customerId153,com.microsoft.adcenter.v8.DeveloperToken developerToken154,com.microsoft.adcenter.v8.Password password155,com.microsoft.adcenter.v8.UserName userName156)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getHistoricalSearchCountRequest150
            
                * @param applicationToken151
            
                * @param customerAccountId152
            
                * @param customerId153
            
                * @param developerToken154
            
                * @param password155
            
                * @param userName156
            
          */
        public void startgetHistoricalSearchCount(

            com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest getHistoricalSearchCountRequest150,com.microsoft.adcenter.v8.ApplicationToken applicationToken151,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId152,
                com.microsoft.adcenter.v8.CustomerId customerId153,
                com.microsoft.adcenter.v8.DeveloperToken developerToken154,
                com.microsoft.adcenter.v8.Password password155,
                com.microsoft.adcenter.v8.UserName userName156,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getPublisherKeywordPerformanceRequest158
                
                    * @param applicationToken159
                
                    * @param customerAccountId160
                
                    * @param customerId161
                
                    * @param developerToken162
                
                    * @param password163
                
                    * @param userName164
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse getPublisherKeywordPerformance(

                        com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest getPublisherKeywordPerformanceRequest158,com.microsoft.adcenter.v8.ApplicationToken applicationToken159,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId160,com.microsoft.adcenter.v8.CustomerId customerId161,com.microsoft.adcenter.v8.DeveloperToken developerToken162,com.microsoft.adcenter.v8.Password password163,com.microsoft.adcenter.v8.UserName userName164)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPublisherKeywordPerformanceRequest158
            
                * @param applicationToken159
            
                * @param customerAccountId160
            
                * @param customerId161
            
                * @param developerToken162
            
                * @param password163
            
                * @param userName164
            
          */
        public void startgetPublisherKeywordPerformance(

            com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest getPublisherKeywordPerformanceRequest158,com.microsoft.adcenter.v8.ApplicationToken applicationToken159,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId160,
                com.microsoft.adcenter.v8.CustomerId customerId161,
                com.microsoft.adcenter.v8.DeveloperToken developerToken162,
                com.microsoft.adcenter.v8.Password password163,
                com.microsoft.adcenter.v8.UserName userName164,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getHistoricalSearchCountByDeviceRequest166
                
                    * @param applicationToken167
                
                    * @param customerAccountId168
                
                    * @param customerId169
                
                    * @param developerToken170
                
                    * @param password171
                
                    * @param userName172
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse getHistoricalSearchCountByDevice(

                        com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest getHistoricalSearchCountByDeviceRequest166,com.microsoft.adcenter.v8.ApplicationToken applicationToken167,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId168,com.microsoft.adcenter.v8.CustomerId customerId169,com.microsoft.adcenter.v8.DeveloperToken developerToken170,com.microsoft.adcenter.v8.Password password171,com.microsoft.adcenter.v8.UserName userName172)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getHistoricalSearchCountByDeviceRequest166
            
                * @param applicationToken167
            
                * @param customerAccountId168
            
                * @param customerId169
            
                * @param developerToken170
            
                * @param password171
            
                * @param userName172
            
          */
        public void startgetHistoricalSearchCountByDevice(

            com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest getHistoricalSearchCountByDeviceRequest166,com.microsoft.adcenter.v8.ApplicationToken applicationToken167,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId168,
                com.microsoft.adcenter.v8.CustomerId customerId169,
                com.microsoft.adcenter.v8.DeveloperToken developerToken170,
                com.microsoft.adcenter.v8.Password password171,
                com.microsoft.adcenter.v8.UserName userName172,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param suggestKeywordsFromExistingKeywordsRequest174
                
                    * @param applicationToken175
                
                    * @param customerAccountId176
                
                    * @param customerId177
                
                    * @param developerToken178
                
                    * @param password179
                
                    * @param userName180
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse suggestKeywordsFromExistingKeywords(

                        com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest suggestKeywordsFromExistingKeywordsRequest174,com.microsoft.adcenter.v8.ApplicationToken applicationToken175,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId176,com.microsoft.adcenter.v8.CustomerId customerId177,com.microsoft.adcenter.v8.DeveloperToken developerToken178,com.microsoft.adcenter.v8.Password password179,com.microsoft.adcenter.v8.UserName userName180)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param suggestKeywordsFromExistingKeywordsRequest174
            
                * @param applicationToken175
            
                * @param customerAccountId176
            
                * @param customerId177
            
                * @param developerToken178
            
                * @param password179
            
                * @param userName180
            
          */
        public void startsuggestKeywordsFromExistingKeywords(

            com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest suggestKeywordsFromExistingKeywordsRequest174,com.microsoft.adcenter.v8.ApplicationToken applicationToken175,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId176,
                com.microsoft.adcenter.v8.CustomerId customerId177,
                com.microsoft.adcenter.v8.DeveloperToken developerToken178,
                com.microsoft.adcenter.v8.Password password179,
                com.microsoft.adcenter.v8.UserName userName180,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getEstimatedPositionByKeywordIdsRequest182
                
                    * @param applicationToken183
                
                    * @param customerAccountId184
                
                    * @param customerId185
                
                    * @param developerToken186
                
                    * @param password187
                
                    * @param userName188
                
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse getEstimatedPositionByKeywordIds(

                        com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest getEstimatedPositionByKeywordIdsRequest182,com.microsoft.adcenter.v8.ApplicationToken applicationToken183,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId184,com.microsoft.adcenter.v8.CustomerId customerId185,com.microsoft.adcenter.v8.DeveloperToken developerToken186,com.microsoft.adcenter.v8.Password password187,com.microsoft.adcenter.v8.UserName userName188)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEstimatedPositionByKeywordIdsRequest182
            
                * @param applicationToken183
            
                * @param customerAccountId184
            
                * @param customerId185
            
                * @param developerToken186
            
                * @param password187
            
                * @param userName188
            
          */
        public void startgetEstimatedPositionByKeywordIds(

            com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest getEstimatedPositionByKeywordIdsRequest182,com.microsoft.adcenter.v8.ApplicationToken applicationToken183,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId184,
                com.microsoft.adcenter.v8.CustomerId customerId185,
                com.microsoft.adcenter.v8.DeveloperToken developerToken186,
                com.microsoft.adcenter.v8.Password password187,
                com.microsoft.adcenter.v8.UserName userName188,
                

            final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    