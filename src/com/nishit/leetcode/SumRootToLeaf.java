package com.nishit.leetcode;

public class SumRootToLeaf {
	
	private int totalSum = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		SumRootToLeaf obj = new SumRootToLeaf();
		System.out.println(obj.sumNumbers(root));
	}
	
	
	public int sumNumbers(TreeNode root){
		if(root == null) return 0;
		sumNumbers(root, "");
		return totalSum;
	}
	
	private void sumNumbers(TreeNode root, String current){
		if(root == null) return;
		current = current + Integer.toString(root.val);
		if(root.left == null && root.right == null){	
			totalSum += Integer.parseInt(current);
			return;
		}
		sumNumbers(root.left, current);
		sumNumbers(root.right, current);
		return;
	}
}
