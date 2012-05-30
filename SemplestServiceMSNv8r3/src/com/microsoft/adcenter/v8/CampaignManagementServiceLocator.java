/**
 * CampaignManagementServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class CampaignManagementServiceLocator extends org.apache.axis.client.Service implements com.microsoft.adcenter.v8.CampaignManagementService {

    public CampaignManagementServiceLocator() {
    }


    public CampaignManagementServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CampaignManagementServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ICampaignManagementService
    private java.lang.String BasicHttpBinding_ICampaignManagementService_address = "https://adcenterapi.microsoft.com/Api/Advertiser/V8/CampaignManagement/CampaignManagementService.svc";

    public java.lang.String getBasicHttpBinding_ICampaignManagementServiceAddress() {
        return BasicHttpBinding_ICampaignManagementService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ICampaignManagementServiceWSDDServiceName = "BasicHttpBinding_ICampaignManagementService";

    public java.lang.String getBasicHttpBinding_ICampaignManagementServiceWSDDServiceName() {
        return BasicHttpBinding_ICampaignManagementServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_ICampaignManagementServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ICampaignManagementServiceWSDDServiceName = name;
    }

    public com.microsoft.adcenter.v8.ICampaignManagementService getBasicHttpBinding_ICampaignManagementService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ICampaignManagementService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ICampaignManagementService(endpoint);
    }

    public com.microsoft.adcenter.v8.ICampaignManagementService getBasicHttpBinding_ICampaignManagementService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.microsoft.adcenter.v8.BasicHttpBinding_ICampaignManagementServiceStub _stub = new com.microsoft.adcenter.v8.BasicHttpBinding_ICampaignManagementServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ICampaignManagementServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ICampaignManagementServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ICampaignManagementService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.microsoft.adcenter.v8.ICampaignManagementService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.microsoft.adcenter.v8.BasicHttpBinding_ICampaignManagementServiceStub _stub = new com.microsoft.adcenter.v8.BasicHttpBinding_ICampaignManagementServiceStub(new java.net.URL(BasicHttpBinding_ICampaignManagementService_address), this);
                _stub.setPortName(getBasicHttpBinding_ICampaignManagementServiceWSDDServiceName());
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
        if ("BasicHttpBinding_ICampaignManagementService".equals(inputPortName)) {
            return getBasicHttpBinding_ICampaignManagementService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignManagementService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BasicHttpBinding_ICampaignManagementService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ICampaignManagementService".equals(portName)) {
            setBasicHttpBinding_ICampaignManagementServiceEndpointAddress(address);
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
