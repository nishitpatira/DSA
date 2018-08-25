package com.np.dsa.trees;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LowestCommonAncestorI {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> rootToN1 = new LinkedList<TreeNode>();
		List<TreeNode> rootToN2 = new LinkedList<TreeNode>();
		path(root, p, rootToN1);
		path(root, q, rootToN2);
		int min_length = (rootToN1.size() < rootToN2.size()) ? rootToN1.size() : rootToN2.size();
		TreeNode lca = null;
		if (rootToN1.size() == 0 || rootToN2.size() == 0) {
			return null;
		}
		for (int i = 0; i < min_length; i++) {
			if (rootToN1.get(i) != rootToN2.get(i)) {
				lca = rootToN1.get(i - 1);
				break;
			}
		}
		if (lca == null) {
			lca = rootToN1.get(min_length - 1);
		}
		return lca;
	}

	private boolean path(TreeNode root, TreeNode target, List<TreeNode> list) {
		if (root == null) {
			return false;
		}
		list.add(root);
		if (root.val == target.val) {
			return true;
		}
		if (path(root.left, target, list)) {
			return true;
		}
		if (path(root.right, target, list)) {
			return true;
		}
		list.remove(list.size() - 1);
		return false;
	}
}