package com.nishit.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

	public static void main(String[] args) {
		String str = "ABC";
		int rows = 2;
		ZigZagConversion obj = new ZigZagConversion();
		System.out.println(obj.convert(str, rows));
	}

	private String convertToString(List<Character>[] matrix) {
		StringBuilder builder = new StringBuilder();
		for (List<Character> list : matrix) {
			for (Character c : list) {
				builder.append(c);
			}
		}
		return builder.toString();
	}

	public String convert(String s, int numRows) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		if (numRows == 1) {
			return s;
		}
		List<Character>[] matrix = new ArrayList[numRows];
		for (int i = 0; i < numRows; i++) {
			matrix[i] = new ArrayList<>();
		}
		createMatrix(matrix, s);
		return convertToString(matrix);
	} 

	private void createMatrix(List<Character>[] matrix, String s) {
		char[] arr = s.toCharArray();
		int currentRow = 1;
		matrix[0].add(arr[0]);
		boolean goDown = true;

		for (int i = 1; i < arr.length; i++) {
			if (goDown) {
				matrix[currentRow].add(arr[i]);
				if (changeDirection(currentRow, matrix.length)) {
					goDown = !goDown;
					currentRow--;
					continue;
				}
				currentRow++;
			} else {
				matrix[currentRow].add(arr[i]);
				if (changeDirection(currentRow, matrix.length)) {
					goDown = !goDown;
					currentRow++;
					continue;
				}
				currentRow--;
			}
		}

	}

	private boolean changeDirection(int currentRow, int maxRow) {
		return (currentRow == 0 || currentRow >= maxRow - 1) ? true : false;
	}

}
