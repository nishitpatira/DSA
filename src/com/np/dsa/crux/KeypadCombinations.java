package com.np.dsa.crux;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class KeypadCombinations {

	private static HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	static {
		List<String> one = new LinkedList<>();
		List<String> two = new LinkedList<>();
		List<String> three = new LinkedList<>();
		List<String> four = new LinkedList<>();
		List<String> five = new LinkedList<>();
		List<String> six = new LinkedList<>();
		List<String> seven = new LinkedList<>();
		List<String> eight = new LinkedList<>();
		List<String> nine = new LinkedList<>();
		one.add("2");
		one.add("4");
		two.add("1");
		two.add("3");
		two.add("5");
		three.add("2");
		three.add("6");
		four.add("1");
		four.add("5");
		four.add("7");
		five.add("2");
		five.add("4");
		five.add("6");
		five.add("8");
		six.add("3");
		six.add("5");
		six.add("9");
		seven.add("4");
		seven.add("8");
		eight.add("5");
		eight.add("7");
		eight.add("9");
		nine.add("6");
		nine.add("8");
		map.put("1", one);
		map.put("2", two);
		map.put("3", three);
		map.put("4", four);
		map.put("5", five);
		map.put("6", six);
		map.put("7", seven);
		map.put("8", eight);
		map.put("9", nine);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = ScannerUtils.scanForNumber(scanner);
		for (Map.Entry<String, List<String>> mapInner : map.entrySet()) {
			mapInner.getKey();
		}

	}

}
