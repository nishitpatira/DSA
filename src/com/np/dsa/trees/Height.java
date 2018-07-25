package com.np.dsa.trees;

import com.np.dsa.beans.BinaryTree;
import com.np.dsa.beans.Node;
import com.np.dsa.utils.TreeUtils;

public class Height {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		tree.root = node1;
		tree.root.left = node2;
		tree.root.right = node3;
		node3.right = node6;
		node12.right = node15;
		node9.right = node12;
		node9.left = node11;
		node5.right = node9;
		node2.right = node5;
		node2.left = node4;
		node4.left = node7;
		node4.right = node8;
		node8.left = node10;
		node10.left = node13;
		node10.right = node14;
		System.out.println(TreeUtils.height(tree));
		
	}

}
