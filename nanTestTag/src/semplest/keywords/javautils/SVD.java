package semplest.keywords.javautils;

// needs library svd.jar or sspace.jar
import edu.ucla.sspace.matrix.Matrix;
import edu.ucla.sspace.matrix.MatrixIO;
import edu.ucla.sspace.matrix.MatrixIO.Format;
import edu.ucla.sspace.matrix.SvdlibjDriver;
import edu.ucla.sspace.matrix.ArrayMatrix;
import edu.ucla.sspace.matrix.GrowingSparseMatrix;
import edu.ucla.sspace.matrix.TfIdfTransform;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

// singular value decomposition and latent semantic analysis utilities
public class SVD {
  public static final Format inputFormat  = Format.SVDLIBC_SPARSE_TEXT;
  public static final Format matrixFormat = Format.SVDLIBC_DENSE_TEXT;

  public static final int ddim = 500;
  public static int WORDS = 100;

  public double[][] dmat;
  public double[][] smat;
  public double[][] tmat;

  public int termDim;                // t
  public int docDim;                 // d
  public int ssDim;                  // s

  public int[][] mci;                // w x d
  private Matrix omat;
  

  // Constructor -------
  public SVD(){
    omat = new GrowingSparseMatrix();
  }
  public SVD(int r, int c, int dim ){
    termDim = r;
    docDim = c;
    ssDim = dim;

    omat = new GrowingSparseMatrix( r,c );
  }
//-----------------------------------------------------------
  // ------------------------
  // calculate the svd
  public void calcSVD(){
    Matrix[] svd = SvdlibjDriver.svd( omat, ssDim );
    dmat = svd[0].toDenseArray();
    smat = svd[1].toDenseArray();
    tmat = svd[2].toDenseArray();
  }

  public void loadSVD( String path ){
    System.out.println("Loading Matrices");
    dmat = ioUtils.readMatrix( path + ".D.mat" );
    smat = ioUtils.readMatrix( path + ".S.mat" );
    tmat = ioUtils.readMatrix( path + ".T.mat" );

    ssDim = smat.length;
    termDim = tmat[0].length;
    docDim = dmat.length;
  }

