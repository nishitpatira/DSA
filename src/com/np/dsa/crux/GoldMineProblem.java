package com.np.dsa.crux;
//https://www.geeksforgeeks.org/gold-mine-problem/
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class GoldMineProblem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		System.out.println(findMaxGold(matrix));
	}
	
	public static int findMaxGold(int[][] matrix){
		int[][] preProcessedMatrix = preProcess(matrix);
		int max = -1;
		for(int i = 0; i<preProcessedMatrix.length; i++){
			if(preProcessedMatrix[i][0] > max){
				max = preProcessedMatrix[i][0];
			}
		}
		return max;
	}
	
	public static int[][] preProcess(int[][] matrix){
		int[][] preProcessedMatrix = new int[matrix.length][matrix[0].length];
		for(int j = matrix[0].length - 1; j>=0; j--){
			for(int i = 0; i<= matrix.length -1 ; i++){
				if(j == matrix[0].length -1){
					preProcessedMatrix[i][j] = matrix[i][j];
				}
				else {
					preProcessedMatrix[i][j] = matrix[i][j] + findMaxOfNeighbours(preProcessedMatrix, i, j);
				}
			}
		}
		return preProcessedMatrix;
	}
	
	public static int findMaxOfNeighbours(int[][] matrix, int i, int j){
		if(i == 0){
			return Math.max(matrix[i+1][j+1], matrix[i][j+1]);	
		} else if(i == matrix.length -1){
			return Math.max(matrix[i][j+1], matrix[i-1][j+1]);	
		} else {
			return Math.max(matrix[i+1][j+1], Math.max(matrix[i][j+1], matrix[i-1][j+1]));	
		}
		
	}
}
