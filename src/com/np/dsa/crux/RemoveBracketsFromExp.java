//http://www.geeksforgeeks.org/check-two-expressions-brackets/
package com.np.dsa.crux;

import java.util.Scanner;
import java.util.Stack;

import com.np.dsa.utils.ScannerUtils;

public class RemoveBracketsFromExp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String expression = ScannerUtils.scanForString(scanner);
		removeParatheses(expression);
	}

	private static void removeParatheses(String expression) {
		Stack<String> globalOperandStack = new Stack<>();
		Stack<String> workingStack = new Stack<>();
		Stack<String> tempStack = new Stack<>();
		char[] charArray = expression.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '-' || charArray[i] == '+') {
				workingStack.push(new Character(charArray[i]).toString());
			} else if (charArray[i] == '(') {
				globalOperandStack.push(workingStack.pop());
				workingStack.push("(");
			} else if (charArray[i] == ')') {
				while (workingStack.peek() != "(") {
					tempStack.push(workingStack.pop());
				}
				workingStack.pop();
				convert(globalOperandStack.pop(), tempStack, workingStack);
			} else {
				if (workingStack.isEmpty() || workingStack.peek() == "(") {
					workingStack.push("+");
				}
				workingStack.push(new Character(charArray[i]).toString());
			}
		}
		while (!workingStack.isEmpty()) {
			tempStack.push(workingStack.pop());
		}
		printExpression(tempStack);
	}

	private static void convert(String operand, Stack<String> tempStack, Stack<String> workingStack) {
		while (!tempStack.isEmpty()) {
			if (tempStack.peek() == "+") {
				tempStack.pop();
				if (operand.equals("-")) {
					workingStack.push("-");
				} else {
					workingStack.push("+");
				}

			} else if (tempStack.peek() == "-") {
				if (operand.equals("-")) {
					workingStack.push("+");
				} else {
					workingStack.push("-");
				}
				tempStack.pop();
			} else {
				workingStack.push(tempStack.pop());
			}
		}
	}

	public static void printExpression(Stack<String> stack) {
		if (stack.peek() == "+") {
			stack.pop();
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
