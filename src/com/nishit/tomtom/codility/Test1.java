package com.nishit.tomtom.codility;

import java.util.LinkedList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		System.out.println(solution(100));
	}
	
	public static int solution(int A) {
		if(A == 0){
			return 0;
		}
		List<Integer> list = new LinkedList<>();
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
				if(anotherCount  == list.size()){
					
				}else {
					result = result * 10;
					result = result + list.get(count);
					anotherCount++;
					count++;
				}
				
		}
		return result;
    }
	
}
