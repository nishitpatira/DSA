package com.np.dsa.twodarray;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class RowColumnSortedFindK {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		int k = ScannerUtils.scanForNumber(scanner);
		findElementIn2DMatrix(matrix, k);
	}
	
	private static void findElementIn2DMatrix(int[][] matrix, int k){
		int ROW = matrix.length;
		int COLUMN = matrix[0].length;
		int row = ROW -1 ;
		int column = 0;
		
		while (row >= 0 && column < COLUMN){
			if( k == matrix[row][column]){
				System.out.println("(" + row + "," + column + ")");
				return;
			}
			
			else if(k > matrix[row][column]){
				column++;
			}
			else if(k < matrix[row][column]){
				row--;
			}
		}
		System.out.println("Not found");
	}

}
