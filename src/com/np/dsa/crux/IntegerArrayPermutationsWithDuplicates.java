package com.np.dsa.crux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerArrayPermutationsWithDuplicates {
	
	public List<List<Integer>> permuteUnique(final int[] input) {
		List<List<Integer>> returnList = new ArrayList<>();
		if (input == null)
			return null;
		if (input.length == 0) {
			List<Integer> list = new ArrayList<>();
			returnList.add(list);
			return returnList;
		}
		if (input.length == 1) {
			List<Integer> list = new ArrayList<>();
			list.add(input[0]);
			returnList.add(list);
			return returnList;
		}
		
		
		List<Integer> outputList = new ArrayList<>();
		
		findPermutationsUtil(sortInput(input), outputList, returnList);
		return returnList;
	}

	private List<Integer> sortInput(final int[] input) {
		Arrays.sort(input);
		List<Integer> list = new ArrayList<>();
		for(int i : input){
			list.add(i);
		}
		return list;
	}

	private void findPermutationsUtil(List<Integer> inputList, List<Integer> outputList, List<List<Integer>> returnList) {
		if (inputList.size() == 1) {
			List<Integer> newList = new ArrayList<>(outputList);
			newList.add(inputList.get(0));
			returnList.add(newList);
			return;
		}
		Integer firstElement = inputList.remove(0);
		outputList.add(firstElement);
		findPermutationsUtil(inputList, outputList, returnList);
		inputList.add(0,outputList.remove(outputList.size()-1));
		for (int i = 1; i < inputList.size(); i++) {
			if (!inputList.get(i).equals(inputList.get(i-1))) {
				Integer ithElement = inputList.remove(i);
				outputList.add(ithElement);
				findPermutationsUtil(inputList, outputList, returnList);
				inputList.add(i, outputList.remove(outputList.size()-1));
			}
		}
	}

	public static void main(String[] args) {
		IntegerArrayPermutationsWithDuplicates obj = new IntegerArrayPermutationsWithDuplicates();
		int[] input = {1,2,3};
		List<List<Integer>> rturnList = obj.permuteUnique(input);
		System.out.println(rturnList);
	}
}
