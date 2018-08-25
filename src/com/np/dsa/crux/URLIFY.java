package com.np.dsa.crux;

//Given a string, write a method to replace all spaces with %20

public class URLIFY {

	public static void main(String[] args) {
		String input = "Mr John Smith    ";
		urlIfy(input.toCharArray(), 13);
	}
	
	public static void urlIfy(char[] input, int trueLength){
		int i = trueLength-1;
		
		while(i >= 0){
			if(input[i] == ' '){
				shiftByTwo(input, i, trueLength-1);
				trueLength += 2;
			}
			i--;
		}
		print(input);
	}
	
	public static void shiftByTwo(char[] input, int start, int end){
		while(end > start){
			input[end+2] = input[end];
			end--;
		}
		input[start+2] = '0';
		input[start+1] = '2';
		input[start] = '%';
		
	}
	
	public static void print(char[] input){
		for(char c : input){
			System.out.print(c);
		}
	}
}
