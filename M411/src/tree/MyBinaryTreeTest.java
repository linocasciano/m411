package tree;

import java.util.ArrayList;

public class MyBinaryTreeTest {

	public static void main(String[] args) {
		//MyBinaryTree myBinaryTree = generateBinaryTree();
		
		MyBinaryTree myBinaryTree = new MyBinaryTree();
		int[] a = {6, 9, 3, 17, 2, 98, 55, 1, 32, 42, 15, 6, 7, 85, 10};
		for (int i=0; i<a.length; i++) {
			myBinaryTree.insert(a[i]);
		}
		System.out.println("Tree populated.");
		myBinaryTree.remove(1);


	}

	private static void inOrderTraversal(MyBinaryTreeNode node) {
		MyBinaryTreeNode current = node;
		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		}
		System.out.println(current.getElement());
		if (current.getRight() != null) {
			inOrderTraversal(current.getRight());
		}

	}

	public static MyBinaryTree generateBinaryTree() {
		MyBinaryTree myBinaryTree = new MyBinaryTree();
		MyBinaryTreeNode root = new MyBinaryTreeNode(0);
		myBinaryTree.setRoot(root);
		
		root.setLeft(new MyBinaryTreeNode(1));
		root.getLeft().setLeft(new MyBinaryTreeNode(2));
		root.getLeft().setRight(new MyBinaryTreeNode(3));
		
		root.setRight(new MyBinaryTreeNode(4));
		root.getRight().setLeft(new MyBinaryTreeNode(5));
		root.getRight().setRight(new MyBinaryTreeNode(6));
		
		return myBinaryTree;
	}
}
