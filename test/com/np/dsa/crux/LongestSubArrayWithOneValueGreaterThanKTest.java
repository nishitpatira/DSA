package com.np.dsa.crux;

import org.junit.Assert;
import org.junit.Test;



public class LongestSubArrayWithOneValueGreaterThanKTest {
	
	LongestSubArrayWithOneValueGreaterThanK obj = new LongestSubArrayWithOneValueGreaterThanK();
	
	@Test
	public void test1(){
		int[] array = {6,4,8,3,2,6,8,4,2,1,3,3};
		int k = 7;
		int output = obj.longestSubArrayWithOneValueGreaterThanK(array, k);
		Assert.assertEquals(9, output);
	}
	
	@Test
	public void test2(){
		int[] array = {9, 5, 5, 6, 8};
		int k = 7;
		int output = obj.longestSubArrayWithOneValueGreaterThanK(array, k);
		Assert.assertEquals(4, output);
	}

	@Test
	public void test3(){
		int[] array = {9, 5, 5, 6, 8};
		int k = 10;
		int output = obj.longestSubArrayWithOneValueGreaterThanK(array, k);
		Assert.assertEquals(0, output);
	}
}
