package tree;

public class MyBinaryTreeNode {

	Integer element = null;
	MyBinaryTreeNode right = null;
	MyBinaryTreeNode left = null;
	MyBinaryTreeNode parent = null;
	
	public MyBinaryTreeNode(Integer element) {
		this.element = element;
	}
	
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
		if (right != null) { right.setParent(this); }
		this.right = right;
	}
	public MyBinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(MyBinaryTreeNode left) {
		if (left != null) { left.setParent(this); }
		this.left = left;
	}
	public MyBinaryTreeNode getParent() {
		return parent;
	}
	public void setParent(MyBinaryTreeNode parent) {
		this.parent = parent;
	}

	public boolean isLeave() {
		return left == null && right == null;
	}
	
	public int childrenCount() {
		int count = 1;
		if (isLeave()) {
			count = 0;
		} 
		if (left!=null && right!=null) {
			count = 2;
		}
		return count;
	}
	
	public MyBinaryTreeNode max() {
		return max(this);
	}
	
	private MyBinaryTreeNode max(MyBinaryTreeNode node) {
		if (node != null && node.right != null) { 
			return max(node.right); 
		} else {
			return node;
		}
	}
	
	public MyBinaryTreeNode min() {
		return min(this);
	}
	
	private MyBinaryTreeNode min(MyBinaryTreeNode node) {
		if (node != null && node.left != null) {
			return min(node.left);
		} else {
			return node;
		}
	}

}
