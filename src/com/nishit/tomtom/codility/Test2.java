package com.nishit.tomtom.codility;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
	
	
	public static void main(String[] args) {
		System.out.println(solution(1111111112));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(7));
		
	}
	
	private static Map<Integer, Integer> factorialMap = new HashMap<>();
	static {
		factorialMap.put(0, 1);
		factorialMap.put(1, 1);
	}

	public static int solution(int N) {
		if (N == 0) {
			return 1;
		}
		Map<Integer, Integer> digitFrequency = new HashMap<>();
		int length = 0;
		int possibleOutcomes = 1;
		while (N > 0) {
			int remainder = N % 10;
			N = N / 10;
			length++;
			if (digitFrequency.containsKey(remainder)) {
				int oldFreq = digitFrequency.get(remainder);
				digitFrequency.put(remainder, oldFreq + 1);
			} else {
				digitFrequency.put(remainder, 1);
			}
		}
		
		if(digitFrequency.containsKey(0)){
			int zeroCount = digitFrequency.get(0);
			int lengthZeroCombination = findCombination(length, zeroCount);
			int lengthMinusZeroLengthCombination = findCombination(length-1, zeroCount-1);
			int diff = (lengthZeroCombination - lengthMinusZeroLengthCombination);
			possibleOutcomes *=  diff;
			length -= zeroCount;
			digitFrequency.remove(0);
		}

		for (Map.Entry<Integer, Integer> entrySet : digitFrequency.entrySet()) {
			if (entrySet.getKey() != 0) {
				if (entrySet.getValue() == 1) {
					possibleOutcomes *= length;
					length -= 1;
				} else {
					int temp = findCombination(length, entrySet.getValue());
					length -= entrySet.getValue();
					possibleOutcomes *= temp;
					
				}
			}
		}
		return possibleOutcomes;
	}
	
	private static int findCombination(int n, int r){
		int nFactorial = findFactorial(n);
		int nMinusRFactorial = findFactorial(n-r);
		int rFactorial = findFactorial(r);
		return nFactorial/(nMinusRFactorial*rFactorial); 
	}
	
	private static int findFactorial(int n){
		if(factorialMap.containsKey(n)){
			return factorialMap.get(n);
		}
		return n*findFactorial(n-1);
	}
}
