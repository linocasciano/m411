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
		System.out.println("Removing " + i);
		// remove node
		// node is a leaf
		if (node.isLeave()) {
			System.out.println(i + " is a leave node.");
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(null);
			} else {
				node.getParent().setRight(null);
			}
		}
		// node has one child
		if (node.childrenCount() == 1) {
			System.out.println("Node has one child.");
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
		
		// node has two children
		if (node.childrenCount() == 2) {
			// replace the element of the node to be removed with the biggest element in the subtree
			MyBinaryTreeNode max = node.max();
			node.setElement(max.getElement());			
			max.getParent().setRight(max.getLeft());			
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
		if (this.isEmpty()) { return null; }
		return this.root.max().getElement();
	}
	
	public Integer min() {
		if (this.isEmpty()) { return null; }
		return this.root.min().getElement();
	}

	private MyBinaryTreeNode searchNode(MyBinaryTreeNode node, Integer i) {
		if (node == null) { return null; }
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
