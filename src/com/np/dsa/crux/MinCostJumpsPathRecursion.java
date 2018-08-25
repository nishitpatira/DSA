package com.np.dsa.crux;

import java.util.LinkedList;
import java.util.List;

/*Given an integer, n. Starting from 0, find the minimium cost to reach n. You can only do a +1 or *2 operation. There are costs for both increment 
 * and multiplication. Also print the path from 0 to n*/

/* Asked in Ola Telephonic interview */

public class MinCostJumpsPathRecursion {

	private List<Integer> minCostList = null;
	private int minCost = Integer.MAX_VALUE;

	public void minCost(int n, int increment, int multiplication, int cost, List<Integer> path) {
		path.add(n);
		if (n < 0) {
			return;
		}
		if (n == 0) {
			if (cost < minCost) {
				minCost = cost;
				minCostList = new LinkedList<Integer>(path);
			}
			path.remove(path.size() - 1);
			return;
		}

		if (n % 2 == 0) {
			minCost(n - 1, increment, multiplication, cost + increment, path);
			minCost(n / 2, increment, multiplication, cost + multiplication, path);
		} else {
			minCost(n - 1, increment, multiplication, cost + increment, path);
		}
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		int n = 10;
		int increment = 2;
		int multiplication = 2;
		MinCostJumpsPathRecursion obj = new MinCostJumpsPathRecursion();
		obj.minCost(n, increment, multiplication, 0, new LinkedList<Integer>());
		System.out.print("Lowest Cost Path is : ");
		for (int i = 0; i < obj.minCostList.size() - 1; i++) {
			System.out.print(obj.minCostList.get(i) + " -> ");
		}
		System.out.println(obj.minCostList.get(obj.minCostList.size() - 1));
		System.out.println("Lowest Cost is : " + obj.minCost);
	}
}
