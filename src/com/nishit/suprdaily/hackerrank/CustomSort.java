package com.nishit.suprdaily.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomSort {

	public static void main(String[] args) {
		int[] arr = {5,3,1,2,2,4};
		List<Integer> inputList = new ArrayList<>();
		for(int i : arr){
			inputList.add(i);
		}
		customSort(inputList);
		for(int i : inputList){
			System.out.println(i);
		}
	}

	public static void customSort(List<Integer> arr) {
		if (arr == null)
			return;

		if (arr.size() == 1)
			return;

		Map<Integer, Integer> frequencyMap = createFrequencyMap(arr);
		Map<Integer, List<Integer>> countMap = createCountMap(frequencyMap);
		sortEachlistInCountMap(countMap);
		insertElementsInSortedOrder(countMap);
	}

	private static Map<Integer, Integer> createFrequencyMap(final List<Integer> list) {
		Map<Integer, Integer> numberFreq = new HashMap<>();
		for (Integer i : list) {
			if (numberFreq.containsKey(i)) {
				numberFreq.put(i, numberFreq.get(i) + 1);
			} else {
				numberFreq.put(i, 1);
			}
		}
		return numberFreq;
	}

	private static Map<Integer, List<Integer>> createCountMap(final Map<Integer, Integer> frequencyMap) {
		Map<Integer, List<Integer>> countMap = new TreeMap<>();
		for (Map.Entry<Integer, Integer> entrySet : frequencyMap.entrySet()) {
			if (countMap.containsKey(entrySet.getValue())) {
				countMap.get(entrySet.getValue()).add(entrySet.getKey());
			} else {
				List<Integer> listOfElementsWithSameFreq = new ArrayList<>();
				listOfElementsWithSameFreq.add(entrySet.getKey());
				countMap.put(entrySet.getValue(), listOfElementsWithSameFreq);
			}
		}
		return countMap;
	}

	private static void sortEachlistInCountMap(final Map<Integer, List<Integer>> map) {
		for (List<Integer> list : map.values()) {
			Collections.sort(list);
		}
	}

	private static void insertElementsInSortedOrder(final Map<Integer, List<Integer>> map) {
		for (Map.Entry<Integer, List<Integer>> entrySet : map.entrySet()) {
			for (Integer i : entrySet.getValue()) {
				int count = entrySet.getKey();
				while (count > 0) {
					System.out.println(i);
					count--;
				}
			}
		}
	}
	
	private static void insertElementsInSortedOrder(final List<Integer> arr,final Map<Integer, List<Integer>> map) {
		int index = 0;
		for (Map.Entry<Integer, List<Integer>> entrySet : map.entrySet()) {
			for (Integer i : entrySet.getValue()) {
				int count = entrySet.getKey();
				while (count > 0) {
					arr.set(index, i);
					count--;
					index++;
				}
			}
		}
	}

}
