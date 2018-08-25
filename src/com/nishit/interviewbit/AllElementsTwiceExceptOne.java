package com.nishit.interviewbit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AllElementsTwiceExceptOne {
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(111);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(111);
		System.out.println(singleNumberBrute(list));
		System.out.println(singleNumberBit(list));
	}
	
	public static int singleNumberBrute(List<Integer> list){
		Set<Integer> single = new HashSet<>();
		for(int elem : list){
			if(single.contains(elem)){
				single.remove(elem);
			} else {
				single.add(elem);
			}
		}
		for(int output : single){
			return output;
		}
		return 0;
	}
	
	public static int singleNumberBit(List<Integer> list){
		int output = 0;
		for(int i : list){
			output = output^i;
		}
		return output;
	}

}
