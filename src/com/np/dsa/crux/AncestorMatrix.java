package com.np.dsa.crux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nishit.leetcode.TiltTree.TreeNode;
import com.np.dsa.utils.Utils;

//https://www.geeksforgeeks.org/construct-ancestor-matrix-from-a-given-binary-tree/

public class AncestorMatrix {
	
	private int index = 0;
	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);
		*/
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		
		int size = 6;
		AncestorMatrix obj = new AncestorMatrix();
		Utils.printMatrix(obj.createAncestorMatrix(root, size));
	}
	
	public int[][] createAncestorMatrix(final TreeNode root, int size){
		if(root == null){
			return null;
		}
		
		Map<TreeNode, Integer> nodeIndexMapping = new HashMap<>();
		int[][] matrix = new int[size][size];
		convert(root, nodeIndexMapping, matrix, new ArrayList<TreeNode>());
		return matrix;
	}
	
	private void convert(final TreeNode root, final Map<TreeNode, Integer> map, final int[][] matrix, final List<TreeNode> regularList){
		if(root == null) {
			return;
		}
		insertInMap(root, map);
		updateMatrix(root, map, matrix, regularList);
		regularList.add(root);
		convert(root.left, map, matrix, regularList);
		convert(root.right, map, matrix, regularList);
		regularList.remove(regularList.size()-1);
	}
	
	private void insertInMap(final TreeNode root, final Map<TreeNode, Integer> map){
		map.put(root, index);
		index++;
	}
	
	private void updateMatrix(final TreeNode root, final Map<TreeNode, Integer> map, final int[][] matrix, final List<TreeNode> list){
		int columnIndex = map.get(root);
		for(TreeNode node : list){
			int rowIndex = map.get(node);
			matrix[rowIndex][columnIndex] = 1;
		}
	}

}
