package com.nishit.leetcode;

//https://leetcode.com/problems/repeated-substring-pattern/description/
public class RepeatedSubString {
	public static void main(String[] args) {
		String str = "aba";
		RepeatedSubString repeated = new RepeatedSubString();
		System.out.println(repeated.repeatedSubstringPattern(str));
	
	}
	
	public boolean repeatedSubstringPattern(final String str){
		StringBuilder builder = new StringBuilder();
		builder.append(str);
		builder.append(str);
		String removeFirstAndLast = builder.substring(1, builder.length() - 1);
		return removeFirstAndLast.contains(str) == true ? true : false;
		
	}
	
}
