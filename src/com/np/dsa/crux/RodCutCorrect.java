package com.np.dsa.crux;

public class RodCutCorrect {

	
	public int findMaxProfit(int[] prices, int length){
		if(length == 0){
			return 0;
		}
		
		int maxProfit = Integer.MIN_VALUE;
		
		for(int i = 1; i <= length; i++){
			int localProfit = prices[i-1] + findMaxProfit(prices, length - i);
			
			if(localProfit > maxProfit){
				maxProfit = localProfit;
			}
		}
		
		return maxProfit;
	}
}
