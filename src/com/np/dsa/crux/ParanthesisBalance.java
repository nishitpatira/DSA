//https://www.careercup.com/question?id=5721539260448768
package com.np.dsa.crux;

import java.util.Scanner;
import java.util.Stack;

public class ParanthesisBalance {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		System.out.println(checkIfValidParantheses(str.toCharArray()));
	}

	private static boolean checkIfValidParantheses(char[] str) {
		Stack<Integer> openParanthesesStack = new Stack<>();
		Stack<Integer> closeParanthesesStack = new Stack<>();
		Stack<Integer> asterixParanthesesStack = new Stack<>();
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				openParanthesesStack.push(i);
			} else if (str[i] == ')') {
				if (!openParanthesesStack.isEmpty()) {
					str[openParanthesesStack.pop()] = '.';
				} else {
					closeParanthesesStack.push(i);
				}
			} else {
				asterixParanthesesStack.push(i);
			}
		}
		if (openParanthesesStack.isEmpty() && closeParanthesesStack.isEmpty()) {
			return true;
		} else if (!openParanthesesStack.isEmpty()) {
			if (asterixParanthesesStack.size() < openParanthesesStack.size()) {
				return false;
			}
			while (!openParanthesesStack.isEmpty()) {
				if (openParanthesesStack.pop() > asterixParanthesesStack.pop()) {
					return false;
				}
			}
			return true;
		} else {
			if (asterixParanthesesStack.size() < closeParanthesesStack.size()) {
				return false;
			}
			while (!closeParanthesesStack.isEmpty()) {
				if (closeParanthesesStack.pop() < asterixParanthesesStack.pop()) {
					return false;
				}
			}
			return true;
		}
	}

}
