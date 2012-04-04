package semplest.keywords.javautils;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

// Uses Lucene to search the Dmoz description database
public class DmozLucene {

final static String hfile = "../SemplestKeywords/dmoz/all/hCounts.new";
final static String dfile = "../SemplestKeywords/dmoz/all/all.descs";

  IndexWriter w;
  StandardAnalyzer analyzer;
  Directory index;

  public DmozLucene(){
    // Specify the analyzer for tokenizing text.
    // (The same analyzer should be used for indexing and searching)
    try {
      analyzer = new StandardAnalyzer(Version.LUCENE_35);

      // 1. create the index
      index = new RAMDirectory();

      IndexWriterConfig config = new IndexWriterConfig(
          Version.LUCENE_35, analyzer);
      w = new IndexWriter(index, config);
    } catch (Exception e ){
      e.printStackTrace();
    }
  }

  // --------
  // add the description data to the database
  void add( String cat, String desc ){
    try {
      Document doc = new Document();
      doc.add(new Field("cat", cat, Field.Store.YES, Field.Index.ANALYZED));
      doc.add(new Field("desc", desc, Field.Store.YES, Field.Index.ANALYZED));
      w.addDocument(doc);
    } catch (Exception e ){
      e.printStackTrace();
    }
  }
  // done adding words
  void done(){ 
    try {
      w.close(); 
    } catch (Exception e ){
      e.printStackTrace();
    }
  }
  public void loadDesc(){
	  //Indexes description information
	    HashMap<String,String> map = ioUtils.readDescs( dfile );
	    for(Map.Entry<String,String> e : map.entrySet())
	      this.add( e.getKey(), e.getValue() );
	    this.done();
  }
  // ---------
  public String[] search(String qs ){

    // the "desc" arg specifies the default field to use
    // when no field is explicitly specified in the query.
    String[] res = new String[0];
    try {
    	res = search(qs, 10);
    } catch (Exception e ){
      e.printStackTrace();
    }
    return res;
  }
  
  public String[] search(String qs, int hitsPerPage){
	// Query returning any number of results.the "desc" arg specifies the default field to use
	// when no field is explicitly specified in the query.
	  String[] res = new String[0];
	    try {
	      Query qp = new QueryParser(Version.LUCENE_35,"desc",analyzer).parse(qs); 

	      // Search

	      IndexSearcher searcher = new IndexSearcher(index, true);
	      TopScoreDocCollector collector = TopScoreDocCollector.
	        create(hitsPerPage, true);
	      searcher.search(qp, collector);
	      ScoreDoc[] hits = collector.topDocs().scoreDocs;

	      res = new String[hits.length];
	      for(int i=0;i<hits.length;++i) {
	        int docId = hits[i].doc;
	        Document d = searcher.doc(docId);
	        res[i] = d.get("cat");
	      }
	      searcher.close();
	    } catch (Exception e ){
	      e.printStackTrace();
	    }
	    return res;
  }

  // ---------------------
  public static void main(String[] args) throws IOException, ParseException {
    DmozLucene dl = new DmozLucene();
    HashMap<String,String> map = ioUtils.readDescs( hfile );
    for(Map.Entry<String,String> e : map.entrySet())
      dl.add( e.getKey(), e.getValue() );
    dl.done();

      Console c = System.console();
      while( true ){
        c.printf(" > ");
        String q = c.readLine();
        if( q.length() > 5 ) {
          String[] res = dl.search( q );
          for( String re : res )
            c.printf("%s\n", re );
        }
      }
  }
}
