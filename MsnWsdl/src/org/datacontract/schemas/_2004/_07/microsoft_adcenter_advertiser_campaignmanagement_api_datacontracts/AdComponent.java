
/**
 * AdComponent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts;
            

            /**
            *  AdComponent bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class AdComponent
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts",
                "AdComponent",
                "ns2");

            

                        /**
                        * field for AdComponent
                        */

                        
                                    protected java.lang.String localAdComponent ;
                                
                            private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
                            
                                protected AdComponent(java.lang.String value, boolean isRegisterValue) {
                                    localAdComponent = value;
                                    if (isRegisterValue){
                                        
                                               _table_.put(localAdComponent, this);
                                           
                                    }

                                }
                            
                                    public static final java.lang.String _Unknown =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Unknown");
                                
                                    public static final java.lang.String _Keyword =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Keyword");
                                
                                    public static final java.lang.String _KeywordParam1 =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordParam1");
                                
                                    public static final java.lang.String _KeywordParam2 =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordParam2");
                                
                                    public static final java.lang.String _KeywordParam3 =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeywordParam3");
                                
                                    public static final java.lang.String _AdTitleDescription =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdTitleDescription");
                                
                                    public static final java.lang.String _AdTitle =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdTitle");
                                
                                    public static final java.lang.String _AdDescription =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdDescription");
                                
                                    public static final java.lang.String _DisplayUrl =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DisplayUrl");
                                
                                    public static final java.lang.String _DestinationUrl =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DestinationUrl");
                                
                                    public static final java.lang.String _LandingUrl =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("LandingUrl");
                                
                                    public static final java.lang.String _SiteDomain =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SiteDomain");
                                
                                    public static final java.lang.String _BusinessName =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BusinessName");
                                
                                    public static final java.lang.String _PhoneNumber =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PhoneNumber");
                                
                                    public static final java.lang.String _CashbackTextParam =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CashbackTextParam");
                                
                                    public static final java.lang.String _AltText =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AltText");
                                
                                    public static final java.lang.String _Audio =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Audio");
                                
                                    public static final java.lang.String _Video =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Video");
                                
                                    public static final java.lang.String _Flash =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Flash");
                                
                                    public static final java.lang.String _CAsset =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CAsset");
                                
                                    public static final java.lang.String _Image =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Image");
                                
                                    public static final java.lang.String _Destination =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Destination");
                                
                                    public static final java.lang.String _Asset =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Asset");
                                
                                    public static final java.lang.String _Ad =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Ad");
                                
                                    public static final java.lang.String _Order =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Order");
                                
                                    public static final java.lang.String _BiddingKeyword =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BiddingKeyword");
                                
                                    public static final java.lang.String _Association =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Association");
                                
                                    public static final java.lang.String _Script =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Script");
                                
                                public static final AdComponent Unknown =
                                    new AdComponent(_Unknown,true);
                            
                                public static final AdComponent Keyword =
                                    new AdComponent(_Keyword,true);
                            
                                public static final AdComponent KeywordParam1 =
                                    new AdComponent(_KeywordParam1,true);
                            
                                public static final AdComponent KeywordParam2 =
                                    new AdComponent(_KeywordParam2,true);
                            
                                public static final AdComponent KeywordParam3 =
                                    new AdComponent(_KeywordParam3,true);
                            
                                public static final AdComponent AdTitleDescription =
                                    new AdComponent(_AdTitleDescription,true);
                            
                                public static final AdComponent AdTitle =
                                    new AdComponent(_AdTitle,true);
                            
                                public static final AdComponent AdDescription =
                                    new AdComponent(_AdDescription,true);
                            
                                public static final AdComponent DisplayUrl =
                                    new AdComponent(_DisplayUrl,true);
                            
                                public static final AdComponent DestinationUrl =
                                    new AdComponent(_DestinationUrl,true);
                            
                                public static final AdComponent LandingUrl =
                                    new AdComponent(_LandingUrl,true);
                            
                                public static final AdComponent SiteDomain =
                                    new AdComponent(_SiteDomain,true);
                            
                                public static final AdComponent BusinessName =
                                    new AdComponent(_BusinessName,true);
                            
                                public static final AdComponent PhoneNumber =
                                    new AdComponent(_PhoneNumber,true);
                            
                                public static final AdComponent CashbackTextParam =
                                    new AdComponent(_CashbackTextParam,true);
                            
                                public static final AdComponent AltText =
                                    new AdComponent(_AltText,true);
                            
                                public static final AdComponent Audio =
                                    new AdComponent(_Audio,true);
                            
                                public static final AdComponent Video =
                                    new AdComponent(_Video,true);
                            
                                public static final AdComponent Flash =
                                    new AdComponent(_Flash,true);
                            
                                public static final AdComponent CAsset =
                                    new AdComponent(_CAsset,true);
                            
                                public static final AdComponent Image =
                                    new AdComponent(_Image,true);
                            
                                public static final AdComponent Destination =
                                    new AdComponent(_Destination,true);
                            
                                public static final AdComponent Asset =
                                    new AdComponent(_Asset,true);
                            
                                public static final AdComponent Ad =
                                    new AdComponent(_Ad,true);
                            
                                public static final AdComponent Order =
                                    new AdComponent(_Order,true);
                            
                                public static final AdComponent BiddingKeyword =
                                    new AdComponent(_BiddingKeyword,true);
                            
                                public static final AdComponent Association =
                                    new AdComponent(_Association,true);
                            
                                public static final AdComponent Script =
                                    new AdComponent(_Script,true);
                            

                                public java.lang.String getValue() { return localAdComponent;}

                                public boolean equals(java.lang.Object obj) {return (obj == this);}
                                public int hashCode() { return toString().hashCode();}
                                public java.lang.String toString() {
                                
                                        return localAdComponent.toString();
                                    

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
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":AdComponent",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "AdComponent",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localAdComponent==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("AdComponent cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localAdComponent);
                                            
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


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAdComponent)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static AdComponent fromValue(java.lang.String value)
                      throws java.lang.IllegalArgumentException {
                    AdComponent enumeration = (AdComponent)
                       
                               _table_.get(value);
                           

                    if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    return enumeration;
                }
                public static AdComponent fromString(java.lang.String value,java.lang.String namespaceURI)
                      throws java.lang.IllegalArgumentException {
                    try {
                       
                                       return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                                   

                    } catch (java.lang.Exception e) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }

                public static AdComponent fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return AdComponent.Factory.fromString(content,namespaceUri);
                    } else {
                       return AdComponent.Factory.fromString(content,"");
                    }
                }
            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static AdComponent parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AdComponent object = null;
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
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"AdComponent" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                        if (content.indexOf(":") > 0) {
                                            // this seems to be a Qname so find the namespace and send
                                            prefix = content.substring(0, content.indexOf(":"));
                                            namespaceuri = reader.getNamespaceURI(prefix);
                                            object = AdComponent.Factory.fromString(content,namespaceuri);
                                        } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                            // check is done in fromString method
                                            object = AdComponent.Factory.fromString(content,"");
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
           
    