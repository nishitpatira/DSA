package com.nishit.leetcode;

public class ConvertTreeToList {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		TreeNode prev = null;
		new ConvertTreeToList().flatten(root, prev);
		System.out.println();
	}

	public void flatten(TreeNode root, TreeNode prev) {
		if (root == null)
			return;

		flatten(root.right, prev);
		flatten(root.left, prev);

		root.left = null;
		root.right = prev;
		prev = root;

	}

}
