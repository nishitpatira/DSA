package com.nishit.uber.hackerrank;

import java.util.Scanner;

public class Solition2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		System.out.println(splitText(input, 30));
		scanner.close();
	}

	private static int splitText(String message, int charLimit) {
		if(message == null) return 0;
		if (message.length() < charLimit) {
			return 1;
		}
		return splitTextAuxUsingSplit(message, charLimit);
	}

	private static int splitTextAuxUsingSplit(String message, int charLimitOriginal) {
		int charLimit = charLimitOriginal - 5;
		final String[] splitInput = message.split(" ");
		int count = 0;
		int smsCount = 0;
		int i = 0;
		while(i < splitInput.length) {
			if (count + splitInput[i].length() + 1 <= charLimit) {
				count = count + splitInput[i].length() + 1;
				i++;
			} else {
				smsCount++;
				count = 0;
			}
		}
		return (count != 0) ? smsCount + 1 : smsCount;
	}

}
