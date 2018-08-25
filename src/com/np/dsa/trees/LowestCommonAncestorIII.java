package com.np.dsa.trees;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorIII {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		List<TreeNode> list = new LinkedList<>();
		inOrder(root, list);
		int possibility = position(list, root, p, q);
		if(possibility == 1){
			return root;
		} else if(possibility == 2){
			return lowestCommonAncestor(root.left, p, q);
		} else if(possibility == 3){
			return lowestCommonAncestor(root.right, p, q);
		} else{
			return null;
		}
	}

	private static int position(List<TreeNode> list, TreeNode root, TreeNode n1, TreeNode n2) {
		if (list.size() == 0)
			return -1;
		else if (list.size() == 1)
			return 1;
		else{
			int rootIndex = findIndex(list, root);
			int n1Index = findIndex(list, n1);
			int n2Index = findIndex(list, n2);
			if(n1Index < rootIndex && n2Index < rootIndex){
				return 2;
			} else if(n1Index > rootIndex && n2Index > rootIndex){
				return 3;
			} else {
				return 1;
			}
		}
	}
	
	private static int findIndex(List<TreeNode> list, TreeNode node){
		for(int i = 0 ; i < list.size() ; i++){
			if(list.get(i) == node){
				return i;
			}
		}
		return -1;
	}

	private static void inOrder(TreeNode node, List<TreeNode> list) {
		if (node == null)
			return;
		inOrder(node.left, list);
		list.add(node);
		inOrder(node.right, list);
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