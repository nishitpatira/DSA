package com.np.dsa.crux;

import java.util.Arrays;

public class CoinChangeLatestRecursionGoodPerformance {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int[] newArr = new int[coins.length];

		for (int i = 0; i < coins.length; i++) {
			newArr[i] = coins[coins.length - 1 - i];
		}
		return coinChangeUtil(newArr, amount);
	}

	private static int coinChangeUtil(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (amount < 0)
			return -1;

		for (int i = 0; i < coins.length; i++) {
			int returnVal = coinChangeUtil(coins, amount - coins[i]);
			if (returnVal >= 0) {
				return 1 + returnVal;
			}
		}
		return -1;
	}
}
