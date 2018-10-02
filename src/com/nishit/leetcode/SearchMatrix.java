package com.nishit.leetcode;

public class SearchMatrix {

	public static void main(String[] args) {
		SearchMatrix search = new SearchMatrix();
		int[][] matrix = { 
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,50}
		};
		int target = 3;
		System.out.println(search.searchMatrix(matrix, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int rows;
		int columns;
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		try{
			rows = matrix.length;
			columns = matrix[0].length;
		} catch(Exception e){
			return false;
		}
		

		int startPoint = 0;
		int endPoint = (rows * columns) - 1;

		while (startPoint <= endPoint) {
			int midPoint = (startPoint + endPoint) >> 1;
			int midPointRow = midPoint / columns;
			int midPointColumn = midPoint % columns;
			if (matrix[midPointRow][midPointColumn] > target) {
				endPoint = midPoint-1;
			} else if (matrix[midPointRow][midPointColumn] == target) {
				return true;
			} else {
				startPoint = midPoint+1;
			}
		}
		return false;
	}

}
