package com.np.dsa.twodarray;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class SpiralPrint {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		printSpiral(matrix);
	}

	private static void printSpiral(int[][] matrix) {
		int rowStart = 0;
		int columnStart = 0;
		int rowEnd = matrix.length-1;
		int columnEnd = matrix[0].length-1;

		while (rowStart <= rowEnd && columnStart <= columnEnd) {
			
			for (int i = columnStart; i <= columnEnd; i++) {
				System.out.println(matrix[rowStart][i]);
			}
			rowStart++;
			
			for (int j = rowStart; j <= rowEnd; j++) {
				System.out.println(matrix[j][columnEnd]);
			}
			columnEnd--;
			
			for (int k = columnEnd; k >= columnStart; k--) {
				System.out.println(matrix[rowEnd][k]);
			}
			rowEnd--;
			
			for (int l = rowEnd; l >= rowStart; l--) {
				System.out.println(matrix[l][columnStart]);			
			}
			columnStart++;
		}
	}

}
