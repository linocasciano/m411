package tree;


import java.util.ArrayList;
import java.util.List;


public class Node {

	private Integer data = null;

	private ArrayList<Node> children = new ArrayList<Node>();

	private Node parent = null;

	public Node(Integer data) {
		this.data = data;
	}

	public Node addChild(Node child) {
		child.setParent(this);
		this.children.add(child);
		return child;
	}

	public void addChildren(ArrayList<Node> children) {
		children.forEach(n -> n.setParent(this));
		this.children.addAll(children);
	}

	public List<Node> getChildren() {
		return children;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	private void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getParent() {
		return parent;
	}

}