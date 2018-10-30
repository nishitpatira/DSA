package com.np.dsa.trees;

public class ZigZagLevelOrder {

	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	public ZigZagLevelOrder() {
		root = null;
	}

	void printLevelOrder() {
		int h = height(root);
		boolean isOdd = true;
		int i;
		for (i = 1; i <= h; i++){
			printGivenLevel(root, i, isOdd);
			isOdd = !isOdd;
		}
	}

	void printGivenLevel(Node root, int level, boolean isLeftToRight) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.data);
			return;
		}
		if (isLeftToRight) {
			printGivenLevel(root.left, level - 1, isLeftToRight);
			printGivenLevel(root.right, level - 1, isLeftToRight);
		} else {
			printGivenLevel(root.right, level - 1, isLeftToRight);
			printGivenLevel(root.left, level - 1, isLeftToRight);
		}

	}

	int height(Node root) {
		if (root == null) {
			return 0;
		}
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		return 1 + Math.max(lHeight, rHeight);
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		ZigZagLevelOrder tree = new ZigZagLevelOrder();
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
