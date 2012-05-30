
/**
 * EstimatedPositionAndTraffic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts;
            

            /**
            *  EstimatedPositionAndTraffic bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class EstimatedPositionAndTraffic
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = EstimatedPositionAndTraffic
                Namespace URI = http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts
                Namespace Prefix = ns2
                */
            

                        /**
                        * field for MatchType
                        */

                        
                                    protected org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.MatchType localMatchType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMatchTypeTracker = false ;

                           public boolean isMatchTypeSpecified(){
                               return localMatchTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.MatchType
                           */
                           public  org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.MatchType getMatchType(){
                               return localMatchType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MatchType
                               */
                               public void setMatchType(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.MatchType param){
                            localMatchTypeTracker = param != null;
                                   
                                            this.localMatchType=param;
                                    

                               }
                            

                        /**
                        * field for MinClicksPerWeek
                        */

                        
                                    protected int localMinClicksPerWeek ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMinClicksPerWeekTracker = false ;

                           public boolean isMinClicksPerWeekSpecified(){
                               return localMinClicksPerWeekTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMinClicksPerWeek(){
                               return localMinClicksPerWeek;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MinClicksPerWeek
                               */
                               public void setMinClicksPerWeek(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localMinClicksPerWeekTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localMinClicksPerWeek=param;
                                    

                               }
                            

                        /**
                        * field for MaxClicksPerWeek
                        */

                        
                                    protected int localMaxClicksPerWeek ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMaxClicksPerWeekTracker = false ;

                           public boolean isMaxClicksPerWeekSpecified(){
                               return localMaxClicksPerWeekTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMaxClicksPerWeek(){
                               return localMaxClicksPerWeek;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaxClicksPerWeek
                               */
                               public void setMaxClicksPerWeek(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localMaxClicksPerWeekTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localMaxClicksPerWeek=param;
                                    

                               }
                            

                        /**
                        * field for AverageCPC
                        */

                        
                                    protected double localAverageCPC ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAverageCPCTracker = false ;

                           public boolean isAverageCPCSpecified(){
                               return localAverageCPCTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getAverageCPC(){
                               return localAverageCPC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AverageCPC
                               */
                               public void setAverageCPC(double param){
                            
                                       // setting primitive attribute tracker to true
                                       localAverageCPCTracker =
                                       !java.lang.Double.isNaN(param);
                                   
                                            this.localAverageCPC=param;
                                    

                               }
                            

                        /**
                        * field for MinImpressionsPerWeek
                        */

                        
                                    protected int localMinImpressionsPerWeek ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMinImpressionsPerWeekTracker = false ;

                           public boolean isMinImpressionsPerWeekSpecified(){
                               return localMinImpressionsPerWeekTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMinImpressionsPerWeek(){
                               return localMinImpressionsPerWeek;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MinImpressionsPerWeek
                               */
                               public void setMinImpressionsPerWeek(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localMinImpressionsPerWeekTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localMinImpressionsPerWeek=param;
                                    

                               }
                            

                        /**
                        * field for MaxImpressionsPerWeek
                        */

                        
                                    protected int localMaxImpressionsPerWeek ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMaxImpressionsPerWeekTracker = false ;

                           public boolean isMaxImpressionsPerWeekSpecified(){
                               return localMaxImpressionsPerWeekTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMaxImpressionsPerWeek(){
                               return localMaxImpressionsPerWeek;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaxImpressionsPerWeek
                               */
                               public void setMaxImpressionsPerWeek(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localMaxImpressionsPerWeekTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localMaxImpressionsPerWeek=param;
                                    

                               }
                            

                        /**
                        * field for CTR
                        */

                        
                                    protected double localCTR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCTRTracker = false ;

                           public boolean isCTRSpecified(){
                               return localCTRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getCTR(){
                               return localCTR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CTR
                               */
                               public void setCTR(double param){
                            
                                       // setting primitive attribute tracker to true
                                       localCTRTracker =
                                       !java.lang.Double.isNaN(param);
                                   
                                            this.localCTR=param;
                                    

                               }
                            

                        /**
                        * field for MinTotalCostPerWeek
                        */

                        
                                    protected double localMinTotalCostPerWeek ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMinTotalCostPerWeekTracker = false ;

                           public boolean isMinTotalCostPerWeekSpecified(){
                               return localMinTotalCostPerWeekTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getMinTotalCostPerWeek(){
                               return localMinTotalCostPerWeek;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MinTotalCostPerWeek
                               */
                               public void setMinTotalCostPerWeek(double param){
                            
                                       // setting primitive attribute tracker to true
                                       localMinTotalCostPerWeekTracker =
                                       !java.lang.Double.isNaN(param);
                                   
                                            this.localMinTotalCostPerWeek=param;
                                    

                               }
                            

                        /**
                        * field for MaxTotalCostPerWeek
                        */

                        
                                    protected double localMaxTotalCostPerWeek ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMaxTotalCostPerWeekTracker = false ;

                           public boolean isMaxTotalCostPerWeekSpecified(){
                               return localMaxTotalCostPerWeekTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getMaxTotalCostPerWeek(){
                               return localMaxTotalCostPerWeek;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaxTotalCostPerWeek
                               */
                               public void setMaxTotalCostPerWeek(double param){
                            
                                       // setting primitive attribute tracker to true
                                       localMaxTotalCostPerWeekTracker =
                                       !java.lang.Double.isNaN(param);
                                   
                                            this.localMaxTotalCostPerWeek=param;
                                    

                               }
                            

                        /**
                        * field for Currency
                        */

                        
                                    protected org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.Currency localCurrency ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCurrencyTracker = false ;

                           public boolean isCurrencySpecified(){
                               return localCurrencyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.Currency
                           */
                           public  org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.Currency getCurrency(){
                               return localCurrency;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Currency
                               */
                               public void setCurrency(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.Currency param){
                            localCurrencyTracker = param != null;
                                   
                                            this.localCurrency=param;
                                    

                               }
                            

                        /**
                        * field for EstimatedAdPosition
                        */

                        
                                    protected org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition localEstimatedAdPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEstimatedAdPositionTracker = false ;

                           public boolean isEstimatedAdPositionSpecified(){
                               return localEstimatedAdPositionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition
                           */
                           public  org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition getEstimatedAdPosition(){
                               return localEstimatedAdPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EstimatedAdPosition
                               */
                               public void setEstimatedAdPosition(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition param){
                            localEstimatedAdPositionTracker = param != null;
                                   
                                            this.localEstimatedAdPosition=param;
                                    

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
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName);
               return factory.createOMElement(dataSource,parentQName);
            
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
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":EstimatedPositionAndTraffic",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "EstimatedPositionAndTraffic",
                           xmlWriter);
                   }

               
                   }
                if (localMatchTypeTracker){
                                            if (localMatchType==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MatchType cannot be null!!");
                                            }
                                           localMatchType.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","MatchType"),
                                               xmlWriter);
                                        } if (localMinClicksPerWeekTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts";
                                    writeStartElement(null, namespace, "MinClicksPerWeek", xmlWriter);
                             
                                               if (localMinClicksPerWeek==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MinClicksPerWeek cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinClicksPerWeek));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMaxClicksPerWeekTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts";
                                    writeStartElement(null, namespace, "MaxClicksPerWeek", xmlWriter);
                             
                                               if (localMaxClicksPerWeek==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MaxClicksPerWeek cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxClicksPerWeek));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAverageCPCTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts";
                                    writeStartElement(null, namespace, "AverageCPC", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localAverageCPC)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("AverageCPC cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAverageCPC));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMinImpressionsPerWeekTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts";
                                    writeStartElement(null, namespace, "MinImpressionsPerWeek", xmlWriter);
                             
                                               if (localMinImpressionsPerWeek==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MinImpressionsPerWeek cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinImpressionsPerWeek));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMaxImpressionsPerWeekTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts";
                                    writeStartElement(null, namespace, "MaxImpressionsPerWeek", xmlWriter);
                             
                                               if (localMaxImpressionsPerWeek==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MaxImpressionsPerWeek cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxImpressionsPerWeek));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCTRTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts";
                                    writeStartElement(null, namespace, "CTR", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localCTR)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("CTR cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCTR));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMinTotalCostPerWeekTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts";
                                    writeStartElement(null, namespace, "MinTotalCostPerWeek", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localMinTotalCostPerWeek)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MinTotalCostPerWeek cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinTotalCostPerWeek));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMaxTotalCostPerWeekTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts";
                                    writeStartElement(null, namespace, "MaxTotalCostPerWeek", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localMaxTotalCostPerWeek)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MaxTotalCostPerWeek cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxTotalCostPerWeek));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCurrencyTracker){
                                            if (localCurrency==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Currency cannot be null!!");
                                            }
                                           localCurrency.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","Currency"),
                                               xmlWriter);
                                        } if (localEstimatedAdPositionTracker){
                                            if (localEstimatedAdPosition==null){
                                                 throw new org.apache.axis2.databinding.ADBException("EstimatedAdPosition cannot be null!!");
                                            }
                                           localEstimatedAdPosition.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","EstimatedAdPosition"),
                                               xmlWriter);
                                        }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts")){
                return "ns2";
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


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localMatchTypeTracker){
                            elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "MatchType"));
                            
                            
                                    if (localMatchType==null){
                                         throw new org.apache.axis2.databinding.ADBException("MatchType cannot be null!!");
                                    }
                                    elementList.add(localMatchType);
                                } if (localMinClicksPerWeekTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "MinClicksPerWeek"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinClicksPerWeek));
                            } if (localMaxClicksPerWeekTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "MaxClicksPerWeek"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxClicksPerWeek));
                            } if (localAverageCPCTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "AverageCPC"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAverageCPC));
                            } if (localMinImpressionsPerWeekTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "MinImpressionsPerWeek"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinImpressionsPerWeek));
                            } if (localMaxImpressionsPerWeekTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "MaxImpressionsPerWeek"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxImpressionsPerWeek));
                            } if (localCTRTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "CTR"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCTR));
                            } if (localMinTotalCostPerWeekTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "MinTotalCostPerWeek"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinTotalCostPerWeek));
                            } if (localMaxTotalCostPerWeekTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "MaxTotalCostPerWeek"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxTotalCostPerWeek));
                            } if (localCurrencyTracker){
                            elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "Currency"));
                            
                            
                                    if (localCurrency==null){
                                         throw new org.apache.axis2.databinding.ADBException("Currency cannot be null!!");
                                    }
                                    elementList.add(localCurrency);
                                } if (localEstimatedAdPositionTracker){
                            elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                                                                      "EstimatedAdPosition"));
                            
                            
                                    if (localEstimatedAdPosition==null){
                                         throw new org.apache.axis2.databinding.ADBException("EstimatedAdPosition cannot be null!!");
                                    }
                                    elementList.add(localEstimatedAdPosition);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static EstimatedPositionAndTraffic parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            EstimatedPositionAndTraffic object =
                new EstimatedPositionAndTraffic();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"EstimatedPositionAndTraffic".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (EstimatedPositionAndTraffic)com.microsoft.adcenter.v8.imports.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","MatchType").equals(reader.getName())){
                                
                                                object.setMatchType(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.MatchType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","MinClicksPerWeek").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MinClicksPerWeek" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMinClicksPerWeek(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMinClicksPerWeek(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","MaxClicksPerWeek").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MaxClicksPerWeek" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaxClicksPerWeek(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMaxClicksPerWeek(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","AverageCPC").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"AverageCPC" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAverageCPC(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setAverageCPC(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","MinImpressionsPerWeek").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MinImpressionsPerWeek" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMinImpressionsPerWeek(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMinImpressionsPerWeek(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","MaxImpressionsPerWeek").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MaxImpressionsPerWeek" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaxImpressionsPerWeek(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMaxImpressionsPerWeek(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","CTR").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"CTR" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCTR(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setCTR(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","MinTotalCostPerWeek").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MinTotalCostPerWeek" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMinTotalCostPerWeek(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMinTotalCostPerWeek(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","MaxTotalCostPerWeek").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MaxTotalCostPerWeek" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaxTotalCostPerWeek(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMaxTotalCostPerWeek(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","Currency").equals(reader.getName())){
                                
                                                object.setCurrency(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.Currency.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts","EstimatedAdPosition").equals(reader.getName())){
                                
                                                object.setEstimatedAdPosition(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    