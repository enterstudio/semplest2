package semplest.dmoz.test;

import semplest.dmoz.DmozDB;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;

public class testJdbc {	
	
	public static void main(String[] args){
		try {
			/*
			Long start = System.currentTimeMillis();
			DmozTreeNode dmozTree = DmozDB.getTree("top");
			
			System.out.println("===> " + (System.currentTimeMillis() - start)/1000);
			
			TreeFunctions.printTree(dmozTree, "c:\\dmoz\\tempOutput.txt");
			*/
			
			String url = "http://fglk.railfan.net/history.html";
			String[] parts = url.split("://");
			String subUrl;
			if(parts.length > 1){
				subUrl = parts[1];
			}
			else{
				subUrl = parts[0];
			}
			int index = subUrl.indexOf("/");
			String domain;
			if(index > 0){
				domain = subUrl.substring(0, index);
			}
			else{
				domain = subUrl;
			}			
			
			System.out.println(domain);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
