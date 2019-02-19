package com.np.dsa.crux;

import com.nishit.leetcode.TreeNode;

public class MaxDiffNodeAndAncestor {

	private int maxDiffUtil(TreeNode t) {
		if (t == null)
			return 0;

		if (t.left == null && t.right == null)
			return 0;

		int lMax = maxDiffUtil(t.left);
		int rMax = maxDiffUtil(t.right);

		int lMaxDiff = Integer.MIN_VALUE;
		int rMaxDiff = Integer.MIN_VALUE;

		if (t.left != null) {
			lMaxDiff = t.val - (t.left.val - lMax);
		}

		if (t.right != null) {
			rMaxDiff = t.val - (t.right.val - rMax);
		}

		return Math.max(lMaxDiff, rMaxDiff);

	}

	public int maxDiff(TreeNode root) {
		return maxDiffUtil(root);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);

		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);

		MaxDiffNodeAndAncestor obj = new MaxDiffNodeAndAncestor();
		System.out.println("Maximum difference between a node and" + " its ancestor is : " + obj.maxDiff(root));
	}
}