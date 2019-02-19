package com.np.dsa.crux;

import java.util.LinkedList;
import java.util.List;

//Given an array of integers of size N, find and print all subsequences of length k
public class SubsequencesLengthK {
	
	public void findAndPrint(int[] array, int k){
		if(array == null) return;
		
		findAndPrint(array, k, 0, new LinkedList<Integer>());
	}
	
	private void findAndPrint(int[] array, int k, int start, List<Integer> list){
		if(k == 0){
			for(int i : list){
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start ; i < array.length ; i++){
			list.add(array[i]);
			findAndPrint(array, k-1, i+1, list);
			list.remove(list.size()-1);
		}
	}

}
