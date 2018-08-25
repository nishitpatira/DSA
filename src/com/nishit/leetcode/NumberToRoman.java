package com.nishit.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class NumberToRoman {
	private static Map<Integer, String> numberToRoman = new HashMap<>();
	
	static {
		numberToRoman.put(1, "I");
		numberToRoman.put(4, "IV");
		numberToRoman.put(5, "V");
		numberToRoman.put(9, "IX");
		numberToRoman.put(10, "X");
		numberToRoman.put(40, "XL");
		numberToRoman.put(50, "L");
		numberToRoman.put(90, "XC");
		numberToRoman.put(100, "C");
		numberToRoman.put(400, "CD");
		numberToRoman.put(500, "D");
		numberToRoman.put(900, "CM");
		numberToRoman.put(1000, "M");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = ScannerUtils.scanForNumber(scanner);
		intToRoman(new Integer(number));
	}

	public static String intToRoman(Integer number) {
		int count = 0;
		int remainder = 0;
		String[] array = new String[String.valueOf(number).length()];
		while(number != 0){
			remainder = number % 10;
			number = (Integer )number / (10^count);
			if(remainder == 4 || remainder == 7){
				remainder = remainder * (10^count);
				count++;
			} else {
				
			}
			
		}
		return "";
	}
}
