package com.np.dsa.trees;

import com.np.dsa.beans.BinaryTree;
import com.np.dsa.beans.Node;
import com.np.dsa.utils.TreeUtils;

public class PathFromRootToNode {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		tree.root = new Node(1);
		tree.root.left = node2;
		tree.root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		TreeUtils.path(tree, 5);
	}

}
