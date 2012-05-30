
/**
 * ReportingServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.microsoft.adcenter.v8;

        

        /*
        *  ReportingServiceStub java implementation
        */

        
        public class ReportingServiceStub extends org.apache.axis2.client.Stub
        implements ReportingService{
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
     _service = new org.apache.axis2.description.AxisService("ReportingService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IReportingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IReportingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IReportingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IReportingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[1]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SubmitGenerateReport"),"com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SubmitGenerateReport"),"com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SubmitGenerateReport"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SubmitGenerateReport"),"com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SubmitGenerateReport"),"com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SubmitGenerateReport"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "PollGenerateReport"),"com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "PollGenerateReport"),"com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "PollGenerateReport"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "PollGenerateReport"),"com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "PollGenerateReport"),"com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "PollGenerateReport"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public ReportingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public ReportingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public ReportingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"https://adcenterapi.microsoft.com/Api/Advertiser/V8/Reporting/ReportingService.svc" );
                
    }

    /**
     * Default Constructor
     */
    public ReportingServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("https://adcenterapi.microsoft.com/Api/Advertiser/V8/Reporting/ReportingService.svc" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public ReportingServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.ReportingService#submitGenerateReport
                     * @param submitGenerateReportRequest22
                    
                     * @param applicationToken23
                    
                     * @param customerAccountId24
                    
                     * @param customerId25
                    
                     * @param developerToken26
                    
                     * @param password27
                    
                     * @param userName28
                    
                     * @throws com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.SubmitGenerateReportResponse submitGenerateReport(

                            com.microsoft.adcenter.v8.SubmitGenerateReportRequest submitGenerateReportRequest22,com.microsoft.adcenter.v8.ApplicationToken applicationToken23,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId24,com.microsoft.adcenter.v8.CustomerId customerId25,com.microsoft.adcenter.v8.DeveloperToken developerToken26,com.microsoft.adcenter.v8.Password password27,com.microsoft.adcenter.v8.UserName userName28)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("SubmitGenerateReport");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    submitGenerateReportRequest22,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "submitGenerateReport")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "submitGenerateReport"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken23!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken23 = toOM(applicationToken23, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementapplicationToken23,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId24!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId24 = toOM(customerAccountId24, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementcustomerAccountId24,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId25!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId25 = toOM(customerId25, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementcustomerId25,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken26!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken26 = toOM(developerToken26, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementdeveloperToken26,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password27!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword27 = toOM(password27, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementpassword27,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName28!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName28 = toOM(userName28, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementuserName28,env);
                                                
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
                                             com.microsoft.adcenter.v8.SubmitGenerateReportResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.SubmitGenerateReportResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SubmitGenerateReport"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SubmitGenerateReport"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SubmitGenerateReport"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.v8.ReportingService#startsubmitGenerateReport
                    * @param submitGenerateReportRequest22
                
                    * @param applicationToken23
                
                    * @param customerAccountId24
                
                    * @param customerId25
                
                    * @param developerToken26
                
                    * @param password27
                
                    * @param userName28
                
                */
                public  void startsubmitGenerateReport(

                 com.microsoft.adcenter.v8.SubmitGenerateReportRequest submitGenerateReportRequest22,com.microsoft.adcenter.v8.ApplicationToken applicationToken23,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId24,
                    com.microsoft.adcenter.v8.CustomerId customerId25,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken26,
                    com.microsoft.adcenter.v8.Password password27,
                    com.microsoft.adcenter.v8.UserName userName28,
                    

                  final com.microsoft.adcenter.v8.ReportingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("SubmitGenerateReport");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    submitGenerateReportRequest22,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "submitGenerateReport")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "submitGenerateReport"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken23!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken23 = toOM(applicationToken23, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementapplicationToken23,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId24!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId24 = toOM(customerAccountId24, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementcustomerAccountId24,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId25!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId25 = toOM(customerId25, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementcustomerId25,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken26!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken26 = toOM(developerToken26, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementdeveloperToken26,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password27!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword27 = toOM(password27, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementpassword27,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName28!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName28 = toOM(userName28, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "submitGenerateReport")));
                                                    addHeader(omElementuserName28,env);
                                                
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
                                                                         com.microsoft.adcenter.v8.SubmitGenerateReportResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultsubmitGenerateReport(
                                        (com.microsoft.adcenter.v8.SubmitGenerateReportResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorsubmitGenerateReport(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SubmitGenerateReport"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SubmitGenerateReport"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SubmitGenerateReport"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorsubmitGenerateReport((com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorsubmitGenerateReport((com.microsoft.adcenter.v8.IReportingService_SubmitGenerateReport_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorsubmitGenerateReport(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsubmitGenerateReport(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsubmitGenerateReport(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsubmitGenerateReport(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsubmitGenerateReport(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsubmitGenerateReport(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsubmitGenerateReport(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsubmitGenerateReport(f);
                                            }
									    } else {
										    callback.receiveErrorsubmitGenerateReport(f);
									    }
									} else {
									    callback.receiveErrorsubmitGenerateReport(f);
									}
								} else {
								    callback.receiveErrorsubmitGenerateReport(error);
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
                                    callback.receiveErrorsubmitGenerateReport(axisFault);
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
                     * @see com.microsoft.adcenter.v8.ReportingService#pollGenerateReport
                     * @param pollGenerateReportRequest30
                    
                     * @param applicationToken31
                    
                     * @param customerAccountId32
                    
                     * @param customerId33
                    
                     * @param developerToken34
                    
                     * @param password35
                    
                     * @param userName36
                    
                     * @throws com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.PollGenerateReportResponse pollGenerateReport(

                            com.microsoft.adcenter.v8.PollGenerateReportRequest pollGenerateReportRequest30,com.microsoft.adcenter.v8.ApplicationToken applicationToken31,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId32,com.microsoft.adcenter.v8.CustomerId customerId33,com.microsoft.adcenter.v8.DeveloperToken developerToken34,com.microsoft.adcenter.v8.Password password35,com.microsoft.adcenter.v8.UserName userName36)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("PollGenerateReport");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    pollGenerateReportRequest30,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "pollGenerateReport")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "pollGenerateReport"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken31!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken31 = toOM(applicationToken31, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementapplicationToken31,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId32!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId32 = toOM(customerAccountId32, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementcustomerAccountId32,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId33!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId33 = toOM(customerId33, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementcustomerId33,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken34!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken34 = toOM(developerToken34, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementdeveloperToken34,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password35!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword35 = toOM(password35, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementpassword35,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName36!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName36 = toOM(userName36, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementuserName36,env);
                                                
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
                                             com.microsoft.adcenter.v8.PollGenerateReportResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.PollGenerateReportResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"PollGenerateReport"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"PollGenerateReport"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"PollGenerateReport"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.v8.ReportingService#startpollGenerateReport
                    * @param pollGenerateReportRequest30
                
                    * @param applicationToken31
                
                    * @param customerAccountId32
                
                    * @param customerId33
                
                    * @param developerToken34
                
                    * @param password35
                
                    * @param userName36
                
                */
                public  void startpollGenerateReport(

                 com.microsoft.adcenter.v8.PollGenerateReportRequest pollGenerateReportRequest30,com.microsoft.adcenter.v8.ApplicationToken applicationToken31,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId32,
                    com.microsoft.adcenter.v8.CustomerId customerId33,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken34,
                    com.microsoft.adcenter.v8.Password password35,
                    com.microsoft.adcenter.v8.UserName userName36,
                    

                  final com.microsoft.adcenter.v8.ReportingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("PollGenerateReport");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    pollGenerateReportRequest30,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "pollGenerateReport")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "pollGenerateReport"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken31!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken31 = toOM(applicationToken31, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementapplicationToken31,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId32!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId32 = toOM(customerAccountId32, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementcustomerAccountId32,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId33!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId33 = toOM(customerId33, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementcustomerId33,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken34!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken34 = toOM(developerToken34, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementdeveloperToken34,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password35!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword35 = toOM(password35, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementpassword35,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName36!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName36 = toOM(userName36, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "pollGenerateReport")));
                                                    addHeader(omElementuserName36,env);
                                                
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
                                                                         com.microsoft.adcenter.v8.PollGenerateReportResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultpollGenerateReport(
                                        (com.microsoft.adcenter.v8.PollGenerateReportResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorpollGenerateReport(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"PollGenerateReport"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"PollGenerateReport"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"PollGenerateReport"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorpollGenerateReport((com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorpollGenerateReport((com.microsoft.adcenter.v8.IReportingService_PollGenerateReport_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorpollGenerateReport(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorpollGenerateReport(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorpollGenerateReport(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorpollGenerateReport(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorpollGenerateReport(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorpollGenerateReport(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorpollGenerateReport(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorpollGenerateReport(f);
                                            }
									    } else {
										    callback.receiveErrorpollGenerateReport(f);
									    }
									} else {
									    callback.receiveErrorpollGenerateReport(f);
									}
								} else {
								    callback.receiveErrorpollGenerateReport(error);
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
                                    callback.receiveErrorpollGenerateReport(axisFault);
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
     //https://adcenterapi.microsoft.com/Api/Advertiser/V8/Reporting/ReportingService.svc
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.SubmitGenerateReportRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.SubmitGenerateReportRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.SubmitGenerateReportResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.SubmitGenerateReportResponse.MY_QNAME,
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
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.ApiFaultDetailE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.ApiFaultDetailE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.ApplicationToken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.ApplicationToken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.CustomerAccountId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.CustomerAccountId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.CustomerId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.CustomerId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.DeveloperToken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.DeveloperToken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.Password param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.Password.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.UserName param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.UserName.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.TrackingId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.TrackingId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.PollGenerateReportRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.PollGenerateReportRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.PollGenerateReportResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.PollGenerateReportResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.SubmitGenerateReportRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.SubmitGenerateReportRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.PollGenerateReportRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.PollGenerateReportRequest.MY_QNAME,factory));
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
        
                if (com.microsoft.adcenter.v8.SubmitGenerateReportRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.SubmitGenerateReportRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.SubmitGenerateReportResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.SubmitGenerateReportResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.PollGenerateReportRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.PollGenerateReportRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.PollGenerateReportResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.PollGenerateReportResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   