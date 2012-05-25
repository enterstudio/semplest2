/*
 * !BEGIN_LICENSE: Copyright 2009 Icosystem Corporation. All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * :END_LICENSE!
 */
/*
 * Original file: ChartBuilderCodeGenerator.java
 * Original project: ico
 * Original name: com.icosystem.gfx.chart.builder.ChartBuilderCodeGenerator
 * Created on: Oct 28, 2009 3:49:33 PM
 * Created by: kristian
 */
package semplest.service.msn.adcenter;

// import static com.icosystem.core.util.builder.BuilderUtil.aBuilder;
// import static com.icosystem.core.util.builder.BuilderUtil.anObject;
// import static com.icosystem.core.util.builder.BuilderUtil.andPackage;
// import static com.icosystem.core.util.builder.BuilderUtil.defaultThis;
// import static com.icosystem.core.util.builder.BuilderUtil.fromClass;
// import static com.icosystem.core.util.builder.BuilderUtil.makeBuilder;
// import static com.icosystem.core.util.builder.BuilderUtil.makeDomainObject;
// import static com.icosystem.core.util.builder.BuilderUtil.packageLocation;
// import static com.icosystem.core.util.builder.BuilderUtil.srcLoc;
// import static com.icosystem.core.util.builder.BuilderUtil.to;
// import static com.icosystem.core.util.builder.BuilderUtil.withBuilderName;
//
// import java.io.File;
//
// import com.microsoft.adcenter.syncapis.AdCenterAccount;
// import com.microsoft.adcenter.syncapis.AdCenterAddress;
// import com.microsoft.adcenter.syncapis.AdCenterContactInfo;
// import com.microsoft.adcenter.syncapis.AdCenterCustomer;
// import com.microsoft.adcenter.syncapis.AdCenterUser;
// import com.microsoft.adcenter.v8.AdGroup;
// import com.microsoft.adcenter.v8.Bid;
// import com.microsoft.adcenter.v8.Campaign;
// import com.microsoft.adcenter.v8.Keyword;
// import com.microsoft.adcenter.v8.KeywordBid;
// import com.microsoft.adcenter.v8.TextAd;

/**
 * This class requires ico.jar which is not needed for anything else in the project so we just leave it commented out
 * for now.
 * 
 * @version $Id$
 * @author kristian
 */
public class MsnAddCenterCodeGenerator {
	
