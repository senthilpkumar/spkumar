package com.sec.spkumar.problemset;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class DeDupTest {
	
	static int[] inputIntArray;
	DeDup removeDup;
	
	@Before
	public void setUp() throws Exception {
		
	    inputIntArray = new int[]{1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};  
	    //System.out.println(Arrays.toString(inputIntArray));
	    removeDup = new DeDup();
	}

		
	@Test 
	public void testNativeToRemoveDuplicates(){
		
		int[] testResult = removeDup.removeDuplicatesNative(inputIntArray);
		//System.out.println(Arrays.toString(testResult));
		assertEquals(28, testResult.length);
		assertEquals(testResult[0], 1);
		assertEquals(testResult[27], 7);
	}
	
	@Test 
	public void testLinkedHashSetToRemoveDuplicates(){
		
		int[] testResult = removeDup.removeDuplicatesLinkedHashSet(inputIntArray);
		//System.out.println(Arrays.toString(testResult));
		assertEquals(28, testResult.length);
		assertEquals(testResult[0], 1);
		assertEquals(testResult[27], 7);
	}

	
	@Test 
	public void testHashSetToRemoveDuplicates(){
		
		int[] testResult = removeDup.removeDuplicatesHashSet(inputIntArray);
		//System.out.println(Arrays.toString(testResult));
		assertEquals(28, testResult.length);
		assertEquals(testResult[0], 1);
		assertEquals(testResult[27], 86);
	}

}
