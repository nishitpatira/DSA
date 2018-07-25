package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

//http://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
public class RotatedArrayFindElementsOfGivenSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);

		int highestNumberIndex = RotatedArrayFindMaxIndex.findMaxIndexRotatedArray(array);
		int lowestNumberIndex = (highestNumberIndex + 1) % array.length;
		int sum = 0;
		int givenSum = ScannerUtils.scanForNumber(scanner);
		scanner.close();
		int i = highestNumberIndex;
		int j = lowestNumberIndex;
		int mySum;
		boolean pairExists = false;
		while (i != j) {
			if (array[i] + array[j] > givenSum) {
				if (i == 0) {
					i = array.length - 1;
				} else {
					i = i - 1;
				}
			} else if (array[i] + array[j] < givenSum) {
				j = (j + 1) % array.length;
			} else {
				System.out.println("Pair is : " + array[i] + " " + array[j]);
				pairExists = true;
				break;
			}
		}
		if(!pairExists){
			System.out.println("No Pair");
		}
		

	}
}
