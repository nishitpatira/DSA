package com.nishit.leetcode;

public class FirstMissingPositiveConstantSpace {
	
	public static void main(String[] args) {
		int[] nums = {6,8,2,1,-1,1};
		System.out.println(firstMissingPositive(nums));
	}
	
	public static int firstMissingPositive(int[] nums){
		int i = 0;
		while( i < nums.length){
			if(nums[i] > 0 && nums[i] <=nums.length){
				int toIndex = nums[i] -1;
				if(!hasSwapEffect(nums, i , toIndex)){
					i++;
				}
			} else{
				i++;
			}
		}
		int smallesMissingPositive = 1;
		for(int j = 0 ; j < nums.length ; j++){
			if(nums[j] == j+1){
				smallesMissingPositive++;
			} else {
				return smallesMissingPositive;
			}
		}
		return smallesMissingPositive;
	}
	
	private static boolean hasSwapEffect(int[] nums, int fromIndex, int toIndex){
		if(nums[fromIndex] == nums[toIndex]){
			return false;
		}
		else {
			int temp = nums[fromIndex];
			nums[fromIndex] = nums[toIndex];
			nums[toIndex] = temp;
			return true;
		}
	}

}
