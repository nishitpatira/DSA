package com.nishit.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	
	public static void main(String[] args) {
		
	}
	
	public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> lot = new LinkedList<>();
        rightViewUtil(root, lot, 0);
        List<Integer> finalList = new ArrayList<Integer>();
        for(List<Integer> list : lot){
            finalList.add(list.get(0));
        }
        return finalList;
    }
    
    private void rightViewUtil(TreeNode root, List<List<Integer>> lot, int height){
        if(root == null){
            return;
        }
        
        if(height == lot.size()){
            List<Integer> newList = new ArrayList<>();
            lot.add(newList);
            newList.add(root.val);
        } else {
            lot.get(height).add(root.val);
        }
        rightViewUtil(root.right, lot, height+1);
        rightViewUtil(root.left, lot, height+1);
    }

}
