package semplest.keywords.javautils;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

public class LSA
{

	public SVD svd;

	// constructor
	public LSA(String file)
	{
		svd = new SVD();
		svd.loadSVD(file);
	}

	// -----------------------------------------------------
	// distances of doc d to all the documents O(ds2)
	public double[] docDists(double[] d)
	{
		assert (d.length == svd.ssDim);
		double[] dists = new double[svd.docDim];
		for (int i = 0; i < svd.docDim; i++)
			dists[i] = vecUtils.ncdist(d, svd.dmat[i]);
		return dists;
	}

	// distances of term t to all the terms O(ts2)
	public double[] termDists(double[] t)
	{
		assert (t.length == svd.ssDim);
		double[] dists = new double[svd.termDim];
		for (int i = 0; i < svd.termDim; i++)
			dists[i] = vecUtils.ncdist(t, svd.tmat[i]);
		return dists;
	}

	// document in original (word) space
	// get the n documents that best match
	public int[] similarDocs(int[] doc)
	{
		double[] ssDoc = svd.toSSDoc(doc);
		double[] ddists = docDists(ssDoc);
		return vecUtils.sortIndices(ddists);
	}

	// term in original (doc) space
	// get the n words that best match
	public int[] similarWords(int[] term)
	{
		double[] ssTerm = svd.toSSTerm(term);
		double[] tdists = termDists(ssTerm);
		return vecUtils.sortIndices(tdists);
	}

	// get the indices most common num words for document di O(ts)
	public int[] topWords(int di)
	{
		int[] mci = new int[svd.mci.length];
		for (int r = 0; r < mci.length; r++)
			mci[r] = svd.mci[r][di];
		return mci;
	}

	// Utilities ------------------------------
	public int randomDoc()
	{
		return (int) Math.round(Math.random() * svd.docDim);
	}

	public int randomWord()
	{
		return (int) Math.round(Math.random() * svd.termDim);
	}

	// ---------------------------------------------------------------
	public static void main(String[] args)
	{
		LSA lsa;
		if (args.length > 0)
			lsa = new LSA(args[0]);
	}
}
