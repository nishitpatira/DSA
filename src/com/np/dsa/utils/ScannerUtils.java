package com.np.dsa.utils;

import java.util.Scanner;

public class ScannerUtils {

	public static int[][] scanForIntMatrix(Scanner scanner) {
		System.out.println("Enter the number of rows in the matrix");
		int numberOfRows = scanner.nextInt();
		System.out.println("Enter the number of columns in the matrix");
		int numberOfColumns = scanner.nextInt();
		int[][] array = new int[numberOfRows][numberOfColumns];
		System.out.println("Enter elements row wise");
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		// scanner.close();
		return array;
	}

	public static int[] scanForIntArray(Scanner scanner) {
		System.out.println("Enter the number of elements in the array");
		int numberOfTimes = scanner.nextInt();
		int i = 0;
		int[] array = new int[numberOfTimes];
		while (numberOfTimes > 0) {
			array[i] = scanner.nextInt();
			numberOfTimes--;
			i++;
		}
		// scanner.close();
		return array;
	}
	
	public static long[] scanForLongArray(Scanner scanner) {
		System.out.println("Enter the number of elements in the array");
		int numberOfTimes = scanner.nextInt();
		int i = 0;
		long[] array = new long[numberOfTimes];
		while (numberOfTimes > 0) {
			array[i] = scanner.nextInt();
			numberOfTimes--;
			i++;
		}
		// scanner.close();
		return array;
	}

	public static int scanForNumber(Scanner scanner) {
		System.out.println("Enter the number");
		int number = Integer.parseInt(scanner.next());
		// scanner.close();
		return number;
	}

	public static String scanForString(Scanner scanner) {
		System.out.println("Please enter the string");
		String str = scanner.next();
		// scanner.close();
		return str;

	}
	
	public static String[] scanForStringArray(Scanner scanner) {
		System.out.println("Enter the number of elements in the array");
		int numberOfTimes = scanner.nextInt();
		int i = 0;
		String[] array = new String[numberOfTimes];
		while (numberOfTimes > 0) {
			array[i] = scanner.next();
			numberOfTimes--;
			i++;
		}
		// scanner.close();
		return array;
	}

}
