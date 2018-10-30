package com.nishit.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class LongestIncreasingSubSequenceUsingTreeMapFaster {

	public static void main(String[] args) {
		LongestIncreasingSubSequenceUsingTreeMapFaster usingTreeMap = new LongestIncreasingSubSequenceUsingTreeMapFaster();
		// final int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int[] array = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(usingTreeMap.longestIncreasingSubSequence(array));

	}

	private int longestIncreasingSubSequence(final int[] array) {
		if (array == null) {
			return 0;
		}
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(array[0], 1);
		int max = 1;
		for (int i = 1; i < array.length; i++) {
			Map.Entry<Integer, Integer> floorSmaller = map.floorEntry(array[i]);
			if (floorSmaller == null) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], floorSmaller.getValue() + 1);
				if (floorSmaller.getValue() + 1 > max) {
					max = floorSmaller.getValue() + 1;
				}
			}

		}
		return max;
	}
}
