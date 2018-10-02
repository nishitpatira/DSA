package com.nishit.zalando.codility;

import java.util.LinkedList;
import java.util.List;

public class AlternateDigitsEncoding {
	
	public static void main(String[] args) {
		System.out.println(solution(new Integer(null)));
	}
	
	public static final int solution(int A) {
		//Although constraint mentions that A is in range [0-100000], for precaution adding the edge condition
		if(A < 0) return 0;
		
		if(A < 100){
			return A;
		}
		final List<Integer> list = new LinkedList<>();
		while(A > 0){
			int remainder = A % 10;
			A = A/10;
			list.add(remainder);
		}
		int count = 0;
		int result = 0;
		int anotherCount = 0;
		
		while(anotherCount < list.size()){
				
				result = result * 10;
				result = result + list.get(list.size() - count - 1);
				anotherCount++;
				if(anotherCount  != list.size()){
					result = result * 10;
					result = result + list.get(count);
					anotherCount++;
					count++;
				}
		}
		return result;
    }
}
