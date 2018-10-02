package com.nishit.leetcode;

import com.nishit.leetcode.TiltTree.TreeNode;

public class ConstructFullTreeFromPreAndPost {

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		/*if (pre.length % 2 == 0 || pre.length != post.length) {
			return null;
		}*/
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
        if(right != null){
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
		for (int i = postOrder.length-1; i > 0; i--) {
			if (postOrder[i] == value) {
				if (isPostVisited[i - 1]) {
					return null;
				}
				isPostVisited[i - 1] = true;
				for (int j =0 ; j <= preOrder.length-1; j++) {
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
		int[] pre = { 2, 1, 3 };
		int[] post = { 3, 1, 2 };
		construct.constructFromPrePost(pre, post);

	}
}
