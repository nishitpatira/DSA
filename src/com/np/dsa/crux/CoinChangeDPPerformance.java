package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;
//Has been written for only array of size 3.
public class CoinChangeDPPerformance {

	private static int[] auxArray;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int arr[] = ScannerUtils.scanForIntArray(scanner);
		//int n = ScannerUtils.scanForNumber(scanner);
		for(int i = 0 ; i<50;i++){
			int n = i;
			long start = System.currentTimeMillis();
			auxArray = new int[n+1];
			auxArray[0] = 1;
			System.out.println("Number of ways in which coin can be changed is: " + count(arr, n));
			long end = System.currentTimeMillis();
			System.out.println("Time taken for n = " + i + ": "  + (end - start));
		}
	}

	static int count(int[] array, int n) {
		if (n == 0)
			return auxArray[0];

		if (n < 0)
			return 0;
		
		else {
			if(auxArray[n] != 0){
				return auxArray[n];
			}
			else {
				int count = count(array, n - 1) + count(array, n - 2) + count(array, n - 3);
				auxArray[n] = count;
				return count;
			}
		}

		
		
	}

}
