/**
 * BasicHttpBinding_ICustomerManagementServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class BasicHttpBinding_ICustomerManagementServiceStub extends org.apache.axis.client.Stub implements com.microsoft.adcenter.api.customermanagement.ICustomerManagementService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[33];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAccountsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetAccountsInfoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountsInfoRequest"), com.microsoft.adcenter.api.customermanagement.GetAccountsInfoRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountsInfoResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetAccountsInfoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FindAccounts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "FindAccountsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsRequest"), com.microsoft.adcenter.api.customermanagement.FindAccountsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.FindAccountsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "FindAccountsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AddAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddAccountRequest"), com.microsoft.adcenter.api.customermanagement.AddAccountRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddAccountResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.AddAccountResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AddAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpdateAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateAccountRequest"), com.microsoft.adcenter.api.customermanagement.UpdateAccountRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateAccountResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.UpdateAccountResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpdateAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetCustomerRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomerRequest"), com.microsoft.adcenter.api.customermanagement.GetCustomerRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomerResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetCustomerResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetCustomerResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpdateCustomerRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateCustomerRequest"), com.microsoft.adcenter.api.customermanagement.UpdateCustomerRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateCustomerResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.UpdateCustomerResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpdateCustomerResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SignupCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "SignupCustomerRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SignupCustomerRequest"), com.microsoft.adcenter.api.customermanagement.SignupCustomerRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SignupCustomerResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "SignupCustomerResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountRequest"), com.microsoft.adcenter.api.customermanagement.GetAccountRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetAccountResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCustomersInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetCustomersInfoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomersInfoRequest"), com.microsoft.adcenter.api.customermanagement.GetCustomersInfoRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomersInfoResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetCustomersInfoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AddUserRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddUserRequest"), com.microsoft.adcenter.api.customermanagement.AddUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddUserResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.AddUserResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AddUserResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteAccountRequest"), com.microsoft.adcenter.api.customermanagement.DeleteAccountRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteAccountResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteCustomerRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteCustomerRequest"), com.microsoft.adcenter.api.customermanagement.DeleteCustomerRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteCustomerResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.DeleteCustomerResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteCustomerResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpdateUserRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserRequest"), com.microsoft.adcenter.api.customermanagement.UpdateUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.UpdateUserResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpdateUserResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateUserRoles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpdateUserRolesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserRolesRequest"), com.microsoft.adcenter.api.customermanagement.UpdateUserRolesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserRolesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.UpdateUserRolesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpdateUserRolesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetUserRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUserRequest"), com.microsoft.adcenter.api.customermanagement.GetUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUserResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetUserResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetUserResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCurrentUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetCurrentUserRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCurrentUserRequest"), com.microsoft.adcenter.api.customermanagement.GetCurrentUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCurrentUserResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetCurrentUserResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetCurrentUserResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteUserRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteUserRequest"), com.microsoft.adcenter.api.customermanagement.DeleteUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteUserResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.DeleteUserResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteUserResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetUsersInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetUsersInfoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUsersInfoRequest"), com.microsoft.adcenter.api.customermanagement.GetUsersInfoRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUsersInfoResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetUsersInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetUsersInfoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCustomerPilotFeature");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetCustomerPilotFeatureRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomerPilotFeatureRequest"), com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomerPilotFeatureResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetCustomerPilotFeatureResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetPilotFeaturesCountries");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetPilotFeaturesCountriesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetPilotFeaturesCountriesRequest"), com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetPilotFeaturesCountriesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetPilotFeaturesCountriesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAccessibleCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetAccessibleCustomerRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccessibleCustomerRequest"), com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccessibleCustomerResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetAccessibleCustomerResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FindAccountsOrCustomersInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "FindAccountsOrCustomersInfoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsOrCustomersInfoRequest"), com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsOrCustomersInfoResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "FindAccountsOrCustomersInfoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpgradeCustomerToAgency");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpgradeCustomerToAgencyRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpgradeCustomerToAgencyRequest"), com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpgradeCustomerToAgencyResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UpgradeCustomerToAgencyResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SendRequestToManageAccounts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "SendRequestToManageAccountsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToManageAccountsRequest"), com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToManageAccountsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "SendRequestToManageAccountsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AcceptRequestToManageAccounts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AcceptRequestToManageAccountsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AcceptRequestToManageAccountsRequest"), com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AcceptRequestToManageAccountsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AcceptRequestToManageAccountsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelRequestToManageAccounts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "CancelRequestToManageAccountsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">CancelRequestToManageAccountsRequest"), com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">CancelRequestToManageAccountsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "CancelRequestToManageAccountsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SendRequestToStopManagingAccounts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "SendRequestToStopManagingAccountsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToStopManagingAccountsRequest"), com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToStopManagingAccountsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "SendRequestToStopManagingAccountsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetRequestToManageAccounts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetRequestToManageAccountsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsRequest"), com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetRequestToManageAccountsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetRequestToManageAccountsInfos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetRequestToManageAccountsInfosRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsInfosRequest"), com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsInfosResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "GetRequestToManageAccountsInfosResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeclineRequestToManageAccounts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeclineRequestToManageAccountsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeclineRequestToManageAccountsRequest"), com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeclineRequestToManageAccountsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeclineRequestToManageAccountsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddPrepayAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AddPrepayAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddPrepayAccountRequest"), com.microsoft.adcenter.api.customermanagement.AddPrepayAccountRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddPrepayAccountResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.AddPrepayAccountResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AddPrepayAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MapCustomerIdToExternalCustomerId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "MapCustomerIdToExternalCustomerIdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapCustomerIdToExternalCustomerIdRequest"), com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapCustomerIdToExternalCustomerIdResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "MapCustomerIdToExternalCustomerIdResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MapAccountIdToExternalAccountIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "MapAccountIdToExternalAccountIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapAccountIdToExternalAccountIdsRequest"), com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapAccountIdToExternalAccountIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "MapAccountIdToExternalAccountIdsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[32] = oper;

    }

    public BasicHttpBinding_ICustomerManagementServiceStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_ICustomerManagementServiceStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_ICustomerManagementServiceStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfint");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOflong");
            cachedSerQNames.add(qName);
            cls = long[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long");
            qName2 = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
            cachedSerQNames.add(qName);
            cls = int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.Duration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adapi.AdApiError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adapi.AdApiFaultDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "ApplicationFault");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adapi.ApplicationFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "ArrayOfAdApiError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adapi.AdApiError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiError");
            qName2 = new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Account");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.Account.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountFinancialStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.AccountFinancialStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.AccountInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfoWithCustomerData");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.AccountInfoWithCustomerData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountLifeCycleStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.AccountType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Address");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.Address.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AdvertiserAccount");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.AdvertiserAccount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ApplicationType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfAccountInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.AccountInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfAccountInfoWithCustomerData");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.AccountInfoWithCustomerData[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfoWithCustomerData");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfoWithCustomerData");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfCustomerInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.CustomerInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfManageAccountsRequestInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfManageAccountsRequestStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestStatus");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestStatus");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfManageAccountsRequestType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestType");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestType");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfPilotFeature");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.PilotFeature[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PilotFeature");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PilotFeature");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfUserInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ContactInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ContactInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CurrencyType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.CurrencyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Customer");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.Customer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerFinancialStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.CustomerFinancialStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.CustomerInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerLifeCycleStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.CustomerLifeCycleStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Date");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.Date.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "EmailFormat");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.EmailFormat.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Industry");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.Industry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LanguageType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.LanguageType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LCID");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.LCID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PaymentMethodType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.PaymentMethodType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PersonName");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.PersonName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PilotFeature");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.PilotFeature.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PublisherAccount");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.PublisherAccount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "SecretQuestion");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.SecretQuestion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ServiceLevel");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.ServiceLevel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "TimeZoneType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.TimeZoneType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "User");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.User.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.UserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserLifeCycleStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.UserLifeCycleStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserRole");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.UserRole.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.ApiFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ArrayOfOperationError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.OperationError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationError");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.OperationError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AcceptRequestToManageAccountsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AcceptRequestToManageAccountsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddAccountRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.AddAccountRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.AddAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddPrepayAccountRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.AddPrepayAccountRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddPrepayAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.AddPrepayAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddUserRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.AddUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AddUserResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.AddUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">CancelRequestToManageAccountsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">CancelRequestToManageAccountsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeclineRequestToManageAccountsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeclineRequestToManageAccountsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteAccountRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.DeleteAccountRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteCustomerRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.DeleteCustomerRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteCustomerResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.DeleteCustomerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteUserRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.DeleteUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">DeleteUserResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.DeleteUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsOrCustomersInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsOrCustomersInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.FindAccountsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.FindAccountsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccessibleCustomerRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccessibleCustomerResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetAccountRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountsInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetAccountsInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountsInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCurrentUserRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetCurrentUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCurrentUserResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetCurrentUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomerPilotFeatureRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomerPilotFeatureResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomerRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetCustomerRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomerResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetCustomerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomersInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetCustomersInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomersInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetPilotFeaturesCountriesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetPilotFeaturesCountriesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsInfosRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsInfosResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUserRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUserResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUsersInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetUsersInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUsersInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.GetUsersInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapAccountIdToExternalAccountIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapAccountIdToExternalAccountIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapCustomerIdToExternalCustomerIdRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapCustomerIdToExternalCustomerIdResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToManageAccountsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToManageAccountsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToStopManagingAccountsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToStopManagingAccountsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SignupCustomerRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.SignupCustomerRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SignupCustomerResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateAccountRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpdateAccountRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpdateAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateCustomerRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpdateCustomerRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateCustomerResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpdateCustomerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpdateUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpdateUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserRolesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpdateUserRolesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserRolesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpdateUserRolesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpgradeCustomerToAgencyRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpgradeCustomerToAgencyResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse getAccountsInfo(com.microsoft.adcenter.api.customermanagement.GetAccountsInfoRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAccountsInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAccountsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.FindAccountsResponse findAccounts(com.microsoft.adcenter.api.customermanagement.FindAccountsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("FindAccounts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "FindAccounts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.FindAccountsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.FindAccountsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.FindAccountsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.AddAccountResponse addAccount(com.microsoft.adcenter.api.customermanagement.AddAccountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddAccount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.AddAccountResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.AddAccountResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.AddAccountResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.UpdateAccountResponse updateAccount(com.microsoft.adcenter.api.customermanagement.UpdateAccountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateAccount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.UpdateAccountResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.UpdateAccountResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.UpdateAccountResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetCustomerResponse getCustomer(com.microsoft.adcenter.api.customermanagement.GetCustomerRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetCustomerResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetCustomerResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetCustomerResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.UpdateCustomerResponse updateCustomer(com.microsoft.adcenter.api.customermanagement.UpdateCustomerRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.UpdateCustomerResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.UpdateCustomerResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.UpdateCustomerResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse signupCustomer(com.microsoft.adcenter.api.customermanagement.SignupCustomerRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SignupCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SignupCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetAccountResponse getAccount(com.microsoft.adcenter.api.customermanagement.GetAccountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAccount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetAccountResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetAccountResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetAccountResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse getCustomersInfo(com.microsoft.adcenter.api.customermanagement.GetCustomersInfoRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetCustomersInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCustomersInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.AddUserResponse addUser(com.microsoft.adcenter.api.customermanagement.AddUserRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.AddUserResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.AddUserResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.AddUserResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse deleteAccount(com.microsoft.adcenter.api.customermanagement.DeleteAccountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteAccount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.DeleteCustomerResponse deleteCustomer(com.microsoft.adcenter.api.customermanagement.DeleteCustomerRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.DeleteCustomerResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.DeleteCustomerResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.DeleteCustomerResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.UpdateUserResponse updateUser(com.microsoft.adcenter.api.customermanagement.UpdateUserRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.UpdateUserResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.UpdateUserResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.UpdateUserResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.UpdateUserRolesResponse updateUserRoles(com.microsoft.adcenter.api.customermanagement.UpdateUserRolesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateUserRoles");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateUserRoles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.UpdateUserRolesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.UpdateUserRolesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.UpdateUserRolesResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetUserResponse getUser(com.microsoft.adcenter.api.customermanagement.GetUserRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetUserResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetUserResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetUserResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetCurrentUserResponse getCurrentUser(com.microsoft.adcenter.api.customermanagement.GetCurrentUserRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetCurrentUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCurrentUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetCurrentUserResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetCurrentUserResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetCurrentUserResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.DeleteUserResponse deleteUser(com.microsoft.adcenter.api.customermanagement.DeleteUserRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.DeleteUserResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.DeleteUserResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.DeleteUserResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetUsersInfoResponse getUsersInfo(com.microsoft.adcenter.api.customermanagement.GetUsersInfoRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetUsersInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetUsersInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetUsersInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetUsersInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetUsersInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureResponse getCustomerPilotFeature(com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetCustomerPilotFeature");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCustomerPilotFeature"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesResponse getPilotFeaturesCountries(com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetPilotFeaturesCountries");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetPilotFeaturesCountries"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerResponse getAccessibleCustomer(com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAccessibleCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAccessibleCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoResponse findAccountsOrCustomersInfo(com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("FindAccountsOrCustomersInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "FindAccountsOrCustomersInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyResponse upgradeCustomerToAgency(com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpgradeCustomerToAgency");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpgradeCustomerToAgency"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsResponse sendRequestToManageAccounts(com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SendRequestToManageAccounts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SendRequestToManageAccounts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsResponse acceptRequestToManageAccounts(com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AcceptRequestToManageAccounts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AcceptRequestToManageAccounts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsResponse cancelRequestToManageAccounts(com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("CancelRequestToManageAccounts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CancelRequestToManageAccounts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsResponse sendRequestToStopManagingAccounts(com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SendRequestToStopManagingAccounts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SendRequestToStopManagingAccounts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsResponse getRequestToManageAccounts(com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetRequestToManageAccounts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetRequestToManageAccounts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosResponse getRequestToManageAccountsInfos(com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetRequestToManageAccountsInfos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetRequestToManageAccountsInfos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsResponse declineRequestToManageAccounts(com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeclineRequestToManageAccounts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeclineRequestToManageAccounts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.AddPrepayAccountResponse addPrepayAccount(com.microsoft.adcenter.api.customermanagement.AddPrepayAccountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddPrepayAccount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddPrepayAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.AddPrepayAccountResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.AddPrepayAccountResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.AddPrepayAccountResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdResponse mapCustomerIdToExternalCustomerId(com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("MapCustomerIdToExternalCustomerId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "MapCustomerIdToExternalCustomerId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsResponse mapAccountIdToExternalAccountIds(com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("MapAccountIdToExternalAccountIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "MapAccountIdToExternalAccountIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
