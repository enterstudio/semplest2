
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package com.microsoft.adcenter.api.customermanagement.imports;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfAccountInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfAccountInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "TimeZoneType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.TimeZoneType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "char".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization._char.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "CustomerLifeCycleStatus".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.CustomerLifeCycleStatus.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ContactInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ContactInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "Industry".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.Industry.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "ArrayOfOperationError".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.ArrayOfOperationError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "AccountInfoWithCustomerData".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.AccountInfoWithCustomerData.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ApplicationType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ApplicationType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "AccountFinancialStatus".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.AccountFinancialStatus.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "CurrencyType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.CurrencyType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "UserLifeCycleStatus".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.UserLifeCycleStatus.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "UserRole".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.UserRole.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfManageAccountsRequestInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfManageAccountsRequestInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "Date".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.Date.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "EmailFormat".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.EmailFormat.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ManageAccountsRequestStatus".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ManageAccountsRequestStatus.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "AccountType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.AccountType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "ApiFault".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.ApiFault.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "User".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.User.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ManageAccountsRequest".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ManageAccountsRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/Arrays".equals(namespaceURI) &&
                  "ArrayOfint".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfUserInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfUserInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "AccountInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.AccountInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "PersonName".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.PersonName.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfManageAccountsRequestType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfManageAccountsRequestType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ManageAccountsRequestType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ManageAccountsRequestType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "UserInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.UserInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "LanguageType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.LanguageType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "Address".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.Address.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adapi.microsoft.com".equals(namespaceURI) &&
                  "AdApiError".equals(typeName)){
                   
                            return  com.microsoft.adapi.AdApiError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "PublisherAccount".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.PublisherAccount.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ManageAccountsRequestInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ManageAccountsRequestInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfManageAccountsRequestStatus".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfManageAccountsRequestStatus.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "LCID".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.LCID.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "Customer".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.Customer.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "AccountLifeCycleStatus".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.AccountLifeCycleStatus.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "OperationError".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.OperationError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfAccountInfoWithCustomerData".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfAccountInfoWithCustomerData.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "PilotFeature".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.PilotFeature.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "CustomerInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.CustomerInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "PaymentMethodType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.PaymentMethodType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "AdvertiserAccount".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.AdvertiserAccount.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "CustomerFinancialStatus".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.CustomerFinancialStatus.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ServiceLevel".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ServiceLevel.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfPilotFeature".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfPilotFeature.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/Arrays".equals(namespaceURI) &&
                  "ArrayOfstring".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adapi.microsoft.com".equals(namespaceURI) &&
                  "ArrayOfAdApiError".equals(typeName)){
                   
                            return  com.microsoft.adapi.ArrayOfAdApiError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adapi.microsoft.com".equals(namespaceURI) &&
                  "ApplicationFault".equals(typeName)){
                   
                            return  com.microsoft.adapi.ApplicationFault.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "SecretQuestion".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.SecretQuestion.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "guid".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.Guid.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "duration".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.Duration.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/Arrays".equals(namespaceURI) &&
                  "ArrayOflong".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOflong.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adapi.microsoft.com".equals(namespaceURI) &&
                  "AdApiFaultDetail".equals(typeName)){
                   
                            return  com.microsoft.adapi.AdApiFaultDetail.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "Account".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.Account.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfCustomerInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfCustomerInfo.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    