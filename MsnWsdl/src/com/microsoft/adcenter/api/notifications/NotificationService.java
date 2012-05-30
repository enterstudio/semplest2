

/**
 * NotificationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.api.notifications;

    /*
     *  NotificationService java interface
     */

    public interface NotificationService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getNotificationsRequest4
                
                    * @param applicationToken5
                
                    * @param developerToken6
                
                    * @param password7
                
                    * @param userName8
                
             * @throws com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse getNotifications(

                        com.microsoft.adcenter.api.notifications.GetNotificationsRequest getNotificationsRequest4,com.microsoft.adcenter.api.notifications.ApplicationToken applicationToken5,com.microsoft.adcenter.api.notifications.DeveloperToken developerToken6,com.microsoft.adcenter.api.notifications.Password password7,com.microsoft.adcenter.api.notifications.UserName userName8)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getNotificationsRequest4
            
                * @param applicationToken5
            
                * @param developerToken6
            
                * @param password7
            
                * @param userName8
            
          */
        public void startgetNotifications(

            com.microsoft.adcenter.api.notifications.GetNotificationsRequest getNotificationsRequest4,com.microsoft.adcenter.api.notifications.ApplicationToken applicationToken5,
                com.microsoft.adcenter.api.notifications.DeveloperToken developerToken6,
                com.microsoft.adcenter.api.notifications.Password password7,
                com.microsoft.adcenter.api.notifications.UserName userName8,
                

            final com.microsoft.adcenter.api.notifications.NotificationServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getArchivedNotificationsRequest10
                
                    * @param applicationToken11
                
                    * @param developerToken12
                
                    * @param password13
                
                    * @param userName14
                
             * @throws com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse getArchivedNotifications(

                        com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest getArchivedNotificationsRequest10,com.microsoft.adcenter.api.notifications.ApplicationToken applicationToken11,com.microsoft.adcenter.api.notifications.DeveloperToken developerToken12,com.microsoft.adcenter.api.notifications.Password password13,com.microsoft.adcenter.api.notifications.UserName userName14)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getArchivedNotificationsRequest10
            
                * @param applicationToken11
            
                * @param developerToken12
            
                * @param password13
            
                * @param userName14
            
          */
        public void startgetArchivedNotifications(

            com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest getArchivedNotificationsRequest10,com.microsoft.adcenter.api.notifications.ApplicationToken applicationToken11,
                com.microsoft.adcenter.api.notifications.DeveloperToken developerToken12,
                com.microsoft.adcenter.api.notifications.Password password13,
                com.microsoft.adcenter.api.notifications.UserName userName14,
                

            final com.microsoft.adcenter.api.notifications.NotificationServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    