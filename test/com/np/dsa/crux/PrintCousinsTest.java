package com.np.dsa.crux;

import org.junit.BeforeClass;
import org.junit.Test;

import com.nishit.leetcode.TreeNode;

public class PrintCousinsTest {

	PrintCousins obj = new PrintCousins();

	static TreeNode root = new TreeNode(1);

	@BeforeClass
	public static void setUp() {
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(8);

	}

	@Test
	public void test1() {
		obj.findSiblings(root, root.left.right);
	}

	@Test
	public void test2() {
		obj.findSiblings(root, root.left.right.left);
	}

	@Test
	public void test3() {
		obj.findSiblings(root, root.left);
	}
	
	@Test
	public void test4(){
		obj.findSiblings(root, root.right.left);
	}

}
