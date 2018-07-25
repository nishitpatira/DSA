package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class RotatedArrayFindMaxIndex {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		
	}
	
	public static int findMaxIndexRotatedArray(int[] array) {
		int length = array.length;
		int start = 0;
		int end = length - 1;
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if ((array[start] > array[mid]) && (array[mid] < array[end])) {
				end = mid;
			} else if((array[start] < array[mid]) && (array[mid] > array[end])){
				start = mid;
			} else{
				return start;
			}
		}
		return start;
	}
}
