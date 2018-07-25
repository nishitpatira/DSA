package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

/*Given an array of integers, find the contigious subarray which results in max sum of the eleemnts*/
public class LargestContiguousSubArray {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		int sum = array[0];
		int past = array[0];

		for(int i = 1; i < array.length; i++){
			int max_value_index_i = numberOrSum(array[i], past);
			if(max_value_index_i > sum){
				sum = max_value_index_i;
			}
			past = max_value_index_i;
			
		}
		System.out.println("Max sum from a contiguous sub array is : " + sum);
	}
	
	public static int numberOrSum(int number, int past){
		return Math.max(number, number+past);
	}

}
