package com.np.dsa.crux;

import java.util.Stack;

import com.nishit.leetcode.TreeNode;

//https://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/

class NodeCountPair{
	TreeNode node;
	int count;
	
	public NodeCountPair(TreeNode node, int count){
		this.node = node;
		this.count = count;
	}
}

public class ConstructTreeFromPreOrder {
	
	public TreeNode constructTree(final int[] values, final String[] order){
		if(values == null || order == null){
			return null;
		}
		if(values.length != order.length){
			return null;
		}
		return constructUtil(values, order);
	}
	
	private TreeNode constructUtil(int[] values, String[] order){
		Stack<NodeCountPair> stack = new Stack<>();
		TreeNode root = new TreeNode(values[0]);
		stack.push(new NodeCountPair(root, 0));
		
		for(int i = 1 ; i < values.length ; i++){
			TreeNode node = new TreeNode(values[i]);
			NodeCountPair peek = stack.peek();
			
			if(order[i] == "N"){
				NodeCountPair push = new NodeCountPair(node, 0);
				if(peek.count == 0){
					peek.node.left = node;
				} else {
					peek.node.right = node;
				}
				stack.push(push);
			} else {
				if(peek.count == 0){
					peek.node.left = node;
				} else {
					peek.node.right = node;
				}
				peek.count++;
				while(!stack.isEmpty() &&stack.peek().count == 2){
					stack.pop();
					if(!stack.isEmpty()){
						stack.peek().count++;
					}
				}
			}
		}
		
		return root;
	}

}
