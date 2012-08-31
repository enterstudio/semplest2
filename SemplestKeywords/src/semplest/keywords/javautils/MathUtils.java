package semplest.keywords.javautils;

import java.util.*;

import org.apache.log4j.Logger;

import semplest.keywords.lda.KWGenDmozLDAServer1;
import semplest.keywords.lda.KWGenDmozLDAServer2;

public class MathUtils
{
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAServer2.class);

	public static double[][] minNelem(double vect[], int N)
	{
		// Find the N minimum elements in an array and return values and index (sorted)
		// Not an efficient implementation for large N, efficient for large vect.length
		// Return first row index second row value
		// It will only take numbers smaller than maxNum
		int maxNum = 99999;
		double[][] minElem = new double[2][N];
		double[][] minElemaux;
		int length = 0;
		int minElemlength = 0;
		// Put first vect element as first minimum value
		minElem[0][0] = 0;
		minElem[1][0] = vect[0];
		// Initialize matrix
		for (int n = 1; n < minElem[0].length; n++)
		{
			minElem[0][n] = -1;
			minElem[1][n] = maxNum;
		}
		minElemlength = N;
		// Iterate through elements in vect[] and store the N min
		for (int i = 1; i < vect.length; i++)
		{
			for (int j = 0; j < minElemlength; j++)
			{

				if (vect[i] <= minElem[1][j])
				{
					minElemaux = copy2Darray(minElem);
					if (j == 0)
						length = 0;
					else
						length = j - 1;
					System.arraycopy(minElemaux[0], 0, minElem[0], 0, length);
					System.arraycopy(minElemaux[1], 0, minElem[1], 0, length);
					minElem[0][j] = i;
					minElem[1][j] = vect[i];
					if (minElemlength < N)
						minElemlength++;
					System.arraycopy(minElemaux[0], j, minElem[0], j + 1, minElemlength - j - 1);
					System.arraycopy(minElemaux[1], j, minElem[1], j + 1, minElemlength - j - 1);
					break;
				}
			}
		}

		return minElem;
	}

	public static double[][] copy2Darray(double[][] original)
	{
		double[][] newarray = new double[original.length][];
		for (int i = 0; i < original.length; i++)
			newarray[i] = original[i].clone();
		return newarray;
	}

	public static void print2Darray(double[][] matrix)
	{
		for (int i = 0; i < matrix[0].length; i++)
		{
			logger.info(matrix[0][i] + "\t" + matrix[1][i]);
		}
	}

	public static int[] randIntArray(int numElem, int min, int max)
	{
		// Generates a vector of numElem number of random integers between min and max
		int[] randArray = new int[numElem];
		for (int i = 0; i < numElem; i++)
		{
			randArray[i] = (int) (min + (max - 1) * Math.random());
		}
		return randArray;
	}
}
