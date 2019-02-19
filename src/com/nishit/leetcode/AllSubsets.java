package com.nishit.leetcode;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/subsets/description/
public class AllSubsets {
	public static void main(String[] args) {
		int[] nums = { 60, 100, 120 };
		AllSubsets obj = new AllSubsets();
		for (List<Integer> list : obj.subsets(nums)) {
			for (Integer elem : list) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> returnList = new LinkedList<>();
		subsetsUtil(nums, 0, new LinkedList<Integer>(), returnList);
		return returnList;
	}

	private void subsetsUtil(int[] nums, int index, List<Integer> list, List<List<Integer>> returnList) {
		if (index == nums.length) {
			List<Integer> newList = new LinkedList<>();
			returnList.add(newList);
			for (int elem : list) {
				newList.add(elem);
			}
			return;
		}
		subsetsUtil(nums, index + 1, list, returnList);
		list.add(nums[index]);
		subsetsUtil(nums, index + 1, list, returnList);
		list.remove(list.size() - 1);
		
	}

}
