package com.nishit.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {

	public static void main(String[] args) {
		final String str = "dvdf";
		System.out.println(lengthOfLongestSubstring(str));
	}
	
	private static int lengthOfLongestSubstring(final String input){
		int local_max = 0;
		int global_max = 0;
		
		Map<Character, Integer> uniqueChars = new HashMap<Character, Integer>();
		for(int i = 0 ; i < input.length(); i++){
			char c = input.charAt(i);
			if(uniqueChars.containsKey(c)){
				global_max = local_max > global_max ? local_max : global_max;
				local_max = 0;
				i = uniqueChars.get(c);
				uniqueChars.clear();
			} else {
				uniqueChars.put(c, i);
				local_max++;
			}
		}
		return local_max > global_max ? local_max : global_max;
	}
}
