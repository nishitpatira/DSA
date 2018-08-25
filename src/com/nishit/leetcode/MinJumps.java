package com.nishit.leetcode;
//https://leetcode.com/problems/jump-game-ii/description/
public class MinJumps {

	public static void main(String[] args) {
		int[] nums = {2,3,0,1,4};
		System.out.println(jump(nums));
	}
	
	public static int jump(int[] nums){
		int[] aux = new int[nums.length];
		aux[nums.length - 1] = 0;
		
		for(int i = nums.length - 2 ; i >= 0 ; i--){
			int noOfJumps = nums[i];
			int min = Integer.MAX_VALUE-1;
			for(int j = 1; j <= noOfJumps ; j++){
				if(i+j < nums.length){
					if(aux[i+j] < min){
						min = aux[i+j];
					}
				}
			}
			aux[i] = 1 + min;
		}
		return aux[0];
	}
}
