package com.nishit.leetcode;

public class SearchInRotatedArrayFaster {
	
	public int search(final int[] array, final int target){
		if(array == null || array.length == 0){
			return -1;
		}
		int start = 0;
		int end = array.length-1;
		while(array[start] > array[end]){
			int mid = (start + end) >> 1;
			if(array[mid] == target){
				return mid;
			}
			if(array[start] < array[mid]){
				if(target >= array[start] && target < array[mid]){
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if(target > array[mid] && target <= array[end]){
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

}
