package com.np.dsa.trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigZagFast {
	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	public ZigZagFast() {
		root = null;
	}

	public List<List<Integer>> zigzagLevelOrder(Node root) {
		List<List<Integer>> zigzagList = new LinkedList<>();
		printGivenLevel(root, 0, zigzagList);
		for (int i = 0; i < zigzagList.size(); i++) {
			if (i % 2 == 0) {
				Collections.reverse(zigzagList.get(i));
			}
		}
		return zigzagList;
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level, List<List<Integer>> list) {
		if (root == null) {
			return;
		}

		if (level >= list.size()) {
			List<Integer> newList = new LinkedList<>();
			list.add(newList);
		}
		list.get(level).add(root.data);
		printGivenLevel(root.left, level + 1, list);
		printGivenLevel(root.right, level + 1, list);
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		ZigZagFast tree = new ZigZagFast();
		tree.root = new Node(11);
		tree.root.left = new Node(9);
		tree.root.right = new Node(13);
		tree.root.left.left = new Node(2);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(8);

		System.out.println("Level order traversal of binary tree is ");
		tree.zigzagLevelOrder(tree.root);
	}
}
