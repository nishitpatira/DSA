package com.nishit.leetcode;

public class UnboundedKnapSack {

	private static int max_val = 0;

	private static void unboundedKnapsack(int[] val, int[] wt, int rem_wt, int curr_val) {

		if (rem_wt < 0) {
			return;
		}
		if (rem_wt == 0) {
			max_val = (curr_val > max_val) ? curr_val : max_val;
		}
		for (int i = 0; i < val.length; i++) {
			if (rem_wt - wt[i] < 0) {
				max_val = (curr_val > max_val) ? curr_val : max_val;
			}
			unboundedKnapsack(val, wt, rem_wt - wt[i], curr_val + val[i]);
		}
	}

	public static void main(String[] args) {
		int W = 100;
		int val[] = { 8, 10 };
		int wt[] = { 7, 9 };
		int n = val.length;
		unboundedKnapsack(val, wt, W, 0);
		System.out.println(max_val);
	}
}