package com.np.dsa.crux;

public class LongestPalindromicSubString {

	static void printSubStr(String str, int low, int high) {
		System.out.println(str.substring(low, high + 1));
	}

	static int longestPalSubstr(String str) {

		int len = str.length();

		int global_max = 1;
		int low, high, count;

		for (int i = 1; i < len; ++i) {
			count = 1;
			low = i - 1;
			high = i;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
				count++;
				global_max = Math.max(count, global_max);
				--low;
				++high;
			}

			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
				count++;
				global_max = Math.max(count, global_max);
				--low;
				++high;
			}
		}

		System.out.print("Longest palindrome substring is: ");

		return global_max;
	}

	public static void main(String[] args) {

		//String str = "forgeeksskeegfor";
		String str = "facebook";
		System.out.println("Length is: " + longestPalSubstr(str));
	}

}
