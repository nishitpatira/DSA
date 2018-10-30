package com.nishit.acko;

import java.util.HashSet;
import java.util.Set;

class PalindromicSubStrings {
	public static void expandBothSides(String str, int low, int high, Set<String> set) {
		while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
			set.add(str.substring(low, high + 1));
			high++;
			low--;
			
		}
	}

	public static int palindrome(final String str) {
		final Set<String> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			expandBothSides(str, i, i, set);
			expandBothSides(str, i, i + 1, set);
		}
		return set.size();
	}

	public static void main(String[] args) {
		String str = "aabaa";

		System.out.println(palindrome(str));
	}
}