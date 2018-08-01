package com.nishit.leetcode;

import java.util.Arrays;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class SumOf3ElementsClosestApprox {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		int target = ScannerUtils.scanForNumber(scanner);
		System.out.println(threeSumClosest(array, target));
		scanner.close();
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = Integer.MAX_VALUE/2;
		for(int i = 0 ; i < nums.length - 2; i++){
			int startIndex = i+1;
			int endIndex = nums.length - 1;
			while(startIndex < endIndex){
				int temp = nums[startIndex] + nums[endIndex] + nums[i];
				if(Math.abs(closest - target) > Math.abs(temp - target)){
					closest = nums[startIndex] + nums[endIndex] + nums[i];
					if(closest < target){
						startIndex++;
					} else {
						endIndex--;
					}
				} else {
					if(temp < target){
						startIndex++;
					} else {
						endIndex--;
					}
				}
			}
		}
		return closest;
	}
}
