package com.np.dsa.crux;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeDPTest {
	
	CoinChangeDP obj = new CoinChangeDP();
	
	@Test
	public void test1(){
		final int[] coins = {2,5,6,9};
		final int sum = 11;
		int actualOutput = obj.minCoins(coins, sum);
		Assert.assertEquals(2, actualOutput);
	}

}
