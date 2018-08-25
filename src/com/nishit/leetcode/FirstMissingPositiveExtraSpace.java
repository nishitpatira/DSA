package com.nishit.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositiveExtraSpace {

	public static void main(String[] args) {
		int[] nums = {7,8,9,11,12};
		System.out.println(firstMissingPositive(nums));
	}

	public static int firstMissingPositive(int[] nums) {
		Set<Integer> valueSet = new HashSet<>();
		for(int num : nums){
			valueSet.add(num);
		}
		for(int i = 1 ; i< Integer.MAX_VALUE ; i++){
			if(!valueSet.contains(i)){
				return i;
			}
		}
		return Integer.MAX_VALUE;
	}
		

}
