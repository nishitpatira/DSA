package com.nishit.hackerrank.goldman;

import java.util.LinkedList;
import java.util.List;

public class Connections {

	private static int rows = 0;
	private static int columns = 0;

	private static final int countConnections(List<List<Integer>> matrix) {
		int count = 0;
		rows = matrix.size();
		columns = matrix.get(0).size();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (!isElemZero(matrix, i, j)) {
					if (i == 0) {
						count += connectionsForFirstRow(matrix, i, j);
					} else {
						if (!isElemZero(matrix, i - 1, j + 1)) {
							count++;
						}
						count += connectionsForFirstRow(matrix, i, j);
					}
				}
			}
		}
		return count;
	}
	
	private static final int connectionsForFirstRow(final List<List<Integer>> matrix, final int i, final int j){
		int count = 0;
		if (!isElemZero(matrix, i, j + 1)) {
			count++;
		}
		if (!isElemZero(matrix, i + 1, j + 1)) {
			count++;
		}
		if (!isElemZero(matrix, i + 1, j)) {
			count++;
		}
		
		return count;
	}

	private static final boolean isElemZero(final List<List<Integer>> matrix, final int row, final int column) {
		if (row > rows - 1 || column > columns - 1)
			return true;
		return matrix.get(row).get(column) == 0 ? true : false;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> argument = new LinkedList<>();
		List<Integer> row1 = new LinkedList<>();
		List<Integer> row2 = new LinkedList<>();
		List<Integer> row3 = new LinkedList<>();
		row1.add(1);
		row1.add(0);
		row1.add(0);
		row1.add(1);
		row2.add(0);
		row2.add(1);
		row2.add(1);
		row2.add(1);
		row3.add(1);
		row3.add(0);
		row3.add(0);
		row3.add(1);
		argument.add(row1);
		argument.add(row2);
		argument.add(row3);
		System.out.println(countConnections(argument));
	}
}
