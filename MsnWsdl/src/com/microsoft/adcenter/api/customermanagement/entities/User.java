
/**
 * User.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.microsoft.adcenter.api.customermanagement.entities;
            

            /**
            *  User bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class User
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = User
                Namespace URI = https://adcenter.microsoft.com/api/customermanagement/Entities
                Namespace Prefix = ns6
                */
            

                        /**
                        * field for ContactInfo
                        */

                        
                                    protected com.microsoft.adcenter.api.customermanagement.entities.ContactInfo localContactInfo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContactInfoTracker = false ;

                           public boolean isContactInfoSpecified(){
                               return localContactInfoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.api.customermanagement.entities.ContactInfo
                           */
                           public  com.microsoft.adcenter.api.customermanagement.entities.ContactInfo getContactInfo(){
                               return localContactInfo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContactInfo
                               */
                               public void setContactInfo(com.microsoft.adcenter.api.customermanagement.entities.ContactInfo param){
                            localContactInfoTracker = true;
                                   
                                            this.localContactInfo=param;
                                    

                               }
                            

                        /**
                        * field for CustomerAppScope
                        */

                        
                                    protected com.microsoft.adcenter.api.customermanagement.entities.ApplicationType localCustomerAppScope ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCustomerAppScopeTracker = false ;

                           public boolean isCustomerAppScopeSpecified(){
                               return localCustomerAppScopeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.api.customermanagement.entities.ApplicationType
                           */
                           public  com.microsoft.adcenter.api.customermanagement.entities.ApplicationType getCustomerAppScope(){
                               return localCustomerAppScope;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CustomerAppScope
                               */
                               public void setCustomerAppScope(com.microsoft.adcenter.api.customermanagement.entities.ApplicationType param){
                            localCustomerAppScopeTracker = true;
                                   
                                            this.localCustomerAppScope=param;
                                    

                               }
                            

                        /**
                        * field for CustomerId
                        */

                        
                                    protected long localCustomerId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCustomerIdTracker = false ;

                           public boolean isCustomerIdSpecified(){
                               return localCustomerIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getCustomerId(){
                               return localCustomerId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CustomerId
                               */
                               public void setCustomerId(long param){
                            localCustomerIdTracker = true;
                                   
                                            this.localCustomerId=param;
                                    

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
                        * field for JobTitle
                        */

                        
                                    protected java.lang.String localJobTitle ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localJobTitleTracker = false ;

                           public boolean isJobTitleSpecified(){
                               return localJobTitleTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getJobTitle(){
                               return localJobTitle;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JobTitle
                               */
                               public void setJobTitle(java.lang.String param){
                            localJobTitleTracker = true;
                                   
                                            this.localJobTitle=param;
                                    

                               }
                            

                        /**
                        * field for LastModifiedByUserId
                        */

                        
                                    protected long localLastModifiedByUserId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLastModifiedByUserIdTracker = false ;

                           public boolean isLastModifiedByUserIdSpecified(){
                               return localLastModifiedByUserIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getLastModifiedByUserId(){
                               return localLastModifiedByUserId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastModifiedByUserId
                               */
                               public void setLastModifiedByUserId(long param){
                            localLastModifiedByUserIdTracker = true;
                                   
                                            this.localLastModifiedByUserId=param;
                                    

                               }
                            

                        /**
                        * field for LastModifiedTime
                        */

                        
                                    protected java.util.Calendar localLastModifiedTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLastModifiedTimeTracker = false ;

                           public boolean isLastModifiedTimeSpecified(){
                               return localLastModifiedTimeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getLastModifiedTime(){
                               return localLastModifiedTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastModifiedTime
                               */
                               public void setLastModifiedTime(java.util.Calendar param){
                            localLastModifiedTimeTracker = true;
                                   
                                            this.localLastModifiedTime=param;
                                    

                               }
                            

                        /**
                        * field for Lcid
                        */

                        
                                    protected com.microsoft.adcenter.api.customermanagement.entities.LCID localLcid ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLcidTracker = false ;

                           public boolean isLcidSpecified(){
                               return localLcidTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.api.customermanagement.entities.LCID
                           */
                           public  com.microsoft.adcenter.api.customermanagement.entities.LCID getLcid(){
                               return localLcid;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Lcid
                               */
                               public void setLcid(com.microsoft.adcenter.api.customermanagement.entities.LCID param){
                            localLcidTracker = true;
                                   
                                            this.localLcid=param;
                                    

                               }
                            

                        /**
                        * field for Name
                        */

                        
                                    protected com.microsoft.adcenter.api.customermanagement.entities.PersonName localName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNameTracker = false ;

                           public boolean isNameSpecified(){
                               return localNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.api.customermanagement.entities.PersonName
                           */
                           public  com.microsoft.adcenter.api.customermanagement.entities.PersonName getName(){
                               return localName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Name
                               */
                               public void setName(com.microsoft.adcenter.api.customermanagement.entities.PersonName param){
                            localNameTracker = true;
                                   
                                            this.localName=param;
                                    

                               }
                            

                        /**
                        * field for Password
                        */

                        
                                    protected java.lang.String localPassword ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPasswordTracker = false ;

                           public boolean isPasswordSpecified(){
                               return localPasswordTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPassword(){
                               return localPassword;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Password
                               */
                               public void setPassword(java.lang.String param){
                            localPasswordTracker = true;
                                   
                                            this.localPassword=param;
                                    

                               }
                            

                        /**
                        * field for SecretAnswer
                        */

                        
                                    protected java.lang.String localSecretAnswer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSecretAnswerTracker = false ;

                           public boolean isSecretAnswerSpecified(){
                               return localSecretAnswerTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSecretAnswer(){
                               return localSecretAnswer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SecretAnswer
                               */
                               public void setSecretAnswer(java.lang.String param){
                            localSecretAnswerTracker = true;
                                   
                                            this.localSecretAnswer=param;
                                    

                               }
                            

                        /**
                        * field for SecretQuestion
                        */

                        
                                    protected com.microsoft.adcenter.api.customermanagement.entities.SecretQuestion localSecretQuestion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSecretQuestionTracker = false ;

                           public boolean isSecretQuestionSpecified(){
                               return localSecretQuestionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.api.customermanagement.entities.SecretQuestion
                           */
                           public  com.microsoft.adcenter.api.customermanagement.entities.SecretQuestion getSecretQuestion(){
                               return localSecretQuestion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SecretQuestion
                               */
                               public void setSecretQuestion(com.microsoft.adcenter.api.customermanagement.entities.SecretQuestion param){
                            localSecretQuestionTracker = param != null;
                                   
                                            this.localSecretQuestion=param;
                                    

                               }
                            

                        /**
                        * field for UserLifeCycleStatus
                        */

                        
                                    protected com.microsoft.adcenter.api.customermanagement.entities.UserLifeCycleStatus localUserLifeCycleStatus ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUserLifeCycleStatusTracker = false ;

                           public boolean isUserLifeCycleStatusSpecified(){
                               return localUserLifeCycleStatusTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.adcenter.api.customermanagement.entities.UserLifeCycleStatus
                           */
                           public  com.microsoft.adcenter.api.customermanagement.entities.UserLifeCycleStatus getUserLifeCycleStatus(){
                               return localUserLifeCycleStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UserLifeCycleStatus
                               */
                               public void setUserLifeCycleStatus(com.microsoft.adcenter.api.customermanagement.entities.UserLifeCycleStatus param){
                            localUserLifeCycleStatusTracker = true;
                                   
                                            this.localUserLifeCycleStatus=param;
                                    

                               }
                            

                        /**
                        * field for TimeStamp
                        */

                        
                                    protected javax.activation.DataHandler localTimeStamp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTimeStampTracker = false ;

                           public boolean isTimeStampSpecified(){
                               return localTimeStampTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getTimeStamp(){
                               return localTimeStamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TimeStamp
                               */
                               public void setTimeStamp(javax.activation.DataHandler param){
                            localTimeStampTracker = true;
                                   
                                            this.localTimeStamp=param;
                                    

                               }
                            

                        /**
                        * field for UserName
                        */

                        
                                    protected java.lang.String localUserName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUserNameTracker = false ;

                           public boolean isUserNameSpecified(){
                               return localUserNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUserName(){
                               return localUserName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UserName
                               */
                               public void setUserName(java.lang.String param){
                            localUserNameTracker = true;
                                   
                                            this.localUserName=param;
                                    

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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"https://adcenter.microsoft.com/api/customermanagement/Entities");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":User",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "User",
                           xmlWriter);
                   }

               
                   }
                if (localContactInfoTracker){
                                    if (localContactInfo==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/api/customermanagement/Entities", "ContactInfo", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localContactInfo.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","ContactInfo"),
                                        xmlWriter);
                                    }
                                } if (localCustomerAppScopeTracker){
                                    if (localCustomerAppScope==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerAppScope", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localCustomerAppScope.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","CustomerAppScope"),
                                        xmlWriter);
                                    }
                                } if (localCustomerIdTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "CustomerId", xmlWriter);
                             
                                               if (localCustomerId==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCustomerId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIdTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "Id", xmlWriter);
                             
                                               if (localId==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localJobTitleTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "JobTitle", xmlWriter);
                             

                                          if (localJobTitle==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localJobTitle);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLastModifiedByUserIdTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "LastModifiedByUserId", xmlWriter);
                             
                                               if (localLastModifiedByUserId==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastModifiedByUserId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLastModifiedTimeTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "LastModifiedTime", xmlWriter);
                             

                                          if (localLastModifiedTime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastModifiedTime));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLcidTracker){
                                    if (localLcid==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/api/customermanagement/Entities", "Lcid", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localLcid.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","Lcid"),
                                        xmlWriter);
                                    }
                                } if (localNameTracker){
                                    if (localName==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/api/customermanagement/Entities", "Name", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localName.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","Name"),
                                        xmlWriter);
                                    }
                                } if (localPasswordTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "Password", xmlWriter);
                             

                                          if (localPassword==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPassword);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSecretAnswerTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "SecretAnswer", xmlWriter);
                             

                                          if (localSecretAnswer==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSecretAnswer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSecretQuestionTracker){
                                            if (localSecretQuestion==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SecretQuestion cannot be null!!");
                                            }
                                           localSecretQuestion.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","SecretQuestion"),
                                               xmlWriter);
                                        } if (localUserLifeCycleStatusTracker){
                                    if (localUserLifeCycleStatus==null){

                                        writeStartElement(null, "https://adcenter.microsoft.com/api/customermanagement/Entities", "UserLifeCycleStatus", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localUserLifeCycleStatus.serialize(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","UserLifeCycleStatus"),
                                        xmlWriter);
                                    }
                                } if (localTimeStampTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "TimeStamp", xmlWriter);
                             
                                        
                                    if (localTimeStamp!=null)  {
                                       try {
                                           org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localTimeStamp, null, true);
                                       } catch (java.io.IOException ex) {
                                           throw new javax.xml.stream.XMLStreamException("Unable to read data handler for TimeStamp", ex);
                                       }
                                    } else {
                                         
                                             writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                         
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             } if (localUserNameTracker){
                                    namespace = "https://adcenter.microsoft.com/api/customermanagement/Entities";
                                    writeStartElement(null, namespace, "UserName", xmlWriter);
                             

                                          if (localUserName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUserName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
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


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localContactInfoTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "ContactInfo"));
                            
                            
                                    elementList.add(localContactInfo==null?null:
                                    localContactInfo);
                                } if (localCustomerAppScopeTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "CustomerAppScope"));
                            
                            
                                    elementList.add(localCustomerAppScope==null?null:
                                    localCustomerAppScope);
                                } if (localCustomerIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "CustomerId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCustomerId));
                            } if (localIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "Id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                            } if (localJobTitleTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "JobTitle"));
                                 
                                         elementList.add(localJobTitle==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localJobTitle));
                                    } if (localLastModifiedByUserIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "LastModifiedByUserId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastModifiedByUserId));
                            } if (localLastModifiedTimeTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "LastModifiedTime"));
                                 
                                         elementList.add(localLastModifiedTime==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastModifiedTime));
                                    } if (localLcidTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "Lcid"));
                            
                            
                                    elementList.add(localLcid==null?null:
                                    localLcid);
                                } if (localNameTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "Name"));
                            
                            
                                    elementList.add(localName==null?null:
                                    localName);
                                } if (localPasswordTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "Password"));
                                 
                                         elementList.add(localPassword==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPassword));
                                    } if (localSecretAnswerTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "SecretAnswer"));
                                 
                                         elementList.add(localSecretAnswer==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSecretAnswer));
                                    } if (localSecretQuestionTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "SecretQuestion"));
                            
                            
                                    if (localSecretQuestion==null){
                                         throw new org.apache.axis2.databinding.ADBException("SecretQuestion cannot be null!!");
                                    }
                                    elementList.add(localSecretQuestion);
                                } if (localUserLifeCycleStatusTracker){
                            elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "UserLifeCycleStatus"));
                            
                            
                                    elementList.add(localUserLifeCycleStatus==null?null:
                                    localUserLifeCycleStatus);
                                } if (localTimeStampTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                        "TimeStamp"));
                                
                            elementList.add(localTimeStamp);
                        } if (localUserNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities",
                                                                      "UserName"));
                                 
                                         elementList.add(localUserName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUserName));
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
        public static User parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            User object =
                new User();

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
                    
                            if (!"User".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (User)com.microsoft.adcenter.api.customermanagement.imports.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","ContactInfo").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setContactInfo(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setContactInfo(com.microsoft.adcenter.api.customermanagement.entities.ContactInfo.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","CustomerAppScope").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setCustomerAppScope(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setCustomerAppScope(com.microsoft.adcenter.api.customermanagement.entities.ApplicationType.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","CustomerId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCustomerId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setCustomerId(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setCustomerId(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","Id").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","JobTitle").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setJobTitle(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","LastModifiedByUserId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastModifiedByUserId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setLastModifiedByUserId(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setLastModifiedByUserId(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","LastModifiedTime").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastModifiedTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","Lcid").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setLcid(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setLcid(com.microsoft.adcenter.api.customermanagement.entities.LCID.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","Name").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setName(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setName(com.microsoft.adcenter.api.customermanagement.entities.PersonName.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","Password").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPassword(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","SecretAnswer").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSecretAnswer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","SecretQuestion").equals(reader.getName())){
                                
                                                object.setSecretQuestion(com.microsoft.adcenter.api.customermanagement.entities.SecretQuestion.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","UserLifeCycleStatus").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setUserLifeCycleStatus(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setUserLifeCycleStatus(com.microsoft.adcenter.api.customermanagement.entities.UserLifeCycleStatus.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","TimeStamp").equals(reader.getName())){
                                
                                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                        if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                             object.setTimeStamp(null);
                                             reader.next();
                                        } else {
                                    
                                            object.setTimeStamp(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));
                                    
                                        }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities","UserName").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUserName(
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
           
    