package com.nishit.acko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DigitSum {

	public static void main(String[] args) {

		int a = 1;
		int b = 5;
		List<Long> list = waysToChooseSum(a, b);
		for (Long l : list) {
			System.out.println(l);
		}

	}

	public static List<Long> waysToChooseSum(long a, long b) {
		List<Long> returnList = new ArrayList<>();
		List<Long> digitSumList = new ArrayList<>();
		for (long i = a; i <= b; i++) {
			calAndStoreDigitSum(i, digitSumList);
		}
		Collections.sort(digitSumList);
		findMostCommonFreq(digitSumList, returnList);
		return returnList;
	}

	private static void calAndStoreDigitSum(long element, List<Long> digitSumList) {
		long sum = 0;
		while (element > 0) {
			sum += element % 10;
			element = element / 10;
		}
		digitSumList.add(sum);
	}

	private static void findMostCommonFreq(List<Long> digitSums, List<Long> returnList) {
		long prevElement = digitSums.get(0);
		long maxElementCount = 1;
		int currentElemCount = 1;
		List<Long> maxElements = new ArrayList<>();
		maxElements.add(digitSums.get(0));
		
		for(int i = 1 ; i < digitSums.size() ; i++){
			if(digitSums.get(i) == prevElement){
				currentElemCount++;
			} else {
				if(currentElemCount > maxElementCount){
					maxElements.clear();
					maxElements.add(prevElement);
					maxElementCount = currentElemCount;
					currentElemCount=1;
				} else if(currentElemCount == maxElementCount){
					maxElements.add(prevElement);
					currentElemCount = 1;
				}
				prevElement = digitSums.get(i);
			}
		}
		returnList.add((long)maxElements.size());
		returnList.add(maxElementCount);
		System.out.println();
	}
}
