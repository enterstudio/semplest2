package semplest.dmoz.test;

import java.util.List;

import semplest.dmoz.springjdbc.DmozDB;

public class testJdbc {	
	
	public static void main(String[] args){
		try {
			long start = System.currentTimeMillis();
			testTree.test();
			System.out.println(System.currentTimeMillis() - start);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
