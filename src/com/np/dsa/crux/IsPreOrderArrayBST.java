package com.np.dsa.crux;

public class IsPreOrderArrayBST {

	private static boolean isValidBST = true;

	public static void main(String[] args) {
		// int[] preOrder = { 40, 30, 32, 35, 80, 90, 100, 120 };

		int[] preOrder = { 40, 30, 35, 20, 80, 100 };

		isBST(preOrder, 0, preOrder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(isValidBST);
	}

	private static void isBST(final int[] arr, int start, int end, int min, int max) {
		if (start > end) {
			return;
		}

		int root = arr[start];
		int lStart = start + 1;
		int lEnd = -1;
		int rStart = -1;
		int rEnd = end;
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] > max || arr[i] < min) {
				isValidBST = false;
				return;
			} else if (arr[i] > root) {
				lEnd = i - 1;
				rStart = i;
				isBST(arr, lStart, lEnd, min, root);
				isBST(arr, rStart, rEnd, root, max);
				break;
			}
		}
	}
}
