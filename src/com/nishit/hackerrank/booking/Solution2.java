package com.nishit.hackerrank.booking;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		int[] arr = { 25626, 25757, 24367, 24267, 16, 100, 2, 7277 };
		int[] result = delta_encode(arr);
		for(int i : result){
			System.out.println(i);
		}
	}

	static int[] delta_encode(int[] array) {
		if(array.length == 0){
			return null;
		}
		List<Integer> list = new LinkedList<Integer>();
		list.add(array[0]);
		for(int i = 1 ; i < array.length ; i++){
			int diff = array[i] - array[i-1];
			if(diff > 127 || diff < -127){
				list.add(-128);
				list.add(diff);
			} else {
				list.add(diff);
			}
		}
		int[] resultArray = new int[list.size()];
		
		for(int i = 0 ; i < list.size() ; i++){
			resultArray[i] = list.get(i);
		}
		return resultArray;
		
	}

}
