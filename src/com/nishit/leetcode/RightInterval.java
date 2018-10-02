package com.nishit.leetcode;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/find-right-interval/description/

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class RightInterval {
	public static void main(String[] args) {
		int number = 3;
		Interval[] intervals = new Interval[number];
		intervals[0] = new Interval(1, 4);
		intervals[1] = new Interval(2, 3);
		intervals[2] = new Interval(3, 4);
		int[] array = findRightInterval(intervals);
		System.out.println();
	}
	
	
	private static int[] findRightInterval(final Interval[] intervals){
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for(int i = intervals.length - 1;  i >= 0 ; i--){
			treeMap.put(intervals[i].start, i);
		}
		int[] returnArray = new int[intervals.length];
		for(int i = 0 ; i < intervals.length ; i++){
			int endPoint = intervals[i].end;
			Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(endPoint);
			returnArray[i] = entry == null ? -1 : entry.getValue() ;
		}
		return returnArray;
	}
}
