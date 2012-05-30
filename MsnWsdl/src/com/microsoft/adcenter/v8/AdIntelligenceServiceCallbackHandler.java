
/**
 * AdIntelligenceServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.v8;

    /**
     *  AdIntelligenceServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AdIntelligenceServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AdIntelligenceServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AdIntelligenceServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getHistoricalKeywordPerformance method
            * override this method for handling normal response from getHistoricalKeywordPerformance operation
            */
           public void receiveResultgetHistoricalKeywordPerformance(
                    com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricalKeywordPerformance operation
           */
            public void receiveErrorgetHistoricalKeywordPerformance(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getKeywordCategories method
            * override this method for handling normal response from getKeywordCategories operation
            */
           public void receiveResultgetKeywordCategories(
                    com.microsoft.adcenter.v8.GetKeywordCategoriesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getKeywordCategories operation
           */
            public void receiveErrorgetKeywordCategories(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoricalKeywordPerformanceByDevice method
            * override this method for handling normal response from getHistoricalKeywordPerformanceByDevice operation
            */
           public void receiveResultgetHistoricalKeywordPerformanceByDevice(
                    com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricalKeywordPerformanceByDevice operation
           */
            public void receiveErrorgetHistoricalKeywordPerformanceByDevice(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getKeywordDemographics method
            * override this method for handling normal response from getKeywordDemographics operation
            */
           public void receiveResultgetKeywordDemographics(
                    com.microsoft.adcenter.v8.GetKeywordDemographicsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getKeywordDemographics operation
           */
            public void receiveErrorgetKeywordDemographics(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getKeywordLocations method
            * override this method for handling normal response from getKeywordLocations operation
            */
           public void receiveResultgetKeywordLocations(
                    com.microsoft.adcenter.v8.GetKeywordLocationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getKeywordLocations operation
           */
            public void receiveErrorgetKeywordLocations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEstimatedBidByKeywordIds method
            * override this method for handling normal response from getEstimatedBidByKeywordIds operation
            */
           public void receiveResultgetEstimatedBidByKeywordIds(
                    com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEstimatedBidByKeywordIds operation
           */
            public void receiveErrorgetEstimatedBidByKeywordIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for suggestKeywordsForUrl method
            * override this method for handling normal response from suggestKeywordsForUrl operation
            */
           public void receiveResultsuggestKeywordsForUrl(
                    com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from suggestKeywordsForUrl operation
           */
            public void receiveErrorsuggestKeywordsForUrl(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEstimatedBidByKeywords method
            * override this method for handling normal response from getEstimatedBidByKeywords operation
            */
           public void receiveResultgetEstimatedBidByKeywords(
                    com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEstimatedBidByKeywords operation
           */
            public void receiveErrorgetEstimatedBidByKeywords(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEstimatedPositionByKeywords method
            * override this method for handling normal response from getEstimatedPositionByKeywords operation
            */
           public void receiveResultgetEstimatedPositionByKeywords(
                    com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEstimatedPositionByKeywords operation
           */
            public void receiveErrorgetEstimatedPositionByKeywords(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoricalSearchCount method
            * override this method for handling normal response from getHistoricalSearchCount operation
            */
           public void receiveResultgetHistoricalSearchCount(
                    com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricalSearchCount operation
           */
            public void receiveErrorgetHistoricalSearchCount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPublisherKeywordPerformance method
            * override this method for handling normal response from getPublisherKeywordPerformance operation
            */
           public void receiveResultgetPublisherKeywordPerformance(
                    com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPublisherKeywordPerformance operation
           */
            public void receiveErrorgetPublisherKeywordPerformance(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoricalSearchCountByDevice method
            * override this method for handling normal response from getHistoricalSearchCountByDevice operation
            */
           public void receiveResultgetHistoricalSearchCountByDevice(
                    com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricalSearchCountByDevice operation
           */
            public void receiveErrorgetHistoricalSearchCountByDevice(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for suggestKeywordsFromExistingKeywords method
            * override this method for handling normal response from suggestKeywordsFromExistingKeywords operation
            */
           public void receiveResultsuggestKeywordsFromExistingKeywords(
                    com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from suggestKeywordsFromExistingKeywords operation
           */
            public void receiveErrorsuggestKeywordsFromExistingKeywords(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEstimatedPositionByKeywordIds method
            * override this method for handling normal response from getEstimatedPositionByKeywordIds operation
            */
           public void receiveResultgetEstimatedPositionByKeywordIds(
                    com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEstimatedPositionByKeywordIds operation
           */
            public void receiveErrorgetEstimatedPositionByKeywordIds(java.lang.Exception e) {
            }
                


    }
    