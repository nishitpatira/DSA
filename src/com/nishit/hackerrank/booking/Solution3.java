package com.nishit.hackerrank.booking;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {

	static class TimeAndType implements Comparator<TimeAndType> {

		private int time;
		private boolean isStart;

		public TimeAndType(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}

		@Override
		public int compare(TimeAndType o1, TimeAndType o2) {
			if (o1.time > o2.time) {
				return 1;
			} else if (o1.time == o2.time) {
				return 0;
			} else {
				return -1;
			}
		}
	}

	public static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
		if(callsTimes == null || callsTimes.size() == 0){
			return 0;
		}
		List<TimeAndType> timeTypeList = new LinkedList<>();
		for (List<Integer> oneCall : callsTimes) {
			TimeAndType startTimeObj = new TimeAndType(oneCall.get(0), true);
			TimeAndType endTimeObj = new TimeAndType(oneCall.get(1), false);
			timeTypeList.add(startTimeObj);
			timeTypeList.add(endTimeObj);
		}
		Collections.sort(timeTypeList, new Comparator<TimeAndType>() {
			@Override
			public int compare(TimeAndType o1, TimeAndType o2) {
				if (o1.time > o2.time) {
					return 1;
				} else if (o1.time == o2.time) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		//print(timeTypeList);
		
		int maxAgentsRequired = 0;
		int count = 0;
		for(TimeAndType item : timeTypeList){
			if(item.isStart){
				count++;
				if(count > maxAgentsRequired){
					maxAgentsRequired = count;
				}
			} else {
				count--;
			}
		}
		return (maxAgentsRequired - noOfCurrentAgents > 0) ? maxAgentsRequired - noOfCurrentAgents : 0 ;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> masterList = new LinkedList<>();
		List<Integer> list1 = new LinkedList<>();
		list1.add(2000);
		list1.add(2020);
		List<Integer> list2 = new LinkedList<>();
		list2.add(2000);
		list2.add(2040);
		List<Integer> list3 = new LinkedList<>();
		list3.add(2030);
		list3.add(2035);
		masterList.add(list1);
		masterList.add(list2);
		masterList.add(list3);
		System.out.println(howManyAgentsToAdd(1, masterList));
	}
	
	private static void print(List<TimeAndType> list){
		for(TimeAndType t : list){
			System.out.println(t.time);
		}
	}

}
