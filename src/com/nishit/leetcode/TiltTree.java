package com.nishit.leetcode;

public class TiltTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int findTilt(TreeNode root) {
		if(root == null){
			return 0;
		}
		if (root.left == null && root.right == null)
			return 0;
		if(root.left == null){
			return Math.abs(root.right.val + findTilt(root.right));
		} else if(root.right == null) {
			return Math.abs(root.left.val + findTilt(root.left));
		} else {
			return Math.abs((root.left.val + findTilt(root.left)) - (root.right.val + findTilt(root.right)));
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		//root.right = new TreeNode(3);
		System.out.println(findTilt(root));
		
	}
}
