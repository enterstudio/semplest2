package semplest.bidding.test;

import java.util.ArrayList;
import java.util.HashMap;

import semplest.bidding.optimization.CampaignBid;
import semplest.bidding.optimization.KeyWord;
//import semplest.keywords.javautils.ioUtils;

public class TestBidAlgorithm {

	public static void main(String[] args) {
		ArrayList<String> lines;
		int i, j;
		
		// keywords
		String [] keywords;
		lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/keywords.txt");
		keywords = new String[lines.size()];
		
		i=0;
		for (String line : lines){
//			line=line.replaceAll("\n", "");
			keywords[i]=line;
			i++;
		}
		
		double [] scores = new double[keywords.length];
		lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/QualityScores.txt");
		j=0;
		for (String line : lines){
			line=line.replaceAll("\n", "");
			scores[j]=Double.parseDouble(line);
			j++;
		}
		
		// bids
		double [] bid = null;
		lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/Bid.txt");
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
		
		lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/CPC.txt");
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

		lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/Pos.txt");
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

		lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/Clicks.txt");
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

		lines = ioUtils.readFile("/semplest/data/SemplestQuantTest/tmpSubhojit/DCost.txt");
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

		CampaignBid bidOptimizer = new CampaignBid();
		
		for (i=0; i<keywords.length;i++){
//			bidOptimizer.addKeyWord(new KeyWord(keywords[i], scores[i], bid, Clicks[i], CPC[i], Pos[i], DCost[i]));
			bidOptimizer.addKeyWord(new KeyWord(keywords[i], scores[i], bid, Clicks[i], null, null, DCost[i], null));
		}
		bidOptimizer.setDailyBudget(338.0);
		HashMap<String,Double> bidData = bidOptimizer.optimizeBids();
		
		


	}

}
