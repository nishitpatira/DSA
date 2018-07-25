//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		int givenSum = ScannerUtils.scanForNumber(scanner);
		findSubArrayWithGivenSum(array, givenSum);
	}

	private static void findSubArrayWithGivenSum(int[] array, int givenSum) {
		int movingSum = 0;
		int trailingIndex = 0;
		for (int i = 0; i < array.length; i++) {
			while (movingSum + array[i] > givenSum && trailingIndex <= i) {
				movingSum = movingSum - array[trailingIndex];
				trailingIndex++;
			}
			movingSum = movingSum + array[i];
			if (movingSum == givenSum) {
				System.out.println(
						"Starting index of sub array is : " + trailingIndex + " Ending index of sub array is : " + i);
				return;
			}
		}
		System.out.println("There is no sub array with zero sum");
	}

}
