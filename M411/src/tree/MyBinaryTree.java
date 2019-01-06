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
		if (i == null) {
			return;
		}
		if (isEmpty()) {
			root = new MyBinaryTreeNode(i);
			return;
		}
		insertElement(this.root, i);
	}

	/**
	 * Removes the node in the tree that contains the number provided as argument 
	 * @param i
	 */
	public void remove(Integer i) {
		if (i == null || isEmpty()) {
			return;
		}
		MyBinaryTreeNode node = searchNode(root, i);
		// element not contained in the tree
		if (node == null) {
			System.out.println(i + " not contained.");
			return;
		}

		// Element is contained in the tree, we can remove it
		System.out.println("Removing " + i);

		/**
		 * There are three cases: (a) the node is a leaf --> we can just remove it (b)
		 * the node has one child --> we can link the child to the parent of the node we
		 * are removing (c) the node has two children --> copy the max of the subtree to
		 * the node's value and remove the max from the subtree (case a or b)
		 */
		// node is a leaf
		if (node.isLeaf()) {
			removeLeafNode(node);
		}
		// node has one child
		if (node.childrenCount() == 1) {
			removeNodeWithOneChild(node);
		}

		// node has two children
		if (node.childrenCount() == 2) {
			removeNodeWithTwoChildren(node);
		}

	}

	
	private void removeLeafNode(MyBinaryTreeNode node) {
		System.out.println("Removing leaf node.");
		if (node.getParent().getLeft() == node) {
			node.getParent().setLeft(null);
		} else {
			node.getParent().setRight(null);
		}
	}

	private void removeNodeWithOneChild(MyBinaryTreeNode node) {
		System.out.println("Removing node with one child.");
		if (node.getLeft() != null) {
			node.getLeft().setParent(node.getParent());
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(node.getLeft());
			} else {
				node.getParent().setRight(node.getLeft());
			}
		} else {
			node.getRight().setParent(node.getParent());
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(node.getRight());
			} else {
				node.getParent().setRight(node.getRight());
			}
		}
	}

	private void removeNodeWithTwoChildren(MyBinaryTreeNode node) {
		System.out.println("Removing node with two children.");
		// replace the element of the node to be removed with the biggest element in the
		// subtree
		MyBinaryTreeNode max = node.max();
		System.out.println("Max element of subtree is [" + max.getElement() + "]");
		node.setElement(max.getElement());
		// max is either a leaf or has one child
		if (max.isLeaf()) {
			removeLeafNode(max);
		} 
		if (max.childrenCount() == 1) {
			removeNodeWithOneChild(max);
		}
	}

	public boolean contains(Integer i) {
		if (i == null || isEmpty()) {
			return false;
		}
		MyBinaryTreeNode node = searchNode(root, i);
		return node != null;
	}

	public Integer max() {
		if (this.isEmpty()) {
			return null;
		}
		return this.root.max().getElement();
	}

	public Integer min() {
		if (this.isEmpty()) {
			return null;
		}
		return this.root.min().getElement();
	}

	private MyBinaryTreeNode searchNode(MyBinaryTreeNode node, Integer i) {
		if (node == null) {
			return null;
		}
		MyBinaryTreeNode found = null;
		if (i.compareTo(node.getElement()) == 0) {
			found = node;
		}
		if (i.compareTo(node.getElement()) < 0) {
			found = searchNode(node.getLeft(), i);
		}
		if (i.compareTo(node.getElement()) > 0) {
			found = searchNode(node.getRight(), i);
		}
		return found;
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
