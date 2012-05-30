
/**
 * CurrencyType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.microsoft.adcenter.api.customermanagement.entities;
            

            /**
            *  CurrencyType bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class CurrencyType
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "https://adcenter.microsoft.com/api/customermanagement/Entities",
                "CurrencyType",
                "ns6");

            

                        /**
                        * field for CurrencyType
                        */

                        
                                    protected java.lang.String localCurrencyType ;
                                
                            private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
                            
                                protected CurrencyType(java.lang.String value, boolean isRegisterValue) {
                                    localCurrencyType = value;
                                    if (isRegisterValue){
                                        
                                               _table_.put(localCurrencyType, this);
                                           
                                    }

                                }
                            
                                    public static final java.lang.String _AlgerianDinar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AlgerianDinar");
                                
                                    public static final java.lang.String _ArgentinePeso =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ArgentinePeso");
                                
                                    public static final java.lang.String _ArmenianDram =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ArmenianDram");
                                
                                    public static final java.lang.String _AustralianDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AustralianDollar");
                                
                                    public static final java.lang.String _AzerbaijanianManat =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AzerbaijanianManat");
                                
                                    public static final java.lang.String _BahrainiDinar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BahrainiDinar");
                                
                                    public static final java.lang.String _Baht =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Baht");
                                
                                    public static final java.lang.String _Balboa =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Balboa");
                                
                                    public static final java.lang.String _BelarussianRuble =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BelarussianRuble");
                                
                                    public static final java.lang.String _BelizeDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BelizeDollar");
                                
                                    public static final java.lang.String _Bolivar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Bolivar");
                                
                                    public static final java.lang.String _Boliviano =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Boliviano");
                                
                                    public static final java.lang.String _BrazilianReal =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BrazilianReal");
                                
                                    public static final java.lang.String _BruneiDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BruneiDollar");
                                
                                    public static final java.lang.String _CanadianDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CanadianDollar");
                                
                                    public static final java.lang.String _ChileanPeso =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ChileanPeso");
                                
                                    public static final java.lang.String _ColombianPeso =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ColombianPeso");
                                
                                    public static final java.lang.String _CordobaOro =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CordobaOro");
                                
                                    public static final java.lang.String _CostaRicanColon =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CostaRicanColon");
                                
                                    public static final java.lang.String _Croatiankuna =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Croatiankuna");
                                
                                    public static final java.lang.String _CzechKoruna =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CzechKoruna");
                                
                                    public static final java.lang.String _DanishKrone =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DanishKrone");
                                
                                    public static final java.lang.String _Denar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Denar");
                                
                                    public static final java.lang.String _DominicanPeso =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DominicanPeso");
                                
                                    public static final java.lang.String _Dong =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Dong");
                                
                                    public static final java.lang.String _EgyptianPound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EgyptianPound");
                                
                                    public static final java.lang.String _Euro =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Euro");
                                
                                    public static final java.lang.String _Forint =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Forint");
                                
                                    public static final java.lang.String _Guarani =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Guarani");
                                
                                    public static final java.lang.String _HongKongDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("HongKongDollar");
                                
                                    public static final java.lang.String _Hryvnia =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Hryvnia");
                                
                                    public static final java.lang.String _IcelandKrona =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("IcelandKrona");
                                
                                    public static final java.lang.String _IndianRupee =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("IndianRupee");
                                
                                    public static final java.lang.String _IranianRial =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("IranianRial");
                                
                                    public static final java.lang.String _IraqiDinar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("IraqiDinar");
                                
                                    public static final java.lang.String _JamaicanDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("JamaicanDollar");
                                
                                    public static final java.lang.String _JapaneseYen =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("JapaneseYen");
                                
                                    public static final java.lang.String _JordanianDinar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("JordanianDinar");
                                
                                    public static final java.lang.String _KenyanShilling =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KenyanShilling");
                                
                                    public static final java.lang.String _Kroon =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Kroon");
                                
                                    public static final java.lang.String _KuwaitiDinar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KuwaitiDinar");
                                
                                    public static final java.lang.String _Lari =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Lari");
                                
                                    public static final java.lang.String _LatvianLats =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("LatvianLats");
                                
                                    public static final java.lang.String _LebanesePound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("LebanesePound");
                                
                                    public static final java.lang.String _Lek =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Lek");
                                
                                    public static final java.lang.String _Lempira =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Lempira");
                                
                                    public static final java.lang.String _Leu =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Leu");
                                
                                    public static final java.lang.String _Lev =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Lev");
                                
                                    public static final java.lang.String _LibyanDinar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("LibyanDinar");
                                
                                    public static final java.lang.String _LithuanianLitus =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("LithuanianLitus");
                                
                                    public static final java.lang.String _MalaysianRinggit =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("MalaysianRinggit");
                                
                                    public static final java.lang.String _MexicanPeso =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("MexicanPeso");
                                
                                    public static final java.lang.String _MoroccanDirham =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("MoroccanDirham");
                                
                                    public static final java.lang.String _NewIsraeliSheqel =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NewIsraeliSheqel");
                                
                                    public static final java.lang.String _NewTaiwanDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NewTaiwanDollar");
                                
                                    public static final java.lang.String _NewZealandDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NewZealandDollar");
                                
                                    public static final java.lang.String _NorwegianKrone =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NorwegianKrone");
                                
                                    public static final java.lang.String _NuevoSol =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NuevoSol");
                                
                                    public static final java.lang.String _PakistanRupee =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PakistanRupee");
                                
                                    public static final java.lang.String _Pataca =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Pataca");
                                
                                    public static final java.lang.String _PesoUruguayo =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PesoUruguayo");
                                
                                    public static final java.lang.String _PhilippinePeso =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PhilippinePeso");
                                
                                    public static final java.lang.String _QatariRial =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("QatariRial");
                                
                                    public static final java.lang.String _Quetzal =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Quetzal");
                                
                                    public static final java.lang.String _RialOmani =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("RialOmani");
                                
                                    public static final java.lang.String _Rufiyaa =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Rufiyaa");
                                
                                    public static final java.lang.String _Rupiah =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Rupiah");
                                
                                    public static final java.lang.String _RussianRuble =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("RussianRuble");
                                
                                    public static final java.lang.String _SaudiRiyal =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SaudiRiyal");
                                
                                    public static final java.lang.String _SingaporeDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SingaporeDollar");
                                
                                    public static final java.lang.String _SlovakKoruna =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SlovakKoruna");
                                
                                    public static final java.lang.String _Som =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Som");
                                
                                    public static final java.lang.String _SouthAfricanRand =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SouthAfricanRand");
                                
                                    public static final java.lang.String _SwedishKrona =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SwedishKrona");
                                
                                    public static final java.lang.String _SwissFranc =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SwissFranc");
                                
                                    public static final java.lang.String _SyrianPound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SyrianPound");
                                
                                    public static final java.lang.String _Tenge =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Tenge");
                                
                                    public static final java.lang.String _Tolar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Tolar");
                                
                                    public static final java.lang.String _TrinidadandTobagoDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TrinidadandTobagoDollar");
                                
                                    public static final java.lang.String _Tugrik =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Tugrik");
                                
                                    public static final java.lang.String _TunisianDinar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TunisianDinar");
                                
                                    public static final java.lang.String _TurkishLira =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TurkishLira");
                                
                                    public static final java.lang.String _UAEDirham =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UAEDirham");
                                
                                    public static final java.lang.String _UKPound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UKPound");
                                
                                    public static final java.lang.String _USDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("USDollar");
                                
                                    public static final java.lang.String _UzbekistanSum =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UzbekistanSum");
                                
                                    public static final java.lang.String _Won =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Won");
                                
                                    public static final java.lang.String _YemeniRial =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("YemeniRial");
                                
                                    public static final java.lang.String _YuanRenminbi =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("YuanRenminbi");
                                
                                    public static final java.lang.String _YugoslavianNewDinar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("YugoslavianNewDinar");
                                
                                    public static final java.lang.String _ZimbabweDollar =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ZimbabweDollar");
                                
                                    public static final java.lang.String _Zloty =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Zloty");
                                
                                public static final CurrencyType AlgerianDinar =
                                    new CurrencyType(_AlgerianDinar,true);
                            
                                public static final CurrencyType ArgentinePeso =
                                    new CurrencyType(_ArgentinePeso,true);
                            
                                public static final CurrencyType ArmenianDram =
                                    new CurrencyType(_ArmenianDram,true);
                            
                                public static final CurrencyType AustralianDollar =
                                    new CurrencyType(_AustralianDollar,true);
                            
                                public static final CurrencyType AzerbaijanianManat =
                                    new CurrencyType(_AzerbaijanianManat,true);
                            
                                public static final CurrencyType BahrainiDinar =
                                    new CurrencyType(_BahrainiDinar,true);
                            
                                public static final CurrencyType Baht =
                                    new CurrencyType(_Baht,true);
                            
                                public static final CurrencyType Balboa =
                                    new CurrencyType(_Balboa,true);
                            
                                public static final CurrencyType BelarussianRuble =
                                    new CurrencyType(_BelarussianRuble,true);
                            
                                public static final CurrencyType BelizeDollar =
                                    new CurrencyType(_BelizeDollar,true);
                            
                                public static final CurrencyType Bolivar =
                                    new CurrencyType(_Bolivar,true);
                            
                                public static final CurrencyType Boliviano =
                                    new CurrencyType(_Boliviano,true);
                            
                                public static final CurrencyType BrazilianReal =
                                    new CurrencyType(_BrazilianReal,true);
                            
                                public static final CurrencyType BruneiDollar =
                                    new CurrencyType(_BruneiDollar,true);
                            
                                public static final CurrencyType CanadianDollar =
                                    new CurrencyType(_CanadianDollar,true);
                            
                                public static final CurrencyType ChileanPeso =
                                    new CurrencyType(_ChileanPeso,true);
                            
                                public static final CurrencyType ColombianPeso =
                                    new CurrencyType(_ColombianPeso,true);
                            
                                public static final CurrencyType CordobaOro =
                                    new CurrencyType(_CordobaOro,true);
                            
                                public static final CurrencyType CostaRicanColon =
                                    new CurrencyType(_CostaRicanColon,true);
                            
                                public static final CurrencyType Croatiankuna =
                                    new CurrencyType(_Croatiankuna,true);
                            
                                public static final CurrencyType CzechKoruna =
                                    new CurrencyType(_CzechKoruna,true);
                            
                                public static final CurrencyType DanishKrone =
                                    new CurrencyType(_DanishKrone,true);
                            
                                public static final CurrencyType Denar =
                                    new CurrencyType(_Denar,true);
                            
                                public static final CurrencyType DominicanPeso =
                                    new CurrencyType(_DominicanPeso,true);
                            
                                public static final CurrencyType Dong =
                                    new CurrencyType(_Dong,true);
                            
                                public static final CurrencyType EgyptianPound =
                                    new CurrencyType(_EgyptianPound,true);
                            
                                public static final CurrencyType Euro =
                                    new CurrencyType(_Euro,true);
                            
                                public static final CurrencyType Forint =
                                    new CurrencyType(_Forint,true);
                            
                                public static final CurrencyType Guarani =
                                    new CurrencyType(_Guarani,true);
                            
                                public static final CurrencyType HongKongDollar =
                                    new CurrencyType(_HongKongDollar,true);
                            
                                public static final CurrencyType Hryvnia =
                                    new CurrencyType(_Hryvnia,true);
                            
                                public static final CurrencyType IcelandKrona =
                                    new CurrencyType(_IcelandKrona,true);
                            
                                public static final CurrencyType IndianRupee =
                                    new CurrencyType(_IndianRupee,true);
                            
                                public static final CurrencyType IranianRial =
                                    new CurrencyType(_IranianRial,true);
                            
                                public static final CurrencyType IraqiDinar =
                                    new CurrencyType(_IraqiDinar,true);
                            
                                public static final CurrencyType JamaicanDollar =
                                    new CurrencyType(_JamaicanDollar,true);
                            
                                public static final CurrencyType JapaneseYen =
                                    new CurrencyType(_JapaneseYen,true);
                            
                                public static final CurrencyType JordanianDinar =
                                    new CurrencyType(_JordanianDinar,true);
                            
                                public static final CurrencyType KenyanShilling =
                                    new CurrencyType(_KenyanShilling,true);
                            
                                public static final CurrencyType Kroon =
                                    new CurrencyType(_Kroon,true);
                            
                                public static final CurrencyType KuwaitiDinar =
                                    new CurrencyType(_KuwaitiDinar,true);
                            
                                public static final CurrencyType Lari =
                                    new CurrencyType(_Lari,true);
                            
                                public static final CurrencyType LatvianLats =
                                    new CurrencyType(_LatvianLats,true);
                            
                                public static final CurrencyType LebanesePound =
                                    new CurrencyType(_LebanesePound,true);
                            
                                public static final CurrencyType Lek =
                                    new CurrencyType(_Lek,true);
                            
                                public static final CurrencyType Lempira =
                                    new CurrencyType(_Lempira,true);
                            
                                public static final CurrencyType Leu =
                                    new CurrencyType(_Leu,true);
                            
                                public static final CurrencyType Lev =
                                    new CurrencyType(_Lev,true);
                            
                                public static final CurrencyType LibyanDinar =
                                    new CurrencyType(_LibyanDinar,true);
                            
                                public static final CurrencyType LithuanianLitus =
                                    new CurrencyType(_LithuanianLitus,true);
                            
                                public static final CurrencyType MalaysianRinggit =
                                    new CurrencyType(_MalaysianRinggit,true);
                            
                                public static final CurrencyType MexicanPeso =
                                    new CurrencyType(_MexicanPeso,true);
                            
                                public static final CurrencyType MoroccanDirham =
                                    new CurrencyType(_MoroccanDirham,true);
                            
                                public static final CurrencyType NewIsraeliSheqel =
                                    new CurrencyType(_NewIsraeliSheqel,true);
                            
                                public static final CurrencyType NewTaiwanDollar =
                                    new CurrencyType(_NewTaiwanDollar,true);
                            
                                public static final CurrencyType NewZealandDollar =
                                    new CurrencyType(_NewZealandDollar,true);
                            
                                public static final CurrencyType NorwegianKrone =
                                    new CurrencyType(_NorwegianKrone,true);
                            
                                public static final CurrencyType NuevoSol =
                                    new CurrencyType(_NuevoSol,true);
                            
                                public static final CurrencyType PakistanRupee =
                                    new CurrencyType(_PakistanRupee,true);
                            
                                public static final CurrencyType Pataca =
                                    new CurrencyType(_Pataca,true);
                            
                                public static final CurrencyType PesoUruguayo =
                                    new CurrencyType(_PesoUruguayo,true);
                            
                                public static final CurrencyType PhilippinePeso =
                                    new CurrencyType(_PhilippinePeso,true);
                            
                                public static final CurrencyType QatariRial =
                                    new CurrencyType(_QatariRial,true);
                            
                                public static final CurrencyType Quetzal =
                                    new CurrencyType(_Quetzal,true);
                            
                                public static final CurrencyType RialOmani =
                                    new CurrencyType(_RialOmani,true);
                            
                                public static final CurrencyType Rufiyaa =
                                    new CurrencyType(_Rufiyaa,true);
                            
                                public static final CurrencyType Rupiah =
                                    new CurrencyType(_Rupiah,true);
                            
                                public static final CurrencyType RussianRuble =
                                    new CurrencyType(_RussianRuble,true);
                            
                                public static final CurrencyType SaudiRiyal =
                                    new CurrencyType(_SaudiRiyal,true);
                            
                                public static final CurrencyType SingaporeDollar =
                                    new CurrencyType(_SingaporeDollar,true);
                            
                                public static final CurrencyType SlovakKoruna =
                                    new CurrencyType(_SlovakKoruna,true);
                            
                                public static final CurrencyType Som =
                                    new CurrencyType(_Som,true);
                            
                                public static final CurrencyType SouthAfricanRand =
                                    new CurrencyType(_SouthAfricanRand,true);
                            
                                public static final CurrencyType SwedishKrona =
                                    new CurrencyType(_SwedishKrona,true);
                            
                                public static final CurrencyType SwissFranc =
                                    new CurrencyType(_SwissFranc,true);
                            
                                public static final CurrencyType SyrianPound =
                                    new CurrencyType(_SyrianPound,true);
                            
                                public static final CurrencyType Tenge =
                                    new CurrencyType(_Tenge,true);
                            
                                public static final CurrencyType Tolar =
                                    new CurrencyType(_Tolar,true);
                            
                                public static final CurrencyType TrinidadandTobagoDollar =
                                    new CurrencyType(_TrinidadandTobagoDollar,true);
                            
                                public static final CurrencyType Tugrik =
                                    new CurrencyType(_Tugrik,true);
                            
                                public static final CurrencyType TunisianDinar =
                                    new CurrencyType(_TunisianDinar,true);
                            
                                public static final CurrencyType TurkishLira =
                                    new CurrencyType(_TurkishLira,true);
                            
                                public static final CurrencyType UAEDirham =
                                    new CurrencyType(_UAEDirham,true);
                            
                                public static final CurrencyType UKPound =
                                    new CurrencyType(_UKPound,true);
                            
                                public static final CurrencyType USDollar =
                                    new CurrencyType(_USDollar,true);
                            
                                public static final CurrencyType UzbekistanSum =
                                    new CurrencyType(_UzbekistanSum,true);
                            
                                public static final CurrencyType Won =
                                    new CurrencyType(_Won,true);
                            
                                public static final CurrencyType YemeniRial =
                                    new CurrencyType(_YemeniRial,true);
                            
                                public static final CurrencyType YuanRenminbi =
                                    new CurrencyType(_YuanRenminbi,true);
                            
                                public static final CurrencyType YugoslavianNewDinar =
                                    new CurrencyType(_YugoslavianNewDinar,true);
                            
                                public static final CurrencyType ZimbabweDollar =
                                    new CurrencyType(_ZimbabweDollar,true);
                            
                                public static final CurrencyType Zloty =
                                    new CurrencyType(_Zloty,true);
                            

                                public java.lang.String getValue() { return localCurrencyType;}

                                public boolean equals(java.lang.Object obj) {return (obj == this);}
                                public int hashCode() { return toString().hashCode();}
                                public java.lang.String toString() {
                                
                                        return localCurrencyType.toString();
                                    

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
                                           namespacePrefix+":CurrencyType",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "CurrencyType",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localCurrencyType==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("CurrencyType cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localCurrencyType);
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCurrencyType)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static CurrencyType fromValue(java.lang.String value)
                      throws java.lang.IllegalArgumentException {
                    CurrencyType enumeration = (CurrencyType)
                       
                               _table_.get(value);
                           

                    if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    return enumeration;
                }
                public static CurrencyType fromString(java.lang.String value,java.lang.String namespaceURI)
                      throws java.lang.IllegalArgumentException {
                    try {
                       
                                       return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                                   

                    } catch (java.lang.Exception e) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }

                public static CurrencyType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return CurrencyType.Factory.fromString(content,namespaceUri);
                    } else {
                       return CurrencyType.Factory.fromString(content,"");
                    }
                }
            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static CurrencyType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            CurrencyType object = null;
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
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"CurrencyType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                        if (content.indexOf(":") > 0) {
                                            // this seems to be a Qname so find the namespace and send
                                            prefix = content.substring(0, content.indexOf(":"));
                                            namespaceuri = reader.getNamespaceURI(prefix);
                                            object = CurrencyType.Factory.fromString(content,namespaceuri);
                                        } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                            // check is done in fromString method
                                            object = CurrencyType.Factory.fromString(content,"");
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
           
    