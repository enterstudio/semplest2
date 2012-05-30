
/**
 * CampaignManagementServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.v8;

    /**
     *  CampaignManagementServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CampaignManagementServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CampaignManagementServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CampaignManagementServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for deleteAds method
            * override this method for handling normal response from deleteAds operation
            */
           public void receiveResultdeleteAds(
                    com.microsoft.adcenter.v8.DeleteAdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAds operation
           */
            public void receiveErrordeleteAds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteTarget method
            * override this method for handling normal response from deleteTarget operation
            */
           public void receiveResultdeleteTarget(
                    com.microsoft.adcenter.v8.DeleteTargetResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteTarget operation
           */
            public void receiveErrordeleteTarget(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addCampaigns method
            * override this method for handling normal response from addCampaigns operation
            */
           public void receiveResultaddCampaigns(
                    com.microsoft.adcenter.v8.AddCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addCampaigns operation
           */
            public void receiveErroraddCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteKeywords method
            * override this method for handling normal response from deleteKeywords operation
            */
           public void receiveResultdeleteKeywords(
                    com.microsoft.adcenter.v8.DeleteKeywordsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteKeywords operation
           */
            public void receiveErrordeleteKeywords(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateGoals method
            * override this method for handling normal response from updateGoals operation
            */
           public void receiveResultupdateGoals(
                    com.microsoft.adcenter.v8.UpdateGoalsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateGoals operation
           */
            public void receiveErrorupdateGoals(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateTarget method
            * override this method for handling normal response from updateTarget operation
            */
           public void receiveResultupdateTarget(
                    com.microsoft.adcenter.v8.UpdateTargetResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateTarget operation
           */
            public void receiveErrorupdateTarget(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSitePlacementsByIds method
            * override this method for handling normal response from getSitePlacementsByIds operation
            */
           public void receiveResultgetSitePlacementsByIds(
                    com.microsoft.adcenter.v8.GetSitePlacementsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSitePlacementsByIds operation
           */
            public void receiveErrorgetSitePlacementsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTargetsByAdGroupIds method
            * override this method for handling normal response from getTargetsByAdGroupIds operation
            */
           public void receiveResultgetTargetsByAdGroupIds(
                    com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTargetsByAdGroupIds operation
           */
            public void receiveErrorgetTargetsByAdGroupIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setNegativeKeywordsToAdGroups method
            * override this method for handling normal response from setNegativeKeywordsToAdGroups operation
            */
           public void receiveResultsetNegativeKeywordsToAdGroups(
                    com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setNegativeKeywordsToAdGroups operation
           */
            public void receiveErrorsetNegativeKeywordsToAdGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNormalizedStrings method
            * override this method for handling normal response from getNormalizedStrings operation
            */
           public void receiveResultgetNormalizedStrings(
                    com.microsoft.adcenter.v8.GetNormalizedStringsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNormalizedStrings operation
           */
            public void receiveErrorgetNormalizedStrings(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteSitePlacements method
            * override this method for handling normal response from deleteSitePlacements operation
            */
           public void receiveResultdeleteSitePlacements(
                    com.microsoft.adcenter.v8.DeleteSitePlacementsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteSitePlacements operation
           */
            public void receiveErrordeleteSitePlacements(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setTargetToAdGroup method
            * override this method for handling normal response from setTargetToAdGroup operation
            */
           public void receiveResultsetTargetToAdGroup(
                    com.microsoft.adcenter.v8.SetTargetToAdGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setTargetToAdGroup operation
           */
            public void receiveErrorsetTargetToAdGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for submitAdGroupForApproval method
            * override this method for handling normal response from submitAdGroupForApproval operation
            */
           public void receiveResultsubmitAdGroupForApproval(
                    com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from submitAdGroupForApproval operation
           */
            public void receiveErrorsubmitAdGroupForApproval(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTargetByAdGroupId method
            * override this method for handling normal response from getTargetByAdGroupId operation
            */
           public void receiveResultgetTargetByAdGroupId(
                    com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTargetByAdGroupId operation
           */
            public void receiveErrorgetTargetByAdGroupId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pauseSitePlacements method
            * override this method for handling normal response from pauseSitePlacements operation
            */
           public void receiveResultpauseSitePlacements(
                    com.microsoft.adcenter.v8.PauseSitePlacementsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pauseSitePlacements operation
           */
            public void receiveErrorpauseSitePlacements(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdEditorialReasonsByIds method
            * override this method for handling normal response from getAdEditorialReasonsByIds operation
            */
           public void receiveResultgetAdEditorialReasonsByIds(
                    com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdEditorialReasonsByIds operation
           */
            public void receiveErrorgetAdEditorialReasonsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTargetsByCampaignIds method
            * override this method for handling normal response from getTargetsByCampaignIds operation
            */
           public void receiveResultgetTargetsByCampaignIds(
                    com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTargetsByCampaignIds operation
           */
            public void receiveErrorgetTargetsByCampaignIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addBusinesses method
            * override this method for handling normal response from addBusinesses operation
            */
           public void receiveResultaddBusinesses(
                    com.microsoft.adcenter.v8.AddBusinessesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addBusinesses operation
           */
            public void receiveErroraddBusinesses(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pauseCampaigns method
            * override this method for handling normal response from pauseCampaigns operation
            */
           public void receiveResultpauseCampaigns(
                    com.microsoft.adcenter.v8.PauseCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pauseCampaigns operation
           */
            public void receiveErrorpauseCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getKeywordsByEditorialStatus method
            * override this method for handling normal response from getKeywordsByEditorialStatus operation
            */
           public void receiveResultgetKeywordsByEditorialStatus(
                    com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getKeywordsByEditorialStatus operation
           */
            public void receiveErrorgetKeywordsByEditorialStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getKeywordEditorialReasonsByIds method
            * override this method for handling normal response from getKeywordEditorialReasonsByIds operation
            */
           public void receiveResultgetKeywordEditorialReasonsByIds(
                    com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getKeywordEditorialReasonsByIds operation
           */
            public void receiveErrorgetKeywordEditorialReasonsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteTargetFromAdGroup method
            * override this method for handling normal response from deleteTargetFromAdGroup operation
            */
           public void receiveResultdeleteTargetFromAdGroup(
                    com.microsoft.adcenter.v8.DeleteTargetFromAdGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteTargetFromAdGroup operation
           */
            public void receiveErrordeleteTargetFromAdGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for downloadCampaignHierarchy method
            * override this method for handling normal response from downloadCampaignHierarchy operation
            */
           public void receiveResultdownloadCampaignHierarchy(
                    com.microsoft.adcenter.v8.DownloadCampaignHierarchyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from downloadCampaignHierarchy operation
           */
            public void receiveErrordownloadCampaignHierarchy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resumeKeywords method
            * override this method for handling normal response from resumeKeywords operation
            */
           public void receiveResultresumeKeywords(
                    com.microsoft.adcenter.v8.ResumeKeywordsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeKeywords operation
           */
            public void receiveErrorresumeKeywords(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteAdExtensionsFromCampaigns method
            * override this method for handling normal response from deleteAdExtensionsFromCampaigns operation
            */
           public void receiveResultdeleteAdExtensionsFromCampaigns(
                    com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAdExtensionsFromCampaigns operation
           */
            public void receiveErrordeleteAdExtensionsFromCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setNegativeSitesToCampaigns method
            * override this method for handling normal response from setNegativeSitesToCampaigns operation
            */
           public void receiveResultsetNegativeSitesToCampaigns(
                    com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setNegativeSitesToCampaigns operation
           */
            public void receiveErrorsetNegativeSitesToCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateDeviceOSTargets method
            * override this method for handling normal response from updateDeviceOSTargets operation
            */
           public void receiveResultupdateDeviceOSTargets(
                    com.microsoft.adcenter.v8.UpdateDeviceOSTargetsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateDeviceOSTargets operation
           */
            public void receiveErrorupdateDeviceOSTargets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdsByEditorialStatus method
            * override this method for handling normal response from getAdsByEditorialStatus operation
            */
           public void receiveResultgetAdsByEditorialStatus(
                    com.microsoft.adcenter.v8.GetAdsByEditorialStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdsByEditorialStatus operation
           */
            public void receiveErrorgetAdsByEditorialStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteCampaigns method
            * override this method for handling normal response from deleteCampaigns operation
            */
           public void receiveResultdeleteCampaigns(
                    com.microsoft.adcenter.v8.DeleteCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteCampaigns operation
           */
            public void receiveErrordeleteCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addGoals method
            * override this method for handling normal response from addGoals operation
            */
           public void receiveResultaddGoals(
                    com.microsoft.adcenter.v8.AddGoalsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addGoals operation
           */
            public void receiveErroraddGoals(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDownloadStatus method
            * override this method for handling normal response from getDownloadStatus operation
            */
           public void receiveResultgetDownloadStatus(
                    com.microsoft.adcenter.v8.GetDownloadStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDownloadStatus operation
           */
            public void receiveErrorgetDownloadStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setTargetToCampaign method
            * override this method for handling normal response from setTargetToCampaign operation
            */
           public void receiveResultsetTargetToCampaign(
                    com.microsoft.adcenter.v8.SetTargetToCampaignResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setTargetToCampaign operation
           */
            public void receiveErrorsetTargetToCampaign(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resumeCampaigns method
            * override this method for handling normal response from resumeCampaigns operation
            */
           public void receiveResultresumeCampaigns(
                    com.microsoft.adcenter.v8.ResumeCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeCampaigns operation
           */
            public void receiveErrorresumeCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pauseAdGroups method
            * override this method for handling normal response from pauseAdGroups operation
            */
           public void receiveResultpauseAdGroups(
                    com.microsoft.adcenter.v8.PauseAdGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pauseAdGroups operation
           */
            public void receiveErrorpauseAdGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateTargetsInLibrary method
            * override this method for handling normal response from updateTargetsInLibrary operation
            */
           public void receiveResultupdateTargetsInLibrary(
                    com.microsoft.adcenter.v8.UpdateTargetsInLibraryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateTargetsInLibrary operation
           */
            public void receiveErrorupdateTargetsInLibrary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteBusinesses method
            * override this method for handling normal response from deleteBusinesses operation
            */
           public void receiveResultdeleteBusinesses(
                    com.microsoft.adcenter.v8.DeleteBusinessesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteBusinesses operation
           */
            public void receiveErrordeleteBusinesses(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setAnalyticsType method
            * override this method for handling normal response from setAnalyticsType operation
            */
           public void receiveResultsetAnalyticsType(
                    com.microsoft.adcenter.v8.SetAnalyticsTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setAnalyticsType operation
           */
            public void receiveErrorsetAnalyticsType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNegativeSitesByAdGroupIds method
            * override this method for handling normal response from getNegativeSitesByAdGroupIds operation
            */
           public void receiveResultgetNegativeSitesByAdGroupIds(
                    com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNegativeSitesByAdGroupIds operation
           */
            public void receiveErrorgetNegativeSitesByAdGroupIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteAdGroups method
            * override this method for handling normal response from deleteAdGroups operation
            */
           public void receiveResultdeleteAdGroups(
                    com.microsoft.adcenter.v8.DeleteAdGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAdGroups operation
           */
            public void receiveErrordeleteAdGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateCampaigns method
            * override this method for handling normal response from updateCampaigns operation
            */
           public void receiveResultupdateCampaigns(
                    com.microsoft.adcenter.v8.UpdateCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateCampaigns operation
           */
            public void receiveErrorupdateCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCampaignsByAccountId method
            * override this method for handling normal response from getCampaignsByAccountId operation
            */
           public void receiveResultgetCampaignsByAccountId(
                    com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCampaignsByAccountId operation
           */
            public void receiveErrorgetCampaignsByAccountId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAds method
            * override this method for handling normal response from addAds operation
            */
           public void receiveResultaddAds(
                    com.microsoft.adcenter.v8.AddAdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAds operation
           */
            public void receiveErroraddAds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setCampaignAdExtensions method
            * override this method for handling normal response from setCampaignAdExtensions operation
            */
           public void receiveResultsetCampaignAdExtensions(
                    com.microsoft.adcenter.v8.SetCampaignAdExtensionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setCampaignAdExtensions operation
           */
            public void receiveErrorsetCampaignAdExtensions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccountMigrationStatuses method
            * override this method for handling normal response from getAccountMigrationStatuses operation
            */
           public void receiveResultgetAccountMigrationStatuses(
                    com.microsoft.adcenter.v8.GetAccountMigrationStatusesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccountMigrationStatuses operation
           */
            public void receiveErrorgetAccountMigrationStatuses(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDeviceOSTargetsByIds method
            * override this method for handling normal response from getDeviceOSTargetsByIds operation
            */
           public void receiveResultgetDeviceOSTargetsByIds(
                    com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDeviceOSTargetsByIds operation
           */
            public void receiveErrorgetDeviceOSTargetsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getGoals method
            * override this method for handling normal response from getGoals operation
            */
           public void receiveResultgetGoals(
                    com.microsoft.adcenter.v8.GetGoalsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGoals operation
           */
            public void receiveErrorgetGoals(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdExtensionsByIds method
            * override this method for handling normal response from getAdExtensionsByIds operation
            */
           public void receiveResultgetAdExtensionsByIds(
                    com.microsoft.adcenter.v8.GetAdExtensionsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdExtensionsByIds operation
           */
            public void receiveErrorgetAdExtensionsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getKeywordsByAdGroupId method
            * override this method for handling normal response from getKeywordsByAdGroupId operation
            */
           public void receiveResultgetKeywordsByAdGroupId(
                    com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getKeywordsByAdGroupId operation
           */
            public void receiveErrorgetKeywordsByAdGroupId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setNegativeSitesToAdGroups method
            * override this method for handling normal response from setNegativeSitesToAdGroups operation
            */
           public void receiveResultsetNegativeSitesToAdGroups(
                    com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setNegativeSitesToAdGroups operation
           */
            public void receiveErrorsetNegativeSitesToAdGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNegativeSitesByCampaignIds method
            * override this method for handling normal response from getNegativeSitesByCampaignIds operation
            */
           public void receiveResultgetNegativeSitesByCampaignIds(
                    com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNegativeSitesByCampaignIds operation
           */
            public void receiveErrorgetNegativeSitesByCampaignIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addTarget method
            * override this method for handling normal response from addTarget operation
            */
           public void receiveResultaddTarget(
                    com.microsoft.adcenter.v8.AddTargetResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addTarget operation
           */
            public void receiveErroraddTarget(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdGroupsByIds method
            * override this method for handling normal response from getAdGroupsByIds operation
            */
           public void receiveResultgetAdGroupsByIds(
                    com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdGroupsByIds operation
           */
            public void receiveErrorgetAdGroupsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addTargetsToLibrary method
            * override this method for handling normal response from addTargetsToLibrary operation
            */
           public void receiveResultaddTargetsToLibrary(
                    com.microsoft.adcenter.v8.AddTargetsToLibraryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addTargetsToLibrary operation
           */
            public void receiveErroraddTargetsToLibrary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAnalyticsType method
            * override this method for handling normal response from getAnalyticsType operation
            */
           public void receiveResultgetAnalyticsType(
                    com.microsoft.adcenter.v8.GetAnalyticsTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAnalyticsType operation
           */
            public void receiveErrorgetAnalyticsType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdExtensionsByCampaignIds method
            * override this method for handling normal response from getAdExtensionsByCampaignIds operation
            */
           public void receiveResultgetAdExtensionsByCampaignIds(
                    com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdExtensionsByCampaignIds operation
           */
            public void receiveErrorgetAdExtensionsByCampaignIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBusinessesByIds method
            * override this method for handling normal response from getBusinessesByIds operation
            */
           public void receiveResultgetBusinessesByIds(
                    com.microsoft.adcenter.v8.GetBusinessesByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBusinessesByIds operation
           */
            public void receiveErrorgetBusinessesByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteTargetFromCampaign method
            * override this method for handling normal response from deleteTargetFromCampaign operation
            */
           public void receiveResultdeleteTargetFromCampaign(
                    com.microsoft.adcenter.v8.DeleteTargetFromCampaignResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteTargetFromCampaign operation
           */
            public void receiveErrordeleteTargetFromCampaign(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNegativeKeywordsByAdGroupIds method
            * override this method for handling normal response from getNegativeKeywordsByAdGroupIds operation
            */
           public void receiveResultgetNegativeKeywordsByAdGroupIds(
                    com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNegativeKeywordsByAdGroupIds operation
           */
            public void receiveErrorgetNegativeKeywordsByAdGroupIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateAds method
            * override this method for handling normal response from updateAds operation
            */
           public void receiveResultupdateAds(
                    com.microsoft.adcenter.v8.UpdateAdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateAds operation
           */
            public void receiveErrorupdateAds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAdGroups method
            * override this method for handling normal response from addAdGroups operation
            */
           public void receiveResultaddAdGroups(
                    com.microsoft.adcenter.v8.AddAdGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAdGroups operation
           */
            public void receiveErroraddAdGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCampaignAdExtensions method
            * override this method for handling normal response from getCampaignAdExtensions operation
            */
           public void receiveResultgetCampaignAdExtensions(
                    com.microsoft.adcenter.v8.GetCampaignAdExtensionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCampaignAdExtensions operation
           */
            public void receiveErrorgetCampaignAdExtensions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdsByIds method
            * override this method for handling normal response from getAdsByIds operation
            */
           public void receiveResultgetAdsByIds(
                    com.microsoft.adcenter.v8.GetAdsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdsByIds operation
           */
            public void receiveErrorgetAdsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setAdExtensionsToCampaigns method
            * override this method for handling normal response from setAdExtensionsToCampaigns operation
            */
           public void receiveResultsetAdExtensionsToCampaigns(
                    com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setAdExtensionsToCampaigns operation
           */
            public void receiveErrorsetAdExtensionsToCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteGoals method
            * override this method for handling normal response from deleteGoals operation
            */
           public void receiveResultdeleteGoals(
                    com.microsoft.adcenter.v8.DeleteGoalsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteGoals operation
           */
            public void receiveErrordeleteGoals(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pauseKeywords method
            * override this method for handling normal response from pauseKeywords operation
            */
           public void receiveResultpauseKeywords(
                    com.microsoft.adcenter.v8.PauseKeywordsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pauseKeywords operation
           */
            public void receiveErrorpauseKeywords(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNegativeKeywordsByCampaignIds method
            * override this method for handling normal response from getNegativeKeywordsByCampaignIds operation
            */
           public void receiveResultgetNegativeKeywordsByCampaignIds(
                    com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNegativeKeywordsByCampaignIds operation
           */
            public void receiveErrorgetNegativeKeywordsByCampaignIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateKeywords method
            * override this method for handling normal response from updateKeywords operation
            */
           public void receiveResultupdateKeywords(
                    com.microsoft.adcenter.v8.UpdateKeywordsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateKeywords operation
           */
            public void receiveErrorupdateKeywords(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addKeywords method
            * override this method for handling normal response from addKeywords operation
            */
           public void receiveResultaddKeywords(
                    com.microsoft.adcenter.v8.AddKeywordsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addKeywords operation
           */
            public void receiveErroraddKeywords(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTargetsInfoFromLibrary method
            * override this method for handling normal response from getTargetsInfoFromLibrary operation
            */
           public void receiveResultgetTargetsInfoFromLibrary(
                    com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTargetsInfoFromLibrary operation
           */
            public void receiveErrorgetTargetsInfoFromLibrary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setNegativeKeywordsToCampaigns method
            * override this method for handling normal response from setNegativeKeywordsToCampaigns operation
            */
           public void receiveResultsetNegativeKeywordsToCampaigns(
                    com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setNegativeKeywordsToCampaigns operation
           */
            public void receiveErrorsetNegativeKeywordsToCampaigns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdsByAdGroupId method
            * override this method for handling normal response from getAdsByAdGroupId operation
            */
           public void receiveResultgetAdsByAdGroupId(
                    com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdsByAdGroupId operation
           */
            public void receiveErrorgetAdsByAdGroupId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTargetsByIds method
            * override this method for handling normal response from getTargetsByIds operation
            */
           public void receiveResultgetTargetsByIds(
                    com.microsoft.adcenter.v8.GetTargetsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTargetsByIds operation
           */
            public void receiveErrorgetTargetsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteTargetsFromLibrary method
            * override this method for handling normal response from deleteTargetsFromLibrary operation
            */
           public void receiveResultdeleteTargetsFromLibrary(
                    com.microsoft.adcenter.v8.DeleteTargetsFromLibraryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteTargetsFromLibrary operation
           */
            public void receiveErrordeleteTargetsFromLibrary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resumeAdGroups method
            * override this method for handling normal response from resumeAdGroups operation
            */
           public void receiveResultresumeAdGroups(
                    com.microsoft.adcenter.v8.ResumeAdGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeAdGroups operation
           */
            public void receiveErrorresumeAdGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCampaignsByIds method
            * override this method for handling normal response from getCampaignsByIds operation
            */
           public void receiveResultgetCampaignsByIds(
                    com.microsoft.adcenter.v8.GetCampaignsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCampaignsByIds operation
           */
            public void receiveErrorgetCampaignsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resumeSitePlacements method
            * override this method for handling normal response from resumeSitePlacements operation
            */
           public void receiveResultresumeSitePlacements(
                    com.microsoft.adcenter.v8.ResumeSitePlacementsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeSitePlacements operation
           */
            public void receiveErrorresumeSitePlacements(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getKeywordsByIds method
            * override this method for handling normal response from getKeywordsByIds operation
            */
           public void receiveResultgetKeywordsByIds(
                    com.microsoft.adcenter.v8.GetKeywordsByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getKeywordsByIds operation
           */
            public void receiveErrorgetKeywordsByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resumeAds method
            * override this method for handling normal response from resumeAds operation
            */
           public void receiveResultresumeAds(
                    com.microsoft.adcenter.v8.ResumeAdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeAds operation
           */
            public void receiveErrorresumeAds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAdExtensions method
            * override this method for handling normal response from addAdExtensions operation
            */
           public void receiveResultaddAdExtensions(
                    com.microsoft.adcenter.v8.AddAdExtensionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAdExtensions operation
           */
            public void receiveErroraddAdExtensions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateSitePlacements method
            * override this method for handling normal response from updateSitePlacements operation
            */
           public void receiveResultupdateSitePlacements(
                    com.microsoft.adcenter.v8.UpdateSitePlacementsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateSitePlacements operation
           */
            public void receiveErrorupdateSitePlacements(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPlacementDetailsForUrls method
            * override this method for handling normal response from getPlacementDetailsForUrls operation
            */
           public void receiveResultgetPlacementDetailsForUrls(
                    com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPlacementDetailsForUrls operation
           */
            public void receiveErrorgetPlacementDetailsForUrls(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pauseAds method
            * override this method for handling normal response from pauseAds operation
            */
           public void receiveResultpauseAds(
                    com.microsoft.adcenter.v8.PauseAdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pauseAds operation
           */
            public void receiveErrorpauseAds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSitePlacementsByAdGroupId method
            * override this method for handling normal response from getSitePlacementsByAdGroupId operation
            */
           public void receiveResultgetSitePlacementsByAdGroupId(
                    com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSitePlacementsByAdGroupId operation
           */
            public void receiveErrorgetSitePlacementsByAdGroupId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateBusinesses method
            * override this method for handling normal response from updateBusinesses operation
            */
           public void receiveResultupdateBusinesses(
                    com.microsoft.adcenter.v8.UpdateBusinessesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateBusinesses operation
           */
            public void receiveErrorupdateBusinesses(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addSitePlacements method
            * override this method for handling normal response from addSitePlacements operation
            */
           public void receiveResultaddSitePlacements(
                    com.microsoft.adcenter.v8.AddSitePlacementsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addSitePlacements operation
           */
            public void receiveErroraddSitePlacements(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdGroupsByCampaignId method
            * override this method for handling normal response from getAdGroupsByCampaignId operation
            */
           public void receiveResultgetAdGroupsByCampaignId(
                    com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdGroupsByCampaignId operation
           */
            public void receiveErrorgetAdGroupsByCampaignId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBusinessesInfo method
            * override this method for handling normal response from getBusinessesInfo operation
            */
           public void receiveResultgetBusinessesInfo(
                    com.microsoft.adcenter.v8.GetBusinessesInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBusinessesInfo operation
           */
            public void receiveErrorgetBusinessesInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateAdGroups method
            * override this method for handling normal response from updateAdGroups operation
            */
           public void receiveResultupdateAdGroups(
                    com.microsoft.adcenter.v8.UpdateAdGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateAdGroups operation
           */
            public void receiveErrorupdateAdGroups(java.lang.Exception e) {
            }
                


    }
    