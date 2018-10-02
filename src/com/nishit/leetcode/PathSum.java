package com.nishit.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PathSum {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> listOfList = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		pathSumUtil(root, sum, list, listOfList);
		return listOfList;
	}

	private void pathSumUtil(TreeNode root, int sum, List<Integer> list, List<List<Integer>> listOfList) {
		if (sum < 0)
			return;
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				List<Integer> newList = new LinkedList<Integer>();
				for (Integer elem : list) {
					newList.add(elem);
				}
				newList.add(root.val);
				listOfList.add(newList);
				return;
			} else {
				return;
			}

		}
		list.add(root.val);
		pathSumUtil(root.left, sum - root.val, list, listOfList);
		pathSumUtil(root.right, sum - root.val, list, listOfList);
		list.remove(list.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		PathSum pathSum = new PathSum();
		pathSum.pathSum(root, 22);
	}
}
