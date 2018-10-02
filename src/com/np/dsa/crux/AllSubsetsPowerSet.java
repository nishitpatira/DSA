package com.np.dsa.crux;

import java.util.LinkedList;
import java.util.List;

//https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
public class AllSubsetsPowerSet {
	
	public static void main(String[] args) {
		char[] chars = {'a', 'b', 'c'};
		AllSubsetsPowerSet powerSet = new AllSubsetsPowerSet();
		powerSet.printSubSets(chars);
	}
	
	public void printSubSets(final char[] chars){
		int n = chars.length;
		for(int i = 0 ; i < Math.pow(2, n) ; i++){
			//For each of the i
			int index = 0;
			int temp = i;
			List<Character> subsetList = new LinkedList<>();
			while (temp != 0){
				if((temp & 1) != 0){
					subsetList.add(chars[index]);
				}
				temp = temp >> 1;
				index++;
			}
			printList(subsetList);
		}
	}
	
	private void printList(List<Character> list){
		for(Character c : list){
			System.out.print(c + " ");
		}
		System.out.println();
	}

}
