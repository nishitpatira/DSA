package com.np.dsa.crux;

public class DepthFromPreOrderTraversal {

	private int findDepthRec(String tree, int n, int index) {
		if (index >= n || tree.charAt(index) == 'l')
			return 1;

		index++;
		int left = findDepthRec(tree, n, index);

		index++;
		int right = findDepthRec(tree, n, index);

		return Math.max(left, right) + 1;
	}

	public int findDepth(String tree, int n) {
		int index = 0;
		return (findDepthRec(tree, n, index));
	}

}
