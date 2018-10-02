package com.nishit.leetcode;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class InorderIterative {

	public static void main(String[] args) {

	}
	
	private static void inOrder(TreeNode root) {
		if(root == null) return;
		
		TreeNode mainRoot = root;
		Stack<TreeNode> stack = new Stack<>();
		
		
		while(!stack.isEmpty()){
			if(root != null){
				stack.push(root);
				root = root.left;
			} else {
				TreeNode node = stack.pop();
				System.out.println(node.val);
				root = node.right;
			}
		}
	}

}
