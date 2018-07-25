package com.nishit.leetcode;
//https://leetcode.com/problems/regular-expression-matching/description/
public class RegexMatching {

	public static void main(String[] args) {
		final String input = "aaa";
		final String pattern = "aaaa";
		System.out.println(isMatch(input, pattern));
	}
	
	private static boolean isMatch(final String input, final String pattern) {
		if(pattern.length() == 0 || pattern.trim().length() == 0 || input.length() == 0 || input.trim().length() == 0){
			return false;
		}
		if(pattern.equals(".*")){
			return true;
		}
		if(pattern.charAt(0) == '*'){
			return false;
		}
		int i = 0,j = 0;
		while(i < input.length() && j < pattern.length()-1){
			if(pattern.charAt(j) == '.'){
				j++;
				i++;
			} else if(pattern.charAt(j) != '*' && pattern.charAt(j) != '.'){
				if(pattern.charAt(j+1) != '*'){
					if(pattern.charAt(j) == pattern.charAt(i)){
						i++;
						j++;
					}
					else {
						return false;
					}
				} else {
					while(i < input.length() && pattern.charAt(j) == input.charAt(i)){
						i++;
					}
					j = j+2;
				}
			} else {
				if(pattern.charAt(j-1) == '.'){
					if(input.charAt(i) == input.charAt(i-1)){
						i++;
						j++;						
					} else{
						j++;
					}

				}
			}
		}
		
		if(j == pattern.length() - 1 && i != input.length()){
			if(pattern.charAt(j) == '*'){
				//Do Nothing
			} else if(pattern.charAt(j) == '.'){
				i++;
			} else {
				if(pattern.charAt(j) == input.charAt(i)){
					i++;
				}
				else {
					return false;
				}
			}
		} else if(j != pattern.length() && i == input.length()) {
			return false;
		}
		if(i == input.length()){
			return true;
		} else {
			return false;
		}
		
		//return true;
	}
}
