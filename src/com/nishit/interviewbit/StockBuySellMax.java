package com.nishit.interviewbit;

//https://www.hackerrank.com/challenges/stockmax/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class StockBuySellMax {

	public static void main(String[] args) {
		// final int[] prices = { 5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0 };
		// final int[] prices = { 7, 1, 5, 3, 6, 4 };
		final int[] prices = { 5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0 };
		System.out.println(maxProfit(prices));
	}

	static int stockmax(int[] prices) {
		int max_diff = prices[prices.length - 1];
		int profit = 0;

		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > max_diff) {
				max_diff = prices[i];
			} else {
				profit += max_diff - prices[i];
			}
		}
		return profit;
	}

	/*
	 * public static int maxProfit(int[] prices) { if (prices == null ||
	 * prices.length == 0) return 0; int LOCAL_MIN = prices[0]; int LOCAL_MAX =
	 * -1; int profit = 0; for (int i = 1; i < prices.length - 1; i++) { if
	 * (prices[i - 1] >= prices[i] && prices[i] <= prices[i + 1]) { LOCAL_MIN =
	 * prices[i]; } if (prices[i - 1] <= prices[i] && prices[i] >= prices[i +
	 * 1]) { LOCAL_MAX = prices[i]; profit += LOCAL_MAX - LOCAL_MIN; LOCAL_MIN =
	 * prices[i+1]; LOCAL_MAX = -1; } } if (prices[prices.length - 1] >
	 * LOCAL_MIN) { profit += prices[prices.length - 1] - LOCAL_MIN; } return
	 * profit; }
	 */

	public static int maxProfit(final int[] prices) {
		int valley = 0;
		int peak = 0;
		int profit = 0;

		if (prices.length == 0)
			return profit;
		int i = 0;
		if (i == 0) {
			if (prices[0] <= prices[1]) {
				valley = prices[0];
			}
		}

		for (i = 1; i <= prices.length - 2; i++) {
			if (prices[i - 1] >= prices[i] && prices[i] < prices[i + 1]) {
				valley = prices[i];
			} else if (prices[i - 1] < prices[i] && prices[i] >= prices[i + 1]) {
				peak = prices[i];
				profit = profit + (peak - valley);
			}
		}

		if (i == prices.length - 1) {
			if (prices[i] > prices[i - 1]) {
				peak = prices[i];
				profit = profit + (peak - valley);
			}
		}
		return profit;
	}
}
