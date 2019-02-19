package com.np.dsa.crux;

import org.junit.Test;

public class SubsequencesLengthKTest {
	
	SubsequencesLengthK obj = new SubsequencesLengthK();
	
	
	@Test
	public void test1(){
		int[] array = {1,2,3,4,5};
		int k = 3;
		obj.findAndPrint(array, k);
	}
	
	@Test
	public void test2(){
		int[] array = {1,2};
		int k = 2;
		obj.findAndPrint(array, k);
	}

}
