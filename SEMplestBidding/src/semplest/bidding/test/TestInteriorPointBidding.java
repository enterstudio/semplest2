package semplest.bidding.test;

import java.util.ArrayList;

import semplest.bidding.optimization.BiddingProblem;
import semplest.bidding.optimization.KeyWord;
import semplest.bidding.optimization.KeyWordInterface;

public class TestInteriorPointBidding {
  private static double moneyScale = 1.0 / 1000000.0;

  public static void main(String[] args) {
    String baseDir = "\\\\fs3\\semplest\\data\\SemplestQuantTest\\tmpAlex\\";
    ArrayList<String> lines;
    int i, j;

    // keywords
    String[] keywords;
    lines = ioUtils.readFile(baseDir + "keywords.txt");
    keywords = new String[lines.size()];

    i = 0;
    for (String line : lines) {
      keywords[i] = line;
      i++;
    }
    System.out.println("Got " + keywords.length + " keywords for bidding.");

    double[] scores = new double[keywords.length];
    for (j = 0; j < scores.length; j++) {
      scores[j] = 1.0;
    }

    // bids
    double[] bid = null;
    lines = ioUtils.readFile(baseDir + "Bid.txt");
    for (String line : lines) {
      line = line.replaceAll("\n", "");
      line = line.trim();
      String[] words = line.split("\\s+");
      bid = new double[words.length];
      i = 0;
      for (String word : words) {
        bid[i] = Double.parseDouble(word) * moneyScale;
        i++;
      }
      break; // expect that there is just one line
    }

    double[][] CPC = new double[keywords.length][bid.length];
    double[][] Clicks = new double[keywords.length][bid.length];
    double[][] DCost = new double[keywords.length][bid.length];

    // read in click values
    lines = ioUtils.readFile(baseDir + "Clicks.txt");
    j = 0;
    for (String line : lines) {
      line = line.replaceAll("\n", "");
      line = line.trim();
      String[] words = line.split("\\s+");
      i = 0;
      for (String word : words) {
        Clicks[j][i] = Double.parseDouble(word);
        i++;
      }
      j++;
    }

    // read in cost values
    lines = ioUtils.readFile(baseDir + "DCost.txt");
    j = 0;
    for (String line : lines) {
      line = line.replaceAll("\n", "");
      line = line.trim();
      String[] words = line.split("\\s+");
      i = 0;
      for (String word : words) {
        DCost[j][i] = Double.parseDouble(word) * moneyScale;
        CPC[j][i] = DCost[j][i] / Clicks[j][i];
        i++;
      }
      j++;
    }

    ArrayList<KeyWordInterface> wordList = new ArrayList<KeyWordInterface>();

    for (i = 0; i < keywords.length; i++) {
      KeyWord kw = new KeyWord(keywords[i], scores[i], bid, Clicks[i], CPC[i],
          null, DCost[i], null);
      if (kw.getClickInfo() == null || kw.getCPCInfo() == null) {
        continue;
      } else {
        wordList.add(kw);
      }
    }

    // create a solve the bidding problem
    BiddingProblem bp = new BiddingProblem(wordList, 300.0);
    double[] optBids = bp.solveProblem();
    double cost = bp.computeTotalCost(optBids);
    double clicks = bp.computeTotalClicks(optBids);
    System.out.println("Optimal clicks: " + clicks);
    System.out.println("Optimal cost: " + cost);

  }

}
