package com.np.dsa.crux;

public class BreakInto3DP {

	public static void main(String[] args) {
		int n = Integer.MAX_VALUE/10;
		long start = System.currentTimeMillis();
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		int sum = dpBreak(n,arr);
		long end = System.currentTimeMillis();
		System.out.println("Time taken to calculate the output for n=" + n + "    is : " + (end - start));
		System.out.println(sum);
	}

	private static int dpBreak(int n, int[] arr) {
		if(n == 0){
			return 0;
		}
		if(arr[n] != 0){
			return arr[n];
		}
		arr[n] = Math.max(n, dpBreak(n/2, arr) + dpBreak(n/3, arr) + dpBreak(n/4, arr));
		return arr[n];
	}
}
