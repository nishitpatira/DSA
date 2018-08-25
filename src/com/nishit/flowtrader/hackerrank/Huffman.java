package com.nishit.flowtrader.hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Huffman {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int numberOfEncodings = Integer.parseInt(in.nextLine());
		Map<String, Character> symbolByEncoding = new HashMap<>(numberOfEncodings);
		for (int i = 0; i < numberOfEncodings; i++) {
			String line = in.nextLine();
			char symbol = line.startsWith("[newline]") ? '\n' : line.charAt(0);
			String[] parts = line.split("\\s");
			String encoding = parts[parts.length - 1];
			symbolByEncoding.put(encoding, symbol);
		}

		String encodedText = in.nextLine();
		String decodedText = decode(symbolByEncoding, encodedText);
		System.out.println(decodedText);
	}
	
	public static String decode(Map<String, Character> map, String encodedText){
		int i = 0 ;
		int	big = 0;
		int small = 0;
		for(Map.Entry<String, Character> entrySet : map.entrySet()){
			if(big == 0){
				big = entrySet.getKey().length();
			} else {
				if( entrySet.getKey().length() != big){
					small = entrySet.getKey().length();
				}
			}
		}
		int temp = Math.max(big,small);
		small = Math.min(big, small);
		big = temp;
		StringBuilder builder = new StringBuilder();
		while (i < encodedText.length()-small){
			String key5 = encodedText.substring(i, i+small);
			if(map.containsKey(key5)){
				builder.append(map.get(key5));
				i = i+small;
				continue;
			} else {
				String key6 = encodedText.substring(i, i+big);
				if(map.containsKey(key6)){
					builder.append(map.get(key6));
					i = i+big;
					continue;
				}
			}
		}
		return builder.toString();
	}

}
