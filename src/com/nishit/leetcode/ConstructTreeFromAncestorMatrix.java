package com.nishit.leetcode;

import java.util.Arrays;

import com.np.dsa.utils.TreeUtils;

public class ConstructTreeFromAncestorMatrix {
	
	public static void main(String[] args) {
		int[][] matrix ={
				{0,0,0,0,0,0},
				{1,0,0,0,1,0},
				{0,0,0,1,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{1,1,1,1,1,0}
				};
		ConstructTreeFromAncestorMatrixTest obj = new ConstructTreeFromAncestorMatrixTest();
		TreeNode root = obj.constructTree(matrix);
		TreeUtils.printPreOrder(root);
	}
	
	
	private TreeNode constructTree(final int[][] matrix){
		if(matrix == null){
			return null;
		}
		int[] columnCount = countColumn(matrix);
		return constructTree(columnCount);
	}
	
	protected TreeNode constructTree(int[] array){
		TreeNode[] nodeArr = new TreeNode[array.length];
		for(int i = 0 ; i < array.length ; i++){
			nodeArr[i] = new TreeNode(array[i]);
		}
		int parent = 0;
		int child = 1;
		while(child < nodeArr.length - 1){
			if(array[child] == array[child+1]){
				nodeArr[parent].left = nodeArr[child];
				nodeArr[parent].right = nodeArr[child+1];
				child += 2;
				parent++;
			} else {
				nodeArr[parent].left = nodeArr[child];
				parent = child;
				child++;
			}
		}
		if(child == nodeArr.length - 1){
			nodeArr[parent].left = nodeArr[child];
		}
		return nodeArr[0];
	}
	
	private int[] countColumn(int[][] matrix){
		int[] count = new int[matrix[0].length];
		for(int j = 0 ; j < matrix[0].length ; j++){
			int tempCount = 0;
			for(int i = 0 ; i < matrix.length ; i++){
				if(matrix[i][j] == 1){
					tempCount++;
				}
			}
			count[j] = tempCount;
		}
		Arrays.sort(count);
		return count;
	}

}
