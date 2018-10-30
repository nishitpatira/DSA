package com.np.dsa.crux;

import java.util.Arrays;

public class StringPermutationsWithDuplicates {

	public void findPermutations(final String input) {
		if (input == null)
			return;
		if (input.length() == 0) {
			System.out.println("");
			return;
		}
		if (input.length() == 1) {
			System.out.println(input);
			return;
		}
		String output = "";
		findPermutationsUtil(sortInput(input), output);
	}

	private String sortInput(final String input) {
		char[] charArray = input.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	private void findPermutationsUtil(String input, String output) {
		if (input.isEmpty()) {
			System.out.println(output);
			return;
		}
		String newInput0 = input.substring(1);
		String newOutput0 = output.concat(input.substring(0, 1));
		findPermutationsUtil(newInput0, newOutput0);
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) != input.charAt(i - 1)) {
				String newInput = input.substring(0, i) + input.substring(i + 1, input.length());
				String newOutput = output.concat(input.substring(i, i + 1));
				findPermutationsUtil(newInput, newOutput);
			}
		}
	}

	public static void main(String[] args) {
		StringPermutationsWithDuplicates obj = new StringPermutationsWithDuplicates();
		obj.findPermutations("ACBC");
	}

}
