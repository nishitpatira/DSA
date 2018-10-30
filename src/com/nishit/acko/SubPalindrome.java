package com.nishit.acko;

import java.util.HashSet;
import java.util.Set;

public class SubPalindrome {
	
	public static void main(String[] args) {
		final String input = "aabaa";
		System.out.println(palindrome(input));
	}
	
	static int palindrome(final String input){
		Set<Character> charSet = new HashSet<>();
		for(Character c : input.toCharArray()){
			charSet.add(c);
		}
		return palindromeUtil(input) + charSet.size();
	}

	static int palindromeUtil(final String input) {
		int dp[][] = new int[input.length()][input.length()];
		boolean P[][] = new boolean[input.length()][input.length()];
		for (int i = 0; i < input.length(); i++)
			P[i][i] = true;
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1)) {
				P[i][i + 1] = true;
				dp[i][i + 1] = 1;
			}
		}

		for (int gap = 2; gap < input.length(); gap++) {
			for (int i = 0; i < input.length() - gap; i++) {
				int j = gap + i;
				if (input.charAt(i) == input.charAt(j) && P[i + 1][j - 1])
					P[i][j] = true;

				if (P[i][j] == true)
					dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1 - dp[i + 1][j - 1];
				else
					dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
			}
		}
		return dp[0][input.length() - 1];
	}
}
