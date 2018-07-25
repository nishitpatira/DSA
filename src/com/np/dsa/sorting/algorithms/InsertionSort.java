package com.np.dsa.sorting.algorithms;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;
import com.np.dsa.utils.Utils;

public class InsertionSort {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		scanner.close();
		insertionSort(array);
	}
	
	public static void insertionSort(int[] array){
		for(int i = 1; i< array.length ; i++){
			if(array[i] < array[i-1]){
				for(int j = 0 ; j<i ; j++){
					if(array[j] > array[i]){
						Utils.copySelfImplementation(array,j,i);
						//Utils.copyJavaImplementation(array,j,i);
					}
				}
			}
		}
		Utils.printArray(array);
	}

}
