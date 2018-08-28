package com.nishit.line;

public class DiceThrow {

	public static void main(String[] args) {
		int[] diceValues = { 1, 2, 3, 4, 5, 6 };
		int n = 3;
		System.out.println(waysToReachN(diceValues, n));
	}

	public static final int waysToReachN(final int[] diceValues, final int value) {
		if (value == 0)
			return 0;
		int[] waysToReachIndex = new int[value + 1];
		waysToReachIndex[0] = 1;
		for (int diceValue : diceValues) {
			for (int i = 1; i < waysToReachIndex.length; i++) {
				if (i - diceValue >= 0) {
					waysToReachIndex[i] = waysToReachIndex[i] + waysToReachIndex[i - diceValue];
				}
			}
		}
		return waysToReachIndex[waysToReachIndex.length - 1];
	}
}
