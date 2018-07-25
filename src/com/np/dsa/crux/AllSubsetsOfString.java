package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class AllSubsetsOfString {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = ScannerUtils.scanForString(scanner);
		printAllSubsets(input);
	}
	
	private static void printAllSubsets(final String input){
		int length = input.length();
		int N = 1 << length;
		int count = 0;
		for(int i = 0 ; i < N ; i++){
			StringBuilder builder = new StringBuilder();
			count++;
			int x = 0;
			while(x <= length){
				int y = i & (1 << x) ;
				if(y != 0){
					builder.append(input.charAt(x));
				}
				x++;
			}
			System.out.println(builder.toString());
		}
		System.out.println("Count is : " + count);
	}
}
