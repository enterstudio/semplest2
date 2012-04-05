// Node Object for Category tree

// Written by Subhojit Som (subhojit@semplest.com)


package semplest.keywords.javautils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import semplest.keywords.classification.Document;;

public class TreeNode {
	
	private int level; // 0 for Top, then incrementally added
	private String name; // Photography
	private String path; // will have the complete path e.g., /Top/Arts/Visual_Arts/Photography
	
	private ArrayList<TreeNode> children;
	
	private TreeNode parent;
	
	private Document d;
	
	
	public TreeNode(){
		level=0;
		name="Top";
		path="/Top";
		children=new ArrayList<TreeNode>();
		parent=null;
		
	}
	
	public TreeNode(TreeNode parent, String name){
		this.name=name;
		this.parent=parent;
		level=parent.getLevel()+1;
		path=parent.getPath()+"/"+name;
		children=new ArrayList<TreeNode>();
	}
	
	public TreeNode(TreeNode parent, String name, Document d){
		this.name=name;
		this.parent=parent;
		this.d=d;
		level=parent.getLevel()+1;
		path=parent.getPath()+"/"+name;
		children=new ArrayList<TreeNode>();
	}
	
	public int getLevel(){
		return level;
	}
	
	public String getPath(){
		return path;
	}
	
	public String getName(){
		return name;
	}
	
	public void addChild(TreeNode node){
		children.add(node);
	}
	
	public ArrayList<TreeNode> getChildren(){
		return children;
	}
	
	public TreeNode getParent(){
		return parent;
	}
	
	public void dft() { // depth first traversal	
		System.out.println(path);
		
		if(children.isEmpty())
			return;


		for (TreeNode t : children){
			t.dft();
		}
	}
	
	public void dftGenGraph(BufferedWriter file) { // depth first traversal			
		if(children.isEmpty())
			return;

		for (TreeNode t : children){
			try {
				file.write(name.replaceAll("[0-9]","X").replaceAll(".html","_html")+"->"+t.getName().replaceAll("[0-9]","X").replaceAll(".html","_html")+";\n");
			} catch (IOException e) { 
				e.printStackTrace();
				System.out.println("File write error!!");
			}
			t.dftGenGraph(file);
		}
	}

}
