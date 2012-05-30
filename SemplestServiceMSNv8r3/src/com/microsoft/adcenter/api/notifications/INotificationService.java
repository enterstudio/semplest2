/**
 * INotificationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications;

public interface INotificationService extends java.rmi.Remote {
    public com.microsoft.adcenter.api.notifications.Entities.GetNotificationsResponse getNotifications(com.microsoft.adcenter.api.notifications.GetNotificationsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
    public com.microsoft.adcenter.api.notifications.Entities.GetArchivedNotificationsResponse getArchivedNotifications(com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
}
