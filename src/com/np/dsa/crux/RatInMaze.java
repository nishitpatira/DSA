package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class RatInMaze {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		System.out.println(findIfPathExists(matrix, 0, 0));
	}

	public static boolean findIfPathExists(int[][] matrix, int row, int column) {
		if (row == matrix.length - 1 && column != matrix.length - 1) {
			if (matrix[row][column + 1] == 1) {
				return false;
			}
		} else if (column == matrix.length - 1 && row != matrix.length - 1) {
			if (matrix[row + 1][column] == 1) {
				return false;
			}
		} else {
			if (matrix[row + 1][column] == 1 && matrix[row][column + 1] == 1) {
				return false;
			}

		}
		if ((row + 1 == matrix.length - 1 && column == matrix.length - 1)
				|| (row == matrix.length - 1 && column + 1 == matrix.length - 1)) {
			return true;
		}
		if (row == matrix.length - 1) {
			return findIfPathExists(matrix, row, column + 1);
		}
		if (column == matrix.length - 1) {
			return findIfPathExists(matrix, row + 1, column);
		}
		return findIfPathExists(matrix, row + 1, column) || findIfPathExists(matrix, row, column + 1);
	}
}
