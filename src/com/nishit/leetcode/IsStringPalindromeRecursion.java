package com.nishit.leetcode;

public class IsStringPalindromeRecursion {

	public static void main(String[] args) {
		final String str = "nishit";
		System.out.println(isStringPalindrome(str));
	}
	
	private static boolean isStringPalindrome(final String str){
		if(str.length() == 1){
			return true;
		}
		if(str.length() == 2){
			if (str.charAt(0) == str.charAt(1)){
				return true;
			}
			else {
				return false;
			}
		}
		boolean areStartAndEndCharSame;
		if(str.charAt(0) == str.charAt(str.length()-1)){
			areStartAndEndCharSame = true;
		}
		else{
			areStartAndEndCharSame = false;
		}
		return isStringPalindrome(str.substring(1, str.length()-1)) && areStartAndEndCharSame ;
	}
}
