package com.nishit.leetcode.contest97;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UncommonWords {
	public static void main(String[] args) {
		String str1 = "this apple is sweet";
		String str2 = "this apple is sour";
		System.out.println(uncommonFromSentences(str1, str2));
	}

	public static String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> wordFrequency = new HashMap<>();
		String[] str1Split = A.split(" ");
		String[] str2Split = B.split(" ");
		for(int i = 0 ; i < str1Split.length ; i++){
			if(wordFrequency.containsKey(str1Split[i])){
				int currentCount = wordFrequency.get(str1Split[i]);
				wordFrequency.put(str1Split[i], currentCount+1);
			}
			else {
				wordFrequency.put(str1Split[i], 1);
			}	
		}
		
		for(int i = 0 ; i < str2Split.length ; i++){
			if(wordFrequency.containsKey(str2Split[i])){
				int currentCount = wordFrequency.get(str2Split[i]);
				wordFrequency.put(str2Split[i], currentCount+1);
			}
			else {
				wordFrequency.put(str2Split[i], 1);
			}	
		}
		
		List<String> unCommonWordsList = new LinkedList<>();
		for(Map.Entry<String, Integer> entrySet : wordFrequency.entrySet()){
			if(entrySet.getValue() == 1){
				unCommonWordsList.add(entrySet.getKey());
			}
		}
		String[] uncommonWords = new String[unCommonWordsList.size()];
		int i = 0;
		for(String uncommonWord : unCommonWordsList){
			uncommonWords[i] = uncommonWord;
			i++;
		}
		return uncommonWords;
		
	}
}
