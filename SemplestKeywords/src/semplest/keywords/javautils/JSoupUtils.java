package semplest.keywords.javautils;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

import scala.actors.threadpool.Arrays;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class JSoupUtils {

	/**
	 * Utils to use JSoup HTML parser
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		
        String url = "http://www.shopping.hp.com/en_US/home-office/-/products/Printers/Printers";
        print("Fetching %s...", url);
        JSoupUtils jSoup = new JSoupUtils();
        Document doc = Jsoup.connect(url).get();
        PrintStream pr= new PrintStream(new FileOutputStream("/home/lluis/tagInfo.txt"));
        //get all media sources
        List<String> media = getMediaSource(doc);
        //get all imports sources
        List<String> imports = getImportsSource(doc);
        //get all imports sources
        List<String> link = getLinks(doc);
        // fetch the specified URL and parse to a HTML DOM
        String plainText = jSoup.getPlainText(doc);
        System.out.println(plainText);
        Map<String, List<String>> tagMap = jSoup.getTagContent(doc);
        System.out.println("Tags created: ");
        for(String tag : tagMap.keySet()){
        	System.out.println(tag);
        	pr.println("-> "+ tag);
        	for(String line : tagMap.get(tag)){
        		pr.println("\t\t"+ line);
        	}
        }
        
    }
	
	
	
	//Returns a list of all the links in the primary Url
	public static List<String> getLinks(Element element){
		Set<String> linkSet = getLinksMap(element).keySet();
        return Arrays.asList(linkSet.toArray(new String[linkSet.size()]));
	}
	public static List<String> getLinks(String url) throws IOException{
		JSoupUtils jSoup = new JSoupUtils();
        Document doc = Jsoup.connect(url).get();
        return getLinks(doc);
	}
	
	//Returns a list of all the links in the primary Url
	public static Map<String, String> getLinksMap(Element element){
		Map<String, String> linksM = new HashMap<String, String>();
		Elements links = element.select("a[href]");
		print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            linksM.put(link.attr("abs:href"), link.text());
            print(" * %s: <%s>", link.text(), link.attr("abs:href"));
        }
        return linksM;
	}
	
	public static Map<String, String> getLinksMap(String url) throws IOException{
		JSoupUtils jSoup = new JSoupUtils();
        Document doc = Jsoup.connect(url).get();
        return getLinksMap(doc);
	}
	
	//Returns a list all the media sources
	public static List<String> getMediaSource(Element element){
		List<String> mediaL = new ArrayList<String>();
		Elements media = element.select("[src]");
		print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                print(" * %s: <%s> %sx%s (%s)",
                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                        trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
            mediaL.add(src.attr("abs:src"));
        }
        return mediaL;
	}
	
	public static List<String> getMediaSource(String url) throws IOException{
		JSoupUtils jSoup = new JSoupUtils();
        Document doc = Jsoup.connect(url).get();
        return getMediaSource(doc);
	}
	
	//Returns a list the import sources
	public static List<String> getImportsSource(Element element){
		List<String> importL = new ArrayList<String>();
		Elements imports = element.select("link[href]");
		print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
            String text =link.text();
            importL.add(link.attr("abs:href"));
        }
        return importL;
	}
	public static List<String> getImportsSource(String url) throws IOException{
		JSoupUtils jSoup = new JSoupUtils();
        Document doc = Jsoup.connect(url).get();
        return getImportsSource(doc);
	}
	
	
	//Returns plain text of specidified url
    public static String getPlainText(Element element) {
        FormattingVisitor formatter = new FormattingVisitor();
        NodeTraversor traversor = new NodeTraversor(formatter);
        traversor.traverse(element); // walk the DOM, and call .head() and .tail() for each node

        return formatter.toString();
    }
    
    // Returns a map with each of the tags in the document and a list of all the content lines withing that tag
    public static Map<String, List<String>> getTagContent(Element element) {
        TagFormattingVisitor tagFormatter = new TagFormattingVisitor();
        NodeTraversor traversor = new NodeTraversor(tagFormatter);
        traversor.traverse(element); // walk the DOM, and call .head() and .tail() for each node
        return tagFormatter.getTagContentMap();
    }
    
    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
    
    // the formatting rules, implemented in a depth-first DOM traverse
    private static class TagFormattingVisitor implements NodeVisitor {
    	public Map<String, List<String>> tagContentMap = new HashMap<String, List<String>>();
    	public String[] tagTarget;
    	//public List<String> acum = new ArrayList<String>();
    	public Stack<List<String>> stack = new Stack<List<String>>();
    	
    	public TagFormattingVisitor(){
    	}
    	public TagFormattingVisitor(String[] tags){
    		tagTarget = tags;
    		tagContentMap = new HashMap<String, List<String>>(); 
    	}
    	// Get results of Crawl
    	public Map<String, List<String>> getTagContentMap() {
			return tagContentMap;
		}
        
        public void head(Node node, int depth) {
            String name = node.nodeName();
            List<String> lineL = new ArrayList<String>();
            if (node instanceof TextNode){
            	String txt = ((TextNode) node).text();
            	txt = txt.trim();
            	if(txt.length()>1)
            		lineL.add(((TextNode) node).text());
            }
            stack.push(lineL);
        }
        // hit when all of the node's children (if any) have been visited
        public void tail(Node node, int depth) {
        	List<String> selfL = stack.pop();
        	if(!stack.isEmpty()){
        		List<String> parentL = stack.pop();
        		parentL.addAll(selfL);
            	stack.push(parentL);
        	}
        	String name = node.nodeName();
        	if( tagTarget == null || (tagTarget !=null && StringUtil.in(name, tagTarget))){
            	if(tagContentMap.containsKey(name)){
            		tagContentMap.get(name).addAll(selfL);
            	}else{
            		tagContentMap.put(name, selfL);
            	}
            }
        }
    }
  
    
    
    // the formatting rules, implemented in a breadth-first DOM traverse
    private static class FormattingVisitor implements NodeVisitor {
        private StringBuilder accum = new StringBuilder(); // holds the accumulated text

        // hit when the node is first seen
        public void head(Node node, int depth) {
            String name = node.nodeName();
            if (node instanceof TextNode)
                append(((TextNode) node).text()); // TextNodes carry all user-readable text in the DOM.
            else if (name.equals("li"))
                append("\n");
        }

        // hit when all of the node's children (if any) have been visited
        public void tail(Node node, int depth) {
            String name = node.nodeName();
            if (name.equals("br"))
                append("\n");
            else if (StringUtil.in(name, "p", "h1", "h2", "h3", "h4", "h5"))
                append("\n\n");
        }

        // appends text to the string builder with a simple word wrap method
        private void append(String text) {
            if (text.startsWith("\n"))
            if (text.equals(" ") &&
                    (accum.length() == 0 || StringUtil.in(accum.substring(accum.length() - 1), " ", "\n")))
                return; // don't accumulate long runs of empty spaces
                accum.append(text);
            
        }

        public String toString() {
            return accum.toString();
        }
    }

}
