/**
 * CustomerBillingServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customerbilling;

public class CustomerBillingServiceLocator extends org.apache.axis.client.Service implements com.microsoft.adcenter.api.customerbilling.CustomerBillingService {

    public CustomerBillingServiceLocator() {
    }


    public CustomerBillingServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerBillingServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ICustomerBillingService
    private java.lang.String BasicHttpBinding_ICustomerBillingService_address = "https://sharedservices.adcenterapi.microsoft.com/Api/Billing/v8/CustomerBillingService.svc";

    public java.lang.String getBasicHttpBinding_ICustomerBillingServiceAddress() {
        return BasicHttpBinding_ICustomerBillingService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ICustomerBillingServiceWSDDServiceName = "BasicHttpBinding_ICustomerBillingService";

    public java.lang.String getBasicHttpBinding_ICustomerBillingServiceWSDDServiceName() {
        return BasicHttpBinding_ICustomerBillingServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_ICustomerBillingServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ICustomerBillingServiceWSDDServiceName = name;
    }

    public com.microsoft.adcenter.api.customerbilling.ICustomerBillingService getBasicHttpBinding_ICustomerBillingService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ICustomerBillingService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ICustomerBillingService(endpoint);
    }

    public com.microsoft.adcenter.api.customerbilling.ICustomerBillingService getBasicHttpBinding_ICustomerBillingService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.microsoft.adcenter.api.customerbilling.BasicHttpBinding_ICustomerBillingServiceStub _stub = new com.microsoft.adcenter.api.customerbilling.BasicHttpBinding_ICustomerBillingServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ICustomerBillingServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ICustomerBillingServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ICustomerBillingService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.microsoft.adcenter.api.customerbilling.BasicHttpBinding_ICustomerBillingServiceStub _stub = new com.microsoft.adcenter.api.customerbilling.BasicHttpBinding_ICustomerBillingServiceStub(new java.net.URL(BasicHttpBinding_ICustomerBillingService_address), this);
                _stub.setPortName(getBasicHttpBinding_ICustomerBillingServiceWSDDServiceName());
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
        if ("BasicHttpBinding_ICustomerBillingService".equals(inputPortName)) {
            return getBasicHttpBinding_ICustomerBillingService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "CustomerBillingService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "BasicHttpBinding_ICustomerBillingService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ICustomerBillingService".equals(portName)) {
            setBasicHttpBinding_ICustomerBillingServiceEndpointAddress(address);
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
