package com.nishit.leetcode;

public class ValidateBSTMinMaxRange {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static boolean isValidBST(TreeNode root){
		if(root == null || (root.left == null && root.right == null)) return true;
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isValidBST(TreeNode root, int min, int max){
		if(root == null) return true;
		if(root.val <= min || root.val >= max){
			return false;
		}
		boolean left = isValidBST(root.left, min, root.val);
		boolean right = isValidBST(root.right, root.val, max);
		return left && right;
	}

}
