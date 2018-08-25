package com.np.dsa.trees;

class TreeFromInAndPre
{
	static class Node
	{
		int data;
		Node left, right;

		Node(int item)
		{
			data = item;
			left = right = null;
		}

		public void setLeft(Node left)
		{
			this.left = left;
		}

		public void setRight(Node right)
		{
			this.right = right;
		}
	}
	public static void main(String args[])
	{
		final TreeFromInAndPre tree = new TreeFromInAndPre();
		final int in[] = {4, 8, 10, 12, 14, 20, 22};
		final int level[] = {20, 8, 22, 4, 12, 10, 14};
		final Node node = tree.buildTree(in, level);

		System.out.print("Inorder traversal of the constructed tree is ");
		tree.printInorder(node);
	}

	Node root;

	Node buildTree(int in[], int level[])
	{
		return constructTree( level, in, 0, in.length - 1);
	}

	Node constructTree(int[] levelOrder, int[] inOrder,
			int inStart, int inEnd)
	{
		if (inStart > inEnd) {
			return null;
		}

		if (inStart == inEnd) {
			return new Node(inOrder[inStart]);
		}

		int root_index = -1;
		root_index = findRootIndex(levelOrder, inOrder, inStart, inEnd);

		final Node left = constructTree(levelOrder, inOrder, inStart, root_index-1);
		final Node temp = new Node(inOrder[root_index]);
		final Node right = constructTree(levelOrder, inOrder, root_index+1, inEnd);

		temp.left = left;
		temp.right = right;
		return temp;
	}

	private int findRootIndex(int[] levelOrder, int[] inOrder, int inStart, int inEnd){
		for(int i = 0 ; i < levelOrder.length ; i++){
			for(int j = inStart ; j <= inEnd ; j++){
				if(levelOrder[i] == inOrder[j]){
					return j;
				}
			}
		}
		return -1;
	}
	/* Utility function to print inorder traversal of binary tree */
	void printInorder(Node node)
	{
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}
}
