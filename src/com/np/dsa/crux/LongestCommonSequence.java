package com.np.dsa.crux;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestCommonSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		System.out.println(findLCS(str1,str2));
		scanner.close();
	}
	
	protected static String findLCS(String str1, String str2){
		Set<Integer> indexOfStr1 = new HashSet<>();
		findLCS(str1, str2, 0, 0, indexOfStr1);
		return populateString(str1,indexOfStr1);
	}
	
	private static void findLCS(final String str1, final String str2, int i, int j, final Set<Integer> indexOfStr1){
		if(str1.isEmpty() || str2.isEmpty() || i >= str1.length() || j >= str2.length()){
			return;
		}
		if(str1.charAt(i) == str2.charAt(j)){
			indexOfStr1.add(i);
			findLCS(str1, str2, i+1, j+1, indexOfStr1);
		} else {
			findLCS(str1, str2, i+1, j, indexOfStr1);
			findLCS(str1, str2, i, j+1, indexOfStr1);
		}
	}
	
	private static String populateString(final String str1, final Set<Integer> indexSet){
		final StringBuilder builder = new StringBuilder();
		for(int elem : indexSet){
			builder.append(str1.charAt(elem));
		}
		return builder.toString();
	}
}
