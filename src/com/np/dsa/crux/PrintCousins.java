package com.np.dsa.crux;

import java.util.ArrayList;
import java.util.List;

import com.nishit.leetcode.TreeNode;

public class PrintCousins {
	
	public void findSiblings(TreeNode root, TreeNode node){
		if(root == node){
			return;
		}
		List<TreeNode> list1 = new ArrayList<>();
		list1.add(root);
		List<TreeNode> list2 = new ArrayList<>();
		boolean found = false;
		while(!list1.isEmpty()){
			for(TreeNode temp : list1){
				if(temp.left == node || temp.right == node){
					found = true;
					continue;
				}
				if(temp.left != null){
					list2.add(temp.left);
				}
				if(temp.right != null){
					list2.add(temp.right);
				}
			}
			list1 = list2;
			list2 = new ArrayList<>();
			if(found){
				for(TreeNode n : list1){
					System.out.println(n.val);
				}
				break;
			}
		}
	}

}
