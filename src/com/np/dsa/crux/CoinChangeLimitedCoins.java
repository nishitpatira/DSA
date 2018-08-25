package com.np.dsa.crux;

public class CoinChangeLimitedCoins {

	public static void main(String[] args) {
		int[] coins = { 5, 3, 2, 1 };
		int[] counts = { 2, 1, 2, 1 };
		int target = 9;
		int[] nums = combine(coins, counts);
		System.out.println(minCount(nums, target, 0, 0, 0));
	}

	private static int minCount(int[] nums, int target, int sum, int current, int count){
		if(sum == target) return count;
		if(current > nums.length) return -1;
		if(sum + nums[current] <= target){
			return minCount(nums, target, sum+nums[current], current+1, count+1);
		} else {
			return minCount(nums, target, sum, current+1, count);
		}
	}

	private static int[] combine(int[] coins, int[] counts) {
		int sum = 0;
		for (int count : counts) {
			sum += count;
		}
		int[] returnArray = new int[sum];
		int returnArrayIndex = 0;
		for (int i = 0; i < coins.length; i++) {
			int count = counts[i];
			while (count != 0) {
				returnArray[returnArrayIndex] = coins[i];
				returnArrayIndex++;
				count--;
			}
		}
		return returnArray;
	}
}
