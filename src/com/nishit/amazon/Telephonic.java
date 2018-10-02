package com.nishit.amazon;

import java.util.Stack;

public class Telephonic {

	public static void main(String[] args) {
		int[] a = { 4, 1, 2, 9, 5, 7 };
		Telephonic obj = new Telephonic();
		int[] b = obj.replaeWithNextGreater(a);
		for (int i : b) {
			System.out.println(i);
		}
	}

	public int[] replaeWithNextGreater(final int[] input) {
		if (input.length == 0) {
			return null;
		}
		if (input.length == 1) {
			return input;
		}
		Stack<Integer> stack = new Stack<>();
		int[] output = new int[input.length];
		output[input.length - 1] = -1;
		stack.push(input[input.length - 1]);

		for (int i = input.length - 2; i >= 0; i--) {
			int stackTop = stack.pop();
			if (stackTop > input[i]) {
				output[i] = stackTop;
				stack.push(stackTop);
				stack.push(input[i]);
			} else { // The top is less than or equal to current
				// Keep popping out until you find an element greater than
				// If stack becomes empty, it is -1
				while (!stack.isEmpty()) {
					stackTop = stack.pop();
					if (stackTop > input[i]) {
						output[i] = stackTop;
						stack.push(stackTop);
						stack.push(input[i]);
						break;
					} else {
						//
					}
				}
				if (output[i] > 0) {
					// Do nothing
				} else {
					output[i] = -1;
					stack.push(input[i]);
				}

			}
		}

		return output;
	}

}
