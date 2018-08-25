package com.np.dsa.crux;

//Given an array, find all subarrays whose sum matches a target

public class ArraySubArraySum {

	public static void main(String[] args) {

		int[] arr = { 3, 34, 4, 5, 4, 6, 1, 2, 12 };
		int target = 9;
		findSubArray(arr, target);
	}

	private static void findSubArray(final int[] arr, final int target) {
		int start = 0;
		int end = 0;
		int sum = 0;
		while (end < arr.length) {
			if (sum < target) {
				sum += arr[end];
				end++;
			} else if (sum == target) {
				print(arr, start, end);
				sum -= arr[start];
				start++;
			} else {
				sum -= arr[start];
				start++;
			}
		}
		while(start < arr.length){
			if(sum == target){
				print(arr,start,end);
				sum -= arr[start];
				start++;
			} else if (sum > target){
				sum -= arr[start];
				start++;
			} else {
				start++;
			}
		}
		
	}

	private static void print(final int[] arr, final int start, final int end) {
		for (int i = start; i < end; i++) {
			System.out.print(arr[i] + "->");
		}
		System.out.println();
	}
}
