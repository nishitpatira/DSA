package com.np.dsa.crux;

import java.util.Scanner;

public class LongestCommonSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		System.out.println(findLCS(str1,str2));
		scanner.close();
	}
	
	private static String findLCS(String str1, String str2){
		
		if(str1.isEmpty() || str2.isEmpty()){
			return "";
		}
		if(str1.charAt(0) == str2.charAt(0)){
			return str1.charAt(0) + findLCS(str1.substring(1), str2.substring(1));
		}
		else {
			String temp1 = findLCS(str1.substring(1), str2.substring(0));
			String temp2 = findLCS(str1.substring(0), str2.substring(1));
			return temp1.length() > temp2.length() ? temp1 : temp2;
		}
	}
}
