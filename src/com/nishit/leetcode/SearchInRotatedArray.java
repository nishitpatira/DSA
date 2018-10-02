package com.nishit.leetcode;

public class SearchInRotatedArray {

	private final FindMinInRotatedArray findMin = new FindMinInRotatedArray();

	public int search(int[] array, int target) {
		if(array.length == 0){
			return -1;
		}
		// Find Pivot
		int minIndex = findMin.findMinIndex(array);

		// Binary Search on left
		int leftIndex = binarySearch(array, 0, minIndex - 1, target);

		if (leftIndex != -1) {
			return leftIndex;
		}
		
		//If not found in left, then search in right
		int rightIndex = binarySearch(array, minIndex, array.length - 1, target);
		if (rightIndex != -1) {
			return rightIndex;
		}
		return -1;

	}

	private int binarySearch(final int[] array, final int startIndex, final int endIndex, final int target) {
		if (endIndex < startIndex) {
			return -1;
		}

		int midIndex = (startIndex + endIndex) >> 1;

		if (array[midIndex] == target) {
			return midIndex;
		} else if (array[midIndex] > target) {
			return binarySearch(array, startIndex, midIndex-1, target);
		} else {
			return binarySearch(array, midIndex + 1, endIndex, target);
		}

	}
	
	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 5, 6, 7, 0 };
		SearchInRotatedArray search = new SearchInRotatedArray();
		System.out.println(search.search(nums, 0));
	}

}
