package semplest.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import semplest.other.AdCenterCredentials;
import semplest.other.AdCenterCredentialsProduction;
import semplest.other.TimeServer;
import semplest.other.TimeServerImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.services.client.interfaces.MsnAdcenterServiceInterface;

import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.Ad;
import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.Target;
import com.microsoft.adcenter.v8.TextAd;

public class TestMSN
{
	private MsnAdcenterServiceInterface msnCloudService;
	private Long msnCloudAccountId;
	private Long msnCustomerId;
	private Account account;
	private Campaign[] campaigns;
	private List<AdGroup> adGroups;
	private Set<Keyword> keywords = new HashSet<Keyword>();
	private Set<Ad> ads = new HashSet<Ad>();
	private List<Target> targets = new ArrayList<Target>();
	
	private static final Long msnAccountId = 800609L; // THIS IS A REAL VENDOR ID !!! SEMPLESTg6phzn6t http://www.highlandhtsfloral.com

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		AdCenterCredentials adCenterCredentials = new AdCenterCredentialsProduction();
		TimeServer timeServer = new TimeServerImpl();
		MsnAdcenterServiceInterface msnCloudService = new MsnCloudServiceImpl(adCenterCredentials,timeServer);

		TestMSN test = new TestMSN();
		try
		{
			test.MsnQueryCoreData(msnCloudService,  msnAccountId, 0L);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void MsnQueryCoreData(MsnAdcenterServiceInterface msnCloudService, Long msnCloudAccountId, Long msnCustomerId) throws Exception
	{
		this.msnCloudService = msnCloudService;
		this.msnCloudAccountId = msnCloudAccountId;
		this.msnCustomerId = msnCustomerId;
		account = msnCloudService.getAccountById(msnCloudAccountId);
		System.out.println("account: " + account.getName() + ":" + account.getId());
		campaigns = msnCloudService.getCampaignsByAccountId(msnCloudAccountId);

		adGroups = new ArrayList<AdGroup>();
		for (Campaign campaign : campaigns)
		{
			AdGroup[] adGroupsByCampaignId = msnCloudService.getAdGroupsByCampaignId(msnCloudAccountId, campaign.getId());
			System.out.println("CampaignID=" + campaign.getId() + ":" + campaign.getName() + ":" + campaign.getDescription() + ":" + campaign.getDailyBudget());
			adGroups.addAll(Arrays.asList(adGroupsByCampaignId));
		}
		
		for (AdGroup adGroup : adGroups)
		{
			System.out.println("Add Group: " + adGroup.getName() + ":" + adGroup.getId());
			Keyword[] allKeywords = msnCloudService.getKeywordByAdGroupId(msnCloudAccountId, adGroup.getId());
			for (int i = 0; i < allKeywords.length; i++)
			{
				System.out.println(allKeywords[i].getText());
			}
			keywords.addAll(Arrays.asList(allKeywords));
		}
		for (AdGroup adGroup : adGroups)
		{
			Target adGroupTarget = msnCloudService.getAdGroupTargets(msnCloudAccountId, msnCustomerId, adGroup.getId());
			if (adGroupTarget != null)
			{
				System.out.println(adGroupTarget.getName());
			}
			targets.add(adGroupTarget);
		}
		for (AdGroup adGroup : adGroups)
		{
			Ad[] allAds = msnCloudService.getAdsByAdGroupId(msnCloudAccountId, adGroup.getId());
			for (int i = 0; i < allAds.length; i++)
			{
				TextAd adtext = (TextAd) allAds[i];
				System.out.println(adtext.getDisplayUrl() + ":" + adtext.getTitle() + ':' + adtext.getText());
			}
			ads.addAll(Arrays.asList(allAds));
		}
		

	}

}
