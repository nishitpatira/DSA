package com.np.dsa.trees;

public class HeightAndSize {

	 private static int size = 1;
		Node root;

		// Function to compute height and
		// size of a binary tree
		int heighAndSize(Node node) 
		{
			if(node == null){
			    size--;
			    return 0;
			}
			
			int lsize = heighAndSize(node.left);
			size += 1;
			int rsize = heighAndSize(node.right);
			size += 1;
			return 1 + Math.max(lsize,rsize);
		}

		//function to calculate density of a binary tree
		float density(Node root) 
		{
			if (root == null)
				return 0;
					
			// Finds height and size
			int _height = heighAndSize(root);

			return (float) size / _height;
		}

		// Driver code to test above methods
		public static void main(String[] args) 
		{
			HeightAndSize tree = new HeightAndSize();
			tree.root = new Node(1);
			tree.root.left = new Node(2);
			tree.root.right = new Node(3);
			//tree.root.left.left = new Node(4);

			System.out.println("Density of given Binary Tree is : "
					+ tree.density(tree.root));
		}


}

//Java program to find density of Binary Tree

//A binary tree node
class Node 
{
	int data;
	Node left, right;

	public Node(int data) 
	{
		this.data = data;
		left = right = null;
	}
}
