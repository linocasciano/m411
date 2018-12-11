package tree;

public class MyBinaryTree {

	private MyBinaryTreeNode root = null;

	public MyBinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(MyBinaryTreeNode root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(Integer i) {
		if (i==null) { return; }
		if (isEmpty()) {
			root = new MyBinaryTreeNode(i);
			return;
		}
		insertElement(this.root, i);
	}

	private void insertElement(MyBinaryTreeNode node, Integer i) {
		
		// if the element is contained in this node the recursion will terminate
		
		// elemement is smaller than the node
		if (i.compareTo(node.getElement()) < 0) {
			if (node.getLeft() == null) {
				node.setLeft(new MyBinaryTreeNode(i));
			} else {
				insertElement(node.getLeft(), i);
			}
		}

		// element is greate than the node
		if (i.compareTo(node.getElement()) > 0) {
			if (node.getRight() == null) {
				node.setRight(new MyBinaryTreeNode(i));
			} else {
				insertElement(node.getRight(), i);
			}
		}

	}

}
