package com.nishit.leetcode.contest97;

import java.util.HashSet;
import java.util.Set;

public class Paritition {
	public static void main(String[] args) {
		int N = 5;
		int[][] dislikes = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };

		System.out.println(possibleBipartition(N, dislikes));
	}

	public static boolean possibleBipartition(int N, int[][] dislikes) {
		int[][] aux = new int[N][N];
		if (dislikes.length >= N) {
			return false;
		}
		for (int i = 0; i < dislikes.length; i++) {
			int row = dislikes[i][0];
			int column = dislikes[i][1];
			aux[row][column] = 0;
		}

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int i = 0; i < aux.length; i++) {
			boolean isIInSet1 = false;
			boolean isInSet2 = false;
			boolean notInSet1 = false;
			boolean notInSet2 = false;
			if (!set1.contains(i) && !set2.contains(i)) {
				for (int j = i; j < aux.length; j++) {
					if (set1.contains(j)) {
						notInSet1 = true;
					} else if (set2.contains(j)) {
						notInSet2 = true;
					}
				}
				if (notInSet1 && notInSet2) {
					return false;
				} else if (notInSet1 && !notInSet2) {
					set2.add(i);
					isInSet2 = true;
				} else {
					set1.add(i);
					isIInSet1 = true;
				}
			} else {
				if (set1.contains(i)) {
					isIInSet1 = true;
				}
				if (set2.contains(i)) {
					isInSet2 = true;
				}
			}

			for (int j = 0; j < aux.length; j++) {
				if (aux[i][j] == 0) {
					if (isIInSet1) {
						// Check if j can be added to Set2
					}
				}

			}
		}
		return false;
	}
}
