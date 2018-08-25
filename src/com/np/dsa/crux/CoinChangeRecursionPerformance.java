package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class CoinChangeRecursionPerformance {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int arr[] = ScannerUtils.scanForIntArray(scanner);
		//int n = ScannerUtils.scanForNumber(scanner);
		
		for(int i = 0 ; i<50; i++){
			long start = System.currentTimeMillis();
			System.out.println(count(arr, i));
			long end = System.currentTimeMillis();
			System.out.println("Time taken for n = " + i + ": "  + (end - start));
		}
		

	}

	static int count(int[] array , int n) {
		if (n == 0)
			return 1;

		if (n < 0)
			return 0;
		
		int count = 0;
		for(int i = 0 ; i < array.length ; i++){
			count += count(array, n - array[i]);
		}
		return count;
	}

}
