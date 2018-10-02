package com.nishit.transferwise;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArabicToRoman {

	private static TreeMap<Integer, String> arabicToRomanMap = new TreeMap<>();

	static {
		arabicToRomanMap.put(1, "I");
		arabicToRomanMap.put(2, "II");
		arabicToRomanMap.put(3, "III");
		arabicToRomanMap.put(4, "IV");
		arabicToRomanMap.put(5, "V");
		arabicToRomanMap.put(6, "VI");
		arabicToRomanMap.put(7, "VII");
		arabicToRomanMap.put(8, "VIII");
		arabicToRomanMap.put(9, "IX");
		arabicToRomanMap.put(10, "X");
		arabicToRomanMap.put(40, "XL");
		arabicToRomanMap.put(50, "L");
		arabicToRomanMap.put(90, "XC");
		arabicToRomanMap.put(100, "C");
		arabicToRomanMap.put(400, "CD");
		arabicToRomanMap.put(500, "D");
		arabicToRomanMap.put(900, "CM");
		arabicToRomanMap.put(1000, "M");
	}

	public static void main(String[] args) {
		int[] nums = {75,80,99,100,50};
		List<Integer> list = new LinkedList<>();
		for(int num : nums){
			list.add(num);
		}
		for(String str : romanizer(list)){
			System.out.println(str);
		}
	}

	private static List<String> romanizer(List<Integer> numbers) {
		List<String> returnList = new LinkedList<>();
		for (Integer arabic : numbers) {
			if (arabic != null) {
				returnList.add(convert(arabic));
			}
		}
		return returnList;
	}

	private static String convert(int number) {
		StringBuilder builder = new StringBuilder();
		while (number != 0) {
			Map.Entry<Integer, String> entry = arabicToRomanMap.floorEntry(number);
			builder.append(entry.getValue());
			number = number - entry.getKey();
		}
		return builder.toString();
	}

}
