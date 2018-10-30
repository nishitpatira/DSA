package com.np.dsa.crux;

import org.junit.Test;

import com.nishit.leetcode.TreeNode;

public class PrintCousinsTest {

	PrintCousins obj = new PrintCousins();

	@Test
	public void test1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(8);
		obj.findSiblings(root, root.left.right);
	}

	@Test
	public void test2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(8);
		obj.findSiblings(root, root.left.right.left);
	}

	@Test
	public void test3() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(8);
		obj.findSiblings(root, root.left);
	}

}
