package com.np.dsa.crux;

/*
 * author @nishit
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.np.dsa.utils.ScannerUtils;

public class CountSubStringsWithKDistinctCharacters {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = ScannerUtils.scanForString(scanner);
		int k = ScannerUtils.scanForNumber(scanner);

		final int count = countSubArraysKDistinct(input, k);
		scanner.close();
		System.out.println(count);

	}

	private static int countSubArraysKDistinct(final String input, final int k) {
		int count = 0;
		char[] inputArray = input.toCharArray();
		for (int i = 0; i < inputArray.length; i++) {
			Set<Character> distinctChars = new HashSet<>();
			distinctChars.add(inputArray[i]);
			for (int j = i + 1; j < inputArray.length; j++) {
				distinctChars.add(inputArray[j]);
				if (distinctChars.size() < k) {
				} else if (distinctChars.size() == k) {
					count++;
				} else {
					break;
				}
			}
		}
		return count;
	}
}
