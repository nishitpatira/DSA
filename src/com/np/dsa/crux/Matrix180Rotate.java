package com.np.dsa.crux;

import com.np.dsa.utils.Utils;

public class Matrix180Rotate {

	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		Matrix180Rotate obj = new Matrix180Rotate();
		System.out.println("Before Rotate");
		Utils.printMatrix(matrix);
		obj.rotate180(matrix);
		System.out.println("After Rotate");
		Utils.printMatrix(matrix);
	}
	
	public void rotate180(final int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix.length == 1){
			return;
		}
		int startRow = 0;
		int endRow = matrix.length - 1;
		while(startRow <= endRow){
			for(int i = 0; i <= matrix.length - 1; i++){
				int temp = matrix[startRow][i];
				matrix[startRow][i] = matrix[endRow][matrix.length - 1 - i];
				matrix[endRow][matrix.length - 1 - i] = temp;
			}
			startRow++;
			endRow--;
		}
	}
}
