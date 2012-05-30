
/**
 * LocationTarget.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.microsoft.adcenter.v8;
            

            /**
            *  LocationTarget bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class LocationTarget
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = LocationTarget
                Namespace URI = https://adcenter.microsoft.com/v8
                Namespace Prefix = ns4
                */
            

                        /**
                        * field for BusinessTarget
                        */

                        
                                    protected com.microsoft.adcenter.v8.BusinessTarget localBusinessTarget ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBusinessTargetTracker = false ;

                           public boolean isBusinessTargetSpecified(){
                               return localBusinessTargetTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.BusinessTarget
                           */
                           public  com.microsoft.adcenter.v8.BusinessTarget getBusinessTarget(){
                               return localBusinessTarget;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BusinessTarget
                               */
                               public void setBusinessTarget(com.microsoft.adcenter.v8.BusinessTarget param){
                            localBusinessTargetTracker = true;
                                   
                                            this.localBusinessTarget=param;
                                    

                               }
                            

                        /**
                        * field for CityTarget
                        */

                        
                                    protected com.microsoft.adcenter.v8.CityTarget localCityTarget ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCityTargetTracker = false ;

                           public boolean isCityTargetSpecified(){
                               return localCityTargetTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.CityTarget
                           */
                           public  com.microsoft.adcenter.v8.CityTarget getCityTarget(){
                               return localCityTarget;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CityTarget
                               */
                               public void setCityTarget(com.microsoft.adcenter.v8.CityTarget param){
                            localCityTargetTracker = true;
                                   
                                            this.localCityTarget=param;
                                    

                               }
                            

                        /**
                        * field for CountryTarget
                        */

                        
                                    protected com.microsoft.adcenter.v8.CountryTarget localCountryTarget ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCountryTargetTracker = false ;

                           public boolean isCountryTargetSpecified(){
                               return localCountryTargetTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.CountryTarget
                           */
                           public  com.microsoft.adcenter.v8.CountryTarget getCountryTarget(){
                               return localCountryTarget;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CountryTarget
                               */
                               public void setCountryTarget(com.microsoft.adcenter.v8.CountryTarget param){
                            localCountryTargetTracker = true;
                                   
                                            this.localCountryTarget=param;
                                    

                               }
                            

                        /**
                        * field for HasPhysicalIntent
                        */

                        
                                    protected boolean localHasPhysicalIntent ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHasPhysicalIntentTracker = false ;

                           public boolean isHasPhysicalIntentSpecified(){
                               return localHasPhysicalIntentTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getHasPhysicalIntent(){
                               return localHasPhysicalIntent;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HasPhysicalIntent
                               */
                               public void setHasPhysicalIntent(boolean param){
                            localHasPhysicalIntentTracker = true;
                                   
                                            this.localHasPhysicalIntent=param;
                                    

                               }
                            

                        /**
                        * field for MetroAreaTarget
                        */

                        
                                    protected com.microsoft.adcenter.v8.MetroAreaTarget localMetroAreaTarget ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMetroAreaTargetTracker = false ;

                           public boolean isMetroAreaTargetSpecified(){
                               return localMetroAreaTargetTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.MetroAreaTarget
                           */
                           public  com.microsoft.adcenter.v8.MetroAreaTarget getMetroAreaTarget(){
                               return localMetroAreaTarget;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MetroAreaTarget
                               */
                               public void setMetroAreaTarget(com.microsoft.adcenter.v8.MetroAreaTarget param){
                            localMetroAreaTargetTracker = true;
                                   
                                            this.localMetroAreaTarget=param;
                                    

                               }
                            

                        /**
                        * field for RadiusTarget
                        */

                        
                                    protected com.microsoft.adcenter.v8.RadiusTarget localRadiusTarget ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRadiusTargetTracker = false ;

                           public boolean isRadiusTargetSpecified(){
                               return localRadiusTargetTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.RadiusTarget
                           */
                           public  com.microsoft.adcenter.v8.RadiusTarget getRadiusTarget(){
                               return localRadiusTarget;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RadiusTarget
                               */
                               public void setRadiusTarget(com.microsoft.adcenter.v8.RadiusTarget param){
                            localRadiusTargetTracker = true;
                                   
                                            this.localRadiusTarget=param;
                                    

                               }
                            

                        /**
                        * field for StateTarget
                        */

                        
                                    protected com.microsoft.adcenter.v8.StateTarget localStateTarget ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStateTargetTracker = false ;

                           public boolean isStateTargetSpecified(){
                               return localStateTargetTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.StateTarget
                           */
                           public  com.microsoft.adcenter.v8.StateTarget getStateTarget(){
                               return localStateTarget;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StateTarget
                               */
                               public void setStateTarget(com.microsoft.adcenter.v8.StateTarget param){
                            localStateTargetTracker = true;
                                   
                                            this.localStateTarget=param;
                                    

                               }
                            

                        /**
                        * field for TargetAllLocations
                        */

                        
                                    protected boolean localTargetAllLocations ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTargetAllLocationsTracker = false ;

                           public boolean isTargetAllLocationsSpecified(){
                               return localTargetAllLocationsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getTargetAllLocations(){
                               return localTargetAllLocations;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TargetAllLocations
                               */
                               public void setTargetAllLocations(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localTargetAllLocationsTracker =
                                       true;
                                   
                                            this.localTargetAllLocations=param;
                                    

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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"https://adcenter.microsoft.com/v8");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":LocationTarget",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "LocationTarget",
                           xmlWriter);
                   }

               
                   }
                if (localBusinessTargetTracker){
                                    if (localBusinessTarget==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "BusinessTarget", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localBusinessTarget.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","BusinessTarget"),
                                        xmlWriter);
                                    }
                                } if (localCityTargetTracker){
                                    if (localCityTarget==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "CityTarget", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localCityTarget.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","CityTarget"),
                                        xmlWriter);
                                    }
                                } if (localCountryTargetTracker){
                                    if (localCountryTarget==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "CountryTarget", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localCountryTarget.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","CountryTarget"),
                                        xmlWriter);
                                    }
                                } if (localHasPhysicalIntentTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "HasPhysicalIntent", xmlWriter);
                             
                                               if (false) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHasPhysicalIntent));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMetroAreaTargetTracker){
                                    if (localMetroAreaTarget==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "MetroAreaTarget", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localMetroAreaTarget.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","MetroAreaTarget"),
                                        xmlWriter);
                                    }
                                } if (localRadiusTargetTracker){
                                    if (localRadiusTarget==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "RadiusTarget", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localRadiusTarget.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","RadiusTarget"),
                                        xmlWriter);
                                    }
                                } if (localStateTargetTracker){
                                    if (localStateTarget==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "StateTarget", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localStateTarget.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","StateTarget"),
                                        xmlWriter);
                                    }
                                } if (localTargetAllLocationsTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "TargetAllLocations", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("TargetAllLocations cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTargetAllLocations));
                                               }
                                    
                                   xmlWriter.writeEndElement();
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

                 if (localBusinessTargetTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "BusinessTarget"));
                            
                            
                                    elementList.add(localBusinessTarget==null?null:
                                    localBusinessTarget);
                                } if (localCityTargetTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "CityTarget"));
                            
                            
                                    elementList.add(localCityTarget==null?null:
                                    localCityTarget);
                                } if (localCountryTargetTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "CountryTarget"));
                            
                            
                                    elementList.add(localCountryTarget==null?null:
                                    localCountryTarget);
                                } if (localHasPhysicalIntentTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "HasPhysicalIntent"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHasPhysicalIntent));
                            } if (localMetroAreaTargetTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "MetroAreaTarget"));
                            
                            
                                    elementList.add(localMetroAreaTarget==null?null:
                                    localMetroAreaTarget);
                                } if (localRadiusTargetTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "RadiusTarget"));
                            
                            
                                    elementList.add(localRadiusTarget==null?null:
                                    localRadiusTarget);
                                } if (localStateTargetTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "StateTarget"));
                            
                            
                                    elementList.add(localStateTarget==null?null:
                                    localStateTarget);
                                } if (localTargetAllLocationsTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "TargetAllLocations"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTargetAllLocations));
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
        public static LocationTarget parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            LocationTarget object =
                new LocationTarget();

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
                    
                            if (!"LocationTarget".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (LocationTarget)com.microsoft.adcenter.v8.imports.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","BusinessTarget").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setBusinessTarget(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setBusinessTarget(com.microsoft.adcenter.v8.BusinessTarget.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","CityTarget").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setCityTarget(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setCityTarget(com.microsoft.adcenter.v8.CityTarget.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","CountryTarget").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setCountryTarget(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setCountryTarget(com.microsoft.adcenter.v8.CountryTarget.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","HasPhysicalIntent").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHasPhysicalIntent(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","MetroAreaTarget").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setMetroAreaTarget(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setMetroAreaTarget(com.microsoft.adcenter.v8.MetroAreaTarget.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","RadiusTarget").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setRadiusTarget(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setRadiusTarget(com.microsoft.adcenter.v8.RadiusTarget.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","StateTarget").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setStateTarget(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setStateTarget(com.microsoft.adcenter.v8.StateTarget.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","TargetAllLocations").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"TargetAllLocations" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTargetAllLocations(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
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
           
    