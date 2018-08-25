package com.np.dsa.crux;

//Given an integer array, count # of ways in which a given sum can be reached

public class CountWaysToReachSum {

	private static int count = 0;

	private static void countWays(int[] arr, int sum, int curr_sum, int start_index){
		if(curr_sum == sum){
			count++;
			return;
		}
		if(curr_sum > sum || start_index >= arr.length){
			return;
		}
		countWays(arr, sum, curr_sum+arr[start_index], start_index+1);
		countWays(arr, sum, curr_sum, start_index+1);

	}

	public static void main(String[] args) {
		final int[] arr = {1,1,1,2,5,5,5};
		final int n = 8;
		countWays(arr, n, 0, 0);
		System.out.println(count);
	}

	//This can also be done in DP
}
