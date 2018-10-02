package com.nishit.leetcode;

public class FindMinInRotatedArray {

	public int findMinIndex(final int[] array) {
		int start = 0;
		int end = array.length-1;
		while(array[start] >= array[end]){
			int mid = (start + end) >> 1;
			if(array[start] > array[mid]){
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	public int findMin(final int[] array){
		return array[findMinIndex(array)];
	}

	
	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 5, 6, 7, 0 };
		FindMinInRotatedArray search = new FindMinInRotatedArray();
		System.out.println(search.findMin(nums));
	}

}
