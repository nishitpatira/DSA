package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class MinCostPathWrong {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		int row = ScannerUtils.scanForNumber(scanner);
		int column = ScannerUtils.scanForNumber(scanner);
		scanner.close();
		int minSum = findMinPath(matrix, row, column);
		System.out.println("Minimum sum is :" + minSum);
	}
	
	public static int findMinPath(int[][] matrix, int rowIndex, int columnIndex){
		int minPath = matrix[rowIndex][columnIndex];
		int local_row = rowIndex;
		int local_column = columnIndex;
		while(local_row != 0 && local_column!= 0){
			int[] array = findMinForGivenIndex(matrix,local_row, local_column);
			minPath = minPath + array[0];
			local_row = array[1];
			local_column = array[2];
		}
		return minPath + matrix[0][0];
	}
	
	public static int[] findMinForGivenIndex(int[][] matrix, int row, int column){
		int[] returnVals = new int[3];
		int min_1 = Integer.MAX_VALUE, min_2 = Integer.MAX_VALUE, min_3 = Integer.MAX_VALUE;
		if(column > 0){
			min_1 = matrix[row][column-1];
		}
		
		if(row > 0){	
			min_2 = matrix[row-1][column];
		}
		
		if((row > 0) && (column > 0)){
			min_3 = matrix[row-1][column-1];
		}
		int min = Math.min(min_1, Math.min(min_2, min_3));
		returnVals[0] = min;
		if(min == min_1){
			returnVals[1] = row;
			returnVals[2] = column-1;
		}
		else if(min == min_2){
			returnVals[1] = row-1;
			returnVals[2] = column;
		} 
		else{
			returnVals[1] = row-1;
			returnVals[2] = column-1;
		}
		return returnVals;
	}
}
