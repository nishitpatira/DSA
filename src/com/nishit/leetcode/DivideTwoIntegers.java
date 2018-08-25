package com.nishit.leetcode;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		int dividend = -2147483648;
		int divisor = 1;
		System.out.println(divide(dividend, divisor));
	}
	
	private static int divide(int dividend, int divisor){
		int count = 0;
		boolean isNegative =false;
		if(dividend < 0 ^ divisor < 0){
			isNegative = true;
		}
		if(dividend != Integer.MIN_VALUE){
			dividend = Math.abs(dividend);	
		} else {
			dividend = Math.abs(dividend + 1);
		}
		
		divisor = Math.abs(divisor);
		dividend = dividend - divisor;
		while(dividend >= 0){
			if(dividend > Integer.MAX_VALUE || dividend < Integer.MIN_VALUE){
				return Integer.MAX_VALUE;
			}
			count++;
			dividend = dividend - divisor;
		}
		return isNegative ? -1 * count : count; 
		
	}
}
