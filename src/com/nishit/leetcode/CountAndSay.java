package com.nishit.leetcode;

public class CountAndSay {
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(countAndSay(n));
	}
	
	private static String countAndSay(int n){
		String start = "1";
		if(n <= 0){
			return null;
		}
		if(n == 1){
			return start;
		}
		n--;
		while(n > 0){
			int count = 1;
			StringBuilder builder = new StringBuilder();
			for(int i = 0 ; i < start.length() -1 ; i++){
				if(start.charAt(i) == start.charAt(i+1)){
					count++;
				} else {
					builder.append(count);
					builder.append(start.charAt(i));
					count = 1;
				}
			}
			builder.append(count);
			builder.append(start.charAt(start.length()-1));
			start = builder.toString();
			n--;
		}
		return start;
	}

}
