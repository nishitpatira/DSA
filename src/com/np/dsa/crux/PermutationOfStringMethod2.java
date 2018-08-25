package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class PermutationOfStringMethod2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = ScannerUtils.scanForString(scanner);
		findAllPerms(input);
	}
	
	public static void findAllPerms(String input){
		findAllPerms("", input);
	}
	
	private static void findAllPerms(String perm, String input){
		if(input.length() == 0){
			System.out.println(perm);
		} else {
			for(int i = 0 ; i< input.length(); i++){
				findAllPerms(perm + input.charAt(i), input.substring(0, i) + input.substring(i+1, input.length()));
			}
		}
	}

}
