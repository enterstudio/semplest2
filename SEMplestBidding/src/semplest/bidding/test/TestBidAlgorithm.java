package semplest.bidding.test;

import java.util.ArrayList;
import java.util.HashMap;

import semplest.bidding.optimization.BidOptimizer;
import semplest.bidding.optimization.CampaignBid;
import semplest.bidding.optimization.KeyWord;
//import semplest.keywords.javautils.ioUtils;

public class TestBidAlgorithm {

	public static void main(String[] args) {
		ArrayList<String> lines;
		int i, j;
		
		boolean isLinux = false;
		
		// keywords
		String [] keywords;
		if(isLinux) {
			lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/keywords.txt");
		} else {
			lines = ioUtils.readFile("//fs3/Semplest/data/SemplestQuantTest/tmpSubhojit/keywords.txt");
		}
		keywords = new String[lines.size()];
		
		i=0;
		for (String line : lines){
//			line=line.replaceAll("\n", "");
			keywords[i]=line;
			i++;
		}
		
		double [] scores = new double[keywords.length];
		if(isLinux) {
			lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/QualityScores.txt");
		} else {
			lines = ioUtils.readFile("//fs3/Semplest/data/SemplestQuantTest/tmpSubhojit/QualityScores.txt");
		}
		j=0;
		for (String line : lines){
			line=line.replaceAll("\n", "");
			scores[j]=Double.parseDouble(line);
			j++;
		}
		
		// bids
		double [] bid = null;
		if(isLinux) {
			lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/Bid.txt");
		} else {
			lines = ioUtils.readFile("//fs3/Semplest/data/SemplestQuantTest/tmpSubhojit/Bid.txt");
		}
		for (String line : lines){
			line=line.replaceAll("\n", "");
			String [] words = line.split("\\s+");
			bid = new double[words.length];
			i=0;
			for (String word : words){
				bid[i]=Double.parseDouble(word);
				i++;
			}
			break; // expect that there is just one line
		}
		
		double [][] CPC = new double[keywords.length][bid.length];
		double [][] Pos = new double[keywords.length][bid.length];
		double [][] Clicks = new double[keywords.length][bid.length];
		double [][] DCost = new double[keywords.length][bid.length];
		
		if(isLinux) {
			lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/CPC.txt");
		} else {
			lines = ioUtils.readFile("//fs3/Semplest/data/SemplestQuantTest/tmpSubhojit/CPC.txt");
		}
		j=0;
		for (String line : lines){
			line=line.replaceAll("\n", "");
			String [] words = line.split("\\s+");
			i=0;
			for (String word : words){
				CPC[i][j]=Double.parseDouble(word);
				i++;
			}
			j++;
		}

		if(isLinux) {
			lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/Pos.txt");
		} else {
			lines = ioUtils.readFile("//fs3/Semplest/data/SemplestQuantTest/tmpSubhojit/Pos.txt");
		}
		j=0;
		for (String line : lines){
			line=line.replaceAll("\n", "");
			String [] words = line.split("\\s+");
			i=0;
			for (String word : words){
				Pos[i][j]=Double.parseDouble(word);
				i++;
			}
			j++;
		}

		if(isLinux) {
			lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/Clicks.txt");
		} else {
			lines = ioUtils.readFile("//fs3/Semplest/data/SemplestQuantTest/tmpSubhojit/Clicks.txt");
		}
		j=0;
		for (String line : lines){
			line=line.replaceAll("\n", "");
			String [] words = line.split("\\s+");
			i=0;
			for (String word : words){
				Clicks[i][j]=Double.parseDouble(word);
				i++;
			}
			j++;
		}

		if(isLinux) {
			lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/DCost.txt");
		} else {
			lines = ioUtils.readFile("//fs3/Semplest/data/SemplestQuantTest/tmpSubhojit/DCost.txt");
		}
		j=0;
		for (String line : lines){
			line=line.replaceAll("\n", "");
			String [] words = line.split("\\s+");
			i=0;
			for (String word : words){
				DCost[i][j]=Double.parseDouble(word);
				i++;
			}
			j++;
		}

		BidOptimizer bidOptimizer = new BidOptimizer();
		
		for (i=0; i<keywords.length;i++){
//			bidOptimizer.addKeyWord(new KeyWord(keywords[i], scores[i], bid, Clicks[i], CPC[i], Pos[i], DCost[i]));
			System.out.println("Trying to add keyword to the bid optimizer: "+keywords[i]);
			bidOptimizer.addKeyWord(new KeyWord(keywords[i], scores[i], bid, Clicks[i], CPC[i], null, DCost[i], null, 10.0));
		}
		bidOptimizer.setDailyBudget(100.0);
		HashMap<String,Double> bidData = bidOptimizer.optimizeBids();
		
		


	}

}
