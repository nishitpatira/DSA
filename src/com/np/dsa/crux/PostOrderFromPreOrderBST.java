package com.np.dsa.crux;

///https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/
public class PostOrderFromPreOrderBST {

	public static void main(String[] args) {
		//int[] preOrder = { 40, 30, 32, 35, 80, 90, 100, 120 };
		
		int[] preOrder = {40,30,35,80,100};
		
		postOrderBST(preOrder, 0, preOrder.length - 1);
	}

	private static void postOrderBST(int[] arr, int start, int end) {
		if (start > end) {
			return;
		}

		int root = arr[start];
		int leftStart = start + 1;
		int leftEnd = start;
		int rightStart = end+1;
		int rightEnd = end;
		for (int i = start+1; i <= end; i++) {
			if (arr[i] > root) {
				leftEnd = i - 1;
				rightStart = i;
				break;
			}
		}
		postOrderBST(arr, leftStart, leftEnd);
		postOrderBST(arr, rightStart, rightEnd);
		System.out.println(root);

	}

}
