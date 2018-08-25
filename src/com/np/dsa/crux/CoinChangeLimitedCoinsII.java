package com.np.dsa.crux;

public class CoinChangeLimitedCoinsII {

	public static void main(String[] args) {
		int[] coins = { 5, 2, 1 };
		int[] counts = { 2, 2, 1 };
		int target = 9;
		int[] nums = combine(coins, counts);
		System.out.println(minCount(nums, target, 0, 0, 0));
	}

	private static int minCount(int[] nums, int target, int sum, int current, int count) {
		if (sum == target) {
			return count;
		}
		if (current >= nums.length) {
			return -1;
		}
		int withElement = minCount(nums, target, sum + nums[current], current + 1, count + 1);
		int withoutElement = minCount(nums, target, sum, current + 1, count);
		if (withElement != -1 && withoutElement != -1) {
			return Math.min(withElement, withoutElement);
		} else {
			return (withElement != -1) ? withElement : withoutElement;
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
