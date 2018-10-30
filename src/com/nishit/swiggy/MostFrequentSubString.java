package com.nishit.swiggy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostFrequentSubString {

	public static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
		int windowSize = minLength;
		int max = 1;
		Map<String, Integer> wordFrequency = new HashMap<>();
		for (int i = 0; i <= s.length() - windowSize; i++) {
			String subString = s.substring(i, i + windowSize);
			Set<Character> uniqueChars = new HashSet<>();
			for (int j = 0; j < subString.length(); j++) {
				uniqueChars.add(subString.charAt(j));
			}
			if (uniqueChars.size() <= maxUnique) {
				if (wordFrequency.containsKey(subString)) {
					int newSize = wordFrequency.get(subString) + 1;
					wordFrequency.put(subString, newSize);
					max = newSize > max ? newSize : max;
				} else {
					wordFrequency.put(subString, 1);
				}
			}

		}
		return max;

	}

	public static void main(String[] args) {
		String s = "abcde";
		int min = 2;
		int max = 4;
		int unqiue = 26;
		int freq = getMaxOccurrences(s, min, max, unqiue);
		System.out.println(freq);
	}

}
