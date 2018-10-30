package com.nishit.leetcode;

import java.util.LinkedList;
import java.util.List;

public class AllPossibleFullBT {
	
	public static void main(String[] args) {
		AllPossibleFullBT obj = new AllPossibleFullBT();
		List<TreeNode> list = obj.allPossibleFBT(7);
		System.out.println();
	}
	
	public List<TreeNode> allPossibleFBT(int N) {
        if(N <= 0) return null;
        TreeNode root = new TreeNode(0);
        List<TreeNode> returnList = new LinkedList<>();
        if(N == 1){
            returnList.add(root);
            return returnList;
        }
        allPossibleUtil(root, root, N-1, returnList);
        return returnList;
    }
    
    private void allPossibleUtil(TreeNode root, TreeNode node, int count, List<TreeNode> returnList){
        node.left = new TreeNode(0);
        node.right = new TreeNode(0);
        final int tempCount = count - 2; 
        if(tempCount == 0){
            returnList.add(root);
            return;
        }
        allPossibleUtil(root, node.left, count-2, returnList);
        allPossibleUtil(root, node.right, count-2, returnList);
    }

}
