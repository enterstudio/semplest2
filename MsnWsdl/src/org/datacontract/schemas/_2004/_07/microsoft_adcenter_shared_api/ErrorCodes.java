
/**
 * ErrorCodes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package org.datacontract.schemas._2004._07.microsoft_adcenter_shared_api;
            

            /**
            *  ErrorCodes bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ErrorCodes
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Shared.Api",
                "ErrorCodes",
                "ns14");

            

                        /**
                        * field for ErrorCodes
                        */

                        
                                    protected java.lang.String localErrorCodes ;
                                
                            private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
                            
                                protected ErrorCodes(java.lang.String value, boolean isRegisterValue) {
                                    localErrorCodes = value;
                                    if (isRegisterValue){
                                        
                                               _table_.put(localErrorCodes, this);
                                           
                                    }

                                }
                            
                                    public static final java.lang.String _InternalError =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InternalError");
                                
                                    public static final java.lang.String _NullRequest =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NullRequest");
                                
                                    public static final java.lang.String _InvalidCredentials =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCredentials");
                                
                                    public static final java.lang.String _UserIsNotAuthorized =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UserIsNotAuthorized");
                                
                                    public static final java.lang.String _QuotaNotAvailable =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("QuotaNotAvailable");
                                
                                    public static final java.lang.String _InvalidDateObject =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidDateObject");
                                
                                    public static final java.lang.String _RequestMissingHeaders =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("RequestMissingHeaders");
                                
                                    public static final java.lang.String _ApiInputValidationError =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ApiInputValidationError");
                                
                                    public static final java.lang.String _APIExecutionError =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("APIExecutionError");
                                
                                    public static final java.lang.String _NullParameter =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NullParameter");
                                
                                    public static final java.lang.String _OperationNotSupported =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OperationNotSupported");
                                
                                    public static final java.lang.String _InvalidVersion =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidVersion");
                                
                                    public static final java.lang.String _NullArrayArgument =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NullArrayArgument");
                                
                                    public static final java.lang.String _ConcurrentRequestOverLimit =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ConcurrentRequestOverLimit");
                                
                                    public static final java.lang.String _InvalidAccount =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAccount");
                                
                                    public static final java.lang.String _TimestampNotMatch =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TimestampNotMatch");
                                
                                    public static final java.lang.String _EntityNotExistent =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EntityNotExistent");
                                
                                    public static final java.lang.String _NameTooLong =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NameTooLong");
                                
                                    public static final java.lang.String _FilterListOverLimit =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FilterListOverLimit");
                                
                                    public static final java.lang.String _InvalidAccountId =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAccountId");
                                
                                    public static final java.lang.String _InvalidCustomerId =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustomerId");
                                
                                    public static final java.lang.String _CustomerIdHasToBeSpecified =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CustomerIdHasToBeSpecified");
                                
                                    public static final java.lang.String _AccountIdHasToBeSpecified =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AccountIdHasToBeSpecified");
                                
                                    public static final java.lang.String _FutureFeatureCode =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FutureFeatureCode");
                                
                                    public static final java.lang.String _InvalidOpportunityKeysList =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidOpportunityKeysList");
                                
                                    public static final java.lang.String _OpportunityExpired =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OpportunityExpired");
                                
                                    public static final java.lang.String _OpportunityAlreadyApplied =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OpportunityAlreadyApplied");
                                
                                    public static final java.lang.String _OpportunityKeysArrayShouldNotBeNullOrEmpty =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OpportunityKeysArrayShouldNotBeNullOrEmpty");
                                
                                    public static final java.lang.String _OpportunityKeysArrayExceedsLimit =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OpportunityKeysArrayExceedsLimit");
                                
                                    public static final java.lang.String _InvalidOpportunityKey =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidOpportunityKey");
                                
                                    public static final java.lang.String _CampaignBudgetAmountIsAboveLimit =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CampaignBudgetAmountIsAboveLimit");
                                
                                    public static final java.lang.String _CampaignBudgetAmountIsBelowConfiguredLimit =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CampaignBudgetAmountIsBelowConfiguredLimit");
                                
                                    public static final java.lang.String _CampaignBudgetAmountIsLessThanSpendAmount =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CampaignBudgetAmountIsLessThanSpendAmount");
                                
                                    public static final java.lang.String _CampaignBudgetLessThanAdGroupBudget =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CampaignBudgetLessThanAdGroupBudget");
                                
                                    public static final java.lang.String _CampaignDailyTargetBudgetAmountIsInvalid =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CampaignDailyTargetBudgetAmountIsInvalid");
                                
                                    public static final java.lang.String _IncrementalBudgetAmountRequiredForDayTarget =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("IncrementalBudgetAmountRequiredForDayTarget");
                                
                                    public static final java.lang.String _BidsAmountsGreaterThanCeilingPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BidsAmountsGreaterThanCeilingPrice");
                                
                                    public static final java.lang.String _KeywordExactBidAmountsGreaterThanCeilingPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordExactBidAmountsGreaterThanCeilingPrice");
                                
                                    public static final java.lang.String _KeywordPhraseBidAmountsGreaterThanCeilingPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordPhraseBidAmountsGreaterThanCeilingPrice");
                                
                                    public static final java.lang.String _KeywordBroadBidAmountsGreaterThanCeilingPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordBroadBidAmountsGreaterThanCeilingPrice");
                                
                                    public static final java.lang.String _BidAmountsLessThanFloorPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BidAmountsLessThanFloorPrice");
                                
                                    public static final java.lang.String _KeywordExactBidAmountsLessThanFloorPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordExactBidAmountsLessThanFloorPrice");
                                
                                    public static final java.lang.String _KeywordPhraseBidAmountsLessThanFloorPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordPhraseBidAmountsLessThanFloorPrice");
                                
                                    public static final java.lang.String _KeywordBroadBidAmountsLessThanFloorPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordBroadBidAmountsLessThanFloorPrice");
                                
                                public static final ErrorCodes InternalError =
                                    new ErrorCodes(_InternalError,true);
                            
                                public static final ErrorCodes NullRequest =
                                    new ErrorCodes(_NullRequest,true);
                            
                                public static final ErrorCodes InvalidCredentials =
                                    new ErrorCodes(_InvalidCredentials,true);
                            
                                public static final ErrorCodes UserIsNotAuthorized =
                                    new ErrorCodes(_UserIsNotAuthorized,true);
                            
                                public static final ErrorCodes QuotaNotAvailable =
                                    new ErrorCodes(_QuotaNotAvailable,true);
                            
                                public static final ErrorCodes InvalidDateObject =
                                    new ErrorCodes(_InvalidDateObject,true);
                            
                                public static final ErrorCodes RequestMissingHeaders =
                                    new ErrorCodes(_RequestMissingHeaders,true);
                            
                                public static final ErrorCodes ApiInputValidationError =
                                    new ErrorCodes(_ApiInputValidationError,true);
                            
                                public static final ErrorCodes APIExecutionError =
                                    new ErrorCodes(_APIExecutionError,true);
                            
                                public static final ErrorCodes NullParameter =
                                    new ErrorCodes(_NullParameter,true);
                            
                                public static final ErrorCodes OperationNotSupported =
                                    new ErrorCodes(_OperationNotSupported,true);
                            
                                public static final ErrorCodes InvalidVersion =
                                    new ErrorCodes(_InvalidVersion,true);
                            
                                public static final ErrorCodes NullArrayArgument =
                                    new ErrorCodes(_NullArrayArgument,true);
                            
                                public static final ErrorCodes ConcurrentRequestOverLimit =
                                    new ErrorCodes(_ConcurrentRequestOverLimit,true);
                            
                                public static final ErrorCodes InvalidAccount =
                                    new ErrorCodes(_InvalidAccount,true);
                            
                                public static final ErrorCodes TimestampNotMatch =
                                    new ErrorCodes(_TimestampNotMatch,true);
                            
                                public static final ErrorCodes EntityNotExistent =
                                    new ErrorCodes(_EntityNotExistent,true);
                            
                                public static final ErrorCodes NameTooLong =
                                    new ErrorCodes(_NameTooLong,true);
                            
                                public static final ErrorCodes FilterListOverLimit =
                                    new ErrorCodes(_FilterListOverLimit,true);
                            
                                public static final ErrorCodes InvalidAccountId =
                                    new ErrorCodes(_InvalidAccountId,true);
                            
                                public static final ErrorCodes InvalidCustomerId =
                                    new ErrorCodes(_InvalidCustomerId,true);
                            
                                public static final ErrorCodes CustomerIdHasToBeSpecified =
                                    new ErrorCodes(_CustomerIdHasToBeSpecified,true);
                            
                                public static final ErrorCodes AccountIdHasToBeSpecified =
                                    new ErrorCodes(_AccountIdHasToBeSpecified,true);
                            
                                public static final ErrorCodes FutureFeatureCode =
                                    new ErrorCodes(_FutureFeatureCode,true);
                            
                                public static final ErrorCodes InvalidOpportunityKeysList =
                                    new ErrorCodes(_InvalidOpportunityKeysList,true);
                            
                                public static final ErrorCodes OpportunityExpired =
                                    new ErrorCodes(_OpportunityExpired,true);
                            
                                public static final ErrorCodes OpportunityAlreadyApplied =
                                    new ErrorCodes(_OpportunityAlreadyApplied,true);
                            
                                public static final ErrorCodes OpportunityKeysArrayShouldNotBeNullOrEmpty =
                                    new ErrorCodes(_OpportunityKeysArrayShouldNotBeNullOrEmpty,true);
                            
                                public static final ErrorCodes OpportunityKeysArrayExceedsLimit =
                                    new ErrorCodes(_OpportunityKeysArrayExceedsLimit,true);
                            
                                public static final ErrorCodes InvalidOpportunityKey =
                                    new ErrorCodes(_InvalidOpportunityKey,true);
                            
                                public static final ErrorCodes CampaignBudgetAmountIsAboveLimit =
                                    new ErrorCodes(_CampaignBudgetAmountIsAboveLimit,true);
                            
                                public static final ErrorCodes CampaignBudgetAmountIsBelowConfiguredLimit =
                                    new ErrorCodes(_CampaignBudgetAmountIsBelowConfiguredLimit,true);
                            
                                public static final ErrorCodes CampaignBudgetAmountIsLessThanSpendAmount =
                                    new ErrorCodes(_CampaignBudgetAmountIsLessThanSpendAmount,true);
                            
                                public static final ErrorCodes CampaignBudgetLessThanAdGroupBudget =
                                    new ErrorCodes(_CampaignBudgetLessThanAdGroupBudget,true);
                            
                                public static final ErrorCodes CampaignDailyTargetBudgetAmountIsInvalid =
                                    new ErrorCodes(_CampaignDailyTargetBudgetAmountIsInvalid,true);
                            
                                public static final ErrorCodes IncrementalBudgetAmountRequiredForDayTarget =
                                    new ErrorCodes(_IncrementalBudgetAmountRequiredForDayTarget,true);
                            
                                public static final ErrorCodes BidsAmountsGreaterThanCeilingPrice =
                                    new ErrorCodes(_BidsAmountsGreaterThanCeilingPrice,true);
                            
                                public static final ErrorCodes KeywordExactBidAmountsGreaterThanCeilingPrice =
                                    new ErrorCodes(_KeywordExactBidAmountsGreaterThanCeilingPrice,true);
                            
                                public static final ErrorCodes KeywordPhraseBidAmountsGreaterThanCeilingPrice =
                                    new ErrorCodes(_KeywordPhraseBidAmountsGreaterThanCeilingPrice,true);
                            
                                public static final ErrorCodes KeywordBroadBidAmountsGreaterThanCeilingPrice =
                                    new ErrorCodes(_KeywordBroadBidAmountsGreaterThanCeilingPrice,true);
                            
                                public static final ErrorCodes BidAmountsLessThanFloorPrice =
                                    new ErrorCodes(_BidAmountsLessThanFloorPrice,true);
                            
                                public static final ErrorCodes KeywordExactBidAmountsLessThanFloorPrice =
                                    new ErrorCodes(_KeywordExactBidAmountsLessThanFloorPrice,true);
                            
                                public static final ErrorCodes KeywordPhraseBidAmountsLessThanFloorPrice =
                                    new ErrorCodes(_KeywordPhraseBidAmountsLessThanFloorPrice,true);
                            
                                public static final ErrorCodes KeywordBroadBidAmountsLessThanFloorPrice =
                                    new ErrorCodes(_KeywordBroadBidAmountsLessThanFloorPrice,true);
                            

                                public java.lang.String getValue() { return localErrorCodes;}

                                public boolean equals(java.lang.Object obj) {return (obj == this);}
                                public int hashCode() { return toString().hashCode();}
                                public java.lang.String toString() {
                                
                                        return localErrorCodes.toString();
                                    

                                }

                        

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME);
               return factory.createOMElement(dataSource,MY_QNAME);
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String _localName = parentQName.getLocalPart();
                        
                            writeStartElement(null, namespace, _localName, xmlWriter);

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Shared.Api");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":ErrorCodes",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "ErrorCodes",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localErrorCodes==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("ErrorCodes cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localErrorCodes);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();
                    

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Shared.Api")){
                return "ns14";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace,attName,attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCodes)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static ErrorCodes fromValue(java.lang.String value)
                      throws java.lang.IllegalArgumentException {
                    ErrorCodes enumeration = (ErrorCodes)
                       
                               _table_.get(value);
                           

                    if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    return enumeration;
                }
                public static ErrorCodes fromString(java.lang.String value,java.lang.String namespaceURI)
                      throws java.lang.IllegalArgumentException {
                    try {
                       
                                       return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                                   

                    } catch (java.lang.Exception e) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }

                public static ErrorCodes fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return ErrorCodes.Factory.fromString(content,namespaceUri);
                    } else {
                       return ErrorCodes.Factory.fromString(content,"");
                    }
                }
            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ErrorCodes parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ErrorCodes object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();
            

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                   
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ErrorCodes" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                        if (content.indexOf(":") > 0) {
                                            // this seems to be a Qname so find the namespace and send
                                            prefix = content.substring(0, content.indexOf(":"));
                                            namespaceuri = reader.getNamespaceURI(prefix);
                                            object = ErrorCodes.Factory.fromString(content,namespaceuri);
                                        } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                            // check is done in fromString method
                                            object = ErrorCodes.Factory.fromString(content,"");
                                        }
                                        
                                        
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    