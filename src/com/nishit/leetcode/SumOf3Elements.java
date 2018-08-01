package com.nishit.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class SumOf3Elements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numbers = ScannerUtils.scanForIntArray(scanner);
		System.out.println(threeSum(numbers));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> returnList = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int endIndex = nums.length - 1;
			int startIndex = i + 1;
			while (startIndex != endIndex) {
				if (nums[startIndex] + nums[endIndex] == (-1) * nums[i]) {
					List<Integer> triplet = new LinkedList<>();
					triplet.add(nums[i]);
					triplet.add(nums[startIndex]);
					triplet.add(nums[endIndex]);
					if (!returnList.contains(triplet)) {
						returnList.add(triplet);
					}
					startIndex++;
				} else if (nums[startIndex] + nums[endIndex] < (-1) * nums[i]) {
					startIndex++;
				} else {
					endIndex--;
				}
			}
		}
		return returnList;
	}
}
