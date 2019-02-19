package com.np.dsa.crux;

//Find minimum number of coins required to make a given sum

public class CoinChangeDP {

	
	public int minCoins(int[] coins, int sum){
		int[] dp = new int[sum+1];
		for(int i = 1; i < dp.length ; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		
		for(int i = 1 ; i < dp.length ; i++){
			for(int coin : coins){
				int temp = i - coin;
				if(temp < 0){
					break;
				}
				else if(temp == 0){
					dp[i] = 1;
					break;
				} else {
					if(dp[temp] != Integer.MAX_VALUE){
						if(dp[i] == Integer.MAX_VALUE){
							dp[i] = 1 + dp[temp];
						} else {
							dp[i] = 1 + Math.min(dp[i], dp[temp]);
						}
					}
				}
			}
		}
		return dp[dp.length-1];
	}
}
