package com.np.dsa.crux;

public class DistinctSubSequenceSums {

	public static void main(String[] args)
	{
		final int arr[] = { 1,2,5 };
		final int n = arr.length;
		printDistSum(arr, n);
	}


	static void printDistSum(int arr[], int n)
	{
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		// dp[i][j] would be true if arr[0..i-1]
		// has a subset with sum equal to j.
		final boolean[][] dp = new boolean[n + 1][sum + 1];

		// There is always a subset with 0 sum
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		// Fill dp[][] in bottom up manner
		for (int i = 1; i <= n; i++)
		{
			dp[i][arr[i - 1]] = true;
			for (int j = 1; j <= sum; j++)
			{
				// Sums that were achievable
				// without current array element
				if (dp[i - 1][j] == true)
				{
					dp[i][j] = true;
					dp[i][j + arr[i - 1]] = true;
				}
			}
		}

		// Print last row elements
		for (int j = 0; j <= sum; j++) {
			if (dp[n][j] == true) {
				System.out.print(j + " ");
			}
		}
	}
}