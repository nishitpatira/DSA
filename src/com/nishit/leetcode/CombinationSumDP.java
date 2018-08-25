package com.nishit.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

//https://leetcode.com/problems/combination-sum/description/
public class CombinationSumDP {

	private static Map<Integer, List<List<Integer>>> auxMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] candidates = ScannerUtils.scanForIntArray(scanner);
		int target = ScannerUtils.scanForNumber(scanner);
		combinationSum(candidates, target);
	}

	public static void combinationSum(int[] candidates, int target) {
		long startTime = System.currentTimeMillis();
		combinationSumUtil(candidates, target, new LinkedList<Integer>(), 0);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to process : " + (endTime - startTime));
	}

	public static void combinationSumUtil(int[] candidates, int target, List<Integer> list, int elem) {
		
	}
}
