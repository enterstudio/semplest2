
/**
 * LCID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.microsoft.adcenter.api.customermanagement.entities;
            

            /**
            *  LCID bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class LCID
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "https://adcenter.microsoft.com/api/customermanagement/Entities",
                "LCID",
                "ns6");

            

                        /**
                        * field for LCID
                        */

                        
                                    protected java.lang.String localLCID ;
                                
                            private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
                            
                                protected LCID(java.lang.String value, boolean isRegisterValue) {
                                    localLCID = value;
                                    if (isRegisterValue){
                                        
                                               _table_.put(localLCID, this);
                                           
                                    }

                                }
                            
                                    public static final java.lang.String _ArabicSaudiArabia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ArabicSaudiArabia");
                                
                                    public static final java.lang.String _ChineseTaiwan =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ChineseTaiwan");
                                
                                    public static final java.lang.String _DanishDenmark =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DanishDenmark");
                                
                                    public static final java.lang.String _GermanGermany =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GermanGermany");
                                
                                    public static final java.lang.String _EnglishUS =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishUS");
                                
                                    public static final java.lang.String _SpanishSpain =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SpanishSpain");
                                
                                    public static final java.lang.String _FinnishFinland =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FinnishFinland");
                                
                                    public static final java.lang.String _FrenchFrance =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FrenchFrance");
                                
                                    public static final java.lang.String _HebrewIsrael =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("HebrewIsrael");
                                
                                    public static final java.lang.String _ItalianItaly =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ItalianItaly");
                                
                                    public static final java.lang.String _KoreanKorea =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KoreanKorea");
                                
                                    public static final java.lang.String _DutchNetherlands =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DutchNetherlands");
                                
                                    public static final java.lang.String _NorwegianNorway =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NorwegianNorway");
                                
                                    public static final java.lang.String _PortuguesePortugal =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PortuguesePortugal");
                                
                                    public static final java.lang.String _RussianRussia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("RussianRussia");
                                
                                    public static final java.lang.String _SwedishSweden =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SwedishSweden");
                                
                                    public static final java.lang.String _EnglishThailand =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishThailand");
                                
                                    public static final java.lang.String _EnglishIndonesia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishIndonesia");
                                
                                    public static final java.lang.String _EnglishVietnam =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishVietnam");
                                
                                    public static final java.lang.String _GermanSwitzerland =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GermanSwitzerland");
                                
                                    public static final java.lang.String _EnglishUK =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishUK");
                                
                                    public static final java.lang.String _SpanishMexico =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SpanishMexico");
                                
                                    public static final java.lang.String _ChineseHongKong =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ChineseHongKong");
                                
                                    public static final java.lang.String _GermanAustria =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GermanAustria");
                                
                                    public static final java.lang.String _EnglishAustralia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishAustralia");
                                
                                    public static final java.lang.String _FrenchCanada =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FrenchCanada");
                                
                                    public static final java.lang.String _EnglishCanada =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishCanada");
                                
                                    public static final java.lang.String _EnglishNewZeeland =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishNewZeeland");
                                
                                    public static final java.lang.String _EnglishIreland =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishIreland");
                                
                                    public static final java.lang.String _SpanishVenezuela =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SpanishVenezuela");
                                
                                    public static final java.lang.String _SpanishColombia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SpanishColombia");
                                
                                    public static final java.lang.String _SpanishPeru =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SpanishPeru");
                                
                                    public static final java.lang.String _SpanishArgentina =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SpanishArgentina");
                                
                                    public static final java.lang.String _EnglishPhilippines =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishPhilippines");
                                
                                    public static final java.lang.String _SpanishChile =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SpanishChile");
                                
                                    public static final java.lang.String _EnglishIndia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishIndia");
                                
                                    public static final java.lang.String _EnglishMalaysia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishMalaysia");
                                
                                    public static final java.lang.String _EnglishSingapore =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EnglishSingapore");
                                
                                public static final LCID ArabicSaudiArabia =
                                    new LCID(_ArabicSaudiArabia,true);
                            
                                public static final LCID ChineseTaiwan =
                                    new LCID(_ChineseTaiwan,true);
                            
                                public static final LCID DanishDenmark =
                                    new LCID(_DanishDenmark,true);
                            
                                public static final LCID GermanGermany =
                                    new LCID(_GermanGermany,true);
                            
                                public static final LCID EnglishUS =
                                    new LCID(_EnglishUS,true);
                            
                                public static final LCID SpanishSpain =
                                    new LCID(_SpanishSpain,true);
                            
                                public static final LCID FinnishFinland =
                                    new LCID(_FinnishFinland,true);
                            
                                public static final LCID FrenchFrance =
                                    new LCID(_FrenchFrance,true);
                            
                                public static final LCID HebrewIsrael =
                                    new LCID(_HebrewIsrael,true);
                            
                                public static final LCID ItalianItaly =
                                    new LCID(_ItalianItaly,true);
                            
                                public static final LCID KoreanKorea =
                                    new LCID(_KoreanKorea,true);
                            
                                public static final LCID DutchNetherlands =
                                    new LCID(_DutchNetherlands,true);
                            
                                public static final LCID NorwegianNorway =
                                    new LCID(_NorwegianNorway,true);
                            
                                public static final LCID PortuguesePortugal =
                                    new LCID(_PortuguesePortugal,true);
                            
                                public static final LCID RussianRussia =
                                    new LCID(_RussianRussia,true);
                            
                                public static final LCID SwedishSweden =
                                    new LCID(_SwedishSweden,true);
                            
                                public static final LCID EnglishThailand =
                                    new LCID(_EnglishThailand,true);
                            
                                public static final LCID EnglishIndonesia =
                                    new LCID(_EnglishIndonesia,true);
                            
                                public static final LCID EnglishVietnam =
                                    new LCID(_EnglishVietnam,true);
                            
                                public static final LCID GermanSwitzerland =
                                    new LCID(_GermanSwitzerland,true);
                            
                                public static final LCID EnglishUK =
                                    new LCID(_EnglishUK,true);
                            
                                public static final LCID SpanishMexico =
                                    new LCID(_SpanishMexico,true);
                            
                                public static final LCID ChineseHongKong =
                                    new LCID(_ChineseHongKong,true);
                            
                                public static final LCID GermanAustria =
                                    new LCID(_GermanAustria,true);
                            
                                public static final LCID EnglishAustralia =
                                    new LCID(_EnglishAustralia,true);
                            
                                public static final LCID FrenchCanada =
                                    new LCID(_FrenchCanada,true);
                            
                                public static final LCID EnglishCanada =
                                    new LCID(_EnglishCanada,true);
                            
                                public static final LCID EnglishNewZeeland =
                                    new LCID(_EnglishNewZeeland,true);
                            
                                public static final LCID EnglishIreland =
                                    new LCID(_EnglishIreland,true);
                            
                                public static final LCID SpanishVenezuela =
                                    new LCID(_SpanishVenezuela,true);
                            
                                public static final LCID SpanishColombia =
                                    new LCID(_SpanishColombia,true);
                            
                                public static final LCID SpanishPeru =
                                    new LCID(_SpanishPeru,true);
                            
                                public static final LCID SpanishArgentina =
                                    new LCID(_SpanishArgentina,true);
                            
                                public static final LCID EnglishPhilippines =
                                    new LCID(_EnglishPhilippines,true);
                            
                                public static final LCID SpanishChile =
                                    new LCID(_SpanishChile,true);
                            
                                public static final LCID EnglishIndia =
                                    new LCID(_EnglishIndia,true);
                            
                                public static final LCID EnglishMalaysia =
                                    new LCID(_EnglishMalaysia,true);
                            
                                public static final LCID EnglishSingapore =
                                    new LCID(_EnglishSingapore,true);
                            

                                public java.lang.String getValue() { return localLCID;}

                                public boolean equals(java.lang.Object obj) {return (obj == this);}
                                public int hashCode() { return toString().hashCode();}
                                public java.lang.String toString() {
                                
                                        return localLCID.toString();
                                    

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
                                           namespacePrefix+":LCID",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "LCID",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localLCID==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("LCID cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localLCID);
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLCID)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static LCID fromValue(java.lang.String value)
                      throws java.lang.IllegalArgumentException {
                    LCID enumeration = (LCID)
                       
                               _table_.get(value);
                           

                    if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    return enumeration;
                }
                public static LCID fromString(java.lang.String value,java.lang.String namespaceURI)
                      throws java.lang.IllegalArgumentException {
                    try {
                       
                                       return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                                   

                    } catch (java.lang.Exception e) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }

                public static LCID fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return LCID.Factory.fromString(content,namespaceUri);
                    } else {
                       return LCID.Factory.fromString(content,"");
                    }
                }
            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static LCID parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            LCID object = null;
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
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"LCID" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                        if (content.indexOf(":") > 0) {
                                            // this seems to be a Qname so find the namespace and send
                                            prefix = content.substring(0, content.indexOf(":"));
                                            namespaceuri = reader.getNamespaceURI(prefix);
                                            object = LCID.Factory.fromString(content,namespaceuri);
                                        } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                            // check is done in fromString method
                                            object = LCID.Factory.fromString(content,"");
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
           
    