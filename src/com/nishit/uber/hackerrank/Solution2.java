package com.nishit.uber.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		System.out.println(splitText(input, 30));
		scanner.close();
	}

	private static int splitText(String message, int charLimit) {
		if (message.length() < charLimit) {
			return 1;
		}
		return splitTextAuxUsingSplit(message, charLimit).size();
	}

	private static ArrayList<String> splitTextAuxUsingSplit(String message, int charLimitOriginal) {
		int charLimit = charLimitOriginal - 5;
		final ArrayList<String> result = new ArrayList<String>();
		final String[] splitInput = message.split(" ");
		String temp;

		for (int i = 0; i < splitInput.length - 1; i++) {
			temp = splitInput[i];
			while ((temp + 1 + splitInput[i + 1]).length() <= charLimit && i + 1 < splitInput.length - 1) { 
				temp = temp + " " + splitInput[i + 1];
				i++;
			}
			result.add(temp);

		}

		String lastElement = result.get(result.size() - 1);
		if (lastElement.length() + 1 + splitInput[splitInput.length - 1].length() < charLimit) { 
			result.set(result.size() - 1, lastElement + " " + splitInput[splitInput.length - 1]);
		} else {
			result.add(splitInput[splitInput.length - 1]);
		}

		int resultSize = result.size();
		for (int i = 0; i < resultSize; i++) {
			result.set(i, result.get(i) + "(" + (i + 1) + "/" + resultSize + ")");
		}

		return result;
	}
	
	private static int countEvenSubArrays(final int[] array, final int k){
		if(k < 1 || k > array.length){
			return 0;
		}
		Set<String> set = new HashSet<>();
		for(int i = 0 ; i < array.length ; i++){
			int oddCount = 0;
			StringBuilder builder = new StringBuilder();
			for(int j = i; j < array.length ; j++){
				if((array[i] & 1) == 0){
					builder.append(array[j]);
					set.add(builder.toString());
					builder = new StringBuilder(builder);
				} else {
					if(oddCount < k){
						oddCount++;						builder.append(array[j]);
						set.add(builder.toString());
						builder = new StringBuilder(builder);
					} else {
						break;
					}
				}
			}
		}
		return set.size();
	}
}
