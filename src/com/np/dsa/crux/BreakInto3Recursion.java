package com.np.dsa.crux;

public class BreakInto3Recursion {

	public static void main(String[] args) {
		int n = 0;
		long start = System.currentTimeMillis();
		int sum = recursiveBreak(n);
		long end = System.currentTimeMillis();
		System.out.println("Time taken to calculate the output for n=" + n + "    is : " + (end-start));
		System.out.println(sum);
	}
	
	private static int recursiveBreak(int n){
		if( n == 0 || n == 1){
			return n;
		}
		
		int half = recursiveBreak(n >> 1);
		int third = recursiveBreak(n/3);
		int fourth = recursiveBreak(n >> 2);
		return Math.max(n, half+third+fourth);
	}
}
