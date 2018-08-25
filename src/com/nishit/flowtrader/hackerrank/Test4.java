package com.nishit.flowtrader.hackerrank;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test4 implements Comparator<Test4> {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();
		List<Integer> list = new LinkedList<>();
		scanner.close();
	}
	
	public static String firstRepeatedWord(final String sentence){
		String[] words = sentence.split("[\\s\\t,.:;-]");
		Set<String> uniqueWords = new HashSet<>();
		for(String word : words){
			if(uniqueWords.contains(word)){
				return word;
			} else {
				uniqueWords.add(word);
			}
		}
		return sentence;
	}

	public int compare(Test4 o1, Test4 o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
