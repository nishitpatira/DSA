package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class SpiralMatrixPrinting {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = ScannerUtils.scanForIntMatrix(scanner);
		
		spiralPrint(matrix);
	}
	
	private static void spiralPrint(int[][] matrix){
		int start_row = 0;
		int end_row = matrix.length - 1;
		int start_column = 0;
		int end_column = matrix[0].length - 1;
		
		while(start_row <= end_row && start_column <= end_column){
			for(int i = start_column ; i <= end_column ; i++){
				System.out.println(matrix[start_row][i]);
			}
			start_row++;
			
			for(int j = start_row ; j <= end_row ; j++){
				System.out.println(matrix[j][end_column]);
			}
			end_column--;
			
			for(int k = end_column ; k >= start_column ; k-- ){
				System.out.println(matrix[end_row][k]);
			}
			end_row--;
			
			for(int l = end_row ; l >= start_row ; l--){
				System.out.println(matrix[l][start_column]);
			}
			start_column++;	
		}
		
	}

}
