package com.np.dsa.crux;

//https://www.geeksforgeeks.org/minimum-sum-falling-path-in-a-nxn-grid/
public class MinSumFallingPath {

	public void findFallingPath(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (j == 0) {
					dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
				} else if (j == matrix.length - 1) {
					dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
				} else {
					dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
				}
			}
		}

		int min_index = 0;
		int min = dp[matrix.length - 1][0];
		for (int i = 1; i < matrix.length; i++) {
			if (dp[matrix.length - 1][1] < min) {
				min = dp[matrix.length - 1][1];
				min_index = i;
			}
		}

		System.out.println(dp[matrix.length - 1][min_index]);
	}

}
