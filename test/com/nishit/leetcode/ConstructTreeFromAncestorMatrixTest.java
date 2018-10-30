package com.nishit.leetcode;

import org.junit.Test;

import com.np.dsa.utils.TreeUtils;

public class ConstructTreeFromAncestorMatrixTest {
	
	ConstructTreeFromAncestorMatrix obj = new ConstructTreeFromAncestorMatrix();

	@Test
	public void test1(){
		int[] sortedArray = {0,1,1,2,2,2,3,4,5};
		TreeNode root = obj.constructTree(sortedArray);
		TreeUtils.printPreOrder(root);	
	}
	
	@Test
	public void test2(){
		int[] sortedArray = {0,1,1,2,2,2,3,4,4};
		TreeNode root = obj.constructTree(sortedArray);
		TreeUtils.printPreOrder(root);	
	}
	
}
