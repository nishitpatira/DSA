package com.nishit.leetcode;
//https://leetcode.com/problems/permutation-in-string/description/

import java.util.HashMap;
import java.util.Map;

public class PermutationSubString {

	public static void main(String[] args) {
		final String s1 = "hello";
		final String s2 = "ooolleoooleh";
		System.out.println(checkInclusion(s1, s2));
	}

	public static boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s2.length() < s1.length()) {
			return false;
		}
		Map<Character, Integer> inputFreqMap = createFreqMap(s1);
		Map<Character, Integer> subStringFreqMap = createFreqMap(s2.substring(0, s1.length()));
		if (areMapsEqual(inputFreqMap, subStringFreqMap)) {
			return true;
		}
		for (int i = 0; i < s2.length() - s1.length(); i++) {
			removeFirstCharAddNextChar(subStringFreqMap, i, s1, s2);
			if (areMapsEqual(inputFreqMap, subStringFreqMap)) {
				return true;
			}
		}
		return false;

	}

	private static void removeFirstCharAddNextChar(Map<Character, Integer> subStringFreqMap, int i, String s1,
			String s2) {
		int freq = subStringFreqMap.get(s2.charAt(i));
		if (freq == 1) {
			subStringFreqMap.remove(s2.charAt(i));
		} else {
			subStringFreqMap.put(s2.charAt(i), freq - 1);
		}
		char nextChar = s2.charAt(i + s1.length());
		if (subStringFreqMap.containsKey(nextChar)) {
			subStringFreqMap.put(nextChar, subStringFreqMap.get(nextChar) + 1);
		} else {
			subStringFreqMap.put(nextChar, 1);
		}
	}

	private static boolean areMapsEqual(Map<Character, Integer> s1FreqMap, Map<Character, Integer> s2FreqMap) {
		if (s1FreqMap.size() != s2FreqMap.size()) {
			return false;
		}
		for (Map.Entry<Character, Integer> entrySet : s1FreqMap.entrySet()) {
			if (s2FreqMap.containsKey(entrySet.getKey())) {
				int freq = s2FreqMap.get(entrySet.getKey());
				if (freq == entrySet.getValue()) {
					// Do Nothing
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	private static Map<Character, Integer> createFreqMap(final String input) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char c : input.toCharArray()) {
			if (freqMap.containsKey(c)) {
				freqMap.put(c, freqMap.get(c) + 1);
			} else {
				freqMap.put(c, 1);
			}
		}
		return freqMap;
	}
}
