package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class PatternMatching {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = ScannerUtils.scanForString(scanner);
		String pattern = ScannerUtils.scanForString(scanner);
		scanner.close();
		System.out.println(match(input, pattern));
	}

	private static boolean match(String input, String pattern) {
		int firstChar = 0;
		int index = 0;
		for (int i = 0; i < pattern.length() && index < input.length(); i++) {
			if (pattern.charAt(i) == input.charAt(index)) {
				firstChar = index;
				index++;

			} else if (pattern.charAt(i) == '?') {
				index++;
			} else if (pattern.charAt(i) == '*') {
				
			}
			else {
				i = -1;
				index = firstChar + 1;
			}
		}
		return true;
	}
}
