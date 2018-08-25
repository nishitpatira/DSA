package com.nishit.interviewbit;

import java.util.Collections;
import java.util.List;

public class MajorityElement {

	public static void main(String[] args) {
		
	}
	
	public static int majorityElement(final List<Integer> list){
		Collections.sort(list);
		return list.get(list.size()/2);
	}
}
