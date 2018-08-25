package com.nishit.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class CombinationSumRecursion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] candidates = ScannerUtils.scanForIntArray(scanner);
		int target = ScannerUtils.scanForNumber(scanner);
		combinationSum(candidates, target);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		long startTime = System.currentTimeMillis();
		List<List<Integer>> mainList = new LinkedList<>();
		combinationSumUtil(candidates, target, new LinkedList<Integer>(), 0, mainList);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to process : " + (endTime - startTime));
		return mainList;
	}

	public static void combinationSumUtil(int[] candidates, int target, List<Integer> list, int elem, List<List<Integer>> mainList) {
		if (target < 0) {
			return;
		}

		if (target == 0) {
			List<Integer> copyList = new LinkedList<>(list);
			Collections.sort(copyList);
			if(!mainList.contains(copyList)){
				mainList.add(copyList);	
			}
			
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int candidate : candidates) {
			list.add(candidate);
			int newTarget = target - candidate;
			combinationSumUtil(candidates, newTarget, list, candidate, mainList);
			list.remove(list.size()-1);
		}
	}
}
