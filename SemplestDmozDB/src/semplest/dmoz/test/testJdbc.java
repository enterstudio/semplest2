package semplest.dmoz.test;

import java.util.List;

import semplest.dmoz.springjdbc.DmozDB;

public class testJdbc {	
	
	public static void main(String[] args){
		try {
			Integer parentId = DmozDB.getParentNodeID(5);
			//System.out.println(parentId);
			
			List<Integer> siblingIds = DmozDB.getNodeSiblingIDs(3);
			//System.out.println(siblingIds);
			
			List<String> urls = DmozDB.getUrls(1, 2);
			System.out.println(urls);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
