package com.nishit.transferwise;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int queries = Integer.parseInt(sc.nextLine());
		for (int testCases = 0; testCases < queries; testCases++) {
			int length = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
			String[] inputArr = str.split(" ");
			int[] inputArrInt = new int[inputArr.length];
			for (int i = 0; i < inputArr.length; i++) {
				inputArrInt[i] = Integer.parseInt(inputArr[i]);
			}
			if (canRepresentBST(inputArrInt, inputArrInt.length) == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();

	}

	private static final boolean canRepresentBST(final int pre[], final int n) {
		final Stack<Integer> s = new Stack<Integer>();
		int root = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (pre[i] < root) {
				return false;
			}
			while (!s.empty() && s.peek() < pre[i]) {
				root = s.peek();
				s.pop();
			}
			s.push(pre[i]);
		}
		return true;
	}
}