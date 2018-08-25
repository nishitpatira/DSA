package com.nishit.interviewbit;

//https://www.hackerrank.com/challenges/stockmax/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class StockBuySellMax {

	public static void main(String[] args) {
		final int[] prices = {5,3,2,10,6,8,9};
		System.out.println(stockmax(prices));
	}

	static int stockmax(int[] prices) {
		int max_diff = prices[prices.length - 1];
		int profit = 0;

		for(int i = prices.length - 2; i >= 0 ; i--){
			if(prices[i] > max_diff){
				max_diff = prices[i];
			} else {
				profit += max_diff - prices[i];
			}
		}
		return profit;
	}
}
