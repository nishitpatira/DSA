package com.np.dsa.crux;

import org.junit.Test;

import com.nishit.leetcode.TreeNode;
import com.np.dsa.utils.TreeUtils;

public class ConstructTreeFromPreOrderTest {
	
	ConstructTreeFromPreOrder obj = new ConstructTreeFromPreOrder();
	
	@Test
	public void test1(){
		int[] values = {10,30,20,5,15};
		String[] order = {"N","N","L","L","L"};
		TreeNode root = obj.constructTree(values, order);
		TreeUtils.printInOrder(root);
	}
	
}
