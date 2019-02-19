package com.nishit.leetcode.contest107;

import org.junit.Test;

import com.nishit.leetcode.contest109.RecentCounter;

public class RecentCounterTest {
	
	RecentCounter obj = new RecentCounter();
	
	@Test
	public void test1(){
		obj.ping(1);
		obj.ping(100);
		obj.ping(3001);
		obj.ping(3002);
	}

}
