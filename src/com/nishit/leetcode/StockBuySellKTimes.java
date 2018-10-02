package com.nishit.leetcode;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
public class StockBuySellKTimes {

	public static void main(String[] args) {
		final int[] prices = {1,2,4,2,5,7,5,2,4,9,0};
		final int k = 2;
		/*final int[] prices = {1};
		final int k = 1;*/
		StockBuySellKTimes obj = new StockBuySellKTimes();
		System.out.println(obj.maxProfit(k, prices));
	}

	//Approach was to find local minima and local maximas and then profits from that
	/*public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int min = prices[0];
		int min_index = 0;
		int max = -1;
		int max_index = 0;
		int profit = 0;
		List<Integer> profits = new LinkedList<>();
		for (int i = 1; i <= prices.length - 2; i++) {
			if (prices[i] < prices[i - 1] && prices[i] < prices[i + 1]) {
				min = prices[i];
				min_index = i;
			}
			if (prices[i] > prices[i - 1] && prices[i] > prices[i + 1]) {
				max = prices[i];
				int tempProfit = max - min;
				if(min_index - max_index == 1){
					int oldProfit = profits.remove(profits.size() -1);
					profits.add(oldProfit+tempProfit);
				}
				profits.add(tempProfit);
				max = -1;
				min = prices[i + 1];
				max_index = i;
			}
		}
		if (prices[prices.length - 1] > min) {
			profits.add(prices[prices.length - 1] - min);
		}
		Collections.sort(profits, Collections.reverseOrder());
		for (int i = 0; i < Math.min(k, profits.size()); i++) {
			profit += profits.get(i);
		}
		return profit;
	}*/
	
	public int maxProfit(final int k, final int[] prices){
		if (prices == null || prices.length == 0)
			return 0;
		//Rows are days and columns are transactions
		final int[][] dp = new int[prices.length+1][k+1];
		//On Day 0, max profit is always 0
		for(int i = 0; i < prices.length +1 ; i++){
			dp[i][0] = 0;
		}
		for(int i = 0 ; i < k+1 ; i++){
			dp[0][i] = 0;
		}
		for(int i = 1 ; i < prices.length + 1; i++){
			for(int t = 1 ; t < k + 1 ; t++){
				int max_profit = 0;
				for(int x = 0 ; x <t ; x++){
					if(prices[t] - prices[x] + dp[x][t-1] > max_profit){
						max_profit = prices[t] - prices[x] + dp[x][t-1];
					}
				}
				dp[i][t] = Math.max(dp[i-1][t], max_profit);
			}
		}
		return dp[prices.length][k];
	}
	

}
