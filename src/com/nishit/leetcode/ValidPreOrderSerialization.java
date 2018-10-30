package com.nishit.leetcode;

import java.util.Stack;

class Pair {
	String input;
	int count;

	Pair(String input, int count) {
		this.input = input;
		this.count = count;
	}
}

public class ValidPreOrderSerialization {

	public boolean isValidSerialization(String preorder) {
		if(preorder == null || preorder.isEmpty()){
			return false;
		}
		if(preorder.length() == 1){
			if(preorder.charAt(0) == '#'){
				return true;
			} 
			return false;
		}
		Stack<Pair> stack = new Stack<>();
		String[] tokens = preorder.split(",");
		for (int i = 0 ; i < tokens.length ; i++) {
			if (tokens[i].equals("#")) {
				if (stack.isEmpty()) {
					return false;
				}
				stack.peek().count++;
			} else {
				stack.push(new Pair(tokens[i], 0));
			}
			while (!stack.isEmpty() && stack.peek().count == 2) {
				stack.pop();
				if (!stack.isEmpty()) {
					stack.peek().count++;
				} else{
					if(i != tokens.length - 1){
						return false;
					}
					
				}

			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidPreOrderSerialization obj = new ValidPreOrderSerialization();
		//String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		//String preOrder = "9,#,#,1";
		//String preOrder = "#";
		//String preOrder = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
		String preOrder = "9,#,92,#,#";
		System.out.println(obj.isValidSerialization(preOrder));
	}
}
