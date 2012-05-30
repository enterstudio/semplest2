

/**
 * CampaignManagementService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.v8;

    /*
     *  CampaignManagementService java interface
     */

    public interface CampaignManagementService {
          

        /**
          * Auto generated method signature
          * 
                    * @param deleteAdsRequest522
                
                    * @param applicationToken523
                
                    * @param customerAccountId524
                
                    * @param customerId525
                
                    * @param developerToken526
                
                    * @param password527
                
                    * @param userName528
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteAdsResponse deleteAds(

                        com.microsoft.adcenter.v8.DeleteAdsRequest deleteAdsRequest522,com.microsoft.adcenter.v8.ApplicationToken applicationToken523,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId524,com.microsoft.adcenter.v8.CustomerId customerId525,com.microsoft.adcenter.v8.DeveloperToken developerToken526,com.microsoft.adcenter.v8.Password password527,com.microsoft.adcenter.v8.UserName userName528)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteAdsRequest522
            
                * @param applicationToken523
            
                * @param customerAccountId524
            
                * @param customerId525
            
                * @param developerToken526
            
                * @param password527
            
                * @param userName528
            
          */
        public void startdeleteAds(

            com.microsoft.adcenter.v8.DeleteAdsRequest deleteAdsRequest522,com.microsoft.adcenter.v8.ApplicationToken applicationToken523,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId524,
                com.microsoft.adcenter.v8.CustomerId customerId525,
                com.microsoft.adcenter.v8.DeveloperToken developerToken526,
                com.microsoft.adcenter.v8.Password password527,
                com.microsoft.adcenter.v8.UserName userName528,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteTargetRequest530
                
                    * @param applicationToken531
                
                    * @param customerAccountId532
                
                    * @param customerId533
                
                    * @param developerToken534
                
                    * @param password535
                
                    * @param userName536
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTarget_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTarget_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteTargetResponse deleteTarget(

                        com.microsoft.adcenter.v8.DeleteTargetRequest deleteTargetRequest530,com.microsoft.adcenter.v8.ApplicationToken applicationToken531,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId532,com.microsoft.adcenter.v8.CustomerId customerId533,com.microsoft.adcenter.v8.DeveloperToken developerToken534,com.microsoft.adcenter.v8.Password password535,com.microsoft.adcenter.v8.UserName userName536)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTarget_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTarget_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteTargetRequest530
            
                * @param applicationToken531
            
                * @param customerAccountId532
            
                * @param customerId533
            
                * @param developerToken534
            
                * @param password535
            
                * @param userName536
            
          */
        public void startdeleteTarget(

            com.microsoft.adcenter.v8.DeleteTargetRequest deleteTargetRequest530,com.microsoft.adcenter.v8.ApplicationToken applicationToken531,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId532,
                com.microsoft.adcenter.v8.CustomerId customerId533,
                com.microsoft.adcenter.v8.DeveloperToken developerToken534,
                com.microsoft.adcenter.v8.Password password535,
                com.microsoft.adcenter.v8.UserName userName536,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addCampaignsRequest538
                
                    * @param applicationToken539
                
                    * @param customerAccountId540
                
                    * @param customerId541
                
                    * @param developerToken542
                
                    * @param password543
                
                    * @param userName544
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddCampaignsResponse addCampaigns(

                        com.microsoft.adcenter.v8.AddCampaignsRequest addCampaignsRequest538,com.microsoft.adcenter.v8.ApplicationToken applicationToken539,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId540,com.microsoft.adcenter.v8.CustomerId customerId541,com.microsoft.adcenter.v8.DeveloperToken developerToken542,com.microsoft.adcenter.v8.Password password543,com.microsoft.adcenter.v8.UserName userName544)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addCampaignsRequest538
            
                * @param applicationToken539
            
                * @param customerAccountId540
            
                * @param customerId541
            
                * @param developerToken542
            
                * @param password543
            
                * @param userName544
            
          */
        public void startaddCampaigns(

            com.microsoft.adcenter.v8.AddCampaignsRequest addCampaignsRequest538,com.microsoft.adcenter.v8.ApplicationToken applicationToken539,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId540,
                com.microsoft.adcenter.v8.CustomerId customerId541,
                com.microsoft.adcenter.v8.DeveloperToken developerToken542,
                com.microsoft.adcenter.v8.Password password543,
                com.microsoft.adcenter.v8.UserName userName544,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteKeywordsRequest546
                
                    * @param applicationToken547
                
                    * @param customerAccountId548
                
                    * @param customerId549
                
                    * @param developerToken550
                
                    * @param password551
                
                    * @param userName552
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteKeywords_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteKeywords_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteKeywordsResponse deleteKeywords(

                        com.microsoft.adcenter.v8.DeleteKeywordsRequest deleteKeywordsRequest546,com.microsoft.adcenter.v8.ApplicationToken applicationToken547,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId548,com.microsoft.adcenter.v8.CustomerId customerId549,com.microsoft.adcenter.v8.DeveloperToken developerToken550,com.microsoft.adcenter.v8.Password password551,com.microsoft.adcenter.v8.UserName userName552)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteKeywords_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteKeywords_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteKeywordsRequest546
            
                * @param applicationToken547
            
                * @param customerAccountId548
            
                * @param customerId549
            
                * @param developerToken550
            
                * @param password551
            
                * @param userName552
            
          */
        public void startdeleteKeywords(

            com.microsoft.adcenter.v8.DeleteKeywordsRequest deleteKeywordsRequest546,com.microsoft.adcenter.v8.ApplicationToken applicationToken547,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId548,
                com.microsoft.adcenter.v8.CustomerId customerId549,
                com.microsoft.adcenter.v8.DeveloperToken developerToken550,
                com.microsoft.adcenter.v8.Password password551,
                com.microsoft.adcenter.v8.UserName userName552,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateGoalsRequest554
                
                    * @param applicationToken555
                
                    * @param customerAccountId556
                
                    * @param customerId557
                
                    * @param developerToken558
                
                    * @param password559
                
                    * @param userName560
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateGoals_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateGoals_ApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateGoals_AnalyticsApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateGoalsResponse updateGoals(

                        com.microsoft.adcenter.v8.UpdateGoalsRequest updateGoalsRequest554,com.microsoft.adcenter.v8.ApplicationToken applicationToken555,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId556,com.microsoft.adcenter.v8.CustomerId customerId557,com.microsoft.adcenter.v8.DeveloperToken developerToken558,com.microsoft.adcenter.v8.Password password559,com.microsoft.adcenter.v8.UserName userName560)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateGoals_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateGoals_ApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateGoals_AnalyticsApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateGoalsRequest554
            
                * @param applicationToken555
            
                * @param customerAccountId556
            
                * @param customerId557
            
                * @param developerToken558
            
                * @param password559
            
                * @param userName560
            
          */
        public void startupdateGoals(

            com.microsoft.adcenter.v8.UpdateGoalsRequest updateGoalsRequest554,com.microsoft.adcenter.v8.ApplicationToken applicationToken555,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId556,
                com.microsoft.adcenter.v8.CustomerId customerId557,
                com.microsoft.adcenter.v8.DeveloperToken developerToken558,
                com.microsoft.adcenter.v8.Password password559,
                com.microsoft.adcenter.v8.UserName userName560,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateTargetRequest562
                
                    * @param applicationToken563
                
                    * @param customerAccountId564
                
                    * @param customerId565
                
                    * @param developerToken566
                
                    * @param password567
                
                    * @param userName568
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateTarget_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateTarget_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateTargetResponse updateTarget(

                        com.microsoft.adcenter.v8.UpdateTargetRequest updateTargetRequest562,com.microsoft.adcenter.v8.ApplicationToken applicationToken563,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId564,com.microsoft.adcenter.v8.CustomerId customerId565,com.microsoft.adcenter.v8.DeveloperToken developerToken566,com.microsoft.adcenter.v8.Password password567,com.microsoft.adcenter.v8.UserName userName568)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateTarget_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateTarget_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateTargetRequest562
            
                * @param applicationToken563
            
                * @param customerAccountId564
            
                * @param customerId565
            
                * @param developerToken566
            
                * @param password567
            
                * @param userName568
            
          */
        public void startupdateTarget(

            com.microsoft.adcenter.v8.UpdateTargetRequest updateTargetRequest562,com.microsoft.adcenter.v8.ApplicationToken applicationToken563,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId564,
                com.microsoft.adcenter.v8.CustomerId customerId565,
                com.microsoft.adcenter.v8.DeveloperToken developerToken566,
                com.microsoft.adcenter.v8.Password password567,
                com.microsoft.adcenter.v8.UserName userName568,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getSitePlacementsByIdsRequest570
                
                    * @param applicationToken571
                
                    * @param customerAccountId572
                
                    * @param customerId573
                
                    * @param developerToken574
                
                    * @param password575
                
                    * @param userName576
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetSitePlacementsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetSitePlacementsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetSitePlacementsByIdsResponse getSitePlacementsByIds(

                        com.microsoft.adcenter.v8.GetSitePlacementsByIdsRequest getSitePlacementsByIdsRequest570,com.microsoft.adcenter.v8.ApplicationToken applicationToken571,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId572,com.microsoft.adcenter.v8.CustomerId customerId573,com.microsoft.adcenter.v8.DeveloperToken developerToken574,com.microsoft.adcenter.v8.Password password575,com.microsoft.adcenter.v8.UserName userName576)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetSitePlacementsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetSitePlacementsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSitePlacementsByIdsRequest570
            
                * @param applicationToken571
            
                * @param customerAccountId572
            
                * @param customerId573
            
                * @param developerToken574
            
                * @param password575
            
                * @param userName576
            
          */
        public void startgetSitePlacementsByIds(

            com.microsoft.adcenter.v8.GetSitePlacementsByIdsRequest getSitePlacementsByIdsRequest570,com.microsoft.adcenter.v8.ApplicationToken applicationToken571,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId572,
                com.microsoft.adcenter.v8.CustomerId customerId573,
                com.microsoft.adcenter.v8.DeveloperToken developerToken574,
                com.microsoft.adcenter.v8.Password password575,
                com.microsoft.adcenter.v8.UserName userName576,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getTargetsByAdGroupIdsRequest578
                
                    * @param applicationToken579
                
                    * @param customerAccountId580
                
                    * @param customerId581
                
                    * @param developerToken582
                
                    * @param password583
                
                    * @param userName584
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByAdGroupIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByAdGroupIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsResponse getTargetsByAdGroupIds(

                        com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsRequest getTargetsByAdGroupIdsRequest578,com.microsoft.adcenter.v8.ApplicationToken applicationToken579,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId580,com.microsoft.adcenter.v8.CustomerId customerId581,com.microsoft.adcenter.v8.DeveloperToken developerToken582,com.microsoft.adcenter.v8.Password password583,com.microsoft.adcenter.v8.UserName userName584)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByAdGroupIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByAdGroupIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getTargetsByAdGroupIdsRequest578
            
                * @param applicationToken579
            
                * @param customerAccountId580
            
                * @param customerId581
            
                * @param developerToken582
            
                * @param password583
            
                * @param userName584
            
          */
        public void startgetTargetsByAdGroupIds(

            com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsRequest getTargetsByAdGroupIdsRequest578,com.microsoft.adcenter.v8.ApplicationToken applicationToken579,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId580,
                com.microsoft.adcenter.v8.CustomerId customerId581,
                com.microsoft.adcenter.v8.DeveloperToken developerToken582,
                com.microsoft.adcenter.v8.Password password583,
                com.microsoft.adcenter.v8.UserName userName584,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setNegativeKeywordsToAdGroupsRequest586
                
                    * @param applicationToken587
                
                    * @param customerAccountId588
                
                    * @param customerId589
                
                    * @param developerToken590
                
                    * @param password591
                
                    * @param userName592
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeKeywordsToAdGroups_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeKeywordsToAdGroups_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsResponse setNegativeKeywordsToAdGroups(

                        com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsRequest setNegativeKeywordsToAdGroupsRequest586,com.microsoft.adcenter.v8.ApplicationToken applicationToken587,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId588,com.microsoft.adcenter.v8.CustomerId customerId589,com.microsoft.adcenter.v8.DeveloperToken developerToken590,com.microsoft.adcenter.v8.Password password591,com.microsoft.adcenter.v8.UserName userName592)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeKeywordsToAdGroups_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeKeywordsToAdGroups_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setNegativeKeywordsToAdGroupsRequest586
            
                * @param applicationToken587
            
                * @param customerAccountId588
            
                * @param customerId589
            
                * @param developerToken590
            
                * @param password591
            
                * @param userName592
            
          */
        public void startsetNegativeKeywordsToAdGroups(

            com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsRequest setNegativeKeywordsToAdGroupsRequest586,com.microsoft.adcenter.v8.ApplicationToken applicationToken587,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId588,
                com.microsoft.adcenter.v8.CustomerId customerId589,
                com.microsoft.adcenter.v8.DeveloperToken developerToken590,
                com.microsoft.adcenter.v8.Password password591,
                com.microsoft.adcenter.v8.UserName userName592,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getNormalizedStringsRequest594
                
                    * @param applicationToken595
                
                    * @param customerAccountId596
                
                    * @param customerId597
                
                    * @param developerToken598
                
                    * @param password599
                
                    * @param userName600
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNormalizedStrings_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNormalizedStrings_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetNormalizedStringsResponse getNormalizedStrings(

                        com.microsoft.adcenter.v8.GetNormalizedStringsRequest getNormalizedStringsRequest594,com.microsoft.adcenter.v8.ApplicationToken applicationToken595,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId596,com.microsoft.adcenter.v8.CustomerId customerId597,com.microsoft.adcenter.v8.DeveloperToken developerToken598,com.microsoft.adcenter.v8.Password password599,com.microsoft.adcenter.v8.UserName userName600)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNormalizedStrings_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNormalizedStrings_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getNormalizedStringsRequest594
            
                * @param applicationToken595
            
                * @param customerAccountId596
            
                * @param customerId597
            
                * @param developerToken598
            
                * @param password599
            
                * @param userName600
            
          */
        public void startgetNormalizedStrings(

            com.microsoft.adcenter.v8.GetNormalizedStringsRequest getNormalizedStringsRequest594,com.microsoft.adcenter.v8.ApplicationToken applicationToken595,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId596,
                com.microsoft.adcenter.v8.CustomerId customerId597,
                com.microsoft.adcenter.v8.DeveloperToken developerToken598,
                com.microsoft.adcenter.v8.Password password599,
                com.microsoft.adcenter.v8.UserName userName600,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteSitePlacementsRequest602
                
                    * @param applicationToken603
                
                    * @param customerAccountId604
                
                    * @param customerId605
                
                    * @param developerToken606
                
                    * @param password607
                
                    * @param userName608
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteSitePlacements_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteSitePlacements_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteSitePlacementsResponse deleteSitePlacements(

                        com.microsoft.adcenter.v8.DeleteSitePlacementsRequest deleteSitePlacementsRequest602,com.microsoft.adcenter.v8.ApplicationToken applicationToken603,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId604,com.microsoft.adcenter.v8.CustomerId customerId605,com.microsoft.adcenter.v8.DeveloperToken developerToken606,com.microsoft.adcenter.v8.Password password607,com.microsoft.adcenter.v8.UserName userName608)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteSitePlacements_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteSitePlacements_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteSitePlacementsRequest602
            
                * @param applicationToken603
            
                * @param customerAccountId604
            
                * @param customerId605
            
                * @param developerToken606
            
                * @param password607
            
                * @param userName608
            
          */
        public void startdeleteSitePlacements(

            com.microsoft.adcenter.v8.DeleteSitePlacementsRequest deleteSitePlacementsRequest602,com.microsoft.adcenter.v8.ApplicationToken applicationToken603,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId604,
                com.microsoft.adcenter.v8.CustomerId customerId605,
                com.microsoft.adcenter.v8.DeveloperToken developerToken606,
                com.microsoft.adcenter.v8.Password password607,
                com.microsoft.adcenter.v8.UserName userName608,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setTargetToAdGroupRequest610
                
                    * @param applicationToken611
                
                    * @param customerAccountId612
                
                    * @param customerId613
                
                    * @param developerToken614
                
                    * @param password615
                
                    * @param userName616
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetTargetToAdGroup_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetTargetToAdGroup_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetTargetToAdGroupResponse setTargetToAdGroup(

                        com.microsoft.adcenter.v8.SetTargetToAdGroupRequest setTargetToAdGroupRequest610,com.microsoft.adcenter.v8.ApplicationToken applicationToken611,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId612,com.microsoft.adcenter.v8.CustomerId customerId613,com.microsoft.adcenter.v8.DeveloperToken developerToken614,com.microsoft.adcenter.v8.Password password615,com.microsoft.adcenter.v8.UserName userName616)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetTargetToAdGroup_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetTargetToAdGroup_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setTargetToAdGroupRequest610
            
                * @param applicationToken611
            
                * @param customerAccountId612
            
                * @param customerId613
            
                * @param developerToken614
            
                * @param password615
            
                * @param userName616
            
          */
        public void startsetTargetToAdGroup(

            com.microsoft.adcenter.v8.SetTargetToAdGroupRequest setTargetToAdGroupRequest610,com.microsoft.adcenter.v8.ApplicationToken applicationToken611,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId612,
                com.microsoft.adcenter.v8.CustomerId customerId613,
                com.microsoft.adcenter.v8.DeveloperToken developerToken614,
                com.microsoft.adcenter.v8.Password password615,
                com.microsoft.adcenter.v8.UserName userName616,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param submitAdGroupForApprovalRequest618
                
                    * @param applicationToken619
                
                    * @param customerAccountId620
                
                    * @param customerId621
                
                    * @param developerToken622
                
                    * @param password623
                
                    * @param userName624
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SubmitAdGroupForApproval_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SubmitAdGroupForApproval_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse submitAdGroupForApproval(

                        com.microsoft.adcenter.v8.SubmitAdGroupForApprovalRequest submitAdGroupForApprovalRequest618,com.microsoft.adcenter.v8.ApplicationToken applicationToken619,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId620,com.microsoft.adcenter.v8.CustomerId customerId621,com.microsoft.adcenter.v8.DeveloperToken developerToken622,com.microsoft.adcenter.v8.Password password623,com.microsoft.adcenter.v8.UserName userName624)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SubmitAdGroupForApproval_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SubmitAdGroupForApproval_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param submitAdGroupForApprovalRequest618
            
                * @param applicationToken619
            
                * @param customerAccountId620
            
                * @param customerId621
            
                * @param developerToken622
            
                * @param password623
            
                * @param userName624
            
          */
        public void startsubmitAdGroupForApproval(

            com.microsoft.adcenter.v8.SubmitAdGroupForApprovalRequest submitAdGroupForApprovalRequest618,com.microsoft.adcenter.v8.ApplicationToken applicationToken619,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId620,
                com.microsoft.adcenter.v8.CustomerId customerId621,
                com.microsoft.adcenter.v8.DeveloperToken developerToken622,
                com.microsoft.adcenter.v8.Password password623,
                com.microsoft.adcenter.v8.UserName userName624,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getTargetByAdGroupIdRequest626
                
                    * @param applicationToken627
                
                    * @param customerAccountId628
                
                    * @param customerId629
                
                    * @param developerToken630
                
                    * @param password631
                
                    * @param userName632
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetByAdGroupId_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetByAdGroupId_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse getTargetByAdGroupId(

                        com.microsoft.adcenter.v8.GetTargetByAdGroupIdRequest getTargetByAdGroupIdRequest626,com.microsoft.adcenter.v8.ApplicationToken applicationToken627,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId628,com.microsoft.adcenter.v8.CustomerId customerId629,com.microsoft.adcenter.v8.DeveloperToken developerToken630,com.microsoft.adcenter.v8.Password password631,com.microsoft.adcenter.v8.UserName userName632)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetByAdGroupId_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetByAdGroupId_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getTargetByAdGroupIdRequest626
            
                * @param applicationToken627
            
                * @param customerAccountId628
            
                * @param customerId629
            
                * @param developerToken630
            
                * @param password631
            
                * @param userName632
            
          */
        public void startgetTargetByAdGroupId(

            com.microsoft.adcenter.v8.GetTargetByAdGroupIdRequest getTargetByAdGroupIdRequest626,com.microsoft.adcenter.v8.ApplicationToken applicationToken627,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId628,
                com.microsoft.adcenter.v8.CustomerId customerId629,
                com.microsoft.adcenter.v8.DeveloperToken developerToken630,
                com.microsoft.adcenter.v8.Password password631,
                com.microsoft.adcenter.v8.UserName userName632,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param pauseSitePlacementsRequest634
                
                    * @param applicationToken635
                
                    * @param customerAccountId636
                
                    * @param customerId637
                
                    * @param developerToken638
                
                    * @param password639
                
                    * @param userName640
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseSitePlacements_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseSitePlacements_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.PauseSitePlacementsResponse pauseSitePlacements(

                        com.microsoft.adcenter.v8.PauseSitePlacementsRequest pauseSitePlacementsRequest634,com.microsoft.adcenter.v8.ApplicationToken applicationToken635,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId636,com.microsoft.adcenter.v8.CustomerId customerId637,com.microsoft.adcenter.v8.DeveloperToken developerToken638,com.microsoft.adcenter.v8.Password password639,com.microsoft.adcenter.v8.UserName userName640)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseSitePlacements_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseSitePlacements_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param pauseSitePlacementsRequest634
            
                * @param applicationToken635
            
                * @param customerAccountId636
            
                * @param customerId637
            
                * @param developerToken638
            
                * @param password639
            
                * @param userName640
            
          */
        public void startpauseSitePlacements(

            com.microsoft.adcenter.v8.PauseSitePlacementsRequest pauseSitePlacementsRequest634,com.microsoft.adcenter.v8.ApplicationToken applicationToken635,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId636,
                com.microsoft.adcenter.v8.CustomerId customerId637,
                com.microsoft.adcenter.v8.DeveloperToken developerToken638,
                com.microsoft.adcenter.v8.Password password639,
                com.microsoft.adcenter.v8.UserName userName640,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdEditorialReasonsByIdsRequest642
                
                    * @param applicationToken643
                
                    * @param customerAccountId644
                
                    * @param customerId645
                
                    * @param developerToken646
                
                    * @param password647
                
                    * @param userName648
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdEditorialReasonsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdEditorialReasonsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsResponse getAdEditorialReasonsByIds(

                        com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsRequest getAdEditorialReasonsByIdsRequest642,com.microsoft.adcenter.v8.ApplicationToken applicationToken643,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId644,com.microsoft.adcenter.v8.CustomerId customerId645,com.microsoft.adcenter.v8.DeveloperToken developerToken646,com.microsoft.adcenter.v8.Password password647,com.microsoft.adcenter.v8.UserName userName648)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdEditorialReasonsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdEditorialReasonsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdEditorialReasonsByIdsRequest642
            
                * @param applicationToken643
            
                * @param customerAccountId644
            
                * @param customerId645
            
                * @param developerToken646
            
                * @param password647
            
                * @param userName648
            
          */
        public void startgetAdEditorialReasonsByIds(

            com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsRequest getAdEditorialReasonsByIdsRequest642,com.microsoft.adcenter.v8.ApplicationToken applicationToken643,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId644,
                com.microsoft.adcenter.v8.CustomerId customerId645,
                com.microsoft.adcenter.v8.DeveloperToken developerToken646,
                com.microsoft.adcenter.v8.Password password647,
                com.microsoft.adcenter.v8.UserName userName648,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getTargetsByCampaignIdsRequest650
                
                    * @param applicationToken651
                
                    * @param customerAccountId652
                
                    * @param customerId653
                
                    * @param developerToken654
                
                    * @param password655
                
                    * @param userName656
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByCampaignIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByCampaignIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse getTargetsByCampaignIds(

                        com.microsoft.adcenter.v8.GetTargetsByCampaignIdsRequest getTargetsByCampaignIdsRequest650,com.microsoft.adcenter.v8.ApplicationToken applicationToken651,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId652,com.microsoft.adcenter.v8.CustomerId customerId653,com.microsoft.adcenter.v8.DeveloperToken developerToken654,com.microsoft.adcenter.v8.Password password655,com.microsoft.adcenter.v8.UserName userName656)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByCampaignIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByCampaignIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getTargetsByCampaignIdsRequest650
            
                * @param applicationToken651
            
                * @param customerAccountId652
            
                * @param customerId653
            
                * @param developerToken654
            
                * @param password655
            
                * @param userName656
            
          */
        public void startgetTargetsByCampaignIds(

            com.microsoft.adcenter.v8.GetTargetsByCampaignIdsRequest getTargetsByCampaignIdsRequest650,com.microsoft.adcenter.v8.ApplicationToken applicationToken651,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId652,
                com.microsoft.adcenter.v8.CustomerId customerId653,
                com.microsoft.adcenter.v8.DeveloperToken developerToken654,
                com.microsoft.adcenter.v8.Password password655,
                com.microsoft.adcenter.v8.UserName userName656,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addBusinessesRequest658
                
                    * @param applicationToken659
                
                    * @param customerAccountId660
                
                    * @param customerId661
                
                    * @param developerToken662
                
                    * @param password663
                
                    * @param userName664
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddBusinesses_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddBusinesses_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddBusinessesResponse addBusinesses(

                        com.microsoft.adcenter.v8.AddBusinessesRequest addBusinessesRequest658,com.microsoft.adcenter.v8.ApplicationToken applicationToken659,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId660,com.microsoft.adcenter.v8.CustomerId customerId661,com.microsoft.adcenter.v8.DeveloperToken developerToken662,com.microsoft.adcenter.v8.Password password663,com.microsoft.adcenter.v8.UserName userName664)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddBusinesses_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddBusinesses_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addBusinessesRequest658
            
                * @param applicationToken659
            
                * @param customerAccountId660
            
                * @param customerId661
            
                * @param developerToken662
            
                * @param password663
            
                * @param userName664
            
          */
        public void startaddBusinesses(

            com.microsoft.adcenter.v8.AddBusinessesRequest addBusinessesRequest658,com.microsoft.adcenter.v8.ApplicationToken applicationToken659,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId660,
                com.microsoft.adcenter.v8.CustomerId customerId661,
                com.microsoft.adcenter.v8.DeveloperToken developerToken662,
                com.microsoft.adcenter.v8.Password password663,
                com.microsoft.adcenter.v8.UserName userName664,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param pauseCampaignsRequest666
                
                    * @param applicationToken667
                
                    * @param customerAccountId668
                
                    * @param customerId669
                
                    * @param developerToken670
                
                    * @param password671
                
                    * @param userName672
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.PauseCampaignsResponse pauseCampaigns(

                        com.microsoft.adcenter.v8.PauseCampaignsRequest pauseCampaignsRequest666,com.microsoft.adcenter.v8.ApplicationToken applicationToken667,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId668,com.microsoft.adcenter.v8.CustomerId customerId669,com.microsoft.adcenter.v8.DeveloperToken developerToken670,com.microsoft.adcenter.v8.Password password671,com.microsoft.adcenter.v8.UserName userName672)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param pauseCampaignsRequest666
            
                * @param applicationToken667
            
                * @param customerAccountId668
            
                * @param customerId669
            
                * @param developerToken670
            
                * @param password671
            
                * @param userName672
            
          */
        public void startpauseCampaigns(

            com.microsoft.adcenter.v8.PauseCampaignsRequest pauseCampaignsRequest666,com.microsoft.adcenter.v8.ApplicationToken applicationToken667,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId668,
                com.microsoft.adcenter.v8.CustomerId customerId669,
                com.microsoft.adcenter.v8.DeveloperToken developerToken670,
                com.microsoft.adcenter.v8.Password password671,
                com.microsoft.adcenter.v8.UserName userName672,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKeywordsByEditorialStatusRequest674
                
                    * @param applicationToken675
                
                    * @param customerAccountId676
                
                    * @param customerId677
                
                    * @param developerToken678
                
                    * @param password679
                
                    * @param userName680
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByEditorialStatus_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByEditorialStatus_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusResponse getKeywordsByEditorialStatus(

                        com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusRequest getKeywordsByEditorialStatusRequest674,com.microsoft.adcenter.v8.ApplicationToken applicationToken675,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId676,com.microsoft.adcenter.v8.CustomerId customerId677,com.microsoft.adcenter.v8.DeveloperToken developerToken678,com.microsoft.adcenter.v8.Password password679,com.microsoft.adcenter.v8.UserName userName680)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByEditorialStatus_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByEditorialStatus_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKeywordsByEditorialStatusRequest674
            
                * @param applicationToken675
            
                * @param customerAccountId676
            
                * @param customerId677
            
                * @param developerToken678
            
                * @param password679
            
                * @param userName680
            
          */
        public void startgetKeywordsByEditorialStatus(

            com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusRequest getKeywordsByEditorialStatusRequest674,com.microsoft.adcenter.v8.ApplicationToken applicationToken675,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId676,
                com.microsoft.adcenter.v8.CustomerId customerId677,
                com.microsoft.adcenter.v8.DeveloperToken developerToken678,
                com.microsoft.adcenter.v8.Password password679,
                com.microsoft.adcenter.v8.UserName userName680,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKeywordEditorialReasonsByIdsRequest682
                
                    * @param applicationToken683
                
                    * @param customerAccountId684
                
                    * @param customerId685
                
                    * @param developerToken686
                
                    * @param password687
                
                    * @param userName688
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordEditorialReasonsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordEditorialReasonsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsResponse getKeywordEditorialReasonsByIds(

                        com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsRequest getKeywordEditorialReasonsByIdsRequest682,com.microsoft.adcenter.v8.ApplicationToken applicationToken683,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId684,com.microsoft.adcenter.v8.CustomerId customerId685,com.microsoft.adcenter.v8.DeveloperToken developerToken686,com.microsoft.adcenter.v8.Password password687,com.microsoft.adcenter.v8.UserName userName688)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordEditorialReasonsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordEditorialReasonsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKeywordEditorialReasonsByIdsRequest682
            
                * @param applicationToken683
            
                * @param customerAccountId684
            
                * @param customerId685
            
                * @param developerToken686
            
                * @param password687
            
                * @param userName688
            
          */
        public void startgetKeywordEditorialReasonsByIds(

            com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsRequest getKeywordEditorialReasonsByIdsRequest682,com.microsoft.adcenter.v8.ApplicationToken applicationToken683,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId684,
                com.microsoft.adcenter.v8.CustomerId customerId685,
                com.microsoft.adcenter.v8.DeveloperToken developerToken686,
                com.microsoft.adcenter.v8.Password password687,
                com.microsoft.adcenter.v8.UserName userName688,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteTargetFromAdGroupRequest690
                
                    * @param applicationToken691
                
                    * @param customerAccountId692
                
                    * @param customerId693
                
                    * @param developerToken694
                
                    * @param password695
                
                    * @param userName696
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetFromAdGroup_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetFromAdGroup_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteTargetFromAdGroupResponse deleteTargetFromAdGroup(

                        com.microsoft.adcenter.v8.DeleteTargetFromAdGroupRequest deleteTargetFromAdGroupRequest690,com.microsoft.adcenter.v8.ApplicationToken applicationToken691,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId692,com.microsoft.adcenter.v8.CustomerId customerId693,com.microsoft.adcenter.v8.DeveloperToken developerToken694,com.microsoft.adcenter.v8.Password password695,com.microsoft.adcenter.v8.UserName userName696)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetFromAdGroup_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetFromAdGroup_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteTargetFromAdGroupRequest690
            
                * @param applicationToken691
            
                * @param customerAccountId692
            
                * @param customerId693
            
                * @param developerToken694
            
                * @param password695
            
                * @param userName696
            
          */
        public void startdeleteTargetFromAdGroup(

            com.microsoft.adcenter.v8.DeleteTargetFromAdGroupRequest deleteTargetFromAdGroupRequest690,com.microsoft.adcenter.v8.ApplicationToken applicationToken691,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId692,
                com.microsoft.adcenter.v8.CustomerId customerId693,
                com.microsoft.adcenter.v8.DeveloperToken developerToken694,
                com.microsoft.adcenter.v8.Password password695,
                com.microsoft.adcenter.v8.UserName userName696,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param downloadCampaignHierarchyRequest698
                
                    * @param applicationToken699
                
                    * @param customerAccountId700
                
                    * @param customerId701
                
                    * @param developerToken702
                
                    * @param password703
                
                    * @param userName704
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DownloadCampaignHierarchy_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DownloadCampaignHierarchy_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DownloadCampaignHierarchyResponse downloadCampaignHierarchy(

                        com.microsoft.adcenter.v8.DownloadCampaignHierarchyRequest downloadCampaignHierarchyRequest698,com.microsoft.adcenter.v8.ApplicationToken applicationToken699,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId700,com.microsoft.adcenter.v8.CustomerId customerId701,com.microsoft.adcenter.v8.DeveloperToken developerToken702,com.microsoft.adcenter.v8.Password password703,com.microsoft.adcenter.v8.UserName userName704)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DownloadCampaignHierarchy_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DownloadCampaignHierarchy_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param downloadCampaignHierarchyRequest698
            
                * @param applicationToken699
            
                * @param customerAccountId700
            
                * @param customerId701
            
                * @param developerToken702
            
                * @param password703
            
                * @param userName704
            
          */
        public void startdownloadCampaignHierarchy(

            com.microsoft.adcenter.v8.DownloadCampaignHierarchyRequest downloadCampaignHierarchyRequest698,com.microsoft.adcenter.v8.ApplicationToken applicationToken699,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId700,
                com.microsoft.adcenter.v8.CustomerId customerId701,
                com.microsoft.adcenter.v8.DeveloperToken developerToken702,
                com.microsoft.adcenter.v8.Password password703,
                com.microsoft.adcenter.v8.UserName userName704,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param resumeKeywordsRequest706
                
                    * @param applicationToken707
                
                    * @param customerAccountId708
                
                    * @param customerId709
                
                    * @param developerToken710
                
                    * @param password711
                
                    * @param userName712
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeKeywords_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeKeywords_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.ResumeKeywordsResponse resumeKeywords(

                        com.microsoft.adcenter.v8.ResumeKeywordsRequest resumeKeywordsRequest706,com.microsoft.adcenter.v8.ApplicationToken applicationToken707,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId708,com.microsoft.adcenter.v8.CustomerId customerId709,com.microsoft.adcenter.v8.DeveloperToken developerToken710,com.microsoft.adcenter.v8.Password password711,com.microsoft.adcenter.v8.UserName userName712)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeKeywords_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeKeywords_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param resumeKeywordsRequest706
            
                * @param applicationToken707
            
                * @param customerAccountId708
            
                * @param customerId709
            
                * @param developerToken710
            
                * @param password711
            
                * @param userName712
            
          */
        public void startresumeKeywords(

            com.microsoft.adcenter.v8.ResumeKeywordsRequest resumeKeywordsRequest706,com.microsoft.adcenter.v8.ApplicationToken applicationToken707,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId708,
                com.microsoft.adcenter.v8.CustomerId customerId709,
                com.microsoft.adcenter.v8.DeveloperToken developerToken710,
                com.microsoft.adcenter.v8.Password password711,
                com.microsoft.adcenter.v8.UserName userName712,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteAdExtensionsFromCampaignsRequest714
                
                    * @param applicationToken715
                
                    * @param customerAccountId716
                
                    * @param customerId717
                
                    * @param developerToken718
                
                    * @param password719
                
                    * @param userName720
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAdExtensionsFromCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAdExtensionsFromCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsResponse deleteAdExtensionsFromCampaigns(

                        com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsRequest deleteAdExtensionsFromCampaignsRequest714,com.microsoft.adcenter.v8.ApplicationToken applicationToken715,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId716,com.microsoft.adcenter.v8.CustomerId customerId717,com.microsoft.adcenter.v8.DeveloperToken developerToken718,com.microsoft.adcenter.v8.Password password719,com.microsoft.adcenter.v8.UserName userName720)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAdExtensionsFromCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAdExtensionsFromCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteAdExtensionsFromCampaignsRequest714
            
                * @param applicationToken715
            
                * @param customerAccountId716
            
                * @param customerId717
            
                * @param developerToken718
            
                * @param password719
            
                * @param userName720
            
          */
        public void startdeleteAdExtensionsFromCampaigns(

            com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsRequest deleteAdExtensionsFromCampaignsRequest714,com.microsoft.adcenter.v8.ApplicationToken applicationToken715,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId716,
                com.microsoft.adcenter.v8.CustomerId customerId717,
                com.microsoft.adcenter.v8.DeveloperToken developerToken718,
                com.microsoft.adcenter.v8.Password password719,
                com.microsoft.adcenter.v8.UserName userName720,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setNegativeSitesToCampaignsRequest722
                
                    * @param applicationToken723
                
                    * @param customerAccountId724
                
                    * @param customerId725
                
                    * @param developerToken726
                
                    * @param password727
                
                    * @param userName728
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeSitesToCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeSitesToCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsResponse setNegativeSitesToCampaigns(

                        com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsRequest setNegativeSitesToCampaignsRequest722,com.microsoft.adcenter.v8.ApplicationToken applicationToken723,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId724,com.microsoft.adcenter.v8.CustomerId customerId725,com.microsoft.adcenter.v8.DeveloperToken developerToken726,com.microsoft.adcenter.v8.Password password727,com.microsoft.adcenter.v8.UserName userName728)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeSitesToCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeSitesToCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setNegativeSitesToCampaignsRequest722
            
                * @param applicationToken723
            
                * @param customerAccountId724
            
                * @param customerId725
            
                * @param developerToken726
            
                * @param password727
            
                * @param userName728
            
          */
        public void startsetNegativeSitesToCampaigns(

            com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsRequest setNegativeSitesToCampaignsRequest722,com.microsoft.adcenter.v8.ApplicationToken applicationToken723,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId724,
                com.microsoft.adcenter.v8.CustomerId customerId725,
                com.microsoft.adcenter.v8.DeveloperToken developerToken726,
                com.microsoft.adcenter.v8.Password password727,
                com.microsoft.adcenter.v8.UserName userName728,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateDeviceOSTargetsRequest730
                
                    * @param applicationToken731
                
                    * @param customerAccountId732
                
                    * @param customerId733
                
                    * @param developerToken734
                
                    * @param password735
                
                    * @param userName736
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateDeviceOSTargets_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateDeviceOSTargets_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateDeviceOSTargetsResponse updateDeviceOSTargets(

                        com.microsoft.adcenter.v8.UpdateDeviceOSTargetsRequest updateDeviceOSTargetsRequest730,com.microsoft.adcenter.v8.ApplicationToken applicationToken731,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId732,com.microsoft.adcenter.v8.CustomerId customerId733,com.microsoft.adcenter.v8.DeveloperToken developerToken734,com.microsoft.adcenter.v8.Password password735,com.microsoft.adcenter.v8.UserName userName736)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateDeviceOSTargets_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateDeviceOSTargets_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateDeviceOSTargetsRequest730
            
                * @param applicationToken731
            
                * @param customerAccountId732
            
                * @param customerId733
            
                * @param developerToken734
            
                * @param password735
            
                * @param userName736
            
          */
        public void startupdateDeviceOSTargets(

            com.microsoft.adcenter.v8.UpdateDeviceOSTargetsRequest updateDeviceOSTargetsRequest730,com.microsoft.adcenter.v8.ApplicationToken applicationToken731,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId732,
                com.microsoft.adcenter.v8.CustomerId customerId733,
                com.microsoft.adcenter.v8.DeveloperToken developerToken734,
                com.microsoft.adcenter.v8.Password password735,
                com.microsoft.adcenter.v8.UserName userName736,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByEditorialStatusRequest738
                
                    * @param applicationToken739
                
                    * @param customerAccountId740
                
                    * @param customerId741
                
                    * @param developerToken742
                
                    * @param password743
                
                    * @param userName744
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByEditorialStatus_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByEditorialStatus_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAdsByEditorialStatusResponse getAdsByEditorialStatus(

                        com.microsoft.adcenter.v8.GetAdsByEditorialStatusRequest getAdsByEditorialStatusRequest738,com.microsoft.adcenter.v8.ApplicationToken applicationToken739,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId740,com.microsoft.adcenter.v8.CustomerId customerId741,com.microsoft.adcenter.v8.DeveloperToken developerToken742,com.microsoft.adcenter.v8.Password password743,com.microsoft.adcenter.v8.UserName userName744)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByEditorialStatus_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByEditorialStatus_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByEditorialStatusRequest738
            
                * @param applicationToken739
            
                * @param customerAccountId740
            
                * @param customerId741
            
                * @param developerToken742
            
                * @param password743
            
                * @param userName744
            
          */
        public void startgetAdsByEditorialStatus(

            com.microsoft.adcenter.v8.GetAdsByEditorialStatusRequest getAdsByEditorialStatusRequest738,com.microsoft.adcenter.v8.ApplicationToken applicationToken739,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId740,
                com.microsoft.adcenter.v8.CustomerId customerId741,
                com.microsoft.adcenter.v8.DeveloperToken developerToken742,
                com.microsoft.adcenter.v8.Password password743,
                com.microsoft.adcenter.v8.UserName userName744,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteCampaignsRequest746
                
                    * @param applicationToken747
                
                    * @param customerAccountId748
                
                    * @param customerId749
                
                    * @param developerToken750
                
                    * @param password751
                
                    * @param userName752
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteCampaignsResponse deleteCampaigns(

                        com.microsoft.adcenter.v8.DeleteCampaignsRequest deleteCampaignsRequest746,com.microsoft.adcenter.v8.ApplicationToken applicationToken747,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId748,com.microsoft.adcenter.v8.CustomerId customerId749,com.microsoft.adcenter.v8.DeveloperToken developerToken750,com.microsoft.adcenter.v8.Password password751,com.microsoft.adcenter.v8.UserName userName752)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteCampaignsRequest746
            
                * @param applicationToken747
            
                * @param customerAccountId748
            
                * @param customerId749
            
                * @param developerToken750
            
                * @param password751
            
                * @param userName752
            
          */
        public void startdeleteCampaigns(

            com.microsoft.adcenter.v8.DeleteCampaignsRequest deleteCampaignsRequest746,com.microsoft.adcenter.v8.ApplicationToken applicationToken747,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId748,
                com.microsoft.adcenter.v8.CustomerId customerId749,
                com.microsoft.adcenter.v8.DeveloperToken developerToken750,
                com.microsoft.adcenter.v8.Password password751,
                com.microsoft.adcenter.v8.UserName userName752,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addGoalsRequest754
                
                    * @param applicationToken755
                
                    * @param customerAccountId756
                
                    * @param customerId757
                
                    * @param developerToken758
                
                    * @param password759
                
                    * @param userName760
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddGoals_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddGoals_ApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddGoalsResponse addGoals(

                        com.microsoft.adcenter.v8.AddGoalsRequest addGoalsRequest754,com.microsoft.adcenter.v8.ApplicationToken applicationToken755,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId756,com.microsoft.adcenter.v8.CustomerId customerId757,com.microsoft.adcenter.v8.DeveloperToken developerToken758,com.microsoft.adcenter.v8.Password password759,com.microsoft.adcenter.v8.UserName userName760)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddGoals_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddGoals_ApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addGoalsRequest754
            
                * @param applicationToken755
            
                * @param customerAccountId756
            
                * @param customerId757
            
                * @param developerToken758
            
                * @param password759
            
                * @param userName760
            
          */
        public void startaddGoals(

            com.microsoft.adcenter.v8.AddGoalsRequest addGoalsRequest754,com.microsoft.adcenter.v8.ApplicationToken applicationToken755,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId756,
                com.microsoft.adcenter.v8.CustomerId customerId757,
                com.microsoft.adcenter.v8.DeveloperToken developerToken758,
                com.microsoft.adcenter.v8.Password password759,
                com.microsoft.adcenter.v8.UserName userName760,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getDownloadStatusRequest762
                
                    * @param applicationToken763
                
                    * @param customerAccountId764
                
                    * @param customerId765
                
                    * @param developerToken766
                
                    * @param password767
                
                    * @param userName768
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetDownloadStatus_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetDownloadStatus_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetDownloadStatusResponse getDownloadStatus(

                        com.microsoft.adcenter.v8.GetDownloadStatusRequest getDownloadStatusRequest762,com.microsoft.adcenter.v8.ApplicationToken applicationToken763,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId764,com.microsoft.adcenter.v8.CustomerId customerId765,com.microsoft.adcenter.v8.DeveloperToken developerToken766,com.microsoft.adcenter.v8.Password password767,com.microsoft.adcenter.v8.UserName userName768)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetDownloadStatus_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetDownloadStatus_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getDownloadStatusRequest762
            
                * @param applicationToken763
            
                * @param customerAccountId764
            
                * @param customerId765
            
                * @param developerToken766
            
                * @param password767
            
                * @param userName768
            
          */
        public void startgetDownloadStatus(

            com.microsoft.adcenter.v8.GetDownloadStatusRequest getDownloadStatusRequest762,com.microsoft.adcenter.v8.ApplicationToken applicationToken763,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId764,
                com.microsoft.adcenter.v8.CustomerId customerId765,
                com.microsoft.adcenter.v8.DeveloperToken developerToken766,
                com.microsoft.adcenter.v8.Password password767,
                com.microsoft.adcenter.v8.UserName userName768,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setTargetToCampaignRequest770
                
                    * @param applicationToken771
                
                    * @param customerAccountId772
                
                    * @param customerId773
                
                    * @param developerToken774
                
                    * @param password775
                
                    * @param userName776
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetTargetToCampaign_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetTargetToCampaign_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetTargetToCampaignResponse setTargetToCampaign(

                        com.microsoft.adcenter.v8.SetTargetToCampaignRequest setTargetToCampaignRequest770,com.microsoft.adcenter.v8.ApplicationToken applicationToken771,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId772,com.microsoft.adcenter.v8.CustomerId customerId773,com.microsoft.adcenter.v8.DeveloperToken developerToken774,com.microsoft.adcenter.v8.Password password775,com.microsoft.adcenter.v8.UserName userName776)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetTargetToCampaign_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetTargetToCampaign_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setTargetToCampaignRequest770
            
                * @param applicationToken771
            
                * @param customerAccountId772
            
                * @param customerId773
            
                * @param developerToken774
            
                * @param password775
            
                * @param userName776
            
          */
        public void startsetTargetToCampaign(

            com.microsoft.adcenter.v8.SetTargetToCampaignRequest setTargetToCampaignRequest770,com.microsoft.adcenter.v8.ApplicationToken applicationToken771,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId772,
                com.microsoft.adcenter.v8.CustomerId customerId773,
                com.microsoft.adcenter.v8.DeveloperToken developerToken774,
                com.microsoft.adcenter.v8.Password password775,
                com.microsoft.adcenter.v8.UserName userName776,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param resumeCampaignsRequest778
                
                    * @param applicationToken779
                
                    * @param customerAccountId780
                
                    * @param customerId781
                
                    * @param developerToken782
                
                    * @param password783
                
                    * @param userName784
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.ResumeCampaignsResponse resumeCampaigns(

                        com.microsoft.adcenter.v8.ResumeCampaignsRequest resumeCampaignsRequest778,com.microsoft.adcenter.v8.ApplicationToken applicationToken779,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId780,com.microsoft.adcenter.v8.CustomerId customerId781,com.microsoft.adcenter.v8.DeveloperToken developerToken782,com.microsoft.adcenter.v8.Password password783,com.microsoft.adcenter.v8.UserName userName784)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param resumeCampaignsRequest778
            
                * @param applicationToken779
            
                * @param customerAccountId780
            
                * @param customerId781
            
                * @param developerToken782
            
                * @param password783
            
                * @param userName784
            
          */
        public void startresumeCampaigns(

            com.microsoft.adcenter.v8.ResumeCampaignsRequest resumeCampaignsRequest778,com.microsoft.adcenter.v8.ApplicationToken applicationToken779,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId780,
                com.microsoft.adcenter.v8.CustomerId customerId781,
                com.microsoft.adcenter.v8.DeveloperToken developerToken782,
                com.microsoft.adcenter.v8.Password password783,
                com.microsoft.adcenter.v8.UserName userName784,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param pauseAdGroupsRequest786
                
                    * @param applicationToken787
                
                    * @param customerAccountId788
                
                    * @param customerId789
                
                    * @param developerToken790
                
                    * @param password791
                
                    * @param userName792
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseAdGroups_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseAdGroups_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.PauseAdGroupsResponse pauseAdGroups(

                        com.microsoft.adcenter.v8.PauseAdGroupsRequest pauseAdGroupsRequest786,com.microsoft.adcenter.v8.ApplicationToken applicationToken787,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId788,com.microsoft.adcenter.v8.CustomerId customerId789,com.microsoft.adcenter.v8.DeveloperToken developerToken790,com.microsoft.adcenter.v8.Password password791,com.microsoft.adcenter.v8.UserName userName792)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseAdGroups_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseAdGroups_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param pauseAdGroupsRequest786
            
                * @param applicationToken787
            
                * @param customerAccountId788
            
                * @param customerId789
            
                * @param developerToken790
            
                * @param password791
            
                * @param userName792
            
          */
        public void startpauseAdGroups(

            com.microsoft.adcenter.v8.PauseAdGroupsRequest pauseAdGroupsRequest786,com.microsoft.adcenter.v8.ApplicationToken applicationToken787,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId788,
                com.microsoft.adcenter.v8.CustomerId customerId789,
                com.microsoft.adcenter.v8.DeveloperToken developerToken790,
                com.microsoft.adcenter.v8.Password password791,
                com.microsoft.adcenter.v8.UserName userName792,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateTargetsInLibraryRequest794
                
                    * @param applicationToken795
                
                    * @param customerAccountId796
                
                    * @param customerId797
                
                    * @param developerToken798
                
                    * @param password799
                
                    * @param userName800
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateTargetsInLibrary_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateTargetsInLibrary_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateTargetsInLibraryResponse updateTargetsInLibrary(

                        com.microsoft.adcenter.v8.UpdateTargetsInLibraryRequest updateTargetsInLibraryRequest794,com.microsoft.adcenter.v8.ApplicationToken applicationToken795,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId796,com.microsoft.adcenter.v8.CustomerId customerId797,com.microsoft.adcenter.v8.DeveloperToken developerToken798,com.microsoft.adcenter.v8.Password password799,com.microsoft.adcenter.v8.UserName userName800)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateTargetsInLibrary_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateTargetsInLibrary_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateTargetsInLibraryRequest794
            
                * @param applicationToken795
            
                * @param customerAccountId796
            
                * @param customerId797
            
                * @param developerToken798
            
                * @param password799
            
                * @param userName800
            
          */
        public void startupdateTargetsInLibrary(

            com.microsoft.adcenter.v8.UpdateTargetsInLibraryRequest updateTargetsInLibraryRequest794,com.microsoft.adcenter.v8.ApplicationToken applicationToken795,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId796,
                com.microsoft.adcenter.v8.CustomerId customerId797,
                com.microsoft.adcenter.v8.DeveloperToken developerToken798,
                com.microsoft.adcenter.v8.Password password799,
                com.microsoft.adcenter.v8.UserName userName800,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteBusinessesRequest802
                
                    * @param applicationToken803
                
                    * @param customerAccountId804
                
                    * @param customerId805
                
                    * @param developerToken806
                
                    * @param password807
                
                    * @param userName808
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteBusinesses_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteBusinesses_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteBusinessesResponse deleteBusinesses(

                        com.microsoft.adcenter.v8.DeleteBusinessesRequest deleteBusinessesRequest802,com.microsoft.adcenter.v8.ApplicationToken applicationToken803,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId804,com.microsoft.adcenter.v8.CustomerId customerId805,com.microsoft.adcenter.v8.DeveloperToken developerToken806,com.microsoft.adcenter.v8.Password password807,com.microsoft.adcenter.v8.UserName userName808)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteBusinesses_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteBusinesses_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteBusinessesRequest802
            
                * @param applicationToken803
            
                * @param customerAccountId804
            
                * @param customerId805
            
                * @param developerToken806
            
                * @param password807
            
                * @param userName808
            
          */
        public void startdeleteBusinesses(

            com.microsoft.adcenter.v8.DeleteBusinessesRequest deleteBusinessesRequest802,com.microsoft.adcenter.v8.ApplicationToken applicationToken803,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId804,
                com.microsoft.adcenter.v8.CustomerId customerId805,
                com.microsoft.adcenter.v8.DeveloperToken developerToken806,
                com.microsoft.adcenter.v8.Password password807,
                com.microsoft.adcenter.v8.UserName userName808,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setAnalyticsTypeRequest810
                
                    * @param applicationToken811
                
                    * @param customerAccountId812
                
                    * @param customerId813
                
                    * @param developerToken814
                
                    * @param password815
                
                    * @param userName816
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetAnalyticsType_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetAnalyticsType_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetAnalyticsTypeResponse setAnalyticsType(

                        com.microsoft.adcenter.v8.SetAnalyticsTypeRequest setAnalyticsTypeRequest810,com.microsoft.adcenter.v8.ApplicationToken applicationToken811,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId812,com.microsoft.adcenter.v8.CustomerId customerId813,com.microsoft.adcenter.v8.DeveloperToken developerToken814,com.microsoft.adcenter.v8.Password password815,com.microsoft.adcenter.v8.UserName userName816)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetAnalyticsType_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetAnalyticsType_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setAnalyticsTypeRequest810
            
                * @param applicationToken811
            
                * @param customerAccountId812
            
                * @param customerId813
            
                * @param developerToken814
            
                * @param password815
            
                * @param userName816
            
          */
        public void startsetAnalyticsType(

            com.microsoft.adcenter.v8.SetAnalyticsTypeRequest setAnalyticsTypeRequest810,com.microsoft.adcenter.v8.ApplicationToken applicationToken811,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId812,
                com.microsoft.adcenter.v8.CustomerId customerId813,
                com.microsoft.adcenter.v8.DeveloperToken developerToken814,
                com.microsoft.adcenter.v8.Password password815,
                com.microsoft.adcenter.v8.UserName userName816,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getNegativeSitesByAdGroupIdsRequest818
                
                    * @param applicationToken819
                
                    * @param customerAccountId820
                
                    * @param customerId821
                
                    * @param developerToken822
                
                    * @param password823
                
                    * @param userName824
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeSitesByAdGroupIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeSitesByAdGroupIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsResponse getNegativeSitesByAdGroupIds(

                        com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsRequest getNegativeSitesByAdGroupIdsRequest818,com.microsoft.adcenter.v8.ApplicationToken applicationToken819,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId820,com.microsoft.adcenter.v8.CustomerId customerId821,com.microsoft.adcenter.v8.DeveloperToken developerToken822,com.microsoft.adcenter.v8.Password password823,com.microsoft.adcenter.v8.UserName userName824)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeSitesByAdGroupIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeSitesByAdGroupIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getNegativeSitesByAdGroupIdsRequest818
            
                * @param applicationToken819
            
                * @param customerAccountId820
            
                * @param customerId821
            
                * @param developerToken822
            
                * @param password823
            
                * @param userName824
            
          */
        public void startgetNegativeSitesByAdGroupIds(

            com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsRequest getNegativeSitesByAdGroupIdsRequest818,com.microsoft.adcenter.v8.ApplicationToken applicationToken819,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId820,
                com.microsoft.adcenter.v8.CustomerId customerId821,
                com.microsoft.adcenter.v8.DeveloperToken developerToken822,
                com.microsoft.adcenter.v8.Password password823,
                com.microsoft.adcenter.v8.UserName userName824,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteAdGroupsRequest826
                
                    * @param applicationToken827
                
                    * @param customerAccountId828
                
                    * @param customerId829
                
                    * @param developerToken830
                
                    * @param password831
                
                    * @param userName832
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAdGroups_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAdGroups_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteAdGroupsResponse deleteAdGroups(

                        com.microsoft.adcenter.v8.DeleteAdGroupsRequest deleteAdGroupsRequest826,com.microsoft.adcenter.v8.ApplicationToken applicationToken827,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId828,com.microsoft.adcenter.v8.CustomerId customerId829,com.microsoft.adcenter.v8.DeveloperToken developerToken830,com.microsoft.adcenter.v8.Password password831,com.microsoft.adcenter.v8.UserName userName832)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAdGroups_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteAdGroups_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteAdGroupsRequest826
            
                * @param applicationToken827
            
                * @param customerAccountId828
            
                * @param customerId829
            
                * @param developerToken830
            
                * @param password831
            
                * @param userName832
            
          */
        public void startdeleteAdGroups(

            com.microsoft.adcenter.v8.DeleteAdGroupsRequest deleteAdGroupsRequest826,com.microsoft.adcenter.v8.ApplicationToken applicationToken827,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId828,
                com.microsoft.adcenter.v8.CustomerId customerId829,
                com.microsoft.adcenter.v8.DeveloperToken developerToken830,
                com.microsoft.adcenter.v8.Password password831,
                com.microsoft.adcenter.v8.UserName userName832,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateCampaignsRequest834
                
                    * @param applicationToken835
                
                    * @param customerAccountId836
                
                    * @param customerId837
                
                    * @param developerToken838
                
                    * @param password839
                
                    * @param userName840
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateCampaignsResponse updateCampaigns(

                        com.microsoft.adcenter.v8.UpdateCampaignsRequest updateCampaignsRequest834,com.microsoft.adcenter.v8.ApplicationToken applicationToken835,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId836,com.microsoft.adcenter.v8.CustomerId customerId837,com.microsoft.adcenter.v8.DeveloperToken developerToken838,com.microsoft.adcenter.v8.Password password839,com.microsoft.adcenter.v8.UserName userName840)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateCampaignsRequest834
            
                * @param applicationToken835
            
                * @param customerAccountId836
            
                * @param customerId837
            
                * @param developerToken838
            
                * @param password839
            
                * @param userName840
            
          */
        public void startupdateCampaigns(

            com.microsoft.adcenter.v8.UpdateCampaignsRequest updateCampaignsRequest834,com.microsoft.adcenter.v8.ApplicationToken applicationToken835,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId836,
                com.microsoft.adcenter.v8.CustomerId customerId837,
                com.microsoft.adcenter.v8.DeveloperToken developerToken838,
                com.microsoft.adcenter.v8.Password password839,
                com.microsoft.adcenter.v8.UserName userName840,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCampaignsByAccountIdRequest842
                
                    * @param applicationToken843
                
                    * @param customerAccountId844
                
                    * @param customerId845
                
                    * @param developerToken846
                
                    * @param password847
                
                    * @param userName848
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignsByAccountId_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignsByAccountId_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse getCampaignsByAccountId(

                        com.microsoft.adcenter.v8.GetCampaignsByAccountIdRequest getCampaignsByAccountIdRequest842,com.microsoft.adcenter.v8.ApplicationToken applicationToken843,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId844,com.microsoft.adcenter.v8.CustomerId customerId845,com.microsoft.adcenter.v8.DeveloperToken developerToken846,com.microsoft.adcenter.v8.Password password847,com.microsoft.adcenter.v8.UserName userName848)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignsByAccountId_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignsByAccountId_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCampaignsByAccountIdRequest842
            
                * @param applicationToken843
            
                * @param customerAccountId844
            
                * @param customerId845
            
                * @param developerToken846
            
                * @param password847
            
                * @param userName848
            
          */
        public void startgetCampaignsByAccountId(

            com.microsoft.adcenter.v8.GetCampaignsByAccountIdRequest getCampaignsByAccountIdRequest842,com.microsoft.adcenter.v8.ApplicationToken applicationToken843,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId844,
                com.microsoft.adcenter.v8.CustomerId customerId845,
                com.microsoft.adcenter.v8.DeveloperToken developerToken846,
                com.microsoft.adcenter.v8.Password password847,
                com.microsoft.adcenter.v8.UserName userName848,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addAdsRequest850
                
                    * @param applicationToken851
                
                    * @param customerAccountId852
                
                    * @param customerId853
                
                    * @param developerToken854
                
                    * @param password855
                
                    * @param userName856
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddAds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddAds_EditorialApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddAdsResponse addAds(

                        com.microsoft.adcenter.v8.AddAdsRequest addAdsRequest850,com.microsoft.adcenter.v8.ApplicationToken applicationToken851,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId852,com.microsoft.adcenter.v8.CustomerId customerId853,com.microsoft.adcenter.v8.DeveloperToken developerToken854,com.microsoft.adcenter.v8.Password password855,com.microsoft.adcenter.v8.UserName userName856)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddAds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddAds_EditorialApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addAdsRequest850
            
                * @param applicationToken851
            
                * @param customerAccountId852
            
                * @param customerId853
            
                * @param developerToken854
            
                * @param password855
            
                * @param userName856
            
          */
        public void startaddAds(

            com.microsoft.adcenter.v8.AddAdsRequest addAdsRequest850,com.microsoft.adcenter.v8.ApplicationToken applicationToken851,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId852,
                com.microsoft.adcenter.v8.CustomerId customerId853,
                com.microsoft.adcenter.v8.DeveloperToken developerToken854,
                com.microsoft.adcenter.v8.Password password855,
                com.microsoft.adcenter.v8.UserName userName856,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setCampaignAdExtensionsRequest858
                
                    * @param applicationToken859
                
                    * @param customerAccountId860
                
                    * @param customerId861
                
                    * @param developerToken862
                
                    * @param password863
                
                    * @param userName864
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetCampaignAdExtensions_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetCampaignAdExtensionsResponse setCampaignAdExtensions(

                        com.microsoft.adcenter.v8.SetCampaignAdExtensionsRequest setCampaignAdExtensionsRequest858,com.microsoft.adcenter.v8.ApplicationToken applicationToken859,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId860,com.microsoft.adcenter.v8.CustomerId customerId861,com.microsoft.adcenter.v8.DeveloperToken developerToken862,com.microsoft.adcenter.v8.Password password863,com.microsoft.adcenter.v8.UserName userName864)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetCampaignAdExtensions_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setCampaignAdExtensionsRequest858
            
                * @param applicationToken859
            
                * @param customerAccountId860
            
                * @param customerId861
            
                * @param developerToken862
            
                * @param password863
            
                * @param userName864
            
          */
        public void startsetCampaignAdExtensions(

            com.microsoft.adcenter.v8.SetCampaignAdExtensionsRequest setCampaignAdExtensionsRequest858,com.microsoft.adcenter.v8.ApplicationToken applicationToken859,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId860,
                com.microsoft.adcenter.v8.CustomerId customerId861,
                com.microsoft.adcenter.v8.DeveloperToken developerToken862,
                com.microsoft.adcenter.v8.Password password863,
                com.microsoft.adcenter.v8.UserName userName864,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAccountMigrationStatusesRequest866
                
                    * @param applicationToken867
                
                    * @param customerAccountId868
                
                    * @param customerId869
                
                    * @param developerToken870
                
                    * @param password871
                
                    * @param userName872
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAccountMigrationStatuses_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAccountMigrationStatuses_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAccountMigrationStatusesResponse getAccountMigrationStatuses(

                        com.microsoft.adcenter.v8.GetAccountMigrationStatusesRequest getAccountMigrationStatusesRequest866,com.microsoft.adcenter.v8.ApplicationToken applicationToken867,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId868,com.microsoft.adcenter.v8.CustomerId customerId869,com.microsoft.adcenter.v8.DeveloperToken developerToken870,com.microsoft.adcenter.v8.Password password871,com.microsoft.adcenter.v8.UserName userName872)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAccountMigrationStatuses_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAccountMigrationStatuses_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAccountMigrationStatusesRequest866
            
                * @param applicationToken867
            
                * @param customerAccountId868
            
                * @param customerId869
            
                * @param developerToken870
            
                * @param password871
            
                * @param userName872
            
          */
        public void startgetAccountMigrationStatuses(

            com.microsoft.adcenter.v8.GetAccountMigrationStatusesRequest getAccountMigrationStatusesRequest866,com.microsoft.adcenter.v8.ApplicationToken applicationToken867,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId868,
                com.microsoft.adcenter.v8.CustomerId customerId869,
                com.microsoft.adcenter.v8.DeveloperToken developerToken870,
                com.microsoft.adcenter.v8.Password password871,
                com.microsoft.adcenter.v8.UserName userName872,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getDeviceOSTargetsByIdsRequest874
                
                    * @param applicationToken875
                
                    * @param customerAccountId876
                
                    * @param customerId877
                
                    * @param developerToken878
                
                    * @param password879
                
                    * @param userName880
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetDeviceOSTargetsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetDeviceOSTargetsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsResponse getDeviceOSTargetsByIds(

                        com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsRequest getDeviceOSTargetsByIdsRequest874,com.microsoft.adcenter.v8.ApplicationToken applicationToken875,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId876,com.microsoft.adcenter.v8.CustomerId customerId877,com.microsoft.adcenter.v8.DeveloperToken developerToken878,com.microsoft.adcenter.v8.Password password879,com.microsoft.adcenter.v8.UserName userName880)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetDeviceOSTargetsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetDeviceOSTargetsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getDeviceOSTargetsByIdsRequest874
            
                * @param applicationToken875
            
                * @param customerAccountId876
            
                * @param customerId877
            
                * @param developerToken878
            
                * @param password879
            
                * @param userName880
            
          */
        public void startgetDeviceOSTargetsByIds(

            com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsRequest getDeviceOSTargetsByIdsRequest874,com.microsoft.adcenter.v8.ApplicationToken applicationToken875,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId876,
                com.microsoft.adcenter.v8.CustomerId customerId877,
                com.microsoft.adcenter.v8.DeveloperToken developerToken878,
                com.microsoft.adcenter.v8.Password password879,
                com.microsoft.adcenter.v8.UserName userName880,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getGoalsRequest882
                
                    * @param applicationToken883
                
                    * @param customerAccountId884
                
                    * @param customerId885
                
                    * @param developerToken886
                
                    * @param password887
                
                    * @param userName888
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetGoals_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetGoals_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetGoalsResponse getGoals(

                        com.microsoft.adcenter.v8.GetGoalsRequest getGoalsRequest882,com.microsoft.adcenter.v8.ApplicationToken applicationToken883,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId884,com.microsoft.adcenter.v8.CustomerId customerId885,com.microsoft.adcenter.v8.DeveloperToken developerToken886,com.microsoft.adcenter.v8.Password password887,com.microsoft.adcenter.v8.UserName userName888)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetGoals_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetGoals_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getGoalsRequest882
            
                * @param applicationToken883
            
                * @param customerAccountId884
            
                * @param customerId885
            
                * @param developerToken886
            
                * @param password887
            
                * @param userName888
            
          */
        public void startgetGoals(

            com.microsoft.adcenter.v8.GetGoalsRequest getGoalsRequest882,com.microsoft.adcenter.v8.ApplicationToken applicationToken883,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId884,
                com.microsoft.adcenter.v8.CustomerId customerId885,
                com.microsoft.adcenter.v8.DeveloperToken developerToken886,
                com.microsoft.adcenter.v8.Password password887,
                com.microsoft.adcenter.v8.UserName userName888,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdExtensionsByIdsRequest890
                
                    * @param applicationToken891
                
                    * @param customerAccountId892
                
                    * @param customerId893
                
                    * @param developerToken894
                
                    * @param password895
                
                    * @param userName896
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdExtensionsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdExtensionsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAdExtensionsByIdsResponse getAdExtensionsByIds(

                        com.microsoft.adcenter.v8.GetAdExtensionsByIdsRequest getAdExtensionsByIdsRequest890,com.microsoft.adcenter.v8.ApplicationToken applicationToken891,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId892,com.microsoft.adcenter.v8.CustomerId customerId893,com.microsoft.adcenter.v8.DeveloperToken developerToken894,com.microsoft.adcenter.v8.Password password895,com.microsoft.adcenter.v8.UserName userName896)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdExtensionsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdExtensionsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdExtensionsByIdsRequest890
            
                * @param applicationToken891
            
                * @param customerAccountId892
            
                * @param customerId893
            
                * @param developerToken894
            
                * @param password895
            
                * @param userName896
            
          */
        public void startgetAdExtensionsByIds(

            com.microsoft.adcenter.v8.GetAdExtensionsByIdsRequest getAdExtensionsByIdsRequest890,com.microsoft.adcenter.v8.ApplicationToken applicationToken891,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId892,
                com.microsoft.adcenter.v8.CustomerId customerId893,
                com.microsoft.adcenter.v8.DeveloperToken developerToken894,
                com.microsoft.adcenter.v8.Password password895,
                com.microsoft.adcenter.v8.UserName userName896,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKeywordsByAdGroupIdRequest898
                
                    * @param applicationToken899
                
                    * @param customerAccountId900
                
                    * @param customerId901
                
                    * @param developerToken902
                
                    * @param password903
                
                    * @param userName904
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByAdGroupId_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByAdGroupId_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse getKeywordsByAdGroupId(

                        com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdRequest getKeywordsByAdGroupIdRequest898,com.microsoft.adcenter.v8.ApplicationToken applicationToken899,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId900,com.microsoft.adcenter.v8.CustomerId customerId901,com.microsoft.adcenter.v8.DeveloperToken developerToken902,com.microsoft.adcenter.v8.Password password903,com.microsoft.adcenter.v8.UserName userName904)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByAdGroupId_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByAdGroupId_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKeywordsByAdGroupIdRequest898
            
                * @param applicationToken899
            
                * @param customerAccountId900
            
                * @param customerId901
            
                * @param developerToken902
            
                * @param password903
            
                * @param userName904
            
          */
        public void startgetKeywordsByAdGroupId(

            com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdRequest getKeywordsByAdGroupIdRequest898,com.microsoft.adcenter.v8.ApplicationToken applicationToken899,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId900,
                com.microsoft.adcenter.v8.CustomerId customerId901,
                com.microsoft.adcenter.v8.DeveloperToken developerToken902,
                com.microsoft.adcenter.v8.Password password903,
                com.microsoft.adcenter.v8.UserName userName904,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setNegativeSitesToAdGroupsRequest906
                
                    * @param applicationToken907
                
                    * @param customerAccountId908
                
                    * @param customerId909
                
                    * @param developerToken910
                
                    * @param password911
                
                    * @param userName912
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeSitesToAdGroups_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsResponse setNegativeSitesToAdGroups(

                        com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsRequest setNegativeSitesToAdGroupsRequest906,com.microsoft.adcenter.v8.ApplicationToken applicationToken907,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId908,com.microsoft.adcenter.v8.CustomerId customerId909,com.microsoft.adcenter.v8.DeveloperToken developerToken910,com.microsoft.adcenter.v8.Password password911,com.microsoft.adcenter.v8.UserName userName912)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeSitesToAdGroups_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setNegativeSitesToAdGroupsRequest906
            
                * @param applicationToken907
            
                * @param customerAccountId908
            
                * @param customerId909
            
                * @param developerToken910
            
                * @param password911
            
                * @param userName912
            
          */
        public void startsetNegativeSitesToAdGroups(

            com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsRequest setNegativeSitesToAdGroupsRequest906,com.microsoft.adcenter.v8.ApplicationToken applicationToken907,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId908,
                com.microsoft.adcenter.v8.CustomerId customerId909,
                com.microsoft.adcenter.v8.DeveloperToken developerToken910,
                com.microsoft.adcenter.v8.Password password911,
                com.microsoft.adcenter.v8.UserName userName912,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getNegativeSitesByCampaignIdsRequest914
                
                    * @param applicationToken915
                
                    * @param customerAccountId916
                
                    * @param customerId917
                
                    * @param developerToken918
                
                    * @param password919
                
                    * @param userName920
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeSitesByCampaignIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeSitesByCampaignIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsResponse getNegativeSitesByCampaignIds(

                        com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsRequest getNegativeSitesByCampaignIdsRequest914,com.microsoft.adcenter.v8.ApplicationToken applicationToken915,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId916,com.microsoft.adcenter.v8.CustomerId customerId917,com.microsoft.adcenter.v8.DeveloperToken developerToken918,com.microsoft.adcenter.v8.Password password919,com.microsoft.adcenter.v8.UserName userName920)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeSitesByCampaignIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeSitesByCampaignIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getNegativeSitesByCampaignIdsRequest914
            
                * @param applicationToken915
            
                * @param customerAccountId916
            
                * @param customerId917
            
                * @param developerToken918
            
                * @param password919
            
                * @param userName920
            
          */
        public void startgetNegativeSitesByCampaignIds(

            com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsRequest getNegativeSitesByCampaignIdsRequest914,com.microsoft.adcenter.v8.ApplicationToken applicationToken915,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId916,
                com.microsoft.adcenter.v8.CustomerId customerId917,
                com.microsoft.adcenter.v8.DeveloperToken developerToken918,
                com.microsoft.adcenter.v8.Password password919,
                com.microsoft.adcenter.v8.UserName userName920,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addTargetRequest922
                
                    * @param applicationToken923
                
                    * @param customerAccountId924
                
                    * @param customerId925
                
                    * @param developerToken926
                
                    * @param password927
                
                    * @param userName928
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddTarget_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddTarget_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddTargetResponse addTarget(

                        com.microsoft.adcenter.v8.AddTargetRequest addTargetRequest922,com.microsoft.adcenter.v8.ApplicationToken applicationToken923,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId924,com.microsoft.adcenter.v8.CustomerId customerId925,com.microsoft.adcenter.v8.DeveloperToken developerToken926,com.microsoft.adcenter.v8.Password password927,com.microsoft.adcenter.v8.UserName userName928)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddTarget_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddTarget_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addTargetRequest922
            
                * @param applicationToken923
            
                * @param customerAccountId924
            
                * @param customerId925
            
                * @param developerToken926
            
                * @param password927
            
                * @param userName928
            
          */
        public void startaddTarget(

            com.microsoft.adcenter.v8.AddTargetRequest addTargetRequest922,com.microsoft.adcenter.v8.ApplicationToken applicationToken923,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId924,
                com.microsoft.adcenter.v8.CustomerId customerId925,
                com.microsoft.adcenter.v8.DeveloperToken developerToken926,
                com.microsoft.adcenter.v8.Password password927,
                com.microsoft.adcenter.v8.UserName userName928,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdGroupsByIdsRequest930
                
                    * @param applicationToken931
                
                    * @param customerAccountId932
                
                    * @param customerId933
                
                    * @param developerToken934
                
                    * @param password935
                
                    * @param userName936
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdGroupsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdGroupsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse getAdGroupsByIds(

                        com.microsoft.adcenter.v8.GetAdGroupsByIdsRequest getAdGroupsByIdsRequest930,com.microsoft.adcenter.v8.ApplicationToken applicationToken931,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId932,com.microsoft.adcenter.v8.CustomerId customerId933,com.microsoft.adcenter.v8.DeveloperToken developerToken934,com.microsoft.adcenter.v8.Password password935,com.microsoft.adcenter.v8.UserName userName936)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdGroupsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdGroupsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdGroupsByIdsRequest930
            
                * @param applicationToken931
            
                * @param customerAccountId932
            
                * @param customerId933
            
                * @param developerToken934
            
                * @param password935
            
                * @param userName936
            
          */
        public void startgetAdGroupsByIds(

            com.microsoft.adcenter.v8.GetAdGroupsByIdsRequest getAdGroupsByIdsRequest930,com.microsoft.adcenter.v8.ApplicationToken applicationToken931,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId932,
                com.microsoft.adcenter.v8.CustomerId customerId933,
                com.microsoft.adcenter.v8.DeveloperToken developerToken934,
                com.microsoft.adcenter.v8.Password password935,
                com.microsoft.adcenter.v8.UserName userName936,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addTargetsToLibraryRequest938
                
                    * @param applicationToken939
                
                    * @param customerAccountId940
                
                    * @param customerId941
                
                    * @param developerToken942
                
                    * @param password943
                
                    * @param userName944
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddTargetsToLibrary_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddTargetsToLibrary_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddTargetsToLibraryResponse addTargetsToLibrary(

                        com.microsoft.adcenter.v8.AddTargetsToLibraryRequest addTargetsToLibraryRequest938,com.microsoft.adcenter.v8.ApplicationToken applicationToken939,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId940,com.microsoft.adcenter.v8.CustomerId customerId941,com.microsoft.adcenter.v8.DeveloperToken developerToken942,com.microsoft.adcenter.v8.Password password943,com.microsoft.adcenter.v8.UserName userName944)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddTargetsToLibrary_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddTargetsToLibrary_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addTargetsToLibraryRequest938
            
                * @param applicationToken939
            
                * @param customerAccountId940
            
                * @param customerId941
            
                * @param developerToken942
            
                * @param password943
            
                * @param userName944
            
          */
        public void startaddTargetsToLibrary(

            com.microsoft.adcenter.v8.AddTargetsToLibraryRequest addTargetsToLibraryRequest938,com.microsoft.adcenter.v8.ApplicationToken applicationToken939,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId940,
                com.microsoft.adcenter.v8.CustomerId customerId941,
                com.microsoft.adcenter.v8.DeveloperToken developerToken942,
                com.microsoft.adcenter.v8.Password password943,
                com.microsoft.adcenter.v8.UserName userName944,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAnalyticsTypeRequest946
                
                    * @param applicationToken947
                
                    * @param customerAccountId948
                
                    * @param customerId949
                
                    * @param developerToken950
                
                    * @param password951
                
                    * @param userName952
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAnalyticsType_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAnalyticsType_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAnalyticsTypeResponse getAnalyticsType(

                        com.microsoft.adcenter.v8.GetAnalyticsTypeRequest getAnalyticsTypeRequest946,com.microsoft.adcenter.v8.ApplicationToken applicationToken947,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId948,com.microsoft.adcenter.v8.CustomerId customerId949,com.microsoft.adcenter.v8.DeveloperToken developerToken950,com.microsoft.adcenter.v8.Password password951,com.microsoft.adcenter.v8.UserName userName952)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAnalyticsType_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAnalyticsType_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAnalyticsTypeRequest946
            
                * @param applicationToken947
            
                * @param customerAccountId948
            
                * @param customerId949
            
                * @param developerToken950
            
                * @param password951
            
                * @param userName952
            
          */
        public void startgetAnalyticsType(

            com.microsoft.adcenter.v8.GetAnalyticsTypeRequest getAnalyticsTypeRequest946,com.microsoft.adcenter.v8.ApplicationToken applicationToken947,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId948,
                com.microsoft.adcenter.v8.CustomerId customerId949,
                com.microsoft.adcenter.v8.DeveloperToken developerToken950,
                com.microsoft.adcenter.v8.Password password951,
                com.microsoft.adcenter.v8.UserName userName952,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdExtensionsByCampaignIdsRequest954
                
                    * @param applicationToken955
                
                    * @param customerAccountId956
                
                    * @param customerId957
                
                    * @param developerToken958
                
                    * @param password959
                
                    * @param userName960
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdExtensionsByCampaignIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdExtensionsByCampaignIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsResponse getAdExtensionsByCampaignIds(

                        com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsRequest getAdExtensionsByCampaignIdsRequest954,com.microsoft.adcenter.v8.ApplicationToken applicationToken955,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId956,com.microsoft.adcenter.v8.CustomerId customerId957,com.microsoft.adcenter.v8.DeveloperToken developerToken958,com.microsoft.adcenter.v8.Password password959,com.microsoft.adcenter.v8.UserName userName960)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdExtensionsByCampaignIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdExtensionsByCampaignIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdExtensionsByCampaignIdsRequest954
            
                * @param applicationToken955
            
                * @param customerAccountId956
            
                * @param customerId957
            
                * @param developerToken958
            
                * @param password959
            
                * @param userName960
            
          */
        public void startgetAdExtensionsByCampaignIds(

            com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsRequest getAdExtensionsByCampaignIdsRequest954,com.microsoft.adcenter.v8.ApplicationToken applicationToken955,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId956,
                com.microsoft.adcenter.v8.CustomerId customerId957,
                com.microsoft.adcenter.v8.DeveloperToken developerToken958,
                com.microsoft.adcenter.v8.Password password959,
                com.microsoft.adcenter.v8.UserName userName960,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getBusinessesByIdsRequest962
                
                    * @param applicationToken963
                
                    * @param customerAccountId964
                
                    * @param customerId965
                
                    * @param developerToken966
                
                    * @param password967
                
                    * @param userName968
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetBusinessesByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetBusinessesByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetBusinessesByIdsResponse getBusinessesByIds(

                        com.microsoft.adcenter.v8.GetBusinessesByIdsRequest getBusinessesByIdsRequest962,com.microsoft.adcenter.v8.ApplicationToken applicationToken963,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId964,com.microsoft.adcenter.v8.CustomerId customerId965,com.microsoft.adcenter.v8.DeveloperToken developerToken966,com.microsoft.adcenter.v8.Password password967,com.microsoft.adcenter.v8.UserName userName968)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetBusinessesByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetBusinessesByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getBusinessesByIdsRequest962
            
                * @param applicationToken963
            
                * @param customerAccountId964
            
                * @param customerId965
            
                * @param developerToken966
            
                * @param password967
            
                * @param userName968
            
          */
        public void startgetBusinessesByIds(

            com.microsoft.adcenter.v8.GetBusinessesByIdsRequest getBusinessesByIdsRequest962,com.microsoft.adcenter.v8.ApplicationToken applicationToken963,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId964,
                com.microsoft.adcenter.v8.CustomerId customerId965,
                com.microsoft.adcenter.v8.DeveloperToken developerToken966,
                com.microsoft.adcenter.v8.Password password967,
                com.microsoft.adcenter.v8.UserName userName968,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteTargetFromCampaignRequest970
                
                    * @param applicationToken971
                
                    * @param customerAccountId972
                
                    * @param customerId973
                
                    * @param developerToken974
                
                    * @param password975
                
                    * @param userName976
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetFromCampaign_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetFromCampaign_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteTargetFromCampaignResponse deleteTargetFromCampaign(

                        com.microsoft.adcenter.v8.DeleteTargetFromCampaignRequest deleteTargetFromCampaignRequest970,com.microsoft.adcenter.v8.ApplicationToken applicationToken971,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId972,com.microsoft.adcenter.v8.CustomerId customerId973,com.microsoft.adcenter.v8.DeveloperToken developerToken974,com.microsoft.adcenter.v8.Password password975,com.microsoft.adcenter.v8.UserName userName976)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetFromCampaign_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetFromCampaign_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteTargetFromCampaignRequest970
            
                * @param applicationToken971
            
                * @param customerAccountId972
            
                * @param customerId973
            
                * @param developerToken974
            
                * @param password975
            
                * @param userName976
            
          */
        public void startdeleteTargetFromCampaign(

            com.microsoft.adcenter.v8.DeleteTargetFromCampaignRequest deleteTargetFromCampaignRequest970,com.microsoft.adcenter.v8.ApplicationToken applicationToken971,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId972,
                com.microsoft.adcenter.v8.CustomerId customerId973,
                com.microsoft.adcenter.v8.DeveloperToken developerToken974,
                com.microsoft.adcenter.v8.Password password975,
                com.microsoft.adcenter.v8.UserName userName976,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getNegativeKeywordsByAdGroupIdsRequest978
                
                    * @param applicationToken979
                
                    * @param customerAccountId980
                
                    * @param customerId981
                
                    * @param developerToken982
                
                    * @param password983
                
                    * @param userName984
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeKeywordsByAdGroupIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeKeywordsByAdGroupIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsResponse getNegativeKeywordsByAdGroupIds(

                        com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsRequest getNegativeKeywordsByAdGroupIdsRequest978,com.microsoft.adcenter.v8.ApplicationToken applicationToken979,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId980,com.microsoft.adcenter.v8.CustomerId customerId981,com.microsoft.adcenter.v8.DeveloperToken developerToken982,com.microsoft.adcenter.v8.Password password983,com.microsoft.adcenter.v8.UserName userName984)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeKeywordsByAdGroupIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeKeywordsByAdGroupIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getNegativeKeywordsByAdGroupIdsRequest978
            
                * @param applicationToken979
            
                * @param customerAccountId980
            
                * @param customerId981
            
                * @param developerToken982
            
                * @param password983
            
                * @param userName984
            
          */
        public void startgetNegativeKeywordsByAdGroupIds(

            com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsRequest getNegativeKeywordsByAdGroupIdsRequest978,com.microsoft.adcenter.v8.ApplicationToken applicationToken979,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId980,
                com.microsoft.adcenter.v8.CustomerId customerId981,
                com.microsoft.adcenter.v8.DeveloperToken developerToken982,
                com.microsoft.adcenter.v8.Password password983,
                com.microsoft.adcenter.v8.UserName userName984,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateAdsRequest986
                
                    * @param applicationToken987
                
                    * @param customerAccountId988
                
                    * @param customerId989
                
                    * @param developerToken990
                
                    * @param password991
                
                    * @param userName992
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateAds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateAds_EditorialApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateAdsResponse updateAds(

                        com.microsoft.adcenter.v8.UpdateAdsRequest updateAdsRequest986,com.microsoft.adcenter.v8.ApplicationToken applicationToken987,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId988,com.microsoft.adcenter.v8.CustomerId customerId989,com.microsoft.adcenter.v8.DeveloperToken developerToken990,com.microsoft.adcenter.v8.Password password991,com.microsoft.adcenter.v8.UserName userName992)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateAds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateAds_EditorialApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateAdsRequest986
            
                * @param applicationToken987
            
                * @param customerAccountId988
            
                * @param customerId989
            
                * @param developerToken990
            
                * @param password991
            
                * @param userName992
            
          */
        public void startupdateAds(

            com.microsoft.adcenter.v8.UpdateAdsRequest updateAdsRequest986,com.microsoft.adcenter.v8.ApplicationToken applicationToken987,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId988,
                com.microsoft.adcenter.v8.CustomerId customerId989,
                com.microsoft.adcenter.v8.DeveloperToken developerToken990,
                com.microsoft.adcenter.v8.Password password991,
                com.microsoft.adcenter.v8.UserName userName992,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addAdGroupsRequest994
                
                    * @param applicationToken995
                
                    * @param customerAccountId996
                
                    * @param customerId997
                
                    * @param developerToken998
                
                    * @param password999
                
                    * @param userName0
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddAdGroups_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddAdGroups_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddAdGroupsResponse addAdGroups(

                        com.microsoft.adcenter.v8.AddAdGroupsRequest addAdGroupsRequest994,com.microsoft.adcenter.v8.ApplicationToken applicationToken995,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId996,com.microsoft.adcenter.v8.CustomerId customerId997,com.microsoft.adcenter.v8.DeveloperToken developerToken998,com.microsoft.adcenter.v8.Password password999,com.microsoft.adcenter.v8.UserName userName0)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddAdGroups_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddAdGroups_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addAdGroupsRequest994
            
                * @param applicationToken995
            
                * @param customerAccountId996
            
                * @param customerId997
            
                * @param developerToken998
            
                * @param password999
            
                * @param userName0
            
          */
        public void startaddAdGroups(

            com.microsoft.adcenter.v8.AddAdGroupsRequest addAdGroupsRequest994,com.microsoft.adcenter.v8.ApplicationToken applicationToken995,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId996,
                com.microsoft.adcenter.v8.CustomerId customerId997,
                com.microsoft.adcenter.v8.DeveloperToken developerToken998,
                com.microsoft.adcenter.v8.Password password999,
                com.microsoft.adcenter.v8.UserName userName0,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCampaignAdExtensionsRequest2
                
                    * @param applicationToken3
                
                    * @param customerAccountId4
                
                    * @param customerId5
                
                    * @param developerToken6
                
                    * @param password7
                
                    * @param userName8
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignAdExtensions_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignAdExtensions_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetCampaignAdExtensionsResponse getCampaignAdExtensions(

                        com.microsoft.adcenter.v8.GetCampaignAdExtensionsRequest getCampaignAdExtensionsRequest2,com.microsoft.adcenter.v8.ApplicationToken applicationToken3,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId4,com.microsoft.adcenter.v8.CustomerId customerId5,com.microsoft.adcenter.v8.DeveloperToken developerToken6,com.microsoft.adcenter.v8.Password password7,com.microsoft.adcenter.v8.UserName userName8)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignAdExtensions_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignAdExtensions_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCampaignAdExtensionsRequest2
            
                * @param applicationToken3
            
                * @param customerAccountId4
            
                * @param customerId5
            
                * @param developerToken6
            
                * @param password7
            
                * @param userName8
            
          */
        public void startgetCampaignAdExtensions(

            com.microsoft.adcenter.v8.GetCampaignAdExtensionsRequest getCampaignAdExtensionsRequest2,com.microsoft.adcenter.v8.ApplicationToken applicationToken3,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId4,
                com.microsoft.adcenter.v8.CustomerId customerId5,
                com.microsoft.adcenter.v8.DeveloperToken developerToken6,
                com.microsoft.adcenter.v8.Password password7,
                com.microsoft.adcenter.v8.UserName userName8,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByIdsRequest10
                
                    * @param applicationToken11
                
                    * @param customerAccountId12
                
                    * @param customerId13
                
                    * @param developerToken14
                
                    * @param password15
                
                    * @param userName16
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAdsByIdsResponse getAdsByIds(

                        com.microsoft.adcenter.v8.GetAdsByIdsRequest getAdsByIdsRequest10,com.microsoft.adcenter.v8.ApplicationToken applicationToken11,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId12,com.microsoft.adcenter.v8.CustomerId customerId13,com.microsoft.adcenter.v8.DeveloperToken developerToken14,com.microsoft.adcenter.v8.Password password15,com.microsoft.adcenter.v8.UserName userName16)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByIdsRequest10
            
                * @param applicationToken11
            
                * @param customerAccountId12
            
                * @param customerId13
            
                * @param developerToken14
            
                * @param password15
            
                * @param userName16
            
          */
        public void startgetAdsByIds(

            com.microsoft.adcenter.v8.GetAdsByIdsRequest getAdsByIdsRequest10,com.microsoft.adcenter.v8.ApplicationToken applicationToken11,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId12,
                com.microsoft.adcenter.v8.CustomerId customerId13,
                com.microsoft.adcenter.v8.DeveloperToken developerToken14,
                com.microsoft.adcenter.v8.Password password15,
                com.microsoft.adcenter.v8.UserName userName16,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setAdExtensionsToCampaignsRequest18
                
                    * @param applicationToken19
                
                    * @param customerAccountId20
                
                    * @param customerId21
                
                    * @param developerToken22
                
                    * @param password23
                
                    * @param userName24
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetAdExtensionsToCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetAdExtensionsToCampaigns_EditorialApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetAdExtensionsToCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsResponse setAdExtensionsToCampaigns(

                        com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsRequest setAdExtensionsToCampaignsRequest18,com.microsoft.adcenter.v8.ApplicationToken applicationToken19,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId20,com.microsoft.adcenter.v8.CustomerId customerId21,com.microsoft.adcenter.v8.DeveloperToken developerToken22,com.microsoft.adcenter.v8.Password password23,com.microsoft.adcenter.v8.UserName userName24)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetAdExtensionsToCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetAdExtensionsToCampaigns_EditorialApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetAdExtensionsToCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setAdExtensionsToCampaignsRequest18
            
                * @param applicationToken19
            
                * @param customerAccountId20
            
                * @param customerId21
            
                * @param developerToken22
            
                * @param password23
            
                * @param userName24
            
          */
        public void startsetAdExtensionsToCampaigns(

            com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsRequest setAdExtensionsToCampaignsRequest18,com.microsoft.adcenter.v8.ApplicationToken applicationToken19,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId20,
                com.microsoft.adcenter.v8.CustomerId customerId21,
                com.microsoft.adcenter.v8.DeveloperToken developerToken22,
                com.microsoft.adcenter.v8.Password password23,
                com.microsoft.adcenter.v8.UserName userName24,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteGoalsRequest26
                
                    * @param applicationToken27
                
                    * @param customerAccountId28
                
                    * @param customerId29
                
                    * @param developerToken30
                
                    * @param password31
                
                    * @param userName32
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteGoals_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteGoals_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteGoalsResponse deleteGoals(

                        com.microsoft.adcenter.v8.DeleteGoalsRequest deleteGoalsRequest26,com.microsoft.adcenter.v8.ApplicationToken applicationToken27,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId28,com.microsoft.adcenter.v8.CustomerId customerId29,com.microsoft.adcenter.v8.DeveloperToken developerToken30,com.microsoft.adcenter.v8.Password password31,com.microsoft.adcenter.v8.UserName userName32)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteGoals_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteGoals_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteGoalsRequest26
            
                * @param applicationToken27
            
                * @param customerAccountId28
            
                * @param customerId29
            
                * @param developerToken30
            
                * @param password31
            
                * @param userName32
            
          */
        public void startdeleteGoals(

            com.microsoft.adcenter.v8.DeleteGoalsRequest deleteGoalsRequest26,com.microsoft.adcenter.v8.ApplicationToken applicationToken27,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId28,
                com.microsoft.adcenter.v8.CustomerId customerId29,
                com.microsoft.adcenter.v8.DeveloperToken developerToken30,
                com.microsoft.adcenter.v8.Password password31,
                com.microsoft.adcenter.v8.UserName userName32,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param pauseKeywordsRequest34
                
                    * @param applicationToken35
                
                    * @param customerAccountId36
                
                    * @param customerId37
                
                    * @param developerToken38
                
                    * @param password39
                
                    * @param userName40
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseKeywords_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseKeywords_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.PauseKeywordsResponse pauseKeywords(

                        com.microsoft.adcenter.v8.PauseKeywordsRequest pauseKeywordsRequest34,com.microsoft.adcenter.v8.ApplicationToken applicationToken35,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId36,com.microsoft.adcenter.v8.CustomerId customerId37,com.microsoft.adcenter.v8.DeveloperToken developerToken38,com.microsoft.adcenter.v8.Password password39,com.microsoft.adcenter.v8.UserName userName40)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseKeywords_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseKeywords_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param pauseKeywordsRequest34
            
                * @param applicationToken35
            
                * @param customerAccountId36
            
                * @param customerId37
            
                * @param developerToken38
            
                * @param password39
            
                * @param userName40
            
          */
        public void startpauseKeywords(

            com.microsoft.adcenter.v8.PauseKeywordsRequest pauseKeywordsRequest34,com.microsoft.adcenter.v8.ApplicationToken applicationToken35,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId36,
                com.microsoft.adcenter.v8.CustomerId customerId37,
                com.microsoft.adcenter.v8.DeveloperToken developerToken38,
                com.microsoft.adcenter.v8.Password password39,
                com.microsoft.adcenter.v8.UserName userName40,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getNegativeKeywordsByCampaignIdsRequest42
                
                    * @param applicationToken43
                
                    * @param customerAccountId44
                
                    * @param customerId45
                
                    * @param developerToken46
                
                    * @param password47
                
                    * @param userName48
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeKeywordsByCampaignIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeKeywordsByCampaignIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsResponse getNegativeKeywordsByCampaignIds(

                        com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsRequest getNegativeKeywordsByCampaignIdsRequest42,com.microsoft.adcenter.v8.ApplicationToken applicationToken43,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId44,com.microsoft.adcenter.v8.CustomerId customerId45,com.microsoft.adcenter.v8.DeveloperToken developerToken46,com.microsoft.adcenter.v8.Password password47,com.microsoft.adcenter.v8.UserName userName48)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeKeywordsByCampaignIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetNegativeKeywordsByCampaignIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getNegativeKeywordsByCampaignIdsRequest42
            
                * @param applicationToken43
            
                * @param customerAccountId44
            
                * @param customerId45
            
                * @param developerToken46
            
                * @param password47
            
                * @param userName48
            
          */
        public void startgetNegativeKeywordsByCampaignIds(

            com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsRequest getNegativeKeywordsByCampaignIdsRequest42,com.microsoft.adcenter.v8.ApplicationToken applicationToken43,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId44,
                com.microsoft.adcenter.v8.CustomerId customerId45,
                com.microsoft.adcenter.v8.DeveloperToken developerToken46,
                com.microsoft.adcenter.v8.Password password47,
                com.microsoft.adcenter.v8.UserName userName48,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateKeywordsRequest50
                
                    * @param applicationToken51
                
                    * @param customerAccountId52
                
                    * @param customerId53
                
                    * @param developerToken54
                
                    * @param password55
                
                    * @param userName56
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateKeywords_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateKeywords_EditorialApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateKeywordsResponse updateKeywords(

                        com.microsoft.adcenter.v8.UpdateKeywordsRequest updateKeywordsRequest50,com.microsoft.adcenter.v8.ApplicationToken applicationToken51,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId52,com.microsoft.adcenter.v8.CustomerId customerId53,com.microsoft.adcenter.v8.DeveloperToken developerToken54,com.microsoft.adcenter.v8.Password password55,com.microsoft.adcenter.v8.UserName userName56)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateKeywords_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateKeywords_EditorialApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateKeywordsRequest50
            
                * @param applicationToken51
            
                * @param customerAccountId52
            
                * @param customerId53
            
                * @param developerToken54
            
                * @param password55
            
                * @param userName56
            
          */
        public void startupdateKeywords(

            com.microsoft.adcenter.v8.UpdateKeywordsRequest updateKeywordsRequest50,com.microsoft.adcenter.v8.ApplicationToken applicationToken51,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId52,
                com.microsoft.adcenter.v8.CustomerId customerId53,
                com.microsoft.adcenter.v8.DeveloperToken developerToken54,
                com.microsoft.adcenter.v8.Password password55,
                com.microsoft.adcenter.v8.UserName userName56,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addKeywordsRequest58
                
                    * @param applicationToken59
                
                    * @param customerAccountId60
                
                    * @param customerId61
                
                    * @param developerToken62
                
                    * @param password63
                
                    * @param userName64
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddKeywords_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddKeywords_EditorialApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddKeywordsResponse addKeywords(

                        com.microsoft.adcenter.v8.AddKeywordsRequest addKeywordsRequest58,com.microsoft.adcenter.v8.ApplicationToken applicationToken59,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId60,com.microsoft.adcenter.v8.CustomerId customerId61,com.microsoft.adcenter.v8.DeveloperToken developerToken62,com.microsoft.adcenter.v8.Password password63,com.microsoft.adcenter.v8.UserName userName64)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddKeywords_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddKeywords_EditorialApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addKeywordsRequest58
            
                * @param applicationToken59
            
                * @param customerAccountId60
            
                * @param customerId61
            
                * @param developerToken62
            
                * @param password63
            
                * @param userName64
            
          */
        public void startaddKeywords(

            com.microsoft.adcenter.v8.AddKeywordsRequest addKeywordsRequest58,com.microsoft.adcenter.v8.ApplicationToken applicationToken59,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId60,
                com.microsoft.adcenter.v8.CustomerId customerId61,
                com.microsoft.adcenter.v8.DeveloperToken developerToken62,
                com.microsoft.adcenter.v8.Password password63,
                com.microsoft.adcenter.v8.UserName userName64,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getTargetsInfoFromLibraryRequest66
                
                    * @param applicationToken67
                
                    * @param customerAccountId68
                
                    * @param customerId69
                
                    * @param developerToken70
                
                    * @param password71
                
                    * @param userName72
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsInfoFromLibrary_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsInfoFromLibrary_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryResponse getTargetsInfoFromLibrary(

                        com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryRequest getTargetsInfoFromLibraryRequest66,com.microsoft.adcenter.v8.ApplicationToken applicationToken67,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId68,com.microsoft.adcenter.v8.CustomerId customerId69,com.microsoft.adcenter.v8.DeveloperToken developerToken70,com.microsoft.adcenter.v8.Password password71,com.microsoft.adcenter.v8.UserName userName72)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsInfoFromLibrary_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsInfoFromLibrary_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getTargetsInfoFromLibraryRequest66
            
                * @param applicationToken67
            
                * @param customerAccountId68
            
                * @param customerId69
            
                * @param developerToken70
            
                * @param password71
            
                * @param userName72
            
          */
        public void startgetTargetsInfoFromLibrary(

            com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryRequest getTargetsInfoFromLibraryRequest66,com.microsoft.adcenter.v8.ApplicationToken applicationToken67,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId68,
                com.microsoft.adcenter.v8.CustomerId customerId69,
                com.microsoft.adcenter.v8.DeveloperToken developerToken70,
                com.microsoft.adcenter.v8.Password password71,
                com.microsoft.adcenter.v8.UserName userName72,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setNegativeKeywordsToCampaignsRequest74
                
                    * @param applicationToken75
                
                    * @param customerAccountId76
                
                    * @param customerId77
                
                    * @param developerToken78
                
                    * @param password79
                
                    * @param userName80
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeKeywordsToCampaigns_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeKeywordsToCampaigns_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse setNegativeKeywordsToCampaigns(

                        com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsRequest setNegativeKeywordsToCampaignsRequest74,com.microsoft.adcenter.v8.ApplicationToken applicationToken75,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId76,com.microsoft.adcenter.v8.CustomerId customerId77,com.microsoft.adcenter.v8.DeveloperToken developerToken78,com.microsoft.adcenter.v8.Password password79,com.microsoft.adcenter.v8.UserName userName80)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeKeywordsToCampaigns_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_SetNegativeKeywordsToCampaigns_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setNegativeKeywordsToCampaignsRequest74
            
                * @param applicationToken75
            
                * @param customerAccountId76
            
                * @param customerId77
            
                * @param developerToken78
            
                * @param password79
            
                * @param userName80
            
          */
        public void startsetNegativeKeywordsToCampaigns(

            com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsRequest setNegativeKeywordsToCampaignsRequest74,com.microsoft.adcenter.v8.ApplicationToken applicationToken75,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId76,
                com.microsoft.adcenter.v8.CustomerId customerId77,
                com.microsoft.adcenter.v8.DeveloperToken developerToken78,
                com.microsoft.adcenter.v8.Password password79,
                com.microsoft.adcenter.v8.UserName userName80,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByAdGroupIdRequest82
                
                    * @param applicationToken83
                
                    * @param customerAccountId84
                
                    * @param customerId85
                
                    * @param developerToken86
                
                    * @param password87
                
                    * @param userName88
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByAdGroupId_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByAdGroupId_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse getAdsByAdGroupId(

                        com.microsoft.adcenter.v8.GetAdsByAdGroupIdRequest getAdsByAdGroupIdRequest82,com.microsoft.adcenter.v8.ApplicationToken applicationToken83,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId84,com.microsoft.adcenter.v8.CustomerId customerId85,com.microsoft.adcenter.v8.DeveloperToken developerToken86,com.microsoft.adcenter.v8.Password password87,com.microsoft.adcenter.v8.UserName userName88)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByAdGroupId_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdsByAdGroupId_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByAdGroupIdRequest82
            
                * @param applicationToken83
            
                * @param customerAccountId84
            
                * @param customerId85
            
                * @param developerToken86
            
                * @param password87
            
                * @param userName88
            
          */
        public void startgetAdsByAdGroupId(

            com.microsoft.adcenter.v8.GetAdsByAdGroupIdRequest getAdsByAdGroupIdRequest82,com.microsoft.adcenter.v8.ApplicationToken applicationToken83,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId84,
                com.microsoft.adcenter.v8.CustomerId customerId85,
                com.microsoft.adcenter.v8.DeveloperToken developerToken86,
                com.microsoft.adcenter.v8.Password password87,
                com.microsoft.adcenter.v8.UserName userName88,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getTargetsByIdsRequest90
                
                    * @param applicationToken91
                
                    * @param customerAccountId92
                
                    * @param customerId93
                
                    * @param developerToken94
                
                    * @param password95
                
                    * @param userName96
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetTargetsByIdsResponse getTargetsByIds(

                        com.microsoft.adcenter.v8.GetTargetsByIdsRequest getTargetsByIdsRequest90,com.microsoft.adcenter.v8.ApplicationToken applicationToken91,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId92,com.microsoft.adcenter.v8.CustomerId customerId93,com.microsoft.adcenter.v8.DeveloperToken developerToken94,com.microsoft.adcenter.v8.Password password95,com.microsoft.adcenter.v8.UserName userName96)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetTargetsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getTargetsByIdsRequest90
            
                * @param applicationToken91
            
                * @param customerAccountId92
            
                * @param customerId93
            
                * @param developerToken94
            
                * @param password95
            
                * @param userName96
            
          */
        public void startgetTargetsByIds(

            com.microsoft.adcenter.v8.GetTargetsByIdsRequest getTargetsByIdsRequest90,com.microsoft.adcenter.v8.ApplicationToken applicationToken91,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId92,
                com.microsoft.adcenter.v8.CustomerId customerId93,
                com.microsoft.adcenter.v8.DeveloperToken developerToken94,
                com.microsoft.adcenter.v8.Password password95,
                com.microsoft.adcenter.v8.UserName userName96,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteTargetsFromLibraryRequest98
                
                    * @param applicationToken99
                
                    * @param customerAccountId100
                
                    * @param customerId101
                
                    * @param developerToken102
                
                    * @param password103
                
                    * @param userName104
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetsFromLibrary_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetsFromLibrary_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.DeleteTargetsFromLibraryResponse deleteTargetsFromLibrary(

                        com.microsoft.adcenter.v8.DeleteTargetsFromLibraryRequest deleteTargetsFromLibraryRequest98,com.microsoft.adcenter.v8.ApplicationToken applicationToken99,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId100,com.microsoft.adcenter.v8.CustomerId customerId101,com.microsoft.adcenter.v8.DeveloperToken developerToken102,com.microsoft.adcenter.v8.Password password103,com.microsoft.adcenter.v8.UserName userName104)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetsFromLibrary_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_DeleteTargetsFromLibrary_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteTargetsFromLibraryRequest98
            
                * @param applicationToken99
            
                * @param customerAccountId100
            
                * @param customerId101
            
                * @param developerToken102
            
                * @param password103
            
                * @param userName104
            
          */
        public void startdeleteTargetsFromLibrary(

            com.microsoft.adcenter.v8.DeleteTargetsFromLibraryRequest deleteTargetsFromLibraryRequest98,com.microsoft.adcenter.v8.ApplicationToken applicationToken99,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId100,
                com.microsoft.adcenter.v8.CustomerId customerId101,
                com.microsoft.adcenter.v8.DeveloperToken developerToken102,
                com.microsoft.adcenter.v8.Password password103,
                com.microsoft.adcenter.v8.UserName userName104,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param resumeAdGroupsRequest106
                
                    * @param applicationToken107
                
                    * @param customerAccountId108
                
                    * @param customerId109
                
                    * @param developerToken110
                
                    * @param password111
                
                    * @param userName112
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeAdGroups_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeAdGroups_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.ResumeAdGroupsResponse resumeAdGroups(

                        com.microsoft.adcenter.v8.ResumeAdGroupsRequest resumeAdGroupsRequest106,com.microsoft.adcenter.v8.ApplicationToken applicationToken107,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId108,com.microsoft.adcenter.v8.CustomerId customerId109,com.microsoft.adcenter.v8.DeveloperToken developerToken110,com.microsoft.adcenter.v8.Password password111,com.microsoft.adcenter.v8.UserName userName112)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeAdGroups_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeAdGroups_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param resumeAdGroupsRequest106
            
                * @param applicationToken107
            
                * @param customerAccountId108
            
                * @param customerId109
            
                * @param developerToken110
            
                * @param password111
            
                * @param userName112
            
          */
        public void startresumeAdGroups(

            com.microsoft.adcenter.v8.ResumeAdGroupsRequest resumeAdGroupsRequest106,com.microsoft.adcenter.v8.ApplicationToken applicationToken107,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId108,
                com.microsoft.adcenter.v8.CustomerId customerId109,
                com.microsoft.adcenter.v8.DeveloperToken developerToken110,
                com.microsoft.adcenter.v8.Password password111,
                com.microsoft.adcenter.v8.UserName userName112,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCampaignsByIdsRequest114
                
                    * @param applicationToken115
                
                    * @param customerAccountId116
                
                    * @param customerId117
                
                    * @param developerToken118
                
                    * @param password119
                
                    * @param userName120
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetCampaignsByIdsResponse getCampaignsByIds(

                        com.microsoft.adcenter.v8.GetCampaignsByIdsRequest getCampaignsByIdsRequest114,com.microsoft.adcenter.v8.ApplicationToken applicationToken115,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId116,com.microsoft.adcenter.v8.CustomerId customerId117,com.microsoft.adcenter.v8.DeveloperToken developerToken118,com.microsoft.adcenter.v8.Password password119,com.microsoft.adcenter.v8.UserName userName120)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetCampaignsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCampaignsByIdsRequest114
            
                * @param applicationToken115
            
                * @param customerAccountId116
            
                * @param customerId117
            
                * @param developerToken118
            
                * @param password119
            
                * @param userName120
            
          */
        public void startgetCampaignsByIds(

            com.microsoft.adcenter.v8.GetCampaignsByIdsRequest getCampaignsByIdsRequest114,com.microsoft.adcenter.v8.ApplicationToken applicationToken115,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId116,
                com.microsoft.adcenter.v8.CustomerId customerId117,
                com.microsoft.adcenter.v8.DeveloperToken developerToken118,
                com.microsoft.adcenter.v8.Password password119,
                com.microsoft.adcenter.v8.UserName userName120,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param resumeSitePlacementsRequest122
                
                    * @param applicationToken123
                
                    * @param customerAccountId124
                
                    * @param customerId125
                
                    * @param developerToken126
                
                    * @param password127
                
                    * @param userName128
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeSitePlacements_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeSitePlacements_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.ResumeSitePlacementsResponse resumeSitePlacements(

                        com.microsoft.adcenter.v8.ResumeSitePlacementsRequest resumeSitePlacementsRequest122,com.microsoft.adcenter.v8.ApplicationToken applicationToken123,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId124,com.microsoft.adcenter.v8.CustomerId customerId125,com.microsoft.adcenter.v8.DeveloperToken developerToken126,com.microsoft.adcenter.v8.Password password127,com.microsoft.adcenter.v8.UserName userName128)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeSitePlacements_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeSitePlacements_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param resumeSitePlacementsRequest122
            
                * @param applicationToken123
            
                * @param customerAccountId124
            
                * @param customerId125
            
                * @param developerToken126
            
                * @param password127
            
                * @param userName128
            
          */
        public void startresumeSitePlacements(

            com.microsoft.adcenter.v8.ResumeSitePlacementsRequest resumeSitePlacementsRequest122,com.microsoft.adcenter.v8.ApplicationToken applicationToken123,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId124,
                com.microsoft.adcenter.v8.CustomerId customerId125,
                com.microsoft.adcenter.v8.DeveloperToken developerToken126,
                com.microsoft.adcenter.v8.Password password127,
                com.microsoft.adcenter.v8.UserName userName128,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKeywordsByIdsRequest130
                
                    * @param applicationToken131
                
                    * @param customerAccountId132
                
                    * @param customerId133
                
                    * @param developerToken134
                
                    * @param password135
                
                    * @param userName136
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByIds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetKeywordsByIdsResponse getKeywordsByIds(

                        com.microsoft.adcenter.v8.GetKeywordsByIdsRequest getKeywordsByIdsRequest130,com.microsoft.adcenter.v8.ApplicationToken applicationToken131,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId132,com.microsoft.adcenter.v8.CustomerId customerId133,com.microsoft.adcenter.v8.DeveloperToken developerToken134,com.microsoft.adcenter.v8.Password password135,com.microsoft.adcenter.v8.UserName userName136)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetKeywordsByIds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKeywordsByIdsRequest130
            
                * @param applicationToken131
            
                * @param customerAccountId132
            
                * @param customerId133
            
                * @param developerToken134
            
                * @param password135
            
                * @param userName136
            
          */
        public void startgetKeywordsByIds(

            com.microsoft.adcenter.v8.GetKeywordsByIdsRequest getKeywordsByIdsRequest130,com.microsoft.adcenter.v8.ApplicationToken applicationToken131,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId132,
                com.microsoft.adcenter.v8.CustomerId customerId133,
                com.microsoft.adcenter.v8.DeveloperToken developerToken134,
                com.microsoft.adcenter.v8.Password password135,
                com.microsoft.adcenter.v8.UserName userName136,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param resumeAdsRequest138
                
                    * @param applicationToken139
                
                    * @param customerAccountId140
                
                    * @param customerId141
                
                    * @param developerToken142
                
                    * @param password143
                
                    * @param userName144
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeAds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_ResumeAds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.ResumeAdsResponse resumeAds(

                        com.microsoft.adcenter.v8.ResumeAdsRequest resumeAdsRequest138,com.microsoft.adcenter.v8.ApplicationToken applicationToken139,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId140,com.microsoft.adcenter.v8.CustomerId customerId141,com.microsoft.adcenter.v8.DeveloperToken developerToken142,com.microsoft.adcenter.v8.Password password143,com.microsoft.adcenter.v8.UserName userName144)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeAds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_ResumeAds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param resumeAdsRequest138
            
                * @param applicationToken139
            
                * @param customerAccountId140
            
                * @param customerId141
            
                * @param developerToken142
            
                * @param password143
            
                * @param userName144
            
          */
        public void startresumeAds(

            com.microsoft.adcenter.v8.ResumeAdsRequest resumeAdsRequest138,com.microsoft.adcenter.v8.ApplicationToken applicationToken139,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId140,
                com.microsoft.adcenter.v8.CustomerId customerId141,
                com.microsoft.adcenter.v8.DeveloperToken developerToken142,
                com.microsoft.adcenter.v8.Password password143,
                com.microsoft.adcenter.v8.UserName userName144,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addAdExtensionsRequest146
                
                    * @param applicationToken147
                
                    * @param customerAccountId148
                
                    * @param customerId149
                
                    * @param developerToken150
                
                    * @param password151
                
                    * @param userName152
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddAdExtensions_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddAdExtensions_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddAdExtensionsResponse addAdExtensions(

                        com.microsoft.adcenter.v8.AddAdExtensionsRequest addAdExtensionsRequest146,com.microsoft.adcenter.v8.ApplicationToken applicationToken147,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId148,com.microsoft.adcenter.v8.CustomerId customerId149,com.microsoft.adcenter.v8.DeveloperToken developerToken150,com.microsoft.adcenter.v8.Password password151,com.microsoft.adcenter.v8.UserName userName152)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddAdExtensions_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddAdExtensions_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addAdExtensionsRequest146
            
                * @param applicationToken147
            
                * @param customerAccountId148
            
                * @param customerId149
            
                * @param developerToken150
            
                * @param password151
            
                * @param userName152
            
          */
        public void startaddAdExtensions(

            com.microsoft.adcenter.v8.AddAdExtensionsRequest addAdExtensionsRequest146,com.microsoft.adcenter.v8.ApplicationToken applicationToken147,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId148,
                com.microsoft.adcenter.v8.CustomerId customerId149,
                com.microsoft.adcenter.v8.DeveloperToken developerToken150,
                com.microsoft.adcenter.v8.Password password151,
                com.microsoft.adcenter.v8.UserName userName152,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateSitePlacementsRequest154
                
                    * @param applicationToken155
                
                    * @param customerAccountId156
                
                    * @param customerId157
                
                    * @param developerToken158
                
                    * @param password159
                
                    * @param userName160
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateSitePlacements_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateSitePlacements_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateSitePlacementsResponse updateSitePlacements(

                        com.microsoft.adcenter.v8.UpdateSitePlacementsRequest updateSitePlacementsRequest154,com.microsoft.adcenter.v8.ApplicationToken applicationToken155,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId156,com.microsoft.adcenter.v8.CustomerId customerId157,com.microsoft.adcenter.v8.DeveloperToken developerToken158,com.microsoft.adcenter.v8.Password password159,com.microsoft.adcenter.v8.UserName userName160)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateSitePlacements_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateSitePlacements_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateSitePlacementsRequest154
            
                * @param applicationToken155
            
                * @param customerAccountId156
            
                * @param customerId157
            
                * @param developerToken158
            
                * @param password159
            
                * @param userName160
            
          */
        public void startupdateSitePlacements(

            com.microsoft.adcenter.v8.UpdateSitePlacementsRequest updateSitePlacementsRequest154,com.microsoft.adcenter.v8.ApplicationToken applicationToken155,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId156,
                com.microsoft.adcenter.v8.CustomerId customerId157,
                com.microsoft.adcenter.v8.DeveloperToken developerToken158,
                com.microsoft.adcenter.v8.Password password159,
                com.microsoft.adcenter.v8.UserName userName160,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getPlacementDetailsForUrlsRequest162
                
                    * @param applicationToken163
                
                    * @param customerAccountId164
                
                    * @param customerId165
                
                    * @param developerToken166
                
                    * @param password167
                
                    * @param userName168
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetPlacementDetailsForUrls_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetPlacementDetailsForUrls_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsResponse getPlacementDetailsForUrls(

                        com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsRequest getPlacementDetailsForUrlsRequest162,com.microsoft.adcenter.v8.ApplicationToken applicationToken163,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId164,com.microsoft.adcenter.v8.CustomerId customerId165,com.microsoft.adcenter.v8.DeveloperToken developerToken166,com.microsoft.adcenter.v8.Password password167,com.microsoft.adcenter.v8.UserName userName168)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetPlacementDetailsForUrls_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetPlacementDetailsForUrls_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPlacementDetailsForUrlsRequest162
            
                * @param applicationToken163
            
                * @param customerAccountId164
            
                * @param customerId165
            
                * @param developerToken166
            
                * @param password167
            
                * @param userName168
            
          */
        public void startgetPlacementDetailsForUrls(

            com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsRequest getPlacementDetailsForUrlsRequest162,com.microsoft.adcenter.v8.ApplicationToken applicationToken163,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId164,
                com.microsoft.adcenter.v8.CustomerId customerId165,
                com.microsoft.adcenter.v8.DeveloperToken developerToken166,
                com.microsoft.adcenter.v8.Password password167,
                com.microsoft.adcenter.v8.UserName userName168,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param pauseAdsRequest170
                
                    * @param applicationToken171
                
                    * @param customerAccountId172
                
                    * @param customerId173
                
                    * @param developerToken174
                
                    * @param password175
                
                    * @param userName176
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseAds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_PauseAds_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.PauseAdsResponse pauseAds(

                        com.microsoft.adcenter.v8.PauseAdsRequest pauseAdsRequest170,com.microsoft.adcenter.v8.ApplicationToken applicationToken171,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId172,com.microsoft.adcenter.v8.CustomerId customerId173,com.microsoft.adcenter.v8.DeveloperToken developerToken174,com.microsoft.adcenter.v8.Password password175,com.microsoft.adcenter.v8.UserName userName176)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseAds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_PauseAds_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param pauseAdsRequest170
            
                * @param applicationToken171
            
                * @param customerAccountId172
            
                * @param customerId173
            
                * @param developerToken174
            
                * @param password175
            
                * @param userName176
            
          */
        public void startpauseAds(

            com.microsoft.adcenter.v8.PauseAdsRequest pauseAdsRequest170,com.microsoft.adcenter.v8.ApplicationToken applicationToken171,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId172,
                com.microsoft.adcenter.v8.CustomerId customerId173,
                com.microsoft.adcenter.v8.DeveloperToken developerToken174,
                com.microsoft.adcenter.v8.Password password175,
                com.microsoft.adcenter.v8.UserName userName176,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getSitePlacementsByAdGroupIdRequest178
                
                    * @param applicationToken179
                
                    * @param customerAccountId180
                
                    * @param customerId181
                
                    * @param developerToken182
                
                    * @param password183
                
                    * @param userName184
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetSitePlacementsByAdGroupId_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetSitePlacementsByAdGroupId_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdResponse getSitePlacementsByAdGroupId(

                        com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdRequest getSitePlacementsByAdGroupIdRequest178,com.microsoft.adcenter.v8.ApplicationToken applicationToken179,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId180,com.microsoft.adcenter.v8.CustomerId customerId181,com.microsoft.adcenter.v8.DeveloperToken developerToken182,com.microsoft.adcenter.v8.Password password183,com.microsoft.adcenter.v8.UserName userName184)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetSitePlacementsByAdGroupId_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetSitePlacementsByAdGroupId_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSitePlacementsByAdGroupIdRequest178
            
                * @param applicationToken179
            
                * @param customerAccountId180
            
                * @param customerId181
            
                * @param developerToken182
            
                * @param password183
            
                * @param userName184
            
          */
        public void startgetSitePlacementsByAdGroupId(

            com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdRequest getSitePlacementsByAdGroupIdRequest178,com.microsoft.adcenter.v8.ApplicationToken applicationToken179,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId180,
                com.microsoft.adcenter.v8.CustomerId customerId181,
                com.microsoft.adcenter.v8.DeveloperToken developerToken182,
                com.microsoft.adcenter.v8.Password password183,
                com.microsoft.adcenter.v8.UserName userName184,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateBusinessesRequest186
                
                    * @param applicationToken187
                
                    * @param customerAccountId188
                
                    * @param customerId189
                
                    * @param developerToken190
                
                    * @param password191
                
                    * @param userName192
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateBusinesses_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateBusinesses_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateBusinessesResponse updateBusinesses(

                        com.microsoft.adcenter.v8.UpdateBusinessesRequest updateBusinessesRequest186,com.microsoft.adcenter.v8.ApplicationToken applicationToken187,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId188,com.microsoft.adcenter.v8.CustomerId customerId189,com.microsoft.adcenter.v8.DeveloperToken developerToken190,com.microsoft.adcenter.v8.Password password191,com.microsoft.adcenter.v8.UserName userName192)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateBusinesses_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateBusinesses_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateBusinessesRequest186
            
                * @param applicationToken187
            
                * @param customerAccountId188
            
                * @param customerId189
            
                * @param developerToken190
            
                * @param password191
            
                * @param userName192
            
          */
        public void startupdateBusinesses(

            com.microsoft.adcenter.v8.UpdateBusinessesRequest updateBusinessesRequest186,com.microsoft.adcenter.v8.ApplicationToken applicationToken187,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId188,
                com.microsoft.adcenter.v8.CustomerId customerId189,
                com.microsoft.adcenter.v8.DeveloperToken developerToken190,
                com.microsoft.adcenter.v8.Password password191,
                com.microsoft.adcenter.v8.UserName userName192,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addSitePlacementsRequest194
                
                    * @param applicationToken195
                
                    * @param customerAccountId196
                
                    * @param customerId197
                
                    * @param developerToken198
                
                    * @param password199
                
                    * @param userName200
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddSitePlacements_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_AddSitePlacements_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.AddSitePlacementsResponse addSitePlacements(

                        com.microsoft.adcenter.v8.AddSitePlacementsRequest addSitePlacementsRequest194,com.microsoft.adcenter.v8.ApplicationToken applicationToken195,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId196,com.microsoft.adcenter.v8.CustomerId customerId197,com.microsoft.adcenter.v8.DeveloperToken developerToken198,com.microsoft.adcenter.v8.Password password199,com.microsoft.adcenter.v8.UserName userName200)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddSitePlacements_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_AddSitePlacements_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addSitePlacementsRequest194
            
                * @param applicationToken195
            
                * @param customerAccountId196
            
                * @param customerId197
            
                * @param developerToken198
            
                * @param password199
            
                * @param userName200
            
          */
        public void startaddSitePlacements(

            com.microsoft.adcenter.v8.AddSitePlacementsRequest addSitePlacementsRequest194,com.microsoft.adcenter.v8.ApplicationToken applicationToken195,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId196,
                com.microsoft.adcenter.v8.CustomerId customerId197,
                com.microsoft.adcenter.v8.DeveloperToken developerToken198,
                com.microsoft.adcenter.v8.Password password199,
                com.microsoft.adcenter.v8.UserName userName200,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdGroupsByCampaignIdRequest202
                
                    * @param applicationToken203
                
                    * @param customerAccountId204
                
                    * @param customerId205
                
                    * @param developerToken206
                
                    * @param password207
                
                    * @param userName208
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdGroupsByCampaignId_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetAdGroupsByCampaignId_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse getAdGroupsByCampaignId(

                        com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdRequest getAdGroupsByCampaignIdRequest202,com.microsoft.adcenter.v8.ApplicationToken applicationToken203,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId204,com.microsoft.adcenter.v8.CustomerId customerId205,com.microsoft.adcenter.v8.DeveloperToken developerToken206,com.microsoft.adcenter.v8.Password password207,com.microsoft.adcenter.v8.UserName userName208)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdGroupsByCampaignId_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetAdGroupsByCampaignId_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdGroupsByCampaignIdRequest202
            
                * @param applicationToken203
            
                * @param customerAccountId204
            
                * @param customerId205
            
                * @param developerToken206
            
                * @param password207
            
                * @param userName208
            
          */
        public void startgetAdGroupsByCampaignId(

            com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdRequest getAdGroupsByCampaignIdRequest202,com.microsoft.adcenter.v8.ApplicationToken applicationToken203,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId204,
                com.microsoft.adcenter.v8.CustomerId customerId205,
                com.microsoft.adcenter.v8.DeveloperToken developerToken206,
                com.microsoft.adcenter.v8.Password password207,
                com.microsoft.adcenter.v8.UserName userName208,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getBusinessesInfoRequest210
                
                    * @param applicationToken211
                
                    * @param customerAccountId212
                
                    * @param customerId213
                
                    * @param developerToken214
                
                    * @param password215
                
                    * @param userName216
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetBusinessesInfo_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_GetBusinessesInfo_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetBusinessesInfoResponse getBusinessesInfo(

                        com.microsoft.adcenter.v8.GetBusinessesInfoRequest getBusinessesInfoRequest210,com.microsoft.adcenter.v8.ApplicationToken applicationToken211,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId212,com.microsoft.adcenter.v8.CustomerId customerId213,com.microsoft.adcenter.v8.DeveloperToken developerToken214,com.microsoft.adcenter.v8.Password password215,com.microsoft.adcenter.v8.UserName userName216)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetBusinessesInfo_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_GetBusinessesInfo_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getBusinessesInfoRequest210
            
                * @param applicationToken211
            
                * @param customerAccountId212
            
                * @param customerId213
            
                * @param developerToken214
            
                * @param password215
            
                * @param userName216
            
          */
        public void startgetBusinessesInfo(

            com.microsoft.adcenter.v8.GetBusinessesInfoRequest getBusinessesInfoRequest210,com.microsoft.adcenter.v8.ApplicationToken applicationToken211,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId212,
                com.microsoft.adcenter.v8.CustomerId customerId213,
                com.microsoft.adcenter.v8.DeveloperToken developerToken214,
                com.microsoft.adcenter.v8.Password password215,
                com.microsoft.adcenter.v8.UserName userName216,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateAdGroupsRequest218
                
                    * @param applicationToken219
                
                    * @param customerAccountId220
                
                    * @param customerId221
                
                    * @param developerToken222
                
                    * @param password223
                
                    * @param userName224
                
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateAdGroups_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.ICampaignManagementService_UpdateAdGroups_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.UpdateAdGroupsResponse updateAdGroups(

                        com.microsoft.adcenter.v8.UpdateAdGroupsRequest updateAdGroupsRequest218,com.microsoft.adcenter.v8.ApplicationToken applicationToken219,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId220,com.microsoft.adcenter.v8.CustomerId customerId221,com.microsoft.adcenter.v8.DeveloperToken developerToken222,com.microsoft.adcenter.v8.Password password223,com.microsoft.adcenter.v8.UserName userName224)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateAdGroups_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.ICampaignManagementService_UpdateAdGroups_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateAdGroupsRequest218
            
                * @param applicationToken219
            
                * @param customerAccountId220
            
                * @param customerId221
            
                * @param developerToken222
            
                * @param password223
            
                * @param userName224
            
          */
        public void startupdateAdGroups(

            com.microsoft.adcenter.v8.UpdateAdGroupsRequest updateAdGroupsRequest218,com.microsoft.adcenter.v8.ApplicationToken applicationToken219,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId220,
                com.microsoft.adcenter.v8.CustomerId customerId221,
                com.microsoft.adcenter.v8.DeveloperToken developerToken222,
                com.microsoft.adcenter.v8.Password password223,
                com.microsoft.adcenter.v8.UserName userName224,
                

            final com.microsoft.adcenter.v8.CampaignManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    