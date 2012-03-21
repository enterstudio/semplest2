package cc.mallet.types;


import java.io.Serializable;
import java.util.logging.Logger;

import cc.mallet.pipe.Pipe;
import cc.mallet.util.MalletLogger;
import cc.mallet.util.Randoms;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class InstanceListCache extends InstanceList implements Serializable, Iterable<Instance>, AlphabetCarrying{

	/**
	 * 
	 */
	private static final long serialVersionUID = 18940333333333L;

	//**************************Atributes***********************************************************	
	//Atributes related to EhChache
	//private CacheManager managerInstance = null;
	private Cache myCache = null;
	private int numElem; 
	int maxElem;

	//*********************** Constructors **********************************************************
	//Subclass of InstanceList with EhCache implemented to increase memory resources
	//Contructors from the super class will instanciate the Cache objects
	
	// WARINING : We are not setting the capacity of our Cache programatically (Done in xml file)
	// We should implement in the future
	public InstanceListCache(Pipe pipe, int capacity) {
		super(pipe, capacity);
		numElem = 0;
		maxElem = capacity;
		CacheManager managerInstance = new CacheManager(InstanceListCache.class.getResource( "/cacheSetting/InstanceCache.xml"));
		System.out.println(managerInstance.getActiveConfigurationText());
		myCache = managerInstance.getCache("InstanceCache");
		//managerInstance.shutdown();
	}

	public InstanceListCache(Pipe pipe) {
		super(pipe);
		numElem = 0;
		maxElem = 1000000;
		System.out.println("Hello World");
		CacheManager managerInstance = new CacheManager(InstanceListCache.class.getResource( "/cacheSetting/InstanceCache.xml"));
		System.out.println(managerInstance.getActiveConfigurationText());
		myCache = managerInstance.getCache("InstanceCache");
		//managerInstance.shutdown();
	}

	public InstanceListCache(Alphabet dataAlphabet, Alphabet targetAlphabet) {
		super(dataAlphabet, targetAlphabet);
		CacheManager managerInstance = new CacheManager(InstanceListCache.class.getResource( "/cacheSetting/InstanceCache.xml"));
		System.out.println(managerInstance.getActiveConfigurationText());
		myCache = managerInstance.getCache("InstanceCache");
		//managerInstance.shutdown();
	}

	public InstanceListCache(Randoms r, Dirichlet classCentroidDistribution,
			double classCentroidAverageAlphaMean,
			double classCentroidAverageAlphaVariance,
			double featureVectorSizePoissonLambda,
			double classInstanceCountPoissonLambda, String[] classNames) {
		super(r, classCentroidDistribution, classCentroidAverageAlphaMean,
				classCentroidAverageAlphaVariance,
				featureVectorSizePoissonLambda,
				classInstanceCountPoissonLambda, classNames);
		CacheManager managerInstance = new CacheManager(InstanceListCache.class.getResource( "/cacheSetting/InstanceCache.xml"));
		System.out.println(managerInstance.getActiveConfigurationText());
		myCache = managerInstance.getCache("InstanceCache");
		//managerInstance.shutdown();
		numElem = 0;
		maxElem = 1000000;
	}

	public InstanceListCache(Randoms r, Alphabet vocab, String[] classNames,
			int meanInstancesPerLabel) {
		super(r, vocab, classNames, meanInstancesPerLabel);
		CacheManager managerInstance = new CacheManager(InstanceListCache.class.getResource( "/cacheSetting/InstanceCache.xml"));
		System.out.println(managerInstance.getActiveConfigurationText());
		myCache = managerInstance.getCache("InstanceCache");
		//managerInstance.shutdown();
		numElem = 0;
		maxElem = 1000000;
	}

	public InstanceListCache(Randoms r, int vocabSize, int numClasses) {
		super(r, vocabSize, numClasses);
		CacheManager managerInstance = new CacheManager(InstanceListCache.class.getResource( "/cacheSetting/InstanceCache.xml"));
		System.out.println(managerInstance.getActiveConfigurationText());
		myCache = managerInstance.getCache("InstanceCache");
		//managerInstance.shutdown();
		numElem = 0;
		maxElem = 1000000;
	}
	
	//****************************** Overwriten Methods *********************************************************
	
	public boolean add (Instance instance)
	{
		if (dataAlphabet == null)
			dataAlphabet = instance.getDataAlphabet();
		if (targetAlphabet == null)
			targetAlphabet = instance.getTargetAlphabet();
		if (!Alphabet.alphabetsMatch(this, instance)) {
      // gsc
      Alphabet data_alphabet = instance.getDataAlphabet();
      Alphabet target_alphabet = instance.getTargetAlphabet();
      StringBuilder sb = new StringBuilder();
      sb.append("Alphabets don't match: ");
      sb.append("Instance: [" + (data_alphabet == null ? null : data_alphabet.size()) + ", " +
          (target_alphabet == null ? null : target_alphabet.size()) + "], ");
      data_alphabet = this.getDataAlphabet();
      target_alphabet = this.getTargetAlphabet();
      sb.append("InstanceList: [" + (data_alphabet == null ? null : data_alphabet.size()) + ", " +
          (target_alphabet == null ? null : target_alphabet.size()) + "]\n");
      throw new IllegalArgumentException(sb.toString());
//			throw new IllegalArgumentException ("Alphabets don't match: Instance: "+
//					instance.getAlphabets()+" InstanceList: "+this.getAlphabets());
    }
		if (dataClass == null) {
			dataClass = instance.data.getClass();
			if (pipe != null && pipe.isTargetProcessing())
				if (instance.target != null)
					targetClass = instance.target.getClass();
		}
		// Once it is added to an InstanceList, generally-speaking, the Instance shouldn't change.
		// There are exceptions, and for these you can instance.unlock(), then instance.lock() again.
		if(numElem<maxElem){
			instance.lock(); 
			myCache.put(new Element(new Integer(numElem), instance));
			numElem++;
			return true;
		} else { 
			return false;
		}
	}
	
	
	public Instance set (int index, Instance instance) {
		super.prepareToRemove(get(index));

		Integer intObj = new Integer(index);
		Instance removed =(Instance) myCache.get(intObj).getObjectValue();
		myCache.remove(intObj);
		myCache.put(new Element(intObj, instance));
		return removed;
  	}
	
	
	public Instance remove (int index) {
		 super.prepareToRemove(get(index));
		 Integer intObj = new Integer(index);
		 Instance removed =(Instance) myCache.get(intObj).getObjectValue();
		 myCache.remove(intObj);
		 numElem--;
		 return removed;
	 }
	
	public boolean remove (Instance instance) {
		 super.prepareToRemove(instance);
		 Integer intObj; 
		 for (int i=0; i<numElem; i++){
			 intObj= new Integer(i);
			 if(instance == (Instance) myCache.get(intObj).getObjectValue()){
				 myCache.remove(intObj);
				 numElem--;
				 return true; 
			 }
		 }
		 return false;
	 }
	public void clear() {
		  super.clear();
		  myCache.removeAll();
		  instWeights.clear();
		  numElem=0;
		  	// But retain all other instance variables.
	}
	
	public Instance get(int Index){
		Integer intObj= new Integer(Index);
		Instance inst = (Instance) myCache.get(intObj).getObjectValue();
		return inst;
	}
	
	public boolean contains(Instance instance){
		 Integer intObj; 
		 for (int i=0; i<numElem; i++){
			 intObj= new Integer(i);
			 if(instance.equals((Instance) myCache.get(intObj).getObjectValue())){
				 return true; 
			 }
		 }
		 return false;
	}
	public void ensurecapacity(int minCapacity){
		if (maxElem < minCapacity) maxElem=minCapacity;
	}
	
	public int indexOf(Instance instance){
		 Integer intObj; 
		 for (int i=0; i<numElem; i++){
			 intObj= new Integer(i);
			 if(instance.equals((Instance) myCache.get(intObj).getObjectValue())){
				 return i; 
			 }
		 }
		 return -1;
	}
	
	public boolean isEmpty(){
		return numElem==0;
	}
	
	public int lastIndexOf(Instance instance){
		 Integer intObj;
		 int aux=-1;
		 for (int i=0; i<numElem; i++){
			 intObj= new Integer(i);
			 if(instance.equals((Instance) myCache.get(intObj).getObjectValue())){
				 aux=i; 
			 }
		 }
		 return aux;
	}
	
	protected void removeRange(int fromIndex, int toIndex){
		for(int i=fromIndex; i<=toIndex;i++)
		this.remove(i);
	}
	
	public int size(){
		return numElem;
	}
	
	public Instance[] toArray(){
		Instance[] instArray = new Instance[numElem];
		Integer intObj;
		for (int i=0; i<numElem; i++){
			 intObj= new Integer(i);
			 instArray[i]=(Instance) myCache.get(intObj).getObjectValue();
		 }
		return instArray;
	}
	
	public void trimtoSize(){
		maxElem=numElem;
	}
	
	
	//****************************** EhCacheMethods *************************************************************


	public long getCacheSize()
	{
		return myCache.calculateInMemorySize();
	}

	public Cache getMyCache()
	{
		return myCache;
	}

}
