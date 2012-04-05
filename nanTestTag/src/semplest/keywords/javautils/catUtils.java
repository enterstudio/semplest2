package semplest.keywords.javautils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
 * Utilities to manipulate the dmoz category hierarchy
 * eg: top/recreation/pets/dogs/breeds/herding_group/welsh_corgi/pembroke/pets
 * eg node: breeds
 */
public class catUtils
{
  // return top level (returns "top")
  public static String head( String cat ){
    String[] nodes = cat.split("/");
    if( nodes.length == 0) return "";
    return nodes[0];
  }
  // returns tail (everything but the head)
  // (/recreation/pets/dogs/breeds/herding_group/welsh_corgi/pembroke/pets)
  public static String tail( String cat ){
    String[] nodes = cat.split("/");
    if ( nodes.length < 2) return "";
    return toCat( java.util.Arrays.copyOfRange( nodes, 1, nodes.length ) ); 
  }
  // return last node (returns "pets")
  public static String last( String cat ){
    String[] nodes = cat.split("/");
    if( nodes.length == 0) return "";
    return nodes[ nodes.length -1 ];
  }
  // return everything but last node (returns "pets")
  // (top/recreation/pets/dogs/breeds/herding_group/welsh_corgi/pembroke)
  public static String init( String cat ){
    String[] nodes = cat.split("/");
    if ( nodes.length < 2) return "";
    return toCat( java.util.Arrays.copyOfRange( nodes, 0, nodes.length - 1) );
  }
  // first n nodes ( take 3 returns "top/recreation/pets")
  public static String take( String cat, int n ){
    String[] nodes = cat.split("/");
    if ( nodes.length < 2) return "";
    return toCat( java.util.Arrays.copyOfRange( nodes, 0, Math.min(n,nodes.length)));
  }
  // everything but last n nodes ( drop 5 returns top/recreation/pets/dogs )
  public static String drop( String cat, int n ){
    String[] nodes = cat.split("/");
    int index = Math.max( 0 , nodes.length - n);
    if( index == 0 ) return "";
    return toCat( java.util.Arrays.copyOfRange( nodes, 0, index ));
  }
  public static int nodes( String cat ){ return cat.split("/" ).length; }
  public static String parent( String cat ){ return init( cat );}
  
  //----------------------------------------
  // Operations on pairstriplets of categories

  // common ancestor
  //  top/recreation/pets/parrots and top/recreation/pets/dogs/breeds/ will yield
  //  top/recreation/pets
  public static String ancestor( String cat1, String cat2){
    int mind = Math.min( nodes( cat1), nodes( cat2)  );
    for(int i = mind; i >= 1; i--)
      if( take(cat1, i ).equals( take( cat2, i ))) 
        return take(cat1, i);
    assert( false );
    return "";
  }
  // common ancestor of 3 descendants
  public static String ancestor( String cat1, String cat2, String cat3){
    int mind = Math.min( Math.min( nodes(cat2), nodes(cat2) ), nodes( cat3) );
    for(int i = mind; i >= 1; i--)
      if( take(cat1, i ).equals( take( cat2, i ) ))
        if( take(cat1, i).equals( take(cat3, i ) )) 
          return take(cat1, i);
    assert( false );
    return "";
  }
  // do these two categories have a common parent
  public static boolean siblings(String cat1, String cat2){
    if( parent( cat1 ).equals( parent( cat2 ) ) ) return true;
    return false;
  }

  // --------------------
  // Operation on lists of categories

  // longest common ancestor of all the nodes in the list
  public static String ancestor( String[] cats){
    if( cats.length == 0 ) return "";
    int mind = Integer.MAX_VALUE;
    for( String cat: cats )
      mind = nodes( cat ) < mind ? nodes( cat ) : mind;
   
    if( mind < 1 ) return "";

    for(int i = mind; i >= 1; i--){
      String inodes = take( cats[0], i);
      boolean found = true;
      for( String cat: cats )
        if( ! take( cat, i).equals( inodes )){  
          found = false;
          break; 
        }
      if( found ) return inodes;
    }

    assert( false );
    return "";
  }

  // Longest (tree depth) ancestor any two categories in the list share
  public static String longestAncestor( String[] cats ){
    if (cats.length < 2) return "";
    java.util.Arrays.sort( cats );
    String longest = ""; 
    int lnodes = 0;
    for( int i = 1; i< cats.length; i++)     // cache ancestor() ?
      if( nodes( ancestor( cats[i -1], cats[i])) > lnodes){
        longest = ancestor( cats[i-1], cats[i]);
        lnodes = nodes( longest );
      }
    return longest;
  }
  // Longest ancestor any three categoires share 
  public static String longestAncestor3( String[] cats ){
    if (cats.length < 3) return "";
    java.util.Arrays.sort( cats );
    String longest = ""; 
    int lnodes = 0;
    for( int i = 2; i< cats.length; i++)     // cache ancestor() ?
      if( nodes( ancestor( cats[i-2], cats[i-1], cats[i])) > lnodes){
        longest = ancestor( cats[i-2], cats[i-1], cats[i] );
        lnodes = nodes( longest );
      }
    return longest;
  }

  //---------------------------------------------------------------
  // combine nodes into a category
  private static String toCat( String[] nodes ){
    String outs = "";
    for(String node : nodes)
      outs = outs + node + "/";
    return outs.substring(0,outs.length() -1);
  }
  //Operations with categories
  //Given a URL, finds it in the dmoz database and returns the categories were it belong
  public static ArrayList<String> look4URL(String url) throws IOException {
		//Path to the dmoz url file
		FileInputStream fstream = new FileInputStream("/semplest/data/dmoz/all.urls");
		//String url="-- http://www.laserblazers.com";
		String[] urlparts = url.split("/");
		String mainURL=url;
		ArrayList<String> categories=new ArrayList<String>();

		for (String part :urlparts){
			if(!part.contains("http:")&& part.length()!=0){
				mainURL=part;
				break;
			}
		}
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		String[] lineParts;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  	if (strLine.contains(mainURL)){
		  		lineParts=strLine.split(":");
		  		categories.add(lineParts[0]);
		  	}
		}
		return categories;
	}
  //Checks if the category is valid
  public static boolean validcat(String category) throws Exception{
	  String[] validcat ={ "arts","business", "computers","games", "health", "home", "news", "recreation", "reference", "science", "shopping","society","sports"};	  
	  String[] parts = category.split("/");
	  if(parts.length<2) return false;
	  for (int i=0;i<validcat.length;i++){
		  if(validcat[i].equals(parts[1]))
			  return true;
	  }
	  return false;
  }
  //-------------------------------------------------------------
  public static void main (String[] args){

    String[] cats = { 
                  "a/b/c/d/e/f", 
                  "a/b/c/d/e", 
                  "a/b/c/d", 
                  "a/b/c", 
                  "a/b" };


   String a   = ancestor( cats );   
   String la  = longestAncestor( cats );   
   String la3 = longestAncestor3( cats );   

   System.out.println( a + " : " + la + " : " + la3 );

  }
}
