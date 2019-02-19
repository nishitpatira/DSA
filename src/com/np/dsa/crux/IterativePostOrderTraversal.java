package com.np.dsa.crux;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.nishit.leetcode.TreeNode;

class StackObject {
	TreeNode node;
	int limit;
	
	public StackObject(final TreeNode node, final int limit){
		this.node = node;
		this.limit = limit;
	}
}

public class IterativePostOrderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root){
		if(root == null){
			return new ArrayList<>();
		}
		
		Stack<StackObject> stack = new Stack<>();
		stack.push(new StackObject(root, 0));
		List<Integer> list = new ArrayList<>();
		TreeNode node;
		while(!stack.isEmpty()){
			if(stack.peek().limit == 0){
				node = stack.peek().node.left;
			} else {
				node = stack.peek().node.right;
			}
			if(node != null){
				stack.push(new StackObject(node, 0));
			} else {
				stack.peek().limit++;
				while(!stack.isEmpty() && stack.peek().limit == 2){
					list.add(stack.pop().node.val);
					if(!stack.isEmpty()){
						stack.peek().limit++;
					}
					
				}
			}
		}
		return list;
	}

}
