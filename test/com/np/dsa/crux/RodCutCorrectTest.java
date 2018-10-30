package com.np.dsa.crux;

import org.junit.Assert;
import org.junit.Test;

public class RodCutCorrectTest {
	
	RodCutCorrect obj = new RodCutCorrect();
	
	@Test
	public void test1(){
		int[] prices = {1,5,8,9,10,17,17,2};
		
		int maxProfit = obj.findMaxProfit(prices, 4);
		Assert.assertEquals(10, maxProfit);
	}

}
