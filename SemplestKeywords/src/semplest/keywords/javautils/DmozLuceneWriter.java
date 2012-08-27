package semplest.keywords.javautils;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.Document;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.util.*;
import org.apache.lucene.store.*;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import semplest.keywords.properties.ProjectProperties;

// import semplest.keywords.properties.ProjectProperties;
// Uses Lucene to search the Dmoz description database
public class DmozLuceneWriter {

  final static String LuceneDir = ProjectProperties.lucenedir;
  final static String DmozDescFile = ProjectProperties.lucenedfile;

  IndexSearcher searcher;
  QueryParser parser;

  // - Public Interface -------------------------
  // Ctr --------------
  public DmozLuceneWriter(){
    try {
      StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
      Directory directory = FSDirectory.open( new File( LuceneDir ));
      IndexReader reader = IndexReader.open( directory );
      searcher = new IndexSearcher( reader );
      parser = new QueryParser(Version.LUCENE_CURRENT, "desc", analyzer );
    } catch (Exception e ){
      e.printStackTrace();
    }
  }
  public static void createDescIndex() throws Exception {
    System.out.print("Creating Dmoz Lucene Index...");
    StandardAnalyzer analyzer = new StandardAnalyzer( Version.LUCENE_35 );
    Directory directory = FSDirectory.open( new File( LuceneDir ));
    IndexWriter writer = new IndexWriter( directory, analyzer, true,
        new IndexWriter.MaxFieldLength( 256000) );

    System.out.println(".."+DmozDescFile+"..");
    Map<String,String> map = readDescs( DmozDescFile );
    for(Map.Entry<String,String> e : map.entrySet())
      writer.addDocument( mkDoc( e.getKey(), e.getValue() ));
    writer.close(); 
    System.out.println("...done");
  }
  public String[] search(String qs, int nresults ) throws Exception {
    Query q = parser.parse(qs); 
    ScoreDoc[] hits = searcher.search(q, null, nresults).scoreDocs;
    String[] res = new String[ hits.length ];
    for(int i=0; i < hits.length; i++)
      res[i] = (searcher.doc( hits[ i ].doc )).get("cat");
    return res;
  }

  // - Privates -------
  // utilities to add the description data to the database
  private static Document mkDoc( String cat, String desc ) throws Exception {
    Document doc = new Document();
    doc.add(new Field("cat", cat, Field.Store.YES, Field.Index.ANALYZED));
    doc.add(new Field("desc", desc, Field.Store.YES, Field.Index.ANALYZED));
    return doc;
  }
  private static Map<String,String> readDescs( String f) throws Exception {
    Map<String,String> map = new HashMap<String,String>();
    BufferedReader r = new BufferedReader(new FileReader( f ));
    String line;
    while(( line =  r.readLine()) != null ){
      String[] cols = line.split(" : ");
      if( cols.length >= 2 )
        map.put( cols[0].trim(), cols[1].trim() );
    }
    return map;
  }


  // - Test Helpers ---------------
  public static void interactiveTest() throws Exception {
    DmozLuceneWriter dl = new DmozLuceneWriter();

    Console c = System.console();
    while( true ){
      c.printf(" > ");
      String q = c.readLine();
      if( q.length() > 0 ) {
        String[] res = dl.search( q, 10 );
        for( String re : res )
          c.printf("%s\n", re );
      }
    }
  }

  //-------------------------------
  public static void main(String[] args) throws Exception {
    //    createDescIndex();
    DmozLuceneWriter dl = new DmozLuceneWriter();
    String[] res = dl.search( args[0], 10 );
    System.out.println("Dmoz searcher returned " + res.length + " matches");
    for( String re : res ) 
      System.out.println(re );
  }
}
