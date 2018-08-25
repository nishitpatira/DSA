package com.np.dsa.crux;

import java.util.Arrays;

public class SlidingMedian {

	public static double[] medianSlidingWindow(int[] nums, int k) {
		boolean isEven = (k % 2 == 0) ? true : false;
		double[] medians = new double[nums.length - k + 1];
		int[] temp = new int[k];
		int curr_start = -1;
		int medians_index = 0;
		for (int i = 0; i < k; i++) {
			temp[i] = nums[i];
		}
		Arrays.sort(temp);
		findAndAddMedian(temp, medians, medians_index, isEven, k);
		curr_start++;
		medians_index++;
		for (int j = 1; j < nums.length - k + 1; j++) {
			temp[currStartInTemp(nums, temp, curr_start)] = nums[k + j - 1];
			Arrays.sort(temp);
			findAndAddMedian(temp, medians, medians_index, isEven, k);
			curr_start++;
			medians_index++;
		}
		return medians;
	}

	private static int currStartInTemp(int[] nums, int[] temp, int currentIndex) {
		// Return the index of currentStart in temp
		int val = nums[currentIndex];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == val) {
				return i;
			}
		}
		return -1;
	}

	private static void findAndAddMedian(int[] temp, double[] medians, int index, boolean isEven, int k) {
		if (isEven) {
			medians[index] = ((double) (temp[k / 2] + temp[(k / 2) - 1]) / 2);
		} else {
			medians[index] = temp[(k - 1) / 2];
		}
	}

	public static void main(String[] args) {
		int[] arr = { Integer.MAX_VALUE, Integer.MAX_VALUE };
		int k = 2;
		double[] medians = medianSlidingWindow(arr, k);
		for (double d : medians) {
			System.out.print(d + ", ");
		}

	}
}
