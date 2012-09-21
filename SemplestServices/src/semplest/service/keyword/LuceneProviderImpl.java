package semplest.service.keyword;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import semplest.util.SemplestUtils;

public class LuceneProviderImpl implements LuceneProvider
{
	private static final Logger logger = Logger.getLogger(LuceneProviderImpl.class);

	private final IndexSearcher searcher;
	private final QueryParser parser;
	private final Version version;
	
	public static void main(final String[] args) throws Exception
	{
		final KeywordProperties properties = new KeywordPropertiesImpl();
		final String log4jPropertyFile = properties.getLog4jPropertyFile();
		PropertyConfigurator.configure(log4jPropertyFile);
		final String luceneDirectory = properties.getLuceneDirectory();
		final String dmozDescriptionFile = properties.getDmozDescriptionFile();
		final LuceneProvider luceneProvider = new LuceneProviderImpl(luceneDirectory, dmozDescriptionFile);
		final Integer targetNumCategories = properties.getTargetNumCategories();
		final String searchTerm = "wedding dress";
		final List<String> results = luceneProvider.search(searchTerm, targetNumCategories);
		logger.info("\n" + SemplestUtils.getEasilyReadableString(results));
	}
	
	public LuceneProviderImpl(final String luceneDirectory, final String dmozDescriptionFile) throws Exception
	{
		version = Version.LUCENE_36;
		try
		{
			final StandardAnalyzer analyzer = new StandardAnalyzer(version);
			final File luceneDirectoryFile = new File(luceneDirectory);
			final Directory directory = FSDirectory.open(luceneDirectoryFile);
			final IndexReader reader = IndexReader.open(directory);
			searcher = new IndexSearcher(reader);
			parser = new QueryParser(version, "desc", analyzer);
		}
		catch (Exception e)
		{
			final String errMsg = "Problem setting up the LuceneProviderImpl";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}
	
	public List<String> search(String queryString, int numResults) throws Exception
	{
		final Query q = parser.parse(queryString);
		final TopDocs topDocs = searcher.search(q, null, numResults);
		final ScoreDoc[] hits = topDocs.scoreDocs;
		final List<String> results = new ArrayList<String>();
		for (int i = 0; i < hits.length; i++)
		{
			final int docId = hits[i].doc;
			final Document document = searcher.doc(docId);
			final String result = document.get("cat");
			results.add(result);
		}
		return results;
	}
	
}

