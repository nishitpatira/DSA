package com.np.dsa.crux;

import java.util.LinkedList;
import java.util.List;

/*Given an integer, n. Starting from 0, find the minimium cost to reach n. You can only do a +1 or *2 operation. There are costs for both increment 
 * and multiplication. Also print the path from 0 to n*/

/* Asked in Ola Telephonic interview */

public class MinCostsJumpRecursion {

	private int minCost = Integer.MAX_VALUE;

	public void minCost(int n, int increment, int multiplication, int cost) {
		if (n < 0) {
			return;
		}
		if (n == 0) {
			if (cost < minCost) {
				minCost = cost;
			}
			return;
		}

		if (n % 2 == 0) {
			minCost(n - 1, increment, multiplication, cost + increment);
			minCost(n / 2, increment, multiplication, cost + multiplication);
		} else {
			minCost(n - 1, increment, multiplication, cost + increment);
		}
	}

	public static void main(String[] args) {
		int n = 1000;
		int incrementCost = 2;
		int multiplicationCost = 3;
		MinCostsJumpRecursion obj = new MinCostsJumpRecursion();
		long startTime = System.currentTimeMillis();
		obj.minCost(n, incrementCost, multiplicationCost, 0);
		long endTime = System.currentTimeMillis();
		System.out.println(obj.minCost);
		System.out.println("TIme taken for n=" + n + " Increment value=" + incrementCost + " Multiplication value=" + multiplicationCost + " is : " + (endTime-startTime));

	}
}
