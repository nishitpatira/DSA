package com.np.dsa.utils;

import java.util.Arrays;
import java.util.List;

public class Utils {
	private static int[] primeNumbers = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 69, 71,
			73, 79, 83, 89, 97, 101 };

	public static final void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}

	public static final void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void copySelfImplementation(int[] array, int start, int end) {
		int temp = array[end];
		for (int k = end - 1; k >= start; k--) {
			array[k + 1] = array[k];
		}
		array[start] = temp;
	}

	public static void copyJavaImplementation(int[] array, int start, int end) {
		Arrays.copyOfRange(array, start, end);
	}

	public static void removeLastElementFromList(List<Integer> list) {
		list.remove(list.size() - 1);
	}

	public static long stringHash(String str) {
		long hashValue = 0;
		for (int i = 0; i < str.length(); i++) {
			hashValue = hashValue * primeNumbers[str.charAt(i) % 65] * (str.charAt(i) % 65);
		}
		return hashValue;
	}

}
