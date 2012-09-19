package semplest.dmoz.test;

import java.util.List;

import semplest.dmoz.DmozDB;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;

public class testJdbc {	
	
	public static void main(String[] args){
		try {
			Long start = System.currentTimeMillis();
			DmozTreeNode dmozTree = DmozDB.getTree("top/society");
			
			System.out.println("===> " + (System.currentTimeMillis() - start)/1000);
			
			List<DmozTreeNode> treeNodes = TreeFunctions.getTreeInList(dmozTree);			
			TreeFunctions.storeTreeToFile(treeNodes, "c:\\dmoz\\tempOutput.txt");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
