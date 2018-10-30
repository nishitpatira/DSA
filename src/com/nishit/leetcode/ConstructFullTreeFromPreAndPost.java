package com.nishit.leetcode;

import com.np.dsa.utils.TreeUtils;

public class ConstructFullTreeFromPreAndPost {

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		/*
		 * if (pre.length % 2 == 0 || pre.length != post.length) { return null;
		 * }
		 */
		TreeNode root = new TreeNode(pre[0]);
		boolean[] isPreVisited = new boolean[pre.length];
		boolean[] isPostVisited = new boolean[post.length];
		isPreVisited[0] = true;
		isPostVisited[pre.length - 1] = true;
		construct(root, pre, post, isPreVisited, isPostVisited);
		return root;

	}

	private void construct(final TreeNode root, final int[] pre, final int[] post, final boolean[] isPreVisited,
			final boolean[] isPostVisited) {
		if (root == null)
			return;
		Integer left = findAndMarkLeft(root.val, pre, post, isPreVisited, isPostVisited);
		Integer right = findAndMarkRight(root.val, pre, post, isPreVisited, isPostVisited);
		if (left != null) {
			TreeNode leftNode = new TreeNode(left);
			root.left = leftNode;
			construct(leftNode, pre, post, isPreVisited, isPostVisited);
		}
		if (right != null) {
			TreeNode rightNode = new TreeNode(right);
			root.right = rightNode;
			construct(rightNode, pre, post, isPreVisited, isPostVisited);
		}

	}

	private Integer findAndMarkLeft(int value, int[] preOrder, int[] postOrder, boolean[] isPreVisited,
			boolean[] isPostVisited) {
		for (int i = 0; i < preOrder.length - 1; i++) {
			if (preOrder[i] == value) {
				if (isPreVisited[i + 1]) {
					return null;
				}
				isPreVisited[i + 1] = true;
				for (int j = postOrder.length - 1; j >= 0; j--) {
					if (postOrder[j] == preOrder[i + 1]) {
						isPostVisited[j] = true;
					}
				}
				return preOrder[i + 1];
			}
		}
		return null;
	}

	private Integer findAndMarkRight(int value, int[] preOrder, int[] postOrder, boolean[] isPreVisited,
			boolean[] isPostVisited) {
		for (int i = postOrder.length - 1; i > 0; i--) {
			if (postOrder[i] == value) {
				if (isPostVisited[i - 1]) {
					return null;
				}
				isPostVisited[i - 1] = true;
				for (int j = 0; j <= preOrder.length - 1; j++) {
					if (preOrder[j] == postOrder[i - 1]) {
						isPreVisited[j] = true;
					}
				}
				return postOrder[i - 1];
			}
		}
		return null;

	}

	public static void main(String[] args) {
		ConstructFullTreeFromPreAndPost construct = new ConstructFullTreeFromPreAndPost();
		int[] pre = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		int[] post = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
		com.nishit.leetcode.TreeNode root = construct.constructFromPrePost(pre, post);
		TreeUtils.printInOrder(root);

	}
}
