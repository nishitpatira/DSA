package com.np.dsa.crux;

import java.util.Scanner;

public class LongestCommonSubSequenceDP {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
		System.out.println(findLCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length(), matrix));
		scanner.close();
	}

	private static int findLCS(char[] str1, char[] str2, int length1, int length2, int[][] matrix) {

		if (length1 == 0 || length2 == 0) {
			return 0;
		}
		if (matrix[length1][length2] != 0) {
			return matrix[length1][length2];
		}
		if (str1[length1 - 1] == str2[length2 - 1]) {
			int temp = 1 + findLCS(str1, str2, length1 - 1, length2 - 1, matrix);
			matrix[str1.length][str2.length] = temp;
			return matrix[str1.length][str2.length];
		} else {
			int temp1 = findLCS(str1, str2, length1 - 1, length2, matrix);
			int temp2 = findLCS(str1, str2, length1, length2 - 1, matrix);
			matrix[length1][length2] = Math.max(temp1, temp2);
			return matrix[length1][length2];
		}

	}
}
