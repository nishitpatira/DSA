package com.nishit.leetcode.contest109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecentCounter {

	List<Integer> list = new ArrayList<>();

	public int ping(final int time) {
		list.add(time);
		int returnVal = findIndex(list, time);
		return returnVal;
	}

	private int findIndex(List<Integer> list, int time) {
		int index = Collections.binarySearch(list, time-3000);
		int existing = (index >= 0) ? 1 : 0;
		index = (-1*(index+1));
		return list.size() - index - existing;
	}

}
