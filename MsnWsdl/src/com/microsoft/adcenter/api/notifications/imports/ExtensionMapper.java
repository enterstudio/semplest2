
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package com.microsoft.adcenter.api.notifications.imports;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "char".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization._char.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "BudgetDepletedNotification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.BudgetDepletedNotification.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "ExpiredCreditCardNotification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.ExpiredCreditCardNotification.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "CampaignInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.CampaignInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "Notification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.Notification.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adapi.microsoft.com".equals(namespaceURI) &&
                  "AdApiError".equals(typeName)){
                   
                            return  com.microsoft.adapi.AdApiError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "ArrayOfOperationError".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.ArrayOfOperationError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "NotificationType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.NotificationType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "ArrayOfLowBudgetBalanceCampaignInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.ArrayOfLowBudgetBalanceCampaignInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "OperationError".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.OperationError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "AccountNotification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.AccountNotification.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "CreditCardPendingExpirationNotification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.CreditCardPendingExpirationNotification.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "ArrayOfBudgetDepletedCampaignInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.ArrayOfBudgetDepletedCampaignInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "ExpiredInsertionOrderNotification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.ExpiredInsertionOrderNotification.Factory.parse(reader);
                        

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
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "ApiFault".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.ApiFault.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "guid".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.Guid.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "EditorialRejectionNotification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.EditorialRejectionNotification.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "duration".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.Duration.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "BudgetDepletedCampaignInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.BudgetDepletedCampaignInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "LowBudgetBalanceCampaignInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.LowBudgetBalanceCampaignInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adapi.microsoft.com".equals(namespaceURI) &&
                  "AdApiFaultDetail".equals(typeName)){
                   
                            return  com.microsoft.adapi.AdApiFaultDetail.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "NotificationType_type0".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.NotificationType_type0.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "LowBudgetBalanceNotification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.LowBudgetBalanceNotification.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/notifications/Entities".equals(namespaceURI) &&
                  "ArrayOfNotification".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.notifications.entities.ArrayOfNotification.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    