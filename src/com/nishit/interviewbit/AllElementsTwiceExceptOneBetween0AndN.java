package com.nishit.interviewbit;

import java.util.LinkedList;
import java.util.List;

public class AllElementsTwiceExceptOneBetween0AndN {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(111);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(111);
		System.out.println(singleNumber(list));
	}
	
	public static int singleNumber(List<Integer> list){
		for(int i = 0 ; i < list.size() ; i++){
			int index = Math.abs(list.get(i));
			list.set(index, list.get(index)*-1);
		}
		for(int elem : list){
			if(elem < 0){
				return Math.abs(elem);
			}
		}
		return 0;
	}
}
