package semplest.keywords.lda;

import java.util.HashMap;

import semplest.keywords.javautils.DmozLucene;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.javautils.ioUtils;

public class KWGenDmozLDAdata implements Runnable{
	
	public DmozLucene dl; //Index of categories
	public HashMap<String,String> TrainingData;
	public dictUtils dict;
	private String dfile = "dmoz/all/all.descs";
	
	public KWGenDmozLDAdata() {
		dl = new DmozLucene();
		System.out.println("Indexing dmoz description data...");
		DmozLucene.loadDesc(dl,dfile);
		System.out.println("Data indexed!");
		System.out.println("Loading training data...");
		TrainingData = ioUtils.file2Hash("dmoz/all/all.descs");
		System.out.println("Data loaded");
		System.out.println("Loading stem dictionary...");
		dict = new dictUtils();
		System.out.println("Dictionary loaded");
	}

	@Override
	public void run() {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
