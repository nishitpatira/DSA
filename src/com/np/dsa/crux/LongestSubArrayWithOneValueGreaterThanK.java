package com.np.dsa.crux;

//https://www.geeksforgeeks.org/longest-subarray-with-only-one-value-greater-than-k/
public class LongestSubArrayWithOneValueGreaterThanK {

	public final int longestSubArrayWithOneValueGreaterThanK(final int[] array, final int k){
		boolean isOneValueEncountered = false;
		int lastGreaterIndex = 0;
		int local_max = 0;
		int global_max = 0;
		int i = 0;
		while(i < array.length){
			if(array[i] <= k){
				local_max++;
			} else{
				if(!isOneValueEncountered){
					isOneValueEncountered = !isOneValueEncountered;
					lastGreaterIndex = i;
					local_max++;
				} else {
					if(local_max > global_max){
						global_max = local_max;
					}
					local_max = i - lastGreaterIndex;
					lastGreaterIndex = i;
				}
			}
			i++;
		}
		int returnVal = Math.max(local_max, global_max);
		return (returnVal == array.length ? 0 : returnVal);
	}
}
