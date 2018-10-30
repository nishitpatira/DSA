package com.np.dsa.crux;

import com.np.dsa.utils.Utils;

public class ClockWiseRotate2DArray {
	
	public static void main(String[] args) {
		final int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		ClockWiseRotate2DArray obj = new ClockWiseRotate2DArray();
		System.out.println("Before Rotate : ");
		Utils.printMatrix(matrix);
		obj.rotate(matrix);
		System.out.println("After Rotate : ");
		Utils.printMatrix(matrix);
	}
	
	public final void rotate(final int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix.length == 1){
			return;
		}
		transpose(matrix);
		mirror(matrix);
		
	}
	
	public static void mirror(final int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length == 1) {
			return;
		}
		int startColumn = 0;
		int endColumn = matrix.length - 1;
		int temp = 0;
		while (startColumn < endColumn) {
			for (int i = 0; i < matrix.length; i++) {
				temp = matrix[i][startColumn];
				matrix[i][startColumn] = matrix[i][endColumn];
				matrix[i][endColumn] = temp;
			}
			startColumn++;
			endColumn--;
		}
	}
	
	
	private void transpose(final int[][] matrix){
		if (matrix == null || matrix.length == 0 || matrix.length == 1){
			return;
		}
		final int n = matrix.length;
		int i = 0;
		int temp = 0;
		while (i <= n){
			for(int k = i ; k < n ; k++){
				temp = matrix[i][k];
				matrix[i][k] = matrix[k][i];
				matrix[k][i] = temp;
			}
			i++;
		}
	}

}
