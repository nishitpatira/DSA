package com.np.dsa.crux;

import java.util.Arrays;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class MedianOfTwoArrays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array1 = ScannerUtils.scanForIntArray(scanner);
		int[] array2 = ScannerUtils.scanForIntArray(scanner);
		Arrays.sort(array1);
		Arrays.sort(array2);
		System.out.println(findMedianOfCombinedArrays(array1, array2));
	}

	private static int findMedianOfCombinedArrays(int[] array1, int[] array2) {
		int median1 = array1[array1.length / 2];
		int median2 = array2[array2.length / 2];
		int[] array1_new, array2_new;
		if (median1 == median2) {
			return median1;
		}
		else if (array1.length == 1){
			return (array1[0] + array2[0])/2;
		}
		else if (median1 < median2) {
			array1_new = splitSecondHalf(array1);
			array2_new = splitFirstHalf(array2);

		} else {
			array1_new = splitFirstHalf(array1);
			array2_new = splitSecondHalf(array2);
		}
		return findMedianOfCombinedArrays(array1_new, array2_new);
	}

	private static int[] splitFirstHalf(int[] array) {
		int[] newArray = new int[(array.length / 2)];
		for (int i = 0; i <= array.length / 2 - 1; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	private static int[] splitSecondHalf(int[] array) {
		int[] newArray = new int[(array.length / 2)];
		int originalLength = array.length;
		for (int i = (originalLength / 2)+1; i <= originalLength - 1; i++) {
			newArray[i - originalLength / 2] = array[i];
		}
		return newArray;
	}
}
