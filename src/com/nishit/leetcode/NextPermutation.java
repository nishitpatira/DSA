package com.nishit.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class NextPermutation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] nums = ScannerUtils.scanForIntArray(scanner);
		nextPermutation(nums);
	}
	
	private static void nextPermutation(int[] nums){
		Integer[] arr = new Integer[nums.length];
		for(int i = 0 ; i < nums.length ; i++){
			arr[i] = new Integer(nums[i]);
		}
		List<Integer> numsList = new LinkedList<>();
		for(int i = 0 ; i < nums.length ; i++){
			numsList.add(nums[i]);
		}
		int number = 0;
		for(int i = 0 ; i < nums.length ; i++){
			number = (number * 10) + nums[i];
		}
		findAllPermutations(numsList);
		int closestPerm = findClosestGreaterPermutation(numsList, number);
		for(int i = nums.length - 1 ; i >= 0 ; i--){
			nums[i] = closestPerm % 10;
			closestPerm = closestPerm / 10;
		}
		print(nums);
	}
	
	private static List<Integer> findAllPermutations(List<Integer> nums){
		List<Integer> permutationsList = new LinkedList<>();
		Integer perm = new Integer(0);
		findAllPermutations(permutationsList, nums, perm);
		return permutationsList;
	}
	
	private static void findAllPermutations(List<Integer> permutationsList, List<Integer> nums, Integer perm){
		if(nums.size() == 0){
			permutationsList.add(perm);
			return;
		}
		Iterator<Integer> iterator = nums.iterator();
		while(iterator.hasNext()){
			perm = (perm * 10) + iterator.next();
			iterator.remove();
			findAllPermutations(permutationsList, nums, perm);
		}
	}
	
	private static int findClosestGreaterPermutation(List<Integer> permutationsList, int number) {
		int closest = Integer.MAX_VALUE;
		for(Integer perm : permutationsList){
			if(perm > number && perm < closest){
				closest = perm;
			}
		}
		return closest;
	}
	
	private static void print(int[] nums){
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
