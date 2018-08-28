package com.nishit.line;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		List<List<Integer>> levelsList = levelOrderTraversal(root);
		for (List<Integer> heightList : levelsList) {
			for (Integer val : heightList) {
				System.out.print(val + "   ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> levelOrderTraversal(final Node root) {
		List<List<Integer>> levelsList = new LinkedList<List<Integer>>();
		List<Integer> zeroList = new LinkedList<>();
		levelsList.add(zeroList);
		levelOrderUtil(root, levelsList, 0);
		return levelsList;
	}

	private static void levelOrderUtil(final Node root, List<List<Integer>> levelsList, int height) {
		if (root == null) {
			return;
		}

		if (height >= levelsList.size()) {
			List<Integer> levelList = new LinkedList<>();
			levelList.add(root.val);
			levelsList.add(levelList);
		} else {
			levelsList.get(height).add(root.val);
		}
		levelOrderUtil(root.left, levelsList, height + 1);
		levelOrderUtil(root.right, levelsList, height + 1);

	}

}
