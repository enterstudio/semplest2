
/**
 * GetHistoricalKeywordPerformanceRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.microsoft.adcenter.v8;
            

            /**
            *  GetHistoricalKeywordPerformanceRequest bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class GetHistoricalKeywordPerformanceRequest
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "https://adcenter.microsoft.com/v8",
                "GetHistoricalKeywordPerformanceRequest",
                "ns4");

            

                        /**
                        * field for Keywords
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localKeywords ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localKeywordsTracker = false ;

                           public boolean isKeywordsSpecified(){
                               return localKeywordsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getKeywords(){
                               return localKeywords;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Keywords
                               */
                               public void setKeywords(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localKeywordsTracker = true;
                                   
                                            this.localKeywords=param;
                                    

                               }
                            

                        /**
                        * field for TimeInterval
                        */

                        
                                    protected org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.TimeInterval localTimeInterval ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTimeIntervalTracker = false ;

                           public boolean isTimeIntervalSpecified(){
                               return localTimeIntervalTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.TimeInterval
                           */
                           public  org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.TimeInterval getTimeInterval(){
                               return localTimeInterval;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TimeInterval
                               */
                               public void setTimeInterval(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.TimeInterval param){
                            localTimeIntervalTracker = true;
                                   
                                            this.localTimeInterval=param;
                                    

                               }
                            

                        /**
                        * field for TargetAdPosition
                        */

                        
                                    protected org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition localTargetAdPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTargetAdPositionTracker = false ;

                           public boolean isTargetAdPositionSpecified(){
                               return localTargetAdPositionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition
                           */
                           public  org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition getTargetAdPosition(){
                               return localTargetAdPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TargetAdPosition
                               */
                               public void setTargetAdPosition(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition param){
                            localTargetAdPositionTracker = true;
                                   
                                            this.localTargetAdPosition=param;
                                    

                               }
                            

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
                            localMatchTypeTracker = true;
                                   
                                            this.localMatchType=param;
                                    

                               }
                            

                        /**
                        * field for Language
                        */

                        
                                    protected java.lang.String localLanguage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLanguageTracker = false ;

                           public boolean isLanguageSpecified(){
                               return localLanguageTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLanguage(){
                               return localLanguage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Language
                               */
                               public void setLanguage(java.lang.String param){
                            localLanguageTracker = true;
                                   
                                            this.localLanguage=param;
                                    

                               }
                            

                        /**
                        * field for PublisherCountries
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localPublisherCountries ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPublisherCountriesTracker = false ;

                           public boolean isPublisherCountriesSpecified(){
                               return localPublisherCountriesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getPublisherCountries(){
                               return localPublisherCountries;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PublisherCountries
                               */
                               public void setPublisherCountries(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localPublisherCountriesTracker = true;
                                   
                                            this.localPublisherCountries=param;
                                    

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
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"https://adcenter.microsoft.com/v8");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":GetHistoricalKeywordPerformanceRequest",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "GetHistoricalKeywordPerformanceRequest",
                           xmlWriter);
                   }

               
                   }
                if (localKeywordsTracker){
                                    if (localKeywords==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "Keywords", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localKeywords.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Keywords"),
                                        xmlWriter);
                                    }
                                } if (localTimeIntervalTracker){
                                    if (localTimeInterval==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "TimeInterval", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localTimeInterval.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","TimeInterval"),
                                        xmlWriter);
                                    }
                                } if (localTargetAdPositionTracker){
                                    if (localTargetAdPosition==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "TargetAdPosition", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localTargetAdPosition.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","TargetAdPosition"),
                                        xmlWriter);
                                    }
                                } if (localMatchTypeTracker){
                                    if (localMatchType==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "MatchType", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localMatchType.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","MatchType"),
                                        xmlWriter);
                                    }
                                } if (localLanguageTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "Language", xmlWriter);
                             

                                          if (localLanguage==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLanguage);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPublisherCountriesTracker){
                                    if (localPublisherCountries==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "PublisherCountries", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localPublisherCountries.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","PublisherCountries"),
                                        xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("https://adcenter.microsoft.com/v8")){
                return "ns4";
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

                 if (localKeywordsTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Keywords"));
                            
                            
                                    elementList.add(localKeywords==null?null:
                                    localKeywords);
                                } if (localTimeIntervalTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "TimeInterval"));
                            
                            
                                    elementList.add(localTimeInterval==null?null:
                                    localTimeInterval);
                                } if (localTargetAdPositionTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "TargetAdPosition"));
                            
                            
                                    elementList.add(localTargetAdPosition==null?null:
                                    localTargetAdPosition);
                                } if (localMatchTypeTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "MatchType"));
                            
                            
                                    elementList.add(localMatchType==null?null:
                                    localMatchType);
                                } if (localLanguageTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Language"));
                                 
                                         elementList.add(localLanguage==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLanguage));
                                    } if (localPublisherCountriesTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "PublisherCountries"));
                            
                            
                                    elementList.add(localPublisherCountries==null?null:
                                    localPublisherCountries);
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
        public static GetHistoricalKeywordPerformanceRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            GetHistoricalKeywordPerformanceRequest object =
                new GetHistoricalKeywordPerformanceRequest();

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
                    
                            if (!"GetHistoricalKeywordPerformanceRequest".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GetHistoricalKeywordPerformanceRequest)com.microsoft.adcenter.v8.imports.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Keywords").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setKeywords(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setKeywords(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","TimeInterval").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setTimeInterval(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setTimeInterval(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.TimeInterval.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","TargetAdPosition").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setTargetAdPosition(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setTargetAdPosition(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.AdPosition.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","MatchType").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setMatchType(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setMatchType(org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.MatchType.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Language").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLanguage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","PublisherCountries").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setPublisherCountries(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setPublisherCountries(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
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
           
    