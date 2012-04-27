package google;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import com.google.api.adwords.lib.AdWordsService;
import com.google.api.adwords.lib.AdWordsServiceLogger;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.utils.MapUtils;
import com.google.api.adwords.v201101.cm.ApiException;
import com.google.api.adwords.v201101.cm.Keyword;
import com.google.api.adwords.v201101.cm.KeywordMatchType;
import com.google.api.adwords.v201101.cm.Paging;
import com.google.api.adwords.v201101.o.Attribute;
import com.google.api.adwords.v201101.o.AttributeType;
import com.google.api.adwords.v201101.o.CriterionAttribute;
import com.google.api.adwords.v201101.o.IdeaType;
import com.google.api.adwords.v201101.o.KeywordMatchTypeSearchParameter;
import com.google.api.adwords.v201101.o.LongAttribute;
import com.google.api.adwords.v201101.o.RelatedToKeywordSearchParameter;
import com.google.api.adwords.v201101.o.RequestType;
import com.google.api.adwords.v201101.o.SearchParameter;
import com.google.api.adwords.v201101.o.TargetingIdea;
import com.google.api.adwords.v201101.o.TargetingIdeaPage;
import com.google.api.adwords.v201101.o.TargetingIdeaSelector;
import com.google.api.adwords.v201101.o.TargetingIdeaServiceInterface;

/**
 * This example gets keywords related to a seed keyword.
 * 
 * Tags: TargetingIdeaService.get
 * 
 * @author api.arogal@gmail.com (Adam Rogal)
 */
public class GetRelatedKeywords
{
	private String email = "adwords@semplest.com";
	private String password = "ic0system";
	private String userAgent = "Icosystem";
	private String developerToken = "2H8l6aUm6K_Q44vDvxs3Og";
	private boolean useSandbox = false;
	String searchTerm = null; // "florist";
	private AdWordsUser user = null;

	// private String developerToken = email + "++USD";
	// private boolean useSandbox = true;

	public GetRelatedKeywords(String searchStr) throws Exception
	{
		this.searchTerm = searchStr;
		if (this.searchTerm == null)
		{
			throw new Exception("Must imput a valid seed to find keywords");
		}
		user = new AdWordsUser(email, password, null, userAgent,
				developerToken, useSandbox);
	}

	public ArrayList<String> getRelatedKeywords() throws ApiException,
			RemoteException, ServiceException
	{
		// Get the TargetingIdeaService.
		TargetingIdeaServiceInterface targetingIdeaService = user
				.getService(AdWordsService.V201101.TARGETING_IDEA_SERVICE);

		// Create seed keyword.
		Keyword keyword = new Keyword();
		keyword.setText(searchTerm);
		keyword.setMatchType(KeywordMatchType.BROAD);

		// Create selector.
		TargetingIdeaSelector selector = new TargetingIdeaSelector();
		selector.setRequestType(RequestType.IDEAS);
		selector.setIdeaType(IdeaType.KEYWORD);
		selector.setRequestedAttributeTypes(new AttributeType[]
		{ AttributeType.CRITERION,
				AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES });

		// Set selector paging (required for targeting idea service).
		Paging paging = new Paging();
		paging.setStartIndex(0);
		paging.setNumberResults(10);
		selector.setPaging(paging);

		// Create related to keyword search parameter.
		RelatedToKeywordSearchParameter relatedToKeywordSearchParameter = new RelatedToKeywordSearchParameter();
		com.google.api.adwords.v201101.cm.Keyword keywordRequest = new com.google.api.adwords.v201101.cm.Keyword();
		keywordRequest.setText(keyword.getText());
		keywordRequest.setMatchType(KeywordMatchType.BROAD);
		relatedToKeywordSearchParameter
				.setKeywords(new com.google.api.adwords.v201101.cm.Keyword[]
				{ keywordRequest });

		// Create keyword match type search parameter to ensure unique
		// results.
		KeywordMatchTypeSearchParameter keywordMatchTypeSearchParameter = new KeywordMatchTypeSearchParameter();
		keywordMatchTypeSearchParameter
				.setKeywordMatchTypes(new KeywordMatchType[]
				{ KeywordMatchType.EXACT });

		// CompetitionSearchParameter competitionSearchParameter = new
		// CompetitionSearchParameter();
		// competitionSearchParameter.setLevels(new
		// CompetitionSearchParameterLevel[] {
		// CompetitionSearchParameterLevel.MEDIUM });

		// selector.setSearchParameters(new SearchParameter[] {
		// relatedToKeywordSearchParameter, keywordMatchTypeSearchParameter,
		// competitionSearchParameter });
		selector.setSearchParameters(new SearchParameter[]
		{ relatedToKeywordSearchParameter, keywordMatchTypeSearchParameter });

		// Get related keywords.
		TargetingIdeaPage page = targetingIdeaService.get(selector);
		if (page.getTotalNumEntries() == 0)
		{
			System.out.println("no suggestions found for " + keyword);
			// return new ArrayList<KeywordSuggestion>();
		}
		ArrayList<String> kdWords = new ArrayList<String>();
		for (TargetingIdea targetingIdea : page.getEntries())
		{
			Map<AttributeType, Attribute> data = MapUtils.toMap(targetingIdea
					.getData());
			CriterionAttribute criterionAttribute = (CriterionAttribute) data
					.get(AttributeType.CRITERION);
			com.google.api.adwords.v201101.cm.Keyword keywordIdea = (com.google.api.adwords.v201101.cm.Keyword) criterionAttribute
					.getValue();
			Long averageMonthlySearches = ((LongAttribute) data
					.get(AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES))
					.getValue();
			System.out.println("Keyword with text '" + keywordIdea.getText()
					+ "', match type '" + keywordIdea.getMatchType()
					+ "', and average monthly search volume '"
					+ averageMonthlySearches + "' was found.");
			int avgMonthlySearch = 0;
			if (averageMonthlySearches != null)
			{
				avgMonthlySearch = averageMonthlySearches.intValue();
			}
			kdWords.add(keywordIdea.getText());

		}
		return kdWords;

	}

	public static void main(String[] args)
	{
		try
		{
			// Log SOAP XML request and response.
			AdWordsServiceLogger.log();

			GetRelatedKeywords getRelatedKeywords = null;
			if (args.length > 0)
			{
				getRelatedKeywords = new GetRelatedKeywords(args[0]);
			}
			else
			{
				System.out.println("You must input an initial keyword seed");
				return;
			}
			ArrayList<String> res = getRelatedKeywords.getRelatedKeywords();
			for (String aKeywrd : res)
			{
				System.out.println(aKeywrd);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
