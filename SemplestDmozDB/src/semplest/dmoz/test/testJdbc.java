package semplest.dmoz.test;

import java.util.List;
import java.util.Map;

import semplest.dmoz.DmozDB;
import semplest.dmoz.SemplestTreeDB;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;
import semplest.dmoz.tree.UrlDataObject;

public class testJdbc {	
	
	public static void main(String[] args){
		try {
			
			Long start = System.currentTimeMillis();
			
			Map<String,List<UrlDataObject>> work = SemplestTreeDB.getUrlsByDomain("top/arts/visual_arts");
			
			System.out.println("===> " + (System.currentTimeMillis() - start)/1000);
			
			for(Map.Entry<String,List<UrlDataObject>> e : work.entrySet()){
				System.out.println(e.getKey());
				for(UrlDataObject u : e.getValue()){
					System.out.println("	" + u.getUrlDataPK() + " : " + u.getUrl());
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