	//	public static void main(String[] args) {
	//		// Where to deposit all the Builders
	//		String packLoc = packageLocation(MsnAddCenterCodeGenerator.class);
	//		String src = "src";
	//		String main = File.separatorChar + "main";
	//		String java = File.separatorChar + "java";
	//		String srcMainJava = src +  main + java;
	//		String srcLoc = srcLoc(srcMainJava, packLoc);
	//		String aNewName = "aNew";
	//		String DomainObjects = "MsnDomainObjects";
	//		String DomainObjectsJava = DomainObjects + ".java";
	//		String aNewNameFull = DomainObjects + "." + aNewName;
	//		String here = srcMainJava;
	//
	//		// The builders to make
	//
	//		// The Account builders
	//		makeBuilder(here, fromClass(AdCenterContactInfo.class), withBuilderName(AdCenterContactInfo.class), andPackage(packLoc), defaultThis("homePhone", to("\"123-456-7890\"")), defaultThis("phone1", to("\"123-456-7890\"")));
	//		makeBuilder(here, fromClass(AdCenterAddress.class), withBuilderName(AdCenterAddress.class), andPackage(packLoc), defaultThis("addressLine1", to("\"462 Broadway\"")), defaultThis("addressLine2", to("\"Floor 6\"")), defaultThis("city", to("\"New York\"")), defaultThis("stateOrProvince", to("\"NY\"")), defaultThis("country", to("CountryCode.US")), defaultThis("zipOrPostalCode", to("\"10013\"")));
	//		makeBuilder(here, fromClass(AdCenterUser.class), withBuilderName(AdCenterUser.class), andPackage(packLoc), defaultThis("userName", to("\"User\"")), defaultThis("firstName", to("\"first name\"")), defaultThis("lastName", to("\"last name\"")), defaultThis("email", to("\"test@icosystem.com\"")), defaultThis("password", to("\"password\"")), defaultThis("languageLCID", to("LCID.EnglishUSA")), defaultThis("secretQuestion", to("SecretQuestions.FavoriteMovie")), defaultThis("secretAnswer", to("\"Star Wars\"")), defaultThis("contactInfo", to(aBuilder(aNewNameFull, AdCenterContactInfo.class))), defaultThis("userAddress", to(aBuilder(aNewNameFull, AdCenterAddress.class))));
	//		makeBuilder(here, fromClass(AdCenterCustomer.class), withBuilderName(AdCenterCustomer.class), andPackage(packLoc), defaultThis("customerName", to("\"customer name\"")), defaultThis("customerAddress", to(aBuilder(aNewNameFull, AdCenterAddress.class))), defaultThis("industryId", to("Industry.Other")), defaultThis("marketId", to("Market.US")));
	//		makeBuilder(here, fromClass(AdCenterAccount.class), withBuilderName(AdCenterAccount.class), andPackage(packLoc), defaultThis("accountName", to("\"unused\"")), defaultThis("preferredLanguageType", to("LanguageType.English")), defaultThis("preferredCurrencyType", to("CurrencyType.USDollar")), defaultThis("status", to("AccountStatus.Active")));
	//
	//		// The Campaign builders
	//		makeBuilder(here, fromClass(Campaign.class), withBuilderName(Campaign.class), andPackage(packLoc), defaultThis("conversionTrackingEnabled", to("false")), defaultThis("name", to("\"Winter clothing\"")), defaultThis("description", to("\"Clothing products for winter\"")), defaultThis("budgetType", to("BudgetLimitType.DailyBudgetWithMaximumMonthlySpend")), defaultThis("monthlyBudget", to("5000.00")), defaultThis("timeZone", to("\"PacificTimeUSCanadaTijuana\"")), defaultThis("daylightSaving", to("true")));
	//
	//		// The Ad builders
	//		makeBuilder(here, fromClass(AdGroup.class), withBuilderName(AdGroup.class), andPackage(packLoc), defaultThis("name", to("\"Ad Group Name\"")), defaultThis("adDistribution", to("new String[]{\"Search\"}")), defaultThis("biddingModel", to("BiddingModel.Keyword")), defaultThis("pricingModel", to("PricingModel.Cpc")), defaultThis("ExactMatchBid", to(anObject(Bid.class, "10.25"))), defaultThis("startDate", to(anObject(com.microsoft.adcenter.v8.Date.class, "1", "1", "2011"))), defaultThis("endDate", to(anObject(com.microsoft.adcenter.v8.Date.class, "31", "12", "2012"))), defaultThis("languageAndRegion", to("\"EnglishUnitedStates\"")));
	//		makeBuilder(here, fromClass(TextAd.class), withBuilderName(TextAd.class), andPackage(packLoc), defaultThis("title", to("\"Alpine Ski House\"")), defaultThis("destinationUrl", to("\"http://www.alpineskihouse.com\"")), defaultThis("displayUrl", to("\"alpineskihouse.com\"")), defaultThis("text", to("\"Alpine Ski House has a great ski selection for you.\"")));
	//		// This is not currently used: makeBuilder(here, fromClass(MobileAd.class), withBuilderName(MobileAd.class), andPackage(packLoc), defaultThis("title", to("\"Alpine Ski House\"")), defaultThis("destinationUrl", to("\"http://www.alpineskihouse.com\"")), defaultThis("displayUrl", to("\"alpineskihouse.com\"")), defaultThis("text", to("\"Alpine Ski House has a great ski selection for you.\"")));
	//
	//		// Keywords
	//		makeBuilder(here, fromClass(Keyword.class), withBuilderName(Keyword.class), andPackage(packLoc), defaultThis("text", to("\"mittens\"")), defaultThis("broadMatchBid", to(anObject(Bid.class, ".50"))), defaultThis("exactMatchBid", to(anObject(Bid.class, "1.50"))));
	//		makeBuilder(here, fromClass(KeywordBid.class), withBuilderName(KeywordBid.class), andPackage(packLoc), defaultThis("broadMatchBid", to("0d")), defaultThis("exactMatchBid", to("0d")), defaultThis("keyword", to("\"keyword\"")), defaultThis("phraseMatchBid", to("0d")));
	//
	//		// The Doman Object Builder
	//		makeDomainObject(srcLoc, packLoc, srcLoc + File.separatorChar + DomainObjectsJava, aNewName);
	//	}
}
