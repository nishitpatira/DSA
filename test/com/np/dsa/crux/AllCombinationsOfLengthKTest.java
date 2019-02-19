package com.np.dsa.crux;

import org.junit.Test;

public class AllCombinationsOfLengthKTest {
	
	AllCombinationsOfLengthK obj = new AllCombinationsOfLengthK();
	
	@Test
	public void test1(){
		String input = "ABC";
		int k = 2;
		obj.allCombinations(input, k);
	}

}
