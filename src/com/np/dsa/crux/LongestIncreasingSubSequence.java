package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;
import com.np.dsa.utils.Utils;
//https://ide.geeksforgeeks.org/zHpHTqr5iN
public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		int[] aux = new int[array.length];
		scanner.close();
		aux[0] = 1;
		for (int i = 1; i < array.length; i++) {
			int value = 0;
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i]) {
					if (aux[j] >= value) {
						value = aux[j] + 1;
						aux[i] = value;
					}
				}
			}
		}
		Utils.printArray(aux);
	}
}
