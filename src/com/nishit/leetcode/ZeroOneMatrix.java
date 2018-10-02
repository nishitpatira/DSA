package com.nishit.leetcode;

//https://leetcode.com/problems/01-matrix/description/
public class ZeroOneMatrix {

	public static void main(String[] args) {
		ZeroOneMatrix obj = new ZeroOneMatrix();
		/*final int[][] matrix = { {1,1,1},
								 {1,0,1},
								 {1,1,1}
		};*/
		final int[][] matrix = {{0,1}};
		obj.updateMatrix(matrix);
	}

	public int[][] updateMatrix(final int[][] matrix) {
		int[][] newMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				newMatrix[i][j] = 10000;
				if (matrix[i][j] == 0) {
					newMatrix[i][j] = 0;
				}
			}
		}
		traverseMatrix(newMatrix);
		traverseMatrix(newMatrix);
		return newMatrix;
	}

	public void traverseMatrix(final int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] != 0){
					traverseElement(matrix, i, j);
				}
			}
		}
	}

	private void traverseElement(final int[][] matrix, final int i, final int j) {
		// Move only in 2 directions
		if (isCorner(i, j, matrix.length, matrix[0].length)) {
			if (i == 0) {
				if (j == 0) {
					// Top Left Corner
					matrix[i][j] = Math.min(matrix[0][1], matrix[1][0])+1;

				} else {
					// Top Right Corner
					matrix[i][j] = Math.min(matrix[0][matrix[0].length-2], matrix[1][matrix[0].length-1])+1;
				}
			} else {
				if (j == 0) {
					// Bottom Left Corner
					matrix[i][j] = Math.min(matrix[matrix.length-2][0], matrix[matrix.length-1][1])+1;
				} else {
					// Bottom Right Corner
					matrix[i][j] = Math.min(matrix[matrix.length-1][matrix[0].length-2], matrix[matrix.length-2][matrix[0].length-1])+1;
				}
			}
		}
		// Move only in 3 directions
		else if (isEdge(i, j, matrix.length, matrix[0].length)) {
			if (i == 0) {
				//Top Row
				matrix[i][j] = Math.min(matrix[i][j-1], Math.min(matrix[i][j+1], matrix[i+1][j]))+1;
			} else if (i == matrix.length - 1) {
				//Last Row
				matrix[i][j] = Math.min(matrix[i][j-1], Math.min(matrix[i][j+1], matrix[i-1][j]))+1;
			} else if (j == 0) {
				//First Column
				matrix[i][j] = Math.min(matrix[i+1][j], Math.min(matrix[i-1][j], matrix[i][j+1]))+1;
			} else {
				//Last Column
				matrix[i][j] = Math.min(matrix[i][j-1], Math.min(matrix[i+1][j], matrix[i-1][j]))+1;
			}
		}else {
			// Move in all 4 directions
			matrix[i][j] = Math.min(Math.min(matrix[i+1][j], matrix[i-1][j]), Math.min(matrix[i][j+1], matrix[i][j-1]))+1;	
		}

		
	}

	private static boolean isCorner(int i, int j, int rows, int columns) {
		if (i == 0 || i == rows - 1) {
			if (j == 0 || j == columns - 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean isEdge(int i, int j, int rows, int columns) {
		if ((((i == 0 || i == rows - 1) && (j > 0 && j <= columns - 1))
				|| (((j == 0 || j == columns - 1) && (i > 0 && i <= rows - 1))))) {
			return true;
		}
		return false;
	}
}
