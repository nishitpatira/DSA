package com.nishit.leetcode;

//https://leetcode.com/problems/maximum-product-subarray/description/
public class MaxProductSubArray {

	public static void main(String[] args) {
		int[] array = {2,3,-2,4,-2,-3};
		MaxProductSubArray product = new MaxProductSubArray();
		System.out.println(product.maxProduct(array));
	}

	public int maxProduct(int[] nums) {
		int returnVal = nums[0];
		int min = nums[0];
		int max = nums[0];
		for(int i = 1 ; i <nums.length ; i++){
			if(nums[i] < 0){
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(max*nums[i], nums[i]);
			min = Math.min(min*nums[i], nums[i]);
			returnVal = max > returnVal ?max : returnVal;
		}
		return returnVal;
	}
}
