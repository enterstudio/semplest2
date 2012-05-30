
/**
 * AdPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.microsoft.adcenter.v8;
            

            /**
            *  AdPerformanceReportColumn bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class AdPerformanceReportColumn
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "https://adcenter.microsoft.com/v8",
                "AdPerformanceReportColumn",
                "ns4");

            

                        /**
                        * field for AdPerformanceReportColumn
                        */

                        
                                    protected java.lang.String localAdPerformanceReportColumn ;
                                
                            private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
                            
                                protected AdPerformanceReportColumn(java.lang.String value, boolean isRegisterValue) {
                                    localAdPerformanceReportColumn = value;
                                    if (isRegisterValue){
                                        
                                               _table_.put(localAdPerformanceReportColumn, this);
                                           
                                    }

                                }
                            
                                    public static final java.lang.String _AccountName =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AccountName");
                                
                                    public static final java.lang.String _AccountNumber =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AccountNumber");
                                
                                    public static final java.lang.String _TimePeriod =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TimePeriod");
                                
                                    public static final java.lang.String _LanguageAndRegion =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("LanguageAndRegion");
                                
                                    public static final java.lang.String _CampaignName =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CampaignName");
                                
                                    public static final java.lang.String _AdGroupName =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdGroupName");
                                
                                    public static final java.lang.String _AdId =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdId");
                                
                                    public static final java.lang.String _AdGroupId =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdGroupId");
                                
                                    public static final java.lang.String _AdTitle =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdTitle");
                                
                                    public static final java.lang.String _AdDescription =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdDescription");
                                
                                    public static final java.lang.String _AdType =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdType");
                                
                                    public static final java.lang.String _CurrencyCode =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CurrencyCode");
                                
                                    public static final java.lang.String _AdDistribution =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdDistribution");
                                
                                    public static final java.lang.String _Impressions =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Impressions");
                                
                                    public static final java.lang.String _Clicks =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Clicks");
                                
                                    public static final java.lang.String _Ctr =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Ctr");
                                
                                    public static final java.lang.String _AverageCpc =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AverageCpc");
                                
                                    public static final java.lang.String _Spend =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Spend");
                                
                                    public static final java.lang.String _AveragePosition =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AveragePosition");
                                
                                    public static final java.lang.String _Conversions =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Conversions");
                                
                                    public static final java.lang.String _ConversionRate =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ConversionRate");
                                
                                    public static final java.lang.String _CostPerConversion =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CostPerConversion");
                                
                                    public static final java.lang.String _AverageCpm =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AverageCpm");
                                
                                    public static final java.lang.String _PricingModel =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PricingModel");
                                
                                    public static final java.lang.String _DestinationUrl =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DestinationUrl");
                                
                                    public static final java.lang.String _DeviceType =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeviceType");
                                
                                    public static final java.lang.String _Language =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Language");
                                
                                    public static final java.lang.String _DisplayUrl =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DisplayUrl");
                                
                                public static final AdPerformanceReportColumn AccountName =
                                    new AdPerformanceReportColumn(_AccountName,true);
                            
                                public static final AdPerformanceReportColumn AccountNumber =
                                    new AdPerformanceReportColumn(_AccountNumber,true);
                            
                                public static final AdPerformanceReportColumn TimePeriod =
                                    new AdPerformanceReportColumn(_TimePeriod,true);
                            
                                public static final AdPerformanceReportColumn LanguageAndRegion =
                                    new AdPerformanceReportColumn(_LanguageAndRegion,true);
                            
                                public static final AdPerformanceReportColumn CampaignName =
                                    new AdPerformanceReportColumn(_CampaignName,true);
                            
                                public static final AdPerformanceReportColumn AdGroupName =
                                    new AdPerformanceReportColumn(_AdGroupName,true);
                            
                                public static final AdPerformanceReportColumn AdId =
                                    new AdPerformanceReportColumn(_AdId,true);
                            
                                public static final AdPerformanceReportColumn AdGroupId =
                                    new AdPerformanceReportColumn(_AdGroupId,true);
                            
                                public static final AdPerformanceReportColumn AdTitle =
                                    new AdPerformanceReportColumn(_AdTitle,true);
                            
                                public static final AdPerformanceReportColumn AdDescription =
                                    new AdPerformanceReportColumn(_AdDescription,true);
                            
                                public static final AdPerformanceReportColumn AdType =
                                    new AdPerformanceReportColumn(_AdType,true);
                            
                                public static final AdPerformanceReportColumn CurrencyCode =
                                    new AdPerformanceReportColumn(_CurrencyCode,true);
                            
                                public static final AdPerformanceReportColumn AdDistribution =
                                    new AdPerformanceReportColumn(_AdDistribution,true);
                            
                                public static final AdPerformanceReportColumn Impressions =
                                    new AdPerformanceReportColumn(_Impressions,true);
                            
                                public static final AdPerformanceReportColumn Clicks =
                                    new AdPerformanceReportColumn(_Clicks,true);
                            
                                public static final AdPerformanceReportColumn Ctr =
                                    new AdPerformanceReportColumn(_Ctr,true);
                            
                                public static final AdPerformanceReportColumn AverageCpc =
                                    new AdPerformanceReportColumn(_AverageCpc,true);
                            
                                public static final AdPerformanceReportColumn Spend =
                                    new AdPerformanceReportColumn(_Spend,true);
                            
                                public static final AdPerformanceReportColumn AveragePosition =
                                    new AdPerformanceReportColumn(_AveragePosition,true);
                            
                                public static final AdPerformanceReportColumn Conversions =
                                    new AdPerformanceReportColumn(_Conversions,true);
                            
                                public static final AdPerformanceReportColumn ConversionRate =
                                    new AdPerformanceReportColumn(_ConversionRate,true);
                            
                                public static final AdPerformanceReportColumn CostPerConversion =
                                    new AdPerformanceReportColumn(_CostPerConversion,true);
                            
                                public static final AdPerformanceReportColumn AverageCpm =
                                    new AdPerformanceReportColumn(_AverageCpm,true);
                            
                                public static final AdPerformanceReportColumn PricingModel =
                                    new AdPerformanceReportColumn(_PricingModel,true);
                            
                                public static final AdPerformanceReportColumn DestinationUrl =
                                    new AdPerformanceReportColumn(_DestinationUrl,true);
                            
                                public static final AdPerformanceReportColumn DeviceType =
                                    new AdPerformanceReportColumn(_DeviceType,true);
                            
                                public static final AdPerformanceReportColumn Language =
                                    new AdPerformanceReportColumn(_Language,true);
                            
                                public static final AdPerformanceReportColumn DisplayUrl =
                                    new AdPerformanceReportColumn(_DisplayUrl,true);
                            

                                public java.lang.String getValue() { return localAdPerformanceReportColumn;}

                                public boolean equals(java.lang.Object obj) {return (obj == this);}
                                public int hashCode() { return toString().hashCode();}
                                public java.lang.String toString() {
                                
                                        return localAdPerformanceReportColumn.toString();
                                    

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
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"https://adcenter.microsoft.com/v8");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":AdPerformanceReportColumn",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "AdPerformanceReportColumn",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localAdPerformanceReportColumn==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("AdPerformanceReportColumn cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localAdPerformanceReportColumn);
                                            
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


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAdPerformanceReportColumn)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static AdPerformanceReportColumn fromValue(java.lang.String value)
                      throws java.lang.IllegalArgumentException {
                    AdPerformanceReportColumn enumeration = (AdPerformanceReportColumn)
                       
                               _table_.get(value);
                           

                    if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    return enumeration;
                }
                public static AdPerformanceReportColumn fromString(java.lang.String value,java.lang.String namespaceURI)
                      throws java.lang.IllegalArgumentException {
                    try {
                       
                                       return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                                   

                    } catch (java.lang.Exception e) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }

                public static AdPerformanceReportColumn fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return AdPerformanceReportColumn.Factory.fromString(content,namespaceUri);
                    } else {
                       return AdPerformanceReportColumn.Factory.fromString(content,"");
                    }
                }
            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static AdPerformanceReportColumn parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AdPerformanceReportColumn object = null;
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
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"AdPerformanceReportColumn" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                        if (content.indexOf(":") > 0) {
                                            // this seems to be a Qname so find the namespace and send
                                            prefix = content.substring(0, content.indexOf(":"));
                                            namespaceuri = reader.getNamespaceURI(prefix);
                                            object = AdPerformanceReportColumn.Factory.fromString(content,namespaceuri);
                                        } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                            // check is done in fromString method
                                            object = AdPerformanceReportColumn.Factory.fromString(content,"");
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
           
    