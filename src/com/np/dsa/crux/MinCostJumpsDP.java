package com.np.dsa.crux;

/*Given an integer, n. Starting from 0, find the minimium cost to reach n. You can only do a +1 or *2 operation. There are costs for both increment 
 * and multiplication. Also print the path from 0 to n*/

/* Asked in Ola Telephonic interview */

public class MinCostJumpsDP {

	public static void main(String[] args) {
		int n = Integer.MAX_VALUE-1;
		int incrementCost = 2;
		int multiplicationCost = 3;
		long startTime = System.currentTimeMillis();
		System.out.println(minCostPath(n, incrementCost, multiplicationCost));
		long endTime = System.currentTimeMillis();
		System.out.println("TIme taken for n=" + n + " Increment value=" + incrementCost + " Multiplication value=" + multiplicationCost + " is : " + (endTime-startTime));
	}

	private static int minCostPath(int n, int incrementCost, int multiplicationCost) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] costs = new int[n + 1];
		costs[0] = 0;
		costs[1] = incrementCost;
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				costs[i] = Math.min(costs[i / 2] + multiplicationCost, costs[i - 1] + incrementCost);
			} else {
				costs[i] = costs[i - 1] + incrementCost;
			}
		}
		return costs[n];
	}
}
