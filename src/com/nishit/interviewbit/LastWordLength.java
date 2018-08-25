package com.nishit.interviewbit;
//https://codelab.interviewbit.com/problems/lengthlast/
public class LastWordLength {

	public static void main(String[] args) {
		String input = "  ";
		System.out.println(lengthOfLastWord(input));
	}
	
	public static int lengthOfLastWord(final String input){
		int count = 0;
		int space = input.length()-1;
		if(input.length() == 0){
			return 0;
		}
		while(input.charAt(space) == ' '){
			space = space-1;
			if(space == -1){
				return 0;
			}
		}
		
		char[] trimmed = new char[space+1];
		for(int i = 0 ; i <= space; i++){
			trimmed[i] = input.charAt(i);
		}
		for(int i = trimmed.length -1 ; i >=0 ; i--){
			if(trimmed[i] != ' '){
				count++;
			} else {
				break;
			}
		}
		
		return count;
	}
}
