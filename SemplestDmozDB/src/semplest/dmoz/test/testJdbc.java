package semplest.dmoz.test;

import semplest.dmoz.DmozDB;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;

public class testJdbc {	
	
	public static void main(String[] args){
		try {
			
			Long start = System.currentTimeMillis();
			DmozTreeNode dmozTree = DmozDB.getTree("top/business/financial_services");
			
			System.out.println("===> " + (System.currentTimeMillis() - start)/1000);
			
			TreeFunctions.printTree(dmozTree, "c:\\dmoz\\tempOutput.txt");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