  public void writeSVD( String ofile ){
    File dFile = new File(ofile + ".D.mat");
    File sFile = new File(ofile + ".S.mat");
    File tFile = new File(ofile + ".T.mat");

    try {
      MatrixIO.writeMatrix(new ArrayMatrix(dmat), dFile, matrixFormat);
      MatrixIO.writeMatrix(new ArrayMatrix(smat), sFile, matrixFormat);
      MatrixIO.writeMatrix(new ArrayMatrix(tmat), tFile, matrixFormat);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public void printSVD(){
    System.out.println("D (U)"); ioUtils.printMatrix( dmat );
    System.out.println("S (S)"); ioUtils.printMatrix( smat );
    System.out.println("T (V)"); ioUtils.printMatrix( tmat );
  }
  public static void print(Matrix m){
    System.out.printf("%d rows, %d cols\n", m.rows(), m.columns()); 
    ioUtils.printMatrix( m.toDenseArray());
  }

  // Statics --------------
  public static void setColumn(Matrix m,  int index, int[] values){
    for(int r=0; r<values.length; r++)
      m.set( r, index, values[r] );
  }
  public static void setColumn(Matrix m, int index, double[] values){
    m.setColumn( index, values );
  }
  public static void loadMatrix(Matrix m, int[][] arr){
    for(int i=0; i< arr.length; i++)
      setColumn(m,  i, arr[i] );
  }

  public static Matrix[] calcSVD( double[][] M, int dim){
    ArrayMatrix am = new ArrayMatrix( M );
    return SvdlibjDriver.svd( am, dim );
  }

  public static double[] getColumn(double[][] val, int cindex){
    double[] col = new double[ val.length ];
    for (int r=0; r< val.length; r++)
      col[r] = val[r][cindex];
    return col;
  }

  public static void printSVD( Matrix[] svd ){
    System.out.println("D (U)"); ioUtils.printMatrix( svd[0].toDenseArray() );
    System.out.println("S (S)"); ioUtils.printMatrix( svd[1].toDenseArray() );
    System.out.println("T (V)"); ioUtils.printMatrix( svd[2].toDenseArray() );
  }

  public void loadMCI( String file ){
    Matrix m = readMatrix( file );
    mci = vecUtils.toint( m.toDenseArray());
  }
  // sort each column, get tom num indices
  public void calcWriteMCI( String file){
    Matrix MCI = maxColIndices( omat, WORDS );
    mci = vecUtils.toint( MCI.toDenseArray());
    ioUtils.printMatrix( mci );
    writeMatrix( MCI, file );
  }
  public static Matrix maxColIndices( Matrix m, int num ){
    GrowingSparseMatrix om = new GrowingSparseMatrix( num, m.columns());
    for( int i=0; i< m.columns(); i++){
      double[] d = m.getColumn(i);
      int[] si = vecUtils.sortIndices( d );
      int[] is = vecUtils.reverse( si );
      int[] tis = Arrays.copyOfRange( is, 0, num );
      setColumn(om, i,tis);
    }
    return om;
  }
  public static void writeMatrix( Matrix m, String fname ){
    File ofile = new File( fname );
    Format mformat  = Format.SVDLIBC_SPARSE_TEXT;
    try {
      MatrixIO.writeMatrix( m, ofile, mformat ); 
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static Matrix readMatrix( String fname ){
    File ifile = new File( fname );
    Matrix m = null;
    Format mformat  = Format.SVDLIBC_SPARSE_TEXT;
    try {
      m = MatrixIO.readMatrix( ifile, mformat ); 
    } catch (Exception e) {
      e.printStackTrace();
    }
    return m;
  }

  // Utility to create DST matrices from file
  // do a Singular Value Decomposition of dimension dim 
  // transforms a t x d matrix to three matrices:
  //  D: d x s 
  //  S: s x s
  //  T: s x t
  //  expects input matrix to be in a SVDLIBC sparse text format
  //  output matrices are SVDLIBC dense text format
  public static void readWriteSVD( int dim, String ifile ) {

    File matrixFile = new File(ifile);
    if (!matrixFile.exists())
      return;

    try {
      Matrix[] usv = SvdlibjDriver.svd(matrixFile, inputFormat, dim);
      File dFile = new File(ifile + ".D.mat");
      File sFile = new File(ifile + ".S.mat");
      File tFile = new File(ifile + ".T.mat");

      MatrixIO.writeMatrix(usv[0], dFile, matrixFormat);
      MatrixIO.writeMatrix(usv[1], sFile, matrixFormat);
      MatrixIO.writeMatrix(usv[2], tFile, matrixFormat);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  // read in file (which is in semplest format)
  public int readFileSem(String file){
    int coli = 0;
    try {
      BufferedReader r = new BufferedReader(new FileReader(file));
      String line;
      while(( line = r.readLine()) != null ){
        setColumn(omat,  coli, ioUtils.docVector( line ));
        coli++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return coli;
  }
  // Transforms -------------------------------------------------------
  // do a tf-idf transform ont hthe matrix
  public void tfIdf(){
    TfIdfTransform tt = new TfIdfTransform();
    omat = tt.transform( omat );
  }

  //-------------------------------------------------------------------------
  // Utilities 
  // --- transform term-vector to point in subspace O(sd)
  // t'DS-1 
  public double[] toSSTerm( int[] t){
    assert( t.length == docDim );
    double[] res = new double[ ssDim ];
    for(int i=0; i< ssDim; i++){
      double ival = 0;
      for(int j=0; j< docDim; j++)
        ival += t[j] * dmat[j][i];
      res[i] = ival / smat[i][i];    
    }
    return res;     
  }

  // ---- transform doc-vector to a point in the subspace O(st)
  // d'TS-1 
  public double[] toSSDoc( int[] d){
    assert( d.length == termDim );
    double[] res = new double[ ssDim ];
    for(int i=0; i< ssDim; i++){
      double ival = 0;
      for(int j=0; j< termDim; j++)
        if( d[j] != 0 )
          ival += d[j] * tmat[i][j];
      res[i] = ival / smat[i][i];  
    }
    return res;     
  }

  // -- documents magntude sq
  // the dotProduct of two doc vectors in the original space can be calculated
  // in the subspace (faster but less accurate) 
  // Sd1 * Sd2        O(s)
  public double dotPd(double[] d1, double[] d2){
    assert( d1.length == ssDim && d2.length == ssDim );
    double sum = 0;
    for(int i=0; i< ssDim; i++)
      sum += smat[i][i] * smat[i][i] * d1[i] * d2[i];
    return sum;
  }
  // -- term magntude sq
  // the dotProduct of two term vectors in the original space can be calculated
  // in the subspace (faster but less accurate) 
  // Sd1 * Sd2 O(s)
  public double dotPt(double[] t1, double[] t2){
    assert( t1.length == ssDim && t2.length == ssDim );
    double sum = 0;
    for(int i=0; i< ssDim; i++)
      sum += smat[i][i] * smat[i][i] * t1[i] * t2[i];
    return sum;
  }

  // get the wordcount in the original space O(s)
  // Note: may be tfIdf reduced
  public double wordCount( int wi, int di){
    double count = 0;
    for(int i=0; i<ssDim; i++)
      count += tmat[i][wi] * smat[i][i] * dmat[di][i];
    return count;
  }

  // approximation of original document (gets very inaccurate)
  public int[] document( int di ){
    int[] doc = new int[ termDim ];
    for(int i=0; i<termDim; i++)
      doc[i] = (int) Math.round( wordCount( i, di ));
    return doc;
  }
  // magnitude of a document (TSd) O(ts)
  public double dMag (double[] d){
    assert ( d.length == ssDim );
    int mag = 0;
    for(int i=0; i< termDim; i++)
      for(int j=0; j < ssDim; j++)
        mag += tmat[j][i] * smat[j][j] * d[j]; 
    return mag;
  }
  // magnitude of a term (tSD) O(ds)
  public double tMag (double[] t){
    assert ( t.length == ssDim );
    int mag = 0;
    for(int i=0; i< docDim; i++)
      for(int j=0; j < ssDim; j++)
        mag += dmat[i][j] * smat[j][j] * t[j]; 
    return mag;
  }

  //---- cosine document dist in ss space(in radians)  O(s)
  // SD(1) * SD(2)  
  // original vectors should have been normalized
  public double cdist (double[] v1, double[] v2){
    assert ( v1.length == ssDim && v2.length == ssDim );
    double dist = 0;
    for(int i=0; i< ssDim; i++)
      dist += (v1[i] * v2[i] * smat[i][i] * smat[i][i]);
    dist = dist > 1 ? 1 : dist;
    dist = dist < -1 ? -1 : dist;
    return Math.acos(dist);
  }


  // ---------------------------------------------------------------
  public static void main(String[] args) {

    String file = "/semplest/data/dmoz/test/hCounts.txt";
//    dictUtils.loadDict( "/semplest/data/dmoz/test/stemwords.txt");
    
    if( args.length > 0) file = args[0];

    SVD svd = new SVD();
    int lines = svd.readFileSem( file  );
    System.out.printf( "Read %d lines from %s\n", lines, file );

    svd.tfIdf();
//    svd.print( svd.omat );
    svd.calcWriteMCI( file + ".mci" );
//    svd.loadMCI( file + ".mci");
//    ioUtils.printMatrix( svd.mci );

  }
}
