package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class ReverseStringSpecialCharacters {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = ScannerUtils.scanForString(scanner);
		char[] inputArray = input.toCharArray();
		int left = 0;
		int right = inputArray.length - 1;
		while (left < right){
			if('a' <= inputArray[left] && inputArray[left] <= 'z'){
				if('a' <= inputArray[right] && inputArray[right] <= 'z'){
					char temp;
					temp = inputArray[left];
					inputArray[left] = inputArray[right];
					inputArray[right] = temp;
					left++;
					right--;
				}
				else {
					right--;
				}
			}
			else {
				left++;
			}
		}
		for(int j = 0 ; j < inputArray.length ; j++){
			System.out.print(inputArray[j]);	
		}
		
	}

}
