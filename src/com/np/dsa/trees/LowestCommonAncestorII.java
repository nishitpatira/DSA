package com.np.dsa.trees;

public class LowestCommonAncestorII {
	private static boolean v1 = false;
	private static boolean v2 = false;

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode tempLCA = lowestCommonAncestorUtil(root, p, q);
		if (v1 && v2) {
			return tempLCA;
		} else {
			return null;
		}
	}

	private static TreeNode lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		TreeNode temp = null;

		if (root.val == p.val) {
			v1 = true;
			temp = root;
		}
		if (root.val == q.val) {
			v2 = true;
			temp = root;
		}
		TreeNode left = lowestCommonAncestorUtil(root.left, p, q);
		TreeNode right = lowestCommonAncestorUtil(root.right, p, q);
		if (temp != null)
			return temp;
		if (left != null && right != null)
			return root;
		return (left == null) ? right : left;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
	}
}