package com.sec.spkumar.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;



public class DeDup {
	
	private static final Logger logger = Logger.getLogger(DeDup.class);
	
	public static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   
	
	
	public int[] removeDuplicatesHashSet(int[] s) {  
		
		logger.info("Removing duplicates using Hash Set - Starting...");
		long startTime = System.nanoTime();
	    Integer[] resultArray = new HashSet<Integer>(Arrays.asList(ArrayUtils.toObject(s))).toArray(new Integer[0]); 	   
	    long responseTime = System.nanoTime() - startTime;
		logger.info("Removing duplicates using hash set - Response Time : " +  responseTime);		
	    return ArrayUtils.toPrimitive(resultArray);
	    
	}
	
	public int[] removeDuplicatesLinkedHashSet(int[] s){
		
		logger.info("Removing duplicates using Linked Hash Set - Starting...");
		long startTime = System.nanoTime();
	    Integer[] resultArray = new LinkedHashSet<Integer>(Arrays.asList(ArrayUtils.toObject(s))).toArray(new Integer[0]); 
	    long responseTime = System.nanoTime() - startTime;
		logger.info("Removing duplicates using hash set - Response Time : " +  responseTime);
	    return ArrayUtils.toPrimitive(resultArray);		
	}

	
	public int[] removeDuplicatesNative(int[] s){
		
		logger.info("Removing duplicates using Native - Starting...");
		long startTime = System.nanoTime();
		List<Integer> resultArray = new ArrayList<Integer>();

		for(int i=0; i<s.length; i++){
			boolean match = false;
			for(int j=0; j<resultArray.size(); j++){
				// check if the list has a duplicate
				if(resultArray.get(j) == s[i])
					match = true;
			}
			//add if there is no match
			if(!match)
				resultArray.add(s[i]);
		}						
	    
		long responseTime = System.nanoTime() - startTime;
		logger.info("Removing duplicates using Native - Response Time : " +  responseTime);
		return ArrayUtils.toPrimitive(resultArray.toArray(new Integer[0]));	
	}
	
	
	
    public static void main(String [] args) {
    	 
    	 DeDup deDup = new DeDup();
    	 
    	 logger.info("Native....Start");
    	 deDup.removeDuplicatesNative(randomIntegers);
    	 logger.info("Native....End : " + deDup.removeDuplicatesNative(randomIntegers).length);
    	 
    	 
    	 logger.info("Linked Hash....Start");
    	 deDup.removeDuplicatesLinkedHashSet(randomIntegers);
    	 logger.info("Linked Hash....End : " + deDup.removeDuplicatesLinkedHashSet(randomIntegers).length);
    	 
    	 logger.info("Hash Set....Start");
    	 deDup.removeDuplicatesHashSet(randomIntegers);
    	 logger.info("Hash Set....End : " + deDup.removeDuplicatesHashSet(randomIntegers).length);        	 
     }

     
     
}
