package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;
import com.np.dsa.utils.Utils;

public class MatrixTranspose {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		for(int i = 0; i< matrix.length ; i++){
			for(int j = matrix[0].length-1 ; j > i ; j--){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		Utils.printMatrix(matrix);
	}
}
