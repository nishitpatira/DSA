package com.np.dsa.crux;

import com.np.dsa.utils.Utils;

//Given a square matrix(nxn), transpose the matrix in place.

public class TransposeMatrix {
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,2,3},
				{5,6,7},
				{9,10,11}
		};
		System.out.println("Before Transpose : ");
		Utils.printMatrix(matrix);
		Utils.transpose(matrix);
		System.out.println("After Transpose : ");
		Utils.printMatrix(matrix);
	}
}
