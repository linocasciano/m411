package tree;

public class MyBinaryTreeNode {

	Integer element = null;
	MyBinaryTreeNode right = null;
	MyBinaryTreeNode left = null;
	MyBinaryTreeNode parent = null;
	
	public Integer getElement() {
		return element;
	}
	public void setElement(Integer element) {
		this.element = element;
	}
	public MyBinaryTreeNode getRight() {
		return right;
	}
	public void setRight(MyBinaryTreeNode right) {
		this.right = right;
	}
	public MyBinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(MyBinaryTreeNode left) {
		this.left = left;
	}
	public MyBinaryTreeNode getParent() {
		return parent;
	}
	public void setParent(MyBinaryTreeNode parent) {
		this.parent = parent;
	}

}
