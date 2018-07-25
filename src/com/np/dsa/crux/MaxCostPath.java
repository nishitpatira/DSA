package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class MaxCostPath {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		System.out.println(maxCostPath(matrix));
	}

	private static int maxCostPath(int[][] matrix){
		int[][] auxArray = new int[matrix[0].length][matrix.length];
		auxArray[0][0] = matrix[0][0];
		for(int i = 1; i< matrix[0].length; i++){
			auxArray[i][0] = matrix[i][0] + auxArray[i-1][0];
			auxArray[0][i] = matrix[0][i] + auxArray[0][i-1];
		}
		for(int i = 1; i< matrix[0].length ; i++){
			for(int j = 1; j< matrix.length ; j++){
				auxArray[i][j] = matrix[i][j] + findMax(i, j, auxArray);
			}
		}
		return auxArray[matrix[0].length-1][matrix.length-1];
	}
	
	private static int findMax(int i, int j, int[][] auxArray){
		return Math.max(auxArray[i-1][j-1], Math.max(auxArray[i-1][j], auxArray[i][j-1]));
	}
}
