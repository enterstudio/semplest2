package semplest.keywords.javautils;

import org.htmlparser.lexer.Lexer;
import org.htmlparser.Node;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.ParserException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;
import java.net.URL;

// Uses Google's autocomplete service to get keyword suggestions and volume

public class XmlUtils {

  // - The interface ----------
  // Uses builtin Dom parser (same as getSuggestions)
  public static HashMap<String,Integer> autoCompletes (String query) {
    HashMap<String,Integer> res = new HashMap<String,Integer>();
    try {
      DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
      DocumentBuilder b = f.newDocumentBuilder();
      Document d = b.parse( acUrl( query ));
      NodeList l = d.getElementsByTagName("CompleteSuggestion");
      for(int i = 0; i < l.getLength(); i++ ){
        Element s = (Element) l.item( i ).getFirstChild();
        Element n = (Element) l.item( i ).getLastChild();
        res.put( s.getAttribute( "data" ), 
            Integer.decode( n.getAttribute( "int" )));
      }
    } catch (Exception e) { e.printStackTrace(); }
    return res;
  }

  // Uses HtmlLexer (needs to be compiled with htmllexer.jar)
  public static HashMap<String,Integer> getSuggestions (String query) {
    HashMap<String,Integer> res = new HashMap<String,Integer>();

    // parse the xml using the lexer
    String sug = null;
    Integer count = 0;
    try {
      Lexer l = new Lexer( ( new URL( acUrl( query ) ) ).openConnection() );
      TagNode tn = null;
      while (( tn = (TagNode) l.nextNode() ) != null ){
        sug   = tn.getAttribute("data") != null ? 
                tn.getAttribute("data") : sug;
        count = tn.getAttribute("int") != null ? 
          Integer.decode( tn.getAttribute("int")) : 0;
        if( count != 0)
          res.put( sug, count );
      }
    } catch (Exception e) { e.printStackTrace(); }
    return res;
  }
 
  // - Helpers -------------------
  // The url
  private static String acUrl(String query){
    String burl = "http://google.com/complete/search?output=toolbar&q=";
    return  burl + ioUtils.mkString( query.split("\\s+"),"+");
  }

  //-------------------------------------------------------------
  public static void main (String[] args){
    if( args.length  < 1 ) return;
    //  HashMap<String,Integer> res = getSuggestions( args[0] );
    HashMap<String,Integer> res = autoCompletes( args[0] );
    for( Map.Entry<String,Integer> e : res.entrySet())
      System.out.println( e.getKey() + " : " + e.getValue() );
  }
}
