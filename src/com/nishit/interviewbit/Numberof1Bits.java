package com.nishit.interviewbit;

public class Numberof1Bits {

	public static void main(String[] args) {
		long input = 11;
		System.out.println(numSetBits(input));
	}
	
	public static int numSetBits(long num){
		long temp = num;
		long one = 1;
		int count = 0;
		while (num != 0){
			temp = num;
			long and = temp & one;
			if(and == 1){
				count++;
			}
			num = num >> 1;
		}
		return count;
	}
}
