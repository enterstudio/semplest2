package semplest.keywords.javautils;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;


/*
 * Java Language and data-structure Utilities 
 */
public class jUtils {

  // first n entries
  public static <K> Set<K> take( Set<K> s, Integer n){
    Set<K> res = new HashSet<K>();
    int counter = 0;
    for( K e: s ){
      if ( counter >= n ) break;
      res.add( e );
      counter++;
    }
    return res;
  }
  public static <K,V> Map<K,V> take( Map<K,V> m, Integer n){
    Map<K,V> res = new HashMap<K,V>();
    int counter = 0;
    for( Map.Entry<K,V> e: m.entrySet() ){
      if ( counter >= n ) break;
      res.put( e.getKey(), e.getValue());
      counter++;
    }
    return res;
  }

}

