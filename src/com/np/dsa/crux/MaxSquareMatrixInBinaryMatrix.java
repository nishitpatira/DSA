//https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class MaxSquareMatrixInBinaryMatrix {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		findMaxSquareMatrixWithOnes(matrix);
	}
	
	private static void findMaxSquareMatrixWithOnes(int[][] matrix){
		int[][] auxArray = new int[matrix.length][matrix[0].length];
		
		
		
	}

}
