package semplest.service.keyword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import edu.ucla.sspace.text.PorterStemmer;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.protocol.adengine.GetCategoriesRequest;
import semplest.server.protocol.adengine.GetKeywordsRequest;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.KeywordServiceInterface;
import semplest.util.SemplestUtils;

public class KeywordServiceImpl implements KeywordServiceInterface
{
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(KeywordServiceImpl.class);
	
	private final PorterStemmer porterStemmer;
	
	public KeywordServiceImpl()
	{
		porterStemmer = new PorterStemmer();
	}
	
	public static void main(final String[] args) throws Exception
	{
		final KeywordServiceImpl service = new KeywordServiceImpl();
		final Set<String> searchTerms = new HashSet<String>(Arrays.asList("lypako applicator", "needle mat", "acupressure mat"));
		final GetCategoriesRequest request = new GetCategoriesRequest(searchTerms);
		final List<String> categories = service.getCategories(request);
		logger.info("\n" + SemplestUtils.getEasilyReadableString(categories));
		logger.info("Done");
	}
	
	public String getCategories(String json) throws Exception
	{
		logger.info("JSON [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String requestString = data.get("request");
		final GetCategoriesRequest request = gson.fromJson(requestString, GetCategoriesRequest.class);
		final List<String> res = getCategories(request);
		
		return gson.toJson(res);
	}
	
	public static String checkIsValid(final Set<String> terms)
	{
		if (terms == null || terms.isEmpty())
		{
			return "Terms are empty";
		}
		final int numWords = SemplestUtils.getNumWords(terms, SemplestUtils.WORD_DELIMITER);
		if (numWords < SemplestUtils.NUM_MINIMUM_WORDS)
		{
			return "Number of total words [" + numWords + "] is less than minimum of [" + SemplestUtils.NUM_MINIMUM_WORDS + "]";
		}
		return null;
	}

	@Override
	public List<String> getCategories(final GetCategoriesRequest request) throws Exception
	{
		final String operationDescription = "Get Categories for [" + request + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final Set<String> terms = request.getRelevantTerms();
			final String validationErrorMsg = checkIsValid(terms);
			if (validationErrorMsg != null)
			{
				throw new Exception(validationErrorMsg);
			}
			final Set<String> termsTrimmed = SemplestUtils.getTrimmedNonEmptyStrings(terms);
			final Set<String> termsTrimmedWithoutStopWords = SemplestUtils.removeStopWords(termsTrimmed, SemplestUtils.ALL_COMMON_WORDS);
			final Set<String> termsTrimmedWithoutStopWordsStemmed = stem(termsTrimmedWithoutStopWords);
			return new ArrayList<String>(termsTrimmedWithoutStopWordsStemmed);
		}		
		catch (Exception e)
		{
			final String errMsg = "Problem performing " + operationDescription;
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}
	
	public Set<String> stem(final Set<String> terms)
	{
		final Set<String> stemmedTerms = new HashSet<String>();
		for (final String term : terms)
		{
			final String[] words = term.split("\\s+");
			final Set<String> stemmedWords = new HashSet<String>();
			for (final String word : words)
			{
				final String stemmedWord = stem(word);
				stemmedWords.add(stemmedWord);
			}
			final String stemmedTerm = SemplestUtils.getString(stemmedWords, SemplestUtils.WORD_DELIMITER);
			stemmedTerms.add(stemmedTerm);
		}
		return stemmedTerms;
	}
	
	public String stem(final String word)
	{
		return porterStemmer.stem(word);
	}
	/*
	public static String stem(final String string)
	{
		final TokenStream tokenizerTokenStream = new StandardTokenizer(Version.LUCENE_30, new StringReader(string));
		//final TokenStream stopFilterTokenStream = new StopFilter(Version.LUCENE_30, tokenizerTokenStream, SemplestUtils.ALL_COMMON_WORDS, true);
		final TokenFilter stemFilterTokenStream = new PorterStemFilter(tokenizerTokenStream);
		stemFilterTokenStream.n
		
		
		
		final StringBuilder sb = new StringBuilder();
		
		
	  final TermAttribute termAttr = stemFilterTokenStream.getAttribute(TermAttribute.class);
	    while (tokenStream.incrementToken()) {
	        if (sb.length() > 0) {
	            sb.append(" ");
	        }
	        sb.append(termAttr.term());
	    }
	    return sb.toString();
	}*/
	
	public String getKeywords(String json) throws Exception
	{
		logger.info("JSON [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String requestString = data.get("request");
		final GetKeywordsRequest request = gson.fromJson(requestString, GetKeywordsRequest.class);
		final List<KeywordProbabilityObject> keywords = getKeywords(request);
		return gson.toJson(keywords);
	}

	@Override
	public List<KeywordProbabilityObject> getKeywords(final GetKeywordsRequest request) throws Exception
	{
		final String operationDescription = "Get Keywords for [" + request + "]";
		logger.info("Will try to " + operationDescription);
		
		// TODO: change this 
		return null;
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception
	{
		return ServiceStatus.Up.getServiceStatusValue();
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		logger.info("Starting to initialize");
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		logger.info("Finished initializing");
	}

}
