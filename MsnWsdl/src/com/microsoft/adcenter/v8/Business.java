
/**
 * Business.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.microsoft.adcenter.v8;
            

            /**
            *  Business bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Business
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Business
                Namespace URI = https://adcenter.microsoft.com/v8
                Namespace Prefix = ns4
                */
            

                        /**
                        * field for AddressLine1
                        */

                        
                                    protected java.lang.String localAddressLine1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAddressLine1Tracker = false ;

                           public boolean isAddressLine1Specified(){
                               return localAddressLine1Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAddressLine1(){
                               return localAddressLine1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AddressLine1
                               */
                               public void setAddressLine1(java.lang.String param){
                            localAddressLine1Tracker = true;
                                   
                                            this.localAddressLine1=param;
                                    

                               }
                            

                        /**
                        * field for AddressLine2
                        */

                        
                                    protected java.lang.String localAddressLine2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAddressLine2Tracker = false ;

                           public boolean isAddressLine2Specified(){
                               return localAddressLine2Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAddressLine2(){
                               return localAddressLine2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AddressLine2
                               */
                               public void setAddressLine2(java.lang.String param){
                            localAddressLine2Tracker = true;
                                   
                                            this.localAddressLine2=param;
                                    

                               }
                            

                        /**
                        * field for BusinessImageIcon
                        */

                        
                                    protected com.microsoft.adcenter.v8.BusinessImageIcon localBusinessImageIcon ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBusinessImageIconTracker = false ;

                           public boolean isBusinessImageIconSpecified(){
                               return localBusinessImageIconTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.BusinessImageIcon
                           */
                           public  com.microsoft.adcenter.v8.BusinessImageIcon getBusinessImageIcon(){
                               return localBusinessImageIcon;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BusinessImageIcon
                               */
                               public void setBusinessImageIcon(com.microsoft.adcenter.v8.BusinessImageIcon param){
                            localBusinessImageIconTracker = true;
                                   
                                            this.localBusinessImageIcon=param;
                                    

                               }
                            

                        /**
                        * field for City
                        */

                        
                                    protected java.lang.String localCity ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCityTracker = false ;

                           public boolean isCitySpecified(){
                               return localCityTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCity(){
                               return localCity;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param City
                               */
                               public void setCity(java.lang.String param){
                            localCityTracker = true;
                                   
                                            this.localCity=param;
                                    

                               }
                            

                        /**
                        * field for CountryOrRegion
                        */

                        
                                    protected java.lang.String localCountryOrRegion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCountryOrRegionTracker = false ;

                           public boolean isCountryOrRegionSpecified(){
                               return localCountryOrRegionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCountryOrRegion(){
                               return localCountryOrRegion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CountryOrRegion
                               */
                               public void setCountryOrRegion(java.lang.String param){
                            localCountryOrRegionTracker = true;
                                   
                                            this.localCountryOrRegion=param;
                                    

                               }
                            

                        /**
                        * field for Description
                        */

                        
                                    protected java.lang.String localDescription ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDescription(){
                               return localDescription;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Description
                               */
                               public void setDescription(java.lang.String param){
                            
                                            this.localDescription=param;
                                    

                               }
                            

                        /**
                        * field for Email
                        */

                        
                                    protected java.lang.String localEmail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEmailTracker = false ;

                           public boolean isEmailSpecified(){
                               return localEmailTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEmail(){
                               return localEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Email
                               */
                               public void setEmail(java.lang.String param){
                            localEmailTracker = true;
                                   
                                            this.localEmail=param;
                                    

                               }
                            

                        /**
                        * field for GeoCodeStatus
                        */

                        
                                    protected com.microsoft.adcenter.v8.BusinessGeoCodeStatus localGeoCodeStatus ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGeoCodeStatusTracker = false ;

                           public boolean isGeoCodeStatusSpecified(){
                               return localGeoCodeStatusTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.BusinessGeoCodeStatus
                           */
                           public  com.microsoft.adcenter.v8.BusinessGeoCodeStatus getGeoCodeStatus(){
                               return localGeoCodeStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GeoCodeStatus
                               */
                               public void setGeoCodeStatus(com.microsoft.adcenter.v8.BusinessGeoCodeStatus param){
                            localGeoCodeStatusTracker = true;
                                   
                                            this.localGeoCodeStatus=param;
                                    

                               }
                            

                        /**
                        * field for HrsOfOperation
                        */

                        
                                    protected com.microsoft.adcenter.v8.ArrayOfHoursOfOperation localHrsOfOperation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHrsOfOperationTracker = false ;

                           public boolean isHrsOfOperationSpecified(){
                               return localHrsOfOperationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.ArrayOfHoursOfOperation
                           */
                           public  com.microsoft.adcenter.v8.ArrayOfHoursOfOperation getHrsOfOperation(){
                               return localHrsOfOperation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HrsOfOperation
                               */
                               public void setHrsOfOperation(com.microsoft.adcenter.v8.ArrayOfHoursOfOperation param){
                            localHrsOfOperationTracker = true;
                                   
                                            this.localHrsOfOperation=param;
                                    

                               }
                            

                        /**
                        * field for Id
                        */

                        
                                    protected long localId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdTracker = false ;

                           public boolean isIdSpecified(){
                               return localIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getId(){
                               return localId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Id
                               */
                               public void setId(long param){
                            localIdTracker = true;
                                   
                                            this.localId=param;
                                    

                               }
                            

                        /**
                        * field for IsOpen24Hours
                        */

                        
                                    protected boolean localIsOpen24Hours ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsOpen24HoursTracker = false ;

                           public boolean isIsOpen24HoursSpecified(){
                               return localIsOpen24HoursTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsOpen24Hours(){
                               return localIsOpen24Hours;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsOpen24Hours
                               */
                               public void setIsOpen24Hours(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsOpen24HoursTracker =
                                       true;
                                   
                                            this.localIsOpen24Hours=param;
                                    

                               }
                            

                        /**
                        * field for LatitudeDegrees
                        */

                        
                                    protected double localLatitudeDegrees ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLatitudeDegreesTracker = false ;

                           public boolean isLatitudeDegreesSpecified(){
                               return localLatitudeDegreesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getLatitudeDegrees(){
                               return localLatitudeDegrees;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LatitudeDegrees
                               */
                               public void setLatitudeDegrees(double param){
                            localLatitudeDegreesTracker = true;
                                   
                                            this.localLatitudeDegrees=param;
                                    

                               }
                            

                        /**
                        * field for LongitudeDegrees
                        */

                        
                                    protected double localLongitudeDegrees ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLongitudeDegreesTracker = false ;

                           public boolean isLongitudeDegreesSpecified(){
                               return localLongitudeDegreesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getLongitudeDegrees(){
                               return localLongitudeDegrees;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LongitudeDegrees
                               */
                               public void setLongitudeDegrees(double param){
                            localLongitudeDegreesTracker = true;
                                   
                                            this.localLongitudeDegrees=param;
                                    

                               }
                            

                        /**
                        * field for Name
                        */

                        
                                    protected java.lang.String localName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getName(){
                               return localName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Name
                               */
                               public void setName(java.lang.String param){
                            
                                            this.localName=param;
                                    

                               }
                            

                        /**
                        * field for OtherPaymentTypeDesc
                        */

                        
                                    protected java.lang.String localOtherPaymentTypeDesc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOtherPaymentTypeDescTracker = false ;

                           public boolean isOtherPaymentTypeDescSpecified(){
                               return localOtherPaymentTypeDescTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOtherPaymentTypeDesc(){
                               return localOtherPaymentTypeDesc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OtherPaymentTypeDesc
                               */
                               public void setOtherPaymentTypeDesc(java.lang.String param){
                            localOtherPaymentTypeDescTracker = true;
                                   
                                            this.localOtherPaymentTypeDesc=param;
                                    

                               }
                            

                        /**
                        * field for Payment
                        */

                        
                                    protected com.microsoft.adcenter.v8.ArrayOfPaymentType localPayment ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPaymentTracker = false ;

                           public boolean isPaymentSpecified(){
                               return localPaymentTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.ArrayOfPaymentType
                           */
                           public  com.microsoft.adcenter.v8.ArrayOfPaymentType getPayment(){
                               return localPayment;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Payment
                               */
                               public void setPayment(com.microsoft.adcenter.v8.ArrayOfPaymentType param){
                            localPaymentTracker = true;
                                   
                                            this.localPayment=param;
                                    

                               }
                            

                        /**
                        * field for Phone
                        */

                        
                                    protected java.lang.String localPhone ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPhoneTracker = false ;

                           public boolean isPhoneSpecified(){
                               return localPhoneTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPhone(){
                               return localPhone;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Phone
                               */
                               public void setPhone(java.lang.String param){
                            localPhoneTracker = true;
                                   
                                            this.localPhone=param;
                                    

                               }
                            

                        /**
                        * field for StateOrProvince
                        */

                        
                                    protected java.lang.String localStateOrProvince ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStateOrProvinceTracker = false ;

                           public boolean isStateOrProvinceSpecified(){
                               return localStateOrProvinceTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStateOrProvince(){
                               return localStateOrProvince;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StateOrProvince
                               */
                               public void setStateOrProvince(java.lang.String param){
                            localStateOrProvinceTracker = true;
                                   
                                            this.localStateOrProvince=param;
                                    

                               }
                            

                        /**
                        * field for Status
                        */

                        
                                    protected com.microsoft.adcenter.v8.BusinessStatus localStatus ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusTracker = false ;

                           public boolean isStatusSpecified(){
                               return localStatusTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.v8.BusinessStatus
                           */
                           public  com.microsoft.adcenter.v8.BusinessStatus getStatus(){
                               return localStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Status
                               */
                               public void setStatus(com.microsoft.adcenter.v8.BusinessStatus param){
                            localStatusTracker = true;
                                   
                                            this.localStatus=param;
                                    

                               }
                            

                        /**
                        * field for URL
                        */

                        
                                    protected java.lang.String localURL ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localURLTracker = false ;

                           public boolean isURLSpecified(){
                               return localURLTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getURL(){
                               return localURL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param URL
                               */
                               public void setURL(java.lang.String param){
                            localURLTracker = true;
                                   
                                            this.localURL=param;
                                    

                               }
                            

                        /**
                        * field for ZipOrPostalCode
                        */

                        
                                    protected java.lang.String localZipOrPostalCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localZipOrPostalCodeTracker = false ;

                           public boolean isZipOrPostalCodeSpecified(){
                               return localZipOrPostalCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getZipOrPostalCode(){
                               return localZipOrPostalCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZipOrPostalCode
                               */
                               public void setZipOrPostalCode(java.lang.String param){
                            localZipOrPostalCodeTracker = true;
                                   
                                            this.localZipOrPostalCode=param;
                                    

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
                           namespacePrefix+":Business",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Business",
                           xmlWriter);
                   }

               
                   }
                if (localAddressLine1Tracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "AddressLine1", xmlWriter);
                             

                                          if (localAddressLine1==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAddressLine1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAddressLine2Tracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "AddressLine2", xmlWriter);
                             

                                          if (localAddressLine2==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAddressLine2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBusinessImageIconTracker){
                                    if (localBusinessImageIcon==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "BusinessImageIcon", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localBusinessImageIcon.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","BusinessImageIcon"),
                                        xmlWriter);
                                    }
                                } if (localCityTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "City", xmlWriter);
                             

                                          if (localCity==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCity);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCountryOrRegionTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "CountryOrRegion", xmlWriter);
                             

                                          if (localCountryOrRegion==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCountryOrRegion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "Description", xmlWriter);
                             

                                          if (localDescription==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDescription);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localEmailTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "Email", xmlWriter);
                             

                                          if (localEmail==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEmail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localGeoCodeStatusTracker){
                                    if (localGeoCodeStatus==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "GeoCodeStatus", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localGeoCodeStatus.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","GeoCodeStatus"),
                                        xmlWriter);
                                    }
                                } if (localHrsOfOperationTracker){
                                    if (localHrsOfOperation==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "HrsOfOperation", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localHrsOfOperation.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","HrsOfOperation"),
                                        xmlWriter);
                                    }
                                } if (localIdTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "Id", xmlWriter);
                             
                                               if (localId==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsOpen24HoursTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "IsOpen24Hours", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsOpen24Hours cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsOpen24Hours));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLatitudeDegreesTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "LatitudeDegrees", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localLatitudeDegrees)) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLatitudeDegrees));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLongitudeDegreesTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "LongitudeDegrees", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localLongitudeDegrees)) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLongitudeDegrees));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "Name", xmlWriter);
                             

                                          if (localName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localOtherPaymentTypeDescTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "OtherPaymentTypeDesc", xmlWriter);
                             

                                          if (localOtherPaymentTypeDesc==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOtherPaymentTypeDesc);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPaymentTracker){
                                    if (localPayment==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "Payment", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localPayment.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Payment"),
                                        xmlWriter);
                                    }
                                } if (localPhoneTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "Phone", xmlWriter);
                             

                                          if (localPhone==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPhone);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStateOrProvinceTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "StateOrProvince", xmlWriter);
                             

                                          if (localStateOrProvince==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStateOrProvince);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusTracker){
                                    if (localStatus==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/v8", "Status", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localStatus.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Status"),
                                        xmlWriter);
                                    }
                                } if (localURLTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "URL", xmlWriter);
                             

                                          if (localURL==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localURL);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localZipOrPostalCodeTracker){
                                    namespace = "https://adcenter.microsoft.com/v8";
                                    writeStartElement(null, namespace, "ZipOrPostalCode", xmlWriter);
                             

                                          if (localZipOrPostalCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localZipOrPostalCode);
                                            
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

                 if (localAddressLine1Tracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "AddressLine1"));
                                 
                                         elementList.add(localAddressLine1==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddressLine1));
                                    } if (localAddressLine2Tracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "AddressLine2"));
                                 
                                         elementList.add(localAddressLine2==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddressLine2));
                                    } if (localBusinessImageIconTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "BusinessImageIcon"));
                            
                            
                                    elementList.add(localBusinessImageIcon==null?null:
                                    localBusinessImageIcon);
                                } if (localCityTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "City"));
                                 
                                         elementList.add(localCity==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCity));
                                    } if (localCountryOrRegionTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "CountryOrRegion"));
                                 
                                         elementList.add(localCountryOrRegion==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCountryOrRegion));
                                    }
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Description"));
                                 
                                         elementList.add(localDescription==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
                                     if (localEmailTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Email"));
                                 
                                         elementList.add(localEmail==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmail));
                                    } if (localGeoCodeStatusTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "GeoCodeStatus"));
                            
                            
                                    elementList.add(localGeoCodeStatus==null?null:
                                    localGeoCodeStatus);
                                } if (localHrsOfOperationTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "HrsOfOperation"));
                            
                            
                                    elementList.add(localHrsOfOperation==null?null:
                                    localHrsOfOperation);
                                } if (localIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                            } if (localIsOpen24HoursTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "IsOpen24Hours"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsOpen24Hours));
                            } if (localLatitudeDegreesTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "LatitudeDegrees"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLatitudeDegrees));
                            } if (localLongitudeDegreesTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "LongitudeDegrees"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLongitudeDegrees));
                            }
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Name"));
                                 
                                         elementList.add(localName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
                                     if (localOtherPaymentTypeDescTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "OtherPaymentTypeDesc"));
                                 
                                         elementList.add(localOtherPaymentTypeDesc==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOtherPaymentTypeDesc));
                                    } if (localPaymentTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Payment"));
                            
                            
                                    elementList.add(localPayment==null?null:
                                    localPayment);
                                } if (localPhoneTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Phone"));
                                 
                                         elementList.add(localPhone==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhone));
                                    } if (localStateOrProvinceTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "StateOrProvince"));
                                 
                                         elementList.add(localStateOrProvince==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStateOrProvince));
                                    } if (localStatusTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "Status"));
                            
                            
                                    elementList.add(localStatus==null?null:
                                    localStatus);
                                } if (localURLTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "URL"));
                                 
                                         elementList.add(localURL==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localURL));
                                    } if (localZipOrPostalCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                                      "ZipOrPostalCode"));
                                 
                                         elementList.add(localZipOrPostalCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localZipOrPostalCode));
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
        public static Business parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Business object =
                new Business();

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
                    
                            if (!"Business".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Business)com.microsoft.adcenter.v8.imports.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","AddressLine1").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAddressLine1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","AddressLine2").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAddressLine2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","BusinessImageIcon").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setBusinessImageIcon(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setBusinessImageIcon(com.microsoft.adcenter.v8.BusinessImageIcon.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","City").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCity(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","CountryOrRegion").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCountryOrRegion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Description").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Email").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEmail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","GeoCodeStatus").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setGeoCodeStatus(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setGeoCodeStatus(com.microsoft.adcenter.v8.BusinessGeoCodeStatus.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","HrsOfOperation").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setHrsOfOperation(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setHrsOfOperation(com.microsoft.adcenter.v8.ArrayOfHoursOfOperation.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Id").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setId(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setId(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","IsOpen24Hours").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsOpen24Hours" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsOpen24Hours(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","LatitudeDegrees").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLatitudeDegrees(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setLatitudeDegrees(java.lang.Double.NaN);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setLatitudeDegrees(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","LongitudeDegrees").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLongitudeDegrees(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setLongitudeDegrees(java.lang.Double.NaN);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setLongitudeDegrees(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Name").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","OtherPaymentTypeDesc").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOtherPaymentTypeDesc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Payment").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setPayment(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setPayment(com.microsoft.adcenter.v8.ArrayOfPaymentType.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Phone").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPhone(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","StateOrProvince").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStateOrProvince(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","Status").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setStatus(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setStatus(com.microsoft.adcenter.v8.BusinessStatus.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","URL").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setURL(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ZipOrPostalCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setZipOrPostalCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
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
           
    