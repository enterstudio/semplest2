package semplest.keywords.javautils;

import semplest.keywords.properties.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import com.sleepycat.je.*;

/* Utilities to store/retrieve key/value tuples in a Berkeley Database
 * Note: Implementation where keys and values are Strings (this need not be the case)
 */
public class bdb {

  // - Privates ------------
  //  private static String DIR = "/semplest/data/dmoz/bdb/";
  private static String DIR = ProjectProperties.bdbdir;

  private static Environment getEnv( String id, Boolean ro){
    EnvironmentConfig ec = new EnvironmentConfig();
    ec.setAllowCreate( true );
    if( ro ) ec.setReadOnly( true );
    return new Environment( new java.io.File( DIR ), ec );
  }

  private static Database getDB( String id, Boolean ro, Environment e ){
    DatabaseConfig dc = new DatabaseConfig();
    dc.setAllowCreate( true );
    if( ro ) dc.setReadOnly( true );
    dc.setSortedDuplicates( false );
    dc.setDeferredWrite( true );
    Database d = e.openDatabase( null, id, dc );
    if ( ro ) d.preload( null );
    return d;
  }

  private static String toS( DatabaseEntry de ) throws Exception { 
    return new String( de.getData(), "UTF-8");}
  private static DatabaseEntry toDE( String s ) throws Exception {
    return new DatabaseEntry( s.getBytes("UTF-8") );}

  // - Interface ------------------------
  public static int add( String id, HashMap<String,String> kvs) 
    throws Exception {
    Environment e   = getEnv( id, false );
    Database    db  = getDB( id, false, e );
    int count = 0;
    for ( Map.Entry<String,String> en: kvs.entrySet()){ 
      DatabaseEntry key = new DatabaseEntry( en.getKey().getBytes("UTF-8"));
      DatabaseEntry val = new DatabaseEntry( en.getValue().getBytes("UTF-8"));
      if(  db.put( null, key, val) == OperationStatus.SUCCESS )
        count++;
      db.close();
      e.close();
    }
    return count;
  }

  public static String get( String id, String k ) throws Exception {
    Environment e   = getEnv( id, false );
    Database    db  = getDB( id, false, e );

    DatabaseEntry key = new DatabaseEntry( k.getBytes("UTF-8"));
    DatabaseEntry val = new DatabaseEntry();
    String rs = "";
    if( db.get( null, key, val, null) == OperationStatus.SUCCESS)
      rs = new String( val.getData(), "UTF-8");
    db.close();
    e.close();
    return rs;
  }
  public static Map<String,String> get( String id, String[] ks ) 
    throws Exception {
    Environment e   = getEnv( id, false );
    Database    db  = getDB( id, false, e );
    HashMap<String,String> rm = new HashMap<String,String>();
    DatabaseEntry value = new DatabaseEntry();

    for ( String k: ks ){ 
      DatabaseEntry key = new DatabaseEntry( k.getBytes("UTF-8"));
      if( db.get( null, key, value, null) == OperationStatus.SUCCESS)
        rm.put( k, new String( value.getData(), "UTF-8"));
    }

    db.close();
    e.close();
    return rm; 
  }
  // get all records
  public static Map<String,String> getAll( String id) throws Exception {
    Environment e   = getEnv( id, false );
    Database    db  = getDB( id, false, e );

    HashMap<String,String> rm = new HashMap<String,String>();
    DiskOrderedCursor c = db.openCursor( new DiskOrderedCursorConfig() );
      DatabaseEntry fk = new DatabaseEntry();
    DatabaseEntry fv = new DatabaseEntry();
    HashMap<String,String> mm = new HashMap<String,String>();
    while ( c.getNext( fk, fv, null ) == OperationStatus.SUCCESS )            
      mm.put( toS( fk ), toS( fv ));
    c.close();
    return mm;
  }
  // get all keys
  public static String[] getKeys( String id ) throws Exception {
    Environment e   = getEnv( id, false );
    Database    db  = getDB( id, false, e );

    ArrayList<String> res = new ArrayList<String>();
    DiskOrderedCursor c = db.openCursor( new DiskOrderedCursorConfig() );
      DatabaseEntry fk = new DatabaseEntry();
    DatabaseEntry fv = new DatabaseEntry();
    while ( c.getNext( fk, fv, null ) == OperationStatus.SUCCESS)             
      res.add(  toS( fk ) );
    c.close();
    return res.toArray( new String[]{} );
  }

  // containing k ntries whose keys are children of k
  // children => greater than k (in the natural ordering of Strings)
  public static Map<String,String> children(String id, String k) 
    throws Exception {
    Environment e   = getEnv( id, false );
    Database    db  = getDB( id, false, e );

    Cursor c = db.openCursor( null, null );
    DatabaseEntry fk = toDE( k );
    DatabaseEntry fv = new DatabaseEntry();
    HashMap<String,String> mm = new HashMap<String,String>();
    if( c.getSearchKeyRange( fk, fv, LockMode.DEFAULT ) == 
        OperationStatus.SUCCESS )
      mm.put( toS( fk ), toS( fv ) );
    while ( c.getNext( fk, fv, LockMode.DEFAULT ) == 
        OperationStatus.SUCCESS &&
        toS( fk ).contains( k ))
      mm.put( toS( fk ), toS( fv ));
    c.close();
    return mm;
  }
  public static int delete( String id, String k ) throws Exception {
    Environment e   = getEnv( id, false );
    Database    db  = getDB( id, false, e );
    DatabaseEntry key = new DatabaseEntry( k.getBytes("UTF-8") );
    int res = 0;
    if( db.delete( null, key ) == OperationStatus.SUCCESS ) res = 1;
    db.close();
    e.close();
    return res;
  }
  public static int empty( String id) throws Exception {
    Environment e   = getEnv( id, false );
    long cnt = e.truncateDatabase( null, id, true );
    e.close();
    return (int)cnt;
  }

  public static int count( String id) throws Exception {
    Environment e   = getEnv( id, false );
    Database    db  = getDB( id, false, e );
    long c = db.count();
    db.close();
    e.close();
    return (int)c;
  }

  // ---------------------------------------------------------------------
  public static void main(String[] args) throws Exception {
    String key = "top/news/satire";
    String[] dbs = {"2g","3g","4g","ac","descs"};

    long st = System.currentTimeMillis();
    Map<String,String> res = getAll("4g");
    String[] keys = getKeys("4g");
    long et = System.currentTimeMillis();
    
    System.out.println( (res.size() + keys.length) + " records took " + 
        (et - st) + " ms"  );

  }
}

