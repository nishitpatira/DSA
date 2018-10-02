package com.nishit.line;

import java.util.LinkedList;
import java.util.List;

import com.nishit.leetcode.TiltTree.TreeNode;

public class LevelOrderTraversal {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> levelsList = levelOrderTraversal(root);
		for (List<Integer> heightList : levelsList) {
			for (Integer val : heightList) {
				System.out.print(val + "   ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> levelOrderTraversal(final TreeNode root) {
		List<List<Integer>> levelsList = new LinkedList<List<Integer>>();
		List<Integer> zeroList = new LinkedList<>();
		levelsList.add(zeroList);
		levelOrderUtil(root, levelsList, 0);
		return levelsList;
	}

	private static void levelOrderUtil(final TreeNode root, List<List<Integer>> levelsList, int height) {
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
