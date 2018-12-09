package tree;

public class MyBinaryTreeTest {

	public static void main(String[] args) {
		MyBinaryTree myBinaryTree = generateBinaryTree();
		inOrderTraversal(myBinaryTree);
		
		
	}
	
	private static void inOrderTraversal(MyBinaryTree myBinaryTree) {
		//MyBinaryTree
		
	}

	public static MyBinaryTree generateBinaryTree() {
		MyBinaryTree myBinaryTree = new MyBinaryTree();
		MyBinaryTreeNode root = new MyBinaryTreeNode();
		root.setElement(Integer.valueOf(0));
		MyBinaryTreeNode left = new MyBinaryTreeNode();
		left.setElement(1);
		root.setLeft(left);
		MyBinaryTreeNode right = new MyBinaryTreeNode();
		right.setElement(2);
		root.setRight(right);
		return myBinaryTree;
	}
}
