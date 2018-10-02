package com.nishit.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nishit.leetcode.TiltTree.TreeNode;
import com.nishit.line.LevelOrderTraversal;

public class ConstructTreeFromInAndPre {

	public TreeNode buildTree(int[] preOrder, int[] inOrder) {
		if (inOrder == null || preOrder == null || inOrder.length != preOrder.length || inOrder.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = preProcessInOrder(inOrder);
		TreeNode rootIndex = new TreeNode(findInOrderIndex(map, preOrder[0]));
		TreeNode rootValue = new TreeNode(preOrder[0]);

		for (int i = 1; i < preOrder.length; i++) {
			int index = findInOrderIndex(map, preOrder[i]);
			insertIndexInBST(rootIndex, rootValue, index, inOrder);
		}
		//convertIndexToValue(rootIndex, inOrder);

		return rootValue;
	}

	private void insertIndexInBST(TreeNode rootIndex, TreeNode rootValue, int index, int[] inOrder) {
		if (rootIndex.left == null && index < rootIndex.val) {
			TreeNode newIndexNode = new TreeNode(index);
			rootIndex.left = newIndexNode;
			
			TreeNode newValueNode = new TreeNode(inOrder[index]);
			rootValue.left = newValueNode;
			return;
		}
		if (rootIndex.right == null && index > rootIndex.val) {
			TreeNode newIndexNode = new TreeNode(index);
			rootIndex.right = newIndexNode;
			
			TreeNode newValueNode = new TreeNode(inOrder[index]);
			rootValue.right = newValueNode;
			return;
		}
		if (rootIndex.val > index) {
			insertIndexInBST(rootIndex.left, rootValue.left, index, inOrder);
		} else {
			insertIndexInBST(rootIndex.right, rootValue.right, index, inOrder);
		}
	}

	private Map<Integer, Integer> preProcessInOrder(final int[] inOrder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}
		return map;
	}

	private int findInOrderIndex(final Map<Integer, Integer> map, final int preOrderElement) {
		return map.get(preOrderElement);
	}

	private void convertIndexToValue(final TreeNode root, final int[] inOrder) {
		if (root == null) {
			return;
		}
		convertIndexToValue(root.left, inOrder);
		convertIndexToValue(root.right, inOrder);
		root.val = inOrder[root.val];
	}

	public static void main(String[] args) {
		ConstructTreeFromInAndPre construct = new ConstructTreeFromInAndPre();
		final int[] inOrder = { 9, 3, 15, 20, 7 };
		final int[] preOrder = { 3, 9, 20, 15, 7 };
		TreeNode root = construct.buildTree(preOrder, inOrder);
		for (List<Integer> heightList : LevelOrderTraversal.levelOrderTraversal(root)) {
			for (Integer val : heightList) {
				System.out.print(val + "   ");
			}
			System.out.println();
		}
		System.out.println(root);
	}

}
