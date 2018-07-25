package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class StockBuySell {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] matrix = ScannerUtils.scanForIntArray(scanner);
		findBuyAndSell(matrix);
	}

	private static void findBuyAndSell(int[] matrix) {
		int local_min = matrix[0], local_max = 0, local_profit = 0, global_profit = 0;
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i] < local_min) {
				local_max = 0;
				local_min = matrix[i];
				local_profit = 0;
			} else if (matrix[i] > local_min) {
				if (matrix[i] - local_min > local_profit) {
					local_max = matrix[i];
					local_profit = matrix[i] - local_min;
					global_profit = local_profit;
				}
			}
		}
		System.out.println("Max Profit is : " + global_profit);
	}
}
