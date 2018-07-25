package com.nishit.leetcode;

public class MedianOfSortedArrays {

	public static void main(String[] args) {
		//Test Case 1
		/*int[] array1 = {1,12,15,26,38};
		int[] array2 = {2,13,17,30,45};*/
		//Test Case 2
		/*int[] array1 = {1,2,3,6};
		int[] array2 = {4,6,8,10};*/
		//Test Case 3
		/*int[] array1 = {2,5,8,9,10,22};
		int[] array2 = {6,7,9,14,16,19};*/
		//Test Case 4
		/*int[] array1 = {0,1,3,4};
		int[] array2 = {0,2,6,7};*/
		//Test Case 5
		/*int[] array1 = {1,2,3};
		int[] array2 = {4,5,6};*/
		//Test Case 6
		int[] array1 = {1,2,3,4};
		int[] array2 = {1,2,3,4};
		System.out.println(findMedianSortedArrays(array1, array2));
	}
	
	public static double findMedianSortedArrays(int[] array1, int[] array2){
		int arr1_min_index = 0;
		int arr2_min_index = 0;
		int arr1_max_index = array1.length - 1;
		int arr2_max_index = array1.length - 1;
		int count = array1.length + array2.length;
		while(count != 2){
			if(array1[arr1_min_index] <= array2[arr2_min_index]){
				if(arr1_min_index <= arr1_max_index){
					arr1_min_index++;
				}
			} else {
				if(arr2_min_index < arr2_max_index){
					arr2_min_index++;
				}
			}
			if(array1[arr1_max_index] >= array2[arr2_max_index]){
				if(arr1_max_index >= arr1_min_index){
					arr1_max_index--;
				}
			} else {
				if(arr2_max_index > arr2_min_index){
					arr2_max_index--;
				}
			}
			count = count - 2;
		}
		
		//Check if last 2 elements are in same array or different
		if((arr1_min_index > arr1_max_index)){
			return (double)(array2[arr2_min_index] + array2[arr2_max_index])/2;
		} else if((arr2_min_index > arr2_max_index)){
			return (double)(array1[arr1_min_index] + array1[arr1_max_index])/2;
		} else {
			return (double)(array1[arr1_min_index] + array2[arr2_min_index])/2;
		}
	}
}
