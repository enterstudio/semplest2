
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package com.microsoft.adcenter.api.customerbilling.imports;
        
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
                  "ArrayOfInvoice".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfInvoice.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "char".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization._char.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfInvoiceInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfInvoiceInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "BatchError".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.BatchError.Factory.parse(reader);
                        

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
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "ApiFault".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.ApiFault.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adapi.microsoft.com".equals(namespaceURI) &&
                  "ApplicationFault".equals(typeName)){
                   
                            return  com.microsoft.adapi.ApplicationFault.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "DataType".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.DataType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "guid".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.Guid.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "ArrayOfInsertionOrder".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.ArrayOfInsertionOrder.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                  "duration".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.Duration.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "InvoiceInfo".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.InvoiceInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.microsoft.com/2003/10/Serialization/Arrays".equals(namespaceURI) &&
                  "ArrayOflong".equals(typeName)){
                   
                            return  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOflong.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "ArrayOfBatchError".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.ArrayOfBatchError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adapi.microsoft.com".equals(namespaceURI) &&
                  "AdApiFaultDetail".equals(typeName)){
                   
                            return  com.microsoft.adapi.AdApiFaultDetail.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "Invoice".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.Invoice.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Entities".equals(namespaceURI) &&
                  "InsertionOrder".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.entities.InsertionOrder.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "OperationError".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.OperationError.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://adcenter.microsoft.com/api/customermanagement/Exception".equals(namespaceURI) &&
                  "ApiBatchFault".equals(typeName)){
                   
                            return  com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFault.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    