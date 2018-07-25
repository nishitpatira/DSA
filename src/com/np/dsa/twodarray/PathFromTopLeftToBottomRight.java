package com.np.dsa.twodarray;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class PathFromTopLeftToBottomRight {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		boolean pathExists = findIfPathExists(matrix);
		System.out.println(pathExists);
	}

	private static boolean findIfPathExists(int[][] matrix) {
		boolean[][] booleanMatrix = new boolean[matrix.length][matrix[0].length];
		booleanMatrix[matrix.length - 1][matrix[0].length - 1] = true;
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {

				if (i == matrix.length - 1 && j == matrix[0].length - 1) {
					continue;
				}

				if (i == matrix.length - 1) {
					if (booleanMatrix[i][j + 1] == true && matrix[i][j] == 0) {
						booleanMatrix[i][j] = true;
					}
				}
				else if (j == matrix[0].length - 1) {

					if (booleanMatrix[i + 1][j] == true && matrix[i][j] == 0) {
						booleanMatrix[i][j] = true;
					}
				}
				else {
					if((booleanMatrix[i+1][j] || booleanMatrix[i][j+1]) && matrix[i][j] == 0){
						booleanMatrix[i][j] = true;
					}
				}
			}
		}
		return booleanMatrix[0][0];
	}

}
