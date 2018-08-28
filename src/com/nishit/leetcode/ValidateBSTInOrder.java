package com.nishit.leetcode;

public class ValidateBSTInOrder {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private static long prev = -2147483649l;

	public static boolean isValidBST(TreeNode root) {
		System.out.println(prev);
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		return isValidBSTUtil(root);
	}

	private static boolean isValidBSTUtil(TreeNode root) {
		if (root == null)
			return true;

		boolean isLeftBST = isValidBSTUtil(root.left);
		if (root.val > prev) {
			prev = root.val;
		} else {
			return false;
		}
		boolean isRightBST = isValidBSTUtil(root.right);
		return isLeftBST && isRightBST;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		System.out.println(isValidBST(root));
	}
}