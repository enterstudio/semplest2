package semplest.keywords.javautils;

import semplest.keywords.properties.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import com.sleepycat.je.*;

/* Utilities to store/retrieve key/value tuples in a Berkeley Database
 * Note: Implementation where keys and values are Strings (this need not be the case)
 */
public class cdb {

  Environment e;
  Database db;
  String dbid;
  Boolean ro = true;

  // - Ctr ----------
  // Read - only
  public cdb( String dir, String id ){
    e     = getEnv( dir, true ); 
    db    = getDB( id, e, true ); 
    dbid  = id; 
  }
  // Write
  public cdb( String dir, String id, Boolean read ){
    e = getEnv( dir, read ); 
    db = getDB( id, e, read ); 
    ro = false;
  }

  // - Privates ------------
  private Environment getEnv( String dir, Boolean ro){
    EnvironmentConfig ec = new EnvironmentConfig();
    ec.setAllowCreate( true );
    if( ro ) ec.setReadOnly( true );
    return new Environment( new java.io.File( dir ), ec );
  }

  private Database getDB( String id, Environment e, Boolean ro ){
    DatabaseConfig dc = new DatabaseConfig();
    dc.setAllowCreate( true );
    if( ro ) dc.setReadOnly( true );
    dc.setSortedDuplicates( false );
    dc.setDeferredWrite( true );
    Database d = e.openDatabase( null, id, dc );
    if ( ro ) d.preload( null );
    return d;
  }
  //
  private static String toS( DatabaseEntry de ) throws Exception { 
    return new String( de.getData(), "UTF-8");}
  private static DatabaseEntry toDE( String s ) throws Exception {
    return new DatabaseEntry( s.getBytes("UTF-8") );}

  // - Interface ------------------------
  public int add( Map<String,String> kvs) throws Exception {
    if( ro ) return 0;
    int count = 0;
    for ( Map.Entry<String,String> en: kvs.entrySet()){ 
      DatabaseEntry key = new DatabaseEntry( en.getKey().getBytes("UTF-8"));
      DatabaseEntry val = new DatabaseEntry( en.getValue().getBytes("UTF-8"));
      if(  db.put( null, key, val) == OperationStatus.SUCCESS )
        count++;
    }
    return count;
  }

  public String get( String k ) throws Exception {
    DatabaseEntry key = new DatabaseEntry( k.getBytes("UTF-8"));
    DatabaseEntry val = new DatabaseEntry();
    String rs = "";
    if( db.get( null, key, val, null) == OperationStatus.SUCCESS)
      rs = new String( val.getData(), "UTF-8");
    return rs;
  }
  public void close(){
    db.close();
    e.close();
  }
  public Map<String,String> get( String[] ks ) 
    throws Exception {
    HashMap<String,String> rm = new HashMap<String,String>();
    DatabaseEntry value = new DatabaseEntry();

    for ( String k: ks ){ 
      DatabaseEntry key = new DatabaseEntry( k.getBytes("UTF-8"));
      if( db.get( null, key, value, null) == OperationStatus.SUCCESS)
        rm.put( k, new String( value.getData(), "UTF-8"));
    }
    return rm; 
  }
  // get all records
  public Map<String,String> getAll( ) throws Exception {
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
  public String[] getKeys() throws Exception {
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
  public Map<String,String> children( String k) throws Exception {
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
  public int delete( String k ) throws Exception {
    DatabaseEntry key = new DatabaseEntry( k.getBytes("UTF-8") );
    if( db.delete( null, key ) == OperationStatus.SUCCESS ) return(1);
    return 0;
  }
  public int empty() throws Exception {
    return (int)e.truncateDatabase( null, dbid, true );
  }

  public int count() throws Exception { return (int) db.count(); }
  // -------------------------------------------
  public static void createTest( String dir, String dbname) throws Exception {
    String cidfile = "/semplest/data/dmoz/dmoz.8-12.cids";
    Map<String,String> cids = ioUtils.readPair( cidfile );
    
    cdb db = new cdb( dir, dbname, false );
    int ret = db.add( cids );
    db.close();
    System.out.println("Wrote " + ret + " records");
  }
  public static void readTest( String dir, String dbname ) throws Exception {
    String key = "top/news/satire";
    cdb db = new cdb( dir, dbname );
    long st = System.currentTimeMillis();
    Map<String,String> res = db.getAll();
    String[] keys = db.getKeys();
    long et = System.currentTimeMillis();
    db.close();
    
    System.out.println( (res.size() + keys.length) + " records took " + 
        (et - st) + " ms"  );
  }

  // ---------------------------------------------------------------------
  public static void main(String[] args) throws Exception {
    String dir = "/tmp/bdb/";
    String dbname = "test";
    createTest( dir, dbname );
    readTest( dir, dbname );
  }
}

