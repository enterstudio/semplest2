package semplest.dmoz.test;

import java.util.ArrayList;
import java.util.List;

import semplest.dmoz.springjdbc.BaseDB;

public class testTree extends BaseDB {
	
	public ArrayList<TreeNode> sqlBatch = new ArrayList<TreeNode>();
	
	public static void main(String[] args){
		
	}
	
	public static void test(){
		ArrayList<String> sqls = new ArrayList<String>();
		String sql;
		for(int i = 0; i < 1000; i++){
			sql = "insert into DMOZ(DmozNodePK,NodeText) values(" + i + ",'node" + i + "')";
			sqls.add(sql);
		}
		
		jdbcTemplate.batchUpdate(sqls.toArray(new String[sqls.size()]));
	}
	
	public void test2tree(TreeNode topnode){
			
	}
}
