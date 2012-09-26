package semplest.crawl.test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import semplest.db.berkeleydb.BerkeleyDB;
import semplest.db.berkeleydb.BerkeleyDB_Static;
import semplest.dmoz.SemplestTreeDB;
import semplest.dmoz.tree.UrlDataObject;

public class testBerkeleyDB {
	public static void main(String[] args){
		try{
			//read properties file and get DB settings
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream("bin/system.properties");
			properties.load(in);
			in.close();	
			String dbDir = properties.getProperty("berkeleyDb.directory");
			String dbID = properties.getProperty("berkeleyDb.id");
			
			BerkeleyDB_Static.setDirectory(dbDir);
			
			Map<String,String> ret = BerkeleyDB_Static.getAll(dbID);
			
			for(Map.Entry<String, String> e : ret.entrySet()){
				System.out.println(e.getKey());				
			}
			
			System.out.println("===> " + ret.size());
			
			Map<String,List<UrlDataObject>> work = SemplestTreeDB.getUrlsByDomain("top/business/financial_services/insurance/agents_and_marketers/employee_benefits");
			HashSet<String> urls = new HashSet<String>();
			for(List<UrlDataObject> ul : work.values()){
				for(UrlDataObject ud : ul){
					urls.add(ud.getUrl());
				}
			}
			for(String u : urls){
				System.out.println(u);
			}
			System.out.println(urls.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
