package com.nishit.leetcode;

import java.util.Stack;

public class ZigZagLevelOrderStack {

	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	public ZigZagLevelOrderStack() {
		root = null;
	}

	private void printLevelOrder() {
		if (this.root == null) {
			return;
		}
		Stack<Node> stackRightLeftOrder = new Stack<>();
		Stack<Node> stackLeftRightOrder = new Stack<>();
		stackRightLeftOrder.push(root);
		printUtil(stackRightLeftOrder, stackLeftRightOrder);
	}

	private void printUtil(final Stack<Node> stackRightLeft, final Stack<Node> stackLeftRight) {
		while (!stackRightLeft.isEmpty() || !stackLeftRight.isEmpty()) {
			if (!stackRightLeft.isEmpty()) {
				// Means pick from stack in which insert was done first right
				// and then left, find their children and add in other stack in
				// left right fashion
				while (!stackRightLeft.isEmpty()) {
					Node node = stackRightLeft.pop();
					System.out.println(node.data);
					if (node.left != null) {
						stackLeftRight.push(node.left);
					}
					if (node.right != null) {
						stackLeftRight.push(node.right);
					}
				}
				if (!stackLeftRight.isEmpty()) {
					while (!stackLeftRight.isEmpty()) {
						Node node = stackLeftRight.pop();
						System.out.println(node.data);
						if (node.right != null) {
							stackRightLeft.push(node.right);
						}
						if (node.left != null) {
							stackRightLeft.push(node.left);
						}
					}
				}

			}
		}

	}

	public static void main(String args[]) {
		ZigZagLevelOrderStack tree = new ZigZagLevelOrderStack();
		tree.root = new Node(11);
		tree.root.left = new Node(9);
		tree.root.right = new Node(13);
		tree.root.left.left = new Node(2);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(8);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}
}
