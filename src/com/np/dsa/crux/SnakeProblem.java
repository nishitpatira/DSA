package com.np.dsa.crux;

import java.util.LinkedList;
import java.util.List;

//https://www.geeksforgeeks.org/find-maximum-length-snake-sequence/
public class SnakeProblem {

	private static int max_length = -1;
	private static int max_i = -1;
	private static int max_j = -1;

	public static void main(String[] args) {
		int[][] arr = { { 9, 6, 5, 2 }, { 8, 7, 6, 5 }, { 7, 3, 1, 6 }, { 1, 1, 1, 7 }, };
		int[][] aux = snakeSequence(arr);
		System.out.println("Max Length is : " + max_length);
		List<Integer> list = printMaxPath(arr, aux);
		for (int i : list) {
			System.out.print(i + " -> ");
		}
	}

	public static List<Integer> printMaxPath(int[][] arr, int[][] aux) {
		int temp_length = max_length;
		int temp_row = max_i;
		int temp_column = max_j;
		List<Integer> list = new LinkedList<>();
		list.add(arr[temp_row][temp_column]);
		temp_length--;
		while (temp_length != 0) {
			if (temp_row != 0 && temp_column != 0) {
				if (aux[temp_row - 1][temp_column] == temp_length) {
					list.add(arr[temp_row - 1][temp_column]);
					temp_row--;
					temp_length--;
				} else if (aux[temp_row][temp_column - 1] == temp_length) {
					list.add(arr[temp_row][temp_column - 1]);
					temp_column--;
					temp_length--;
				}
			} else if (temp_row == 0) {
				if (aux[temp_row][temp_column - 1] == temp_length) {
					list.add(arr[temp_row][temp_column - 1]);
					temp_column--;
					temp_length--;
				}
			} else {
				if (aux[temp_row - 1][temp_column] == temp_length) {
					list.add(arr[temp_row - 1][temp_column]);
					temp_row--;
					temp_length--;
				}
			}
		}
		return list;
	}

	private static int[][] snakeSequence(int[][] arr) {
		int[][] aux = new int[arr.length][arr[0].length];
		aux[0][0] = 1;
		for (int i = 1; i < aux.length; i++) {
			if (Math.abs(arr[0][i - 1] - arr[0][i]) == 1) {
				aux[0][i] = 1 + aux[0][i - 1];
				compareWithCurrentMax(aux, 0, i);
			}
			if (Math.abs(arr[i - 1][0] - arr[i][0]) == 1) {
				aux[i][0] = 1 + aux[i - 1][0];
				compareWithCurrentMax(aux, i, 0);
			}
		}

		for (int i = 1; i < aux.length; i++) {
			for (int j = 1; j < aux.length; j++) {
				int fromLeft = 0;
				int fromTop = 0;
				if (Math.abs(arr[i - 1][j] - arr[i][j]) == 1) {
					fromTop = aux[i - 1][j];
				}
				if (Math.abs(arr[i][j - 1] - arr[i][j]) == 1) {
					fromLeft = aux[i][j - 1];
				}
				aux[i][j] = 1 + Math.max(fromLeft, fromTop);
				compareWithCurrentMax(aux, i, j);
			}
		}
		return aux;
	}

	public static void compareWithCurrentMax(int[][] matrix, int row, int column) {
		if (matrix[row][column] > max_length) {
			max_length = matrix[row][column];
			max_i = row;
			max_j = column;
		}
	}
}
