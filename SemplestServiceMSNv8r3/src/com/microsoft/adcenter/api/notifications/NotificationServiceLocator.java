/**
 * NotificationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications;

public class NotificationServiceLocator extends org.apache.axis.client.Service implements com.microsoft.adcenter.api.notifications.NotificationService {

    public NotificationServiceLocator() {
    }


    public NotificationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NotificationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_INotificationService
    private java.lang.String BasicHttpBinding_INotificationService_address = "https://sharedservices.adcenterapi.microsoft.com/Api/Notification/v8/NotificationService.svc";

    public java.lang.String getBasicHttpBinding_INotificationServiceAddress() {
        return BasicHttpBinding_INotificationService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_INotificationServiceWSDDServiceName = "BasicHttpBinding_INotificationService";

    public java.lang.String getBasicHttpBinding_INotificationServiceWSDDServiceName() {
        return BasicHttpBinding_INotificationServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_INotificationServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_INotificationServiceWSDDServiceName = name;
    }

    public com.microsoft.adcenter.api.notifications.INotificationService getBasicHttpBinding_INotificationService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_INotificationService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_INotificationService(endpoint);
    }

    public com.microsoft.adcenter.api.notifications.INotificationService getBasicHttpBinding_INotificationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.microsoft.adcenter.api.notifications.BasicHttpBinding_INotificationServiceStub _stub = new com.microsoft.adcenter.api.notifications.BasicHttpBinding_INotificationServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_INotificationServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_INotificationServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_INotificationService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.microsoft.adcenter.api.notifications.INotificationService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.microsoft.adcenter.api.notifications.BasicHttpBinding_INotificationServiceStub _stub = new com.microsoft.adcenter.api.notifications.BasicHttpBinding_INotificationServiceStub(new java.net.URL(BasicHttpBinding_INotificationService_address), this);
                _stub.setPortName(getBasicHttpBinding_INotificationServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_INotificationService".equals(inputPortName)) {
            return getBasicHttpBinding_INotificationService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "NotificationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "BasicHttpBinding_INotificationService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_INotificationService".equals(portName)) {
            setBasicHttpBinding_INotificationServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
