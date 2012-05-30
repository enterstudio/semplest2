
/**
 * Industry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.microsoft.adcenter.api.customermanagement.entities;
            

            /**
            *  Industry bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Industry
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "https://adcenter.microsoft.com/api/customermanagement/Entities",
                "Industry",
                "ns6");

            

                        /**
                        * field for Industry
                        */

                        
                                    protected java.lang.String localIndustry ;
                                
                            private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
                            
                                protected Industry(java.lang.String value, boolean isRegisterValue) {
                                    localIndustry = value;
                                    if (isRegisterValue){
                                        
                                               _table_.put(localIndustry, this);
                                           
                                    }

                                }
                            
                                    public static final java.lang.String _NA =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NA");
                                
                                    public static final java.lang.String _AgencySalesHouse =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AgencySalesHouse");
                                
                                    public static final java.lang.String _Automotive =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Automotive");
                                
                                    public static final java.lang.String _ConsumerPackagedGoods =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ConsumerPackagedGoods");
                                
                                    public static final java.lang.String _Education =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Education");
                                
                                    public static final java.lang.String _Entertainment =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Entertainment");
                                
                                    public static final java.lang.String _FinancialServices =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FinancialServices");
                                
                                    public static final java.lang.String _FoodServices =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FoodServices");
                                
                                    public static final java.lang.String _Gaming =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Gaming");
                                
                                    public static final java.lang.String _GovernmentNonprofitPolitical =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GovernmentNonprofitPolitical");
                                
                                    public static final java.lang.String _Healthcare =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Healthcare");
                                
                                    public static final java.lang.String _Internal =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Internal");
                                
                                    public static final java.lang.String _PublishingAndWebMedia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PublishingAndWebMedia");
                                
                                    public static final java.lang.String _RealEstate =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("RealEstate");
                                
                                    public static final java.lang.String _Retail =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Retail");
                                
                                    public static final java.lang.String _Services =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Services");
                                
                                    public static final java.lang.String _Technology =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Technology");
                                
                                    public static final java.lang.String _Telecommunications =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Telecommunications");
                                
                                    public static final java.lang.String _TravelHospitality =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TravelHospitality");
                                
                                    public static final java.lang.String _Other =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Other");
                                
                                    public static final java.lang.String _Pharmaceuticals =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Pharmaceuticals");
                                
                                public static final Industry NA =
                                    new Industry(_NA,true);
                            
                                public static final Industry AgencySalesHouse =
                                    new Industry(_AgencySalesHouse,true);
                            
                                public static final Industry Automotive =
                                    new Industry(_Automotive,true);
                            
                                public static final Industry ConsumerPackagedGoods =
                                    new Industry(_ConsumerPackagedGoods,true);
                            
                                public static final Industry Education =
                                    new Industry(_Education,true);
                            
                                public static final Industry Entertainment =
                                    new Industry(_Entertainment,true);
                            
                                public static final Industry FinancialServices =
                                    new Industry(_FinancialServices,true);
                            
                                public static final Industry FoodServices =
                                    new Industry(_FoodServices,true);
                            
                                public static final Industry Gaming =
                                    new Industry(_Gaming,true);
                            
                                public static final Industry GovernmentNonprofitPolitical =
                                    new Industry(_GovernmentNonprofitPolitical,true);
                            
                                public static final Industry Healthcare =
                                    new Industry(_Healthcare,true);
                            
                                public static final Industry Internal =
                                    new Industry(_Internal,true);
                            
                                public static final Industry PublishingAndWebMedia =
                                    new Industry(_PublishingAndWebMedia,true);
                            
                                public static final Industry RealEstate =
                                    new Industry(_RealEstate,true);
                            
                                public static final Industry Retail =
                                    new Industry(_Retail,true);
                            
                                public static final Industry Services =
                                    new Industry(_Services,true);
                            
                                public static final Industry Technology =
                                    new Industry(_Technology,true);
                            
                                public static final Industry Telecommunications =
                                    new Industry(_Telecommunications,true);
                            
                                public static final Industry TravelHospitality =
                                    new Industry(_TravelHospitality,true);
                            
                                public static final Industry Other =
                                    new Industry(_Other,true);
                            
                                public static final Industry Pharmaceuticals =
                                    new Industry(_Pharmaceuticals,true);
                            

                                public java.lang.String getValue() { return localIndustry;}

                                public boolean equals(java.lang.Object obj) {return (obj == this);}
                                public int hashCode() { return toString().hashCode();}
                                public java.lang.String toString() {
                                
                                        return localIndustry.toString();
                                    

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
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"https://adcenter.microsoft.com/api/customermanagement/Entities");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":Industry",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "Industry",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localIndustry==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Industry cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localIndustry);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();
                    

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("https://adcenter.microsoft.com/api/customermanagement/Entities")){
                return "ns6";
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndustry)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Industry fromValue(java.lang.String value)
                      throws java.lang.IllegalArgumentException {
                    Industry enumeration = (Industry)
                       
                               _table_.get(value);
                           

                    if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    return enumeration;
                }
                public static Industry fromString(java.lang.String value,java.lang.String namespaceURI)
                      throws java.lang.IllegalArgumentException {
                    try {
                       
                                       return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                                   

                    } catch (java.lang.Exception e) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }

                public static Industry fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Industry.Factory.fromString(content,namespaceUri);
                    } else {
                       return Industry.Factory.fromString(content,"");
                    }
                }
            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Industry parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Industry object = null;
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
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Industry" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                        if (content.indexOf(":") > 0) {
                                            // this seems to be a Qname so find the namespace and send
                                            prefix = content.substring(0, content.indexOf(":"));
                                            namespaceuri = reader.getNamespaceURI(prefix);
                                            object = Industry.Factory.fromString(content,namespaceuri);
                                        } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                            // check is done in fromString method
                                            object = Industry.Factory.fromString(content,"");
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
           
    