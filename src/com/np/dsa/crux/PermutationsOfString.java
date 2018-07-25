package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class PermutationsOfString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = ScannerUtils.scanForString(scanner);
		permutation(input, 0, input.length() - 1);
		scanner.close();
	}

	private static void permutation(String input, int initial, int swapIndex) {
		if (input.length() == 0) {
			return;
		}
		if (initial == swapIndex) {
			System.out.println(input);
		} else {
			for (int i = initial; i <= swapIndex; i++) {
				input = swap(input, initial, i);
				permutation(input, initial + 1, swapIndex);
				input = swap(input, i, initial);
			}
		}
	}

	private static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
