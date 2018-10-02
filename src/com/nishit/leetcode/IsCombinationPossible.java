package com.nishit.leetcode;

public class IsCombinationPossible {

	public Boolean isPossible(int[] arr, int n, int k) {
		if (arr == null || arr.length == 0) {
			return true;
		}
		Boolean[][] matrix = new Boolean[k + 1][n + 1];
		for (int i = 0; i <= k; i++) {
			matrix[i][0] = true;
		}
		for (int i = 0; i <= n; i++) {
			matrix[0][i] = true;
		}
		for (int i = 0; i < arr.length; i++) {
			matrix[1][arr[i]] = true;
		}

		return util(arr, n, k, matrix);
	}

	private Boolean util(int[] arr, int n, int k, Boolean[][] matrix) {
		if (matrix[k][n] != null) {
			return matrix[k][n];
		}
		for (int i = 0; i < arr.length; i++) {
			Boolean b = util(arr, n - arr[i], k - 1, matrix);
			matrix[k - 1][n - arr[i]] = b;
		}
		return matrix[k][n];
	}

	public static void main(String[] args) {
		int k = 3;
		int n = 7;
		IsCombinationPossible obj = new IsCombinationPossible();
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(obj.isPossible(arr, n, k));
	}

}
