package com.np.dsa.utils;

import java.util.ArrayList;
import java.util.List;

import com.np.dsa.beans.BinaryTree;
import com.np.dsa.beans.Node;

public class TreeUtils {

	public static int diameter(BinaryTree tree) {
		/*
		 * Diameter is max of these 3 :
		 * 1. Diameter of left subtree 
		 * 2. Diameter of right subtree 
		 * 3. Height of left subtree + height of right subtree + 1
		 */
		return diameter(tree.root);
	}
	
	public static int height(BinaryTree tree){
		return height(tree.root);
	}

	private static int diameter(Node root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		int leftDiameter = diameter(root.left);
		int rightDiameter = diameter(root.right);

		int diaMeter = Math.max(leftDiameter, rightDiameter);
		return Math.max(diaMeter, leftHeight + rightHeight + 1);
	}

	private static int height(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		return (Math.max(lHeight, rHeight)) + 1;
	}
	
	public static void path(BinaryTree tree, int targetNode) {
		List<Integer> arrayList = new ArrayList<>();
		path(tree.root, arrayList, targetNode);
	}
	
	private static void path(Node root, List<Integer> array, int value) {
		if(root == null) {
			return ;
		}
		array.add(root.data);
		if(root.data == value){
			for(int x : array){
				System.out.println(x);
			}
		}
		path(root.left, array, value);
		path(root.right, array, value);
		Utils.removeLastElementFromList(array);
	}
	
	

}
