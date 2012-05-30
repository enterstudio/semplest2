
/**
 * NotificationServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.microsoft.adcenter.api.notifications;

        

        /*
        *  NotificationServiceStub java implementation
        */

        
        public class NotificationServiceStub extends org.apache.axis2.client.Stub
        implements NotificationService{
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized java.lang.String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("NotificationService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_INotificationService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_INotificationService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_INotificationService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_INotificationService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[1]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetNotifications"),"com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetNotifications"),"com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetNotifications"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetNotifications"),"com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetNotifications"),"com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetNotifications"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetArchivedNotifications"),"com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetArchivedNotifications"),"com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetArchivedNotifications"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetArchivedNotifications"),"com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetArchivedNotifications"),"com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetArchivedNotifications"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public NotificationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public NotificationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
        _service.applyPolicy();
        
	
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public NotificationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"https://sharedservices.adcenterapi.microsoft.com/Api/Notification/v8/NotificationService.svc" );
                
    }

    /**
     * Default Constructor
     */
    public NotificationServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("https://sharedservices.adcenterapi.microsoft.com/Api/Notification/v8/NotificationService.svc" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public NotificationServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.api.notifications.NotificationService#getNotifications
                     * @param getNotificationsRequest16
                    
                     * @param applicationToken17
                    
                     * @param developerToken18
                    
                     * @param password19
                    
                     * @param userName20
                    
                     * @throws com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse getNotifications(

                            com.microsoft.adcenter.api.notifications.GetNotificationsRequest getNotificationsRequest16,com.microsoft.adcenter.api.notifications.ApplicationToken applicationToken17,com.microsoft.adcenter.api.notifications.DeveloperToken developerToken18,com.microsoft.adcenter.api.notifications.Password password19,com.microsoft.adcenter.api.notifications.UserName userName20)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("GetNotifications");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getNotificationsRequest16,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications",
                                                    "getNotifications")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications",
                                                    "getNotifications"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken17!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken17 = toOM(applicationToken17, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications")));
                                                    addHeader(omElementapplicationToken17,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken18!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken18 = toOM(developerToken18, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications")));
                                                    addHeader(omElementdeveloperToken18,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password19!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword19 = toOM(password19, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications")));
                                                    addHeader(omElementpassword19,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName20!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName20 = toOM(userName20, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications")));
                                                    addHeader(omElementuserName20,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetNotifications"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetNotifications"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetNotifications"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.api.notifications.NotificationService#startgetNotifications
                    * @param getNotificationsRequest16
                
                    * @param applicationToken17
                
                    * @param developerToken18
                
                    * @param password19
                
                    * @param userName20
                
                */
                public  void startgetNotifications(

                 com.microsoft.adcenter.api.notifications.GetNotificationsRequest getNotificationsRequest16,com.microsoft.adcenter.api.notifications.ApplicationToken applicationToken17,
                    com.microsoft.adcenter.api.notifications.DeveloperToken developerToken18,
                    com.microsoft.adcenter.api.notifications.Password password19,
                    com.microsoft.adcenter.api.notifications.UserName userName20,
                    

                  final com.microsoft.adcenter.api.notifications.NotificationServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("GetNotifications");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getNotificationsRequest16,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications",
                                                    "getNotifications")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications",
                                                    "getNotifications"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken17!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken17 = toOM(applicationToken17, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications")));
                                                    addHeader(omElementapplicationToken17,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken18!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken18 = toOM(developerToken18, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications")));
                                                    addHeader(omElementdeveloperToken18,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password19!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword19 = toOM(password19, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications")));
                                                    addHeader(omElementpassword19,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName20!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName20 = toOM(userName20, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getNotifications")));
                                                    addHeader(omElementuserName20,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetNotifications(
                                        (com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetNotifications(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetNotifications"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetNotifications"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetNotifications"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetNotifications((com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage){
														callback.receiveErrorgetNotifications((com.microsoft.adcenter.api.notifications.INotificationService_GetNotifications_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetNotifications(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetNotifications(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetNotifications(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetNotifications(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetNotifications(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetNotifications(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetNotifications(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetNotifications(f);
                                            }
									    } else {
										    callback.receiveErrorgetNotifications(f);
									    }
									} else {
									    callback.receiveErrorgetNotifications(f);
									}
								} else {
								    callback.receiveErrorgetNotifications(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetNotifications(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.api.notifications.NotificationService#getArchivedNotifications
                     * @param getArchivedNotificationsRequest22
                    
                     * @param applicationToken23
                    
                     * @param developerToken24
                    
                     * @param password25
                    
                     * @param userName26
                    
                     * @throws com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse getArchivedNotifications(

                            com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest getArchivedNotificationsRequest22,com.microsoft.adcenter.api.notifications.ApplicationToken applicationToken23,com.microsoft.adcenter.api.notifications.DeveloperToken developerToken24,com.microsoft.adcenter.api.notifications.Password password25,com.microsoft.adcenter.api.notifications.UserName userName26)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("GetArchivedNotifications");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getArchivedNotificationsRequest22,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications",
                                                    "getArchivedNotifications")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications",
                                                    "getArchivedNotifications"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken23!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken23 = toOM(applicationToken23, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications")));
                                                    addHeader(omElementapplicationToken23,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken24!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken24 = toOM(developerToken24, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications")));
                                                    addHeader(omElementdeveloperToken24,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password25!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword25 = toOM(password25, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications")));
                                                    addHeader(omElementpassword25,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName26!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName26 = toOM(userName26, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications")));
                                                    addHeader(omElementuserName26,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetArchivedNotifications"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetArchivedNotifications"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetArchivedNotifications"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.api.notifications.NotificationService#startgetArchivedNotifications
                    * @param getArchivedNotificationsRequest22
                
                    * @param applicationToken23
                
                    * @param developerToken24
                
                    * @param password25
                
                    * @param userName26
                
                */
                public  void startgetArchivedNotifications(

                 com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest getArchivedNotificationsRequest22,com.microsoft.adcenter.api.notifications.ApplicationToken applicationToken23,
                    com.microsoft.adcenter.api.notifications.DeveloperToken developerToken24,
                    com.microsoft.adcenter.api.notifications.Password password25,
                    com.microsoft.adcenter.api.notifications.UserName userName26,
                    

                  final com.microsoft.adcenter.api.notifications.NotificationServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("GetArchivedNotifications");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getArchivedNotificationsRequest22,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications",
                                                    "getArchivedNotifications")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications",
                                                    "getArchivedNotifications"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken23!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken23 = toOM(applicationToken23, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications")));
                                                    addHeader(omElementapplicationToken23,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken24!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken24 = toOM(developerToken24, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications")));
                                                    addHeader(omElementdeveloperToken24,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password25!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword25 = toOM(password25, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications")));
                                                    addHeader(omElementpassword25,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName26!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName26 = toOM(userName26, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "getArchivedNotifications")));
                                                    addHeader(omElementuserName26,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetArchivedNotifications(
                                        (com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetArchivedNotifications(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetArchivedNotifications"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetArchivedNotifications"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetArchivedNotifications"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetArchivedNotifications((com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage){
														callback.receiveErrorgetArchivedNotifications((com.microsoft.adcenter.api.notifications.INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetArchivedNotifications(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetArchivedNotifications(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetArchivedNotifications(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetArchivedNotifications(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetArchivedNotifications(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetArchivedNotifications(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetArchivedNotifications(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetArchivedNotifications(f);
                                            }
									    } else {
										    callback.receiveErrorgetArchivedNotifications(f);
									    }
									} else {
									    callback.receiveErrorgetArchivedNotifications(f);
									}
								} else {
								    callback.receiveErrorgetArchivedNotifications(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetArchivedNotifications(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    ////////////////////////////////////////////////////////////////////////
    
    private static org.apache.neethi.Policy getPolicy (java.lang.String policyString) {
    	return org.apache.neethi.PolicyEngine.getPolicy(org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(
    	        new java.io.StringReader(policyString)).getDocument().getXMLStreamReader(false));
    }
    
    /////////////////////////////////////////////////////////////////////////

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //https://sharedservices.adcenterapi.microsoft.com/Api/Notification/v8/NotificationService.svc
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.GetNotificationsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.GetNotificationsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adapi.AdApiFaultDetailE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adapi.AdApiFaultDetailE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.ApplicationToken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.ApplicationToken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.DeveloperToken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.DeveloperToken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.Password param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.Password.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.UserName param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.UserName.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.TrackingId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.TrackingId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.notifications.GetNotificationsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.notifications.GetNotificationsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.microsoft.adcenter.api.notifications.GetNotificationsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.GetNotificationsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.entities.GetNotificationsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.GetArchivedNotificationsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.entities.GetArchivedNotificationsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.notifications.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.notifications.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   