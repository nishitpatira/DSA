package com.np.dsa.trees;

import java.util.LinkedList;
import java.util.List;

public class PrintAllRootToLeaf {
	
	private List<String> paths = new LinkedList<>();
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		path(root, "");
		
		return paths;
		
	}

	private void path(TreeNode root, String str) {
		if (root == null)
			return;
		str = str + Integer.toString(root.val);
		if (root.left == null && root.right == null) {
			paths.add(str);
			return;
		}
		str = str + "->";
		path(root.left, str);
		path(root.right, str);
	}
	
	public static void main(String[] args) {
		PrintAllRootToLeaf tree = new PrintAllRootToLeaf();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		List<String> list = tree.binaryTreePaths(root);
		System.out.println(list.size());
		for(String str : list){
			System.out.println(str);
		}
	}
}
