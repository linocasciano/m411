package tree;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MyTreeTest {

	public static void main(String[] args) {
		MyTree myTree = generateTree();
		//traverseDepthFirst(root, " ");
		breathFirst(myTree.getRoot());

	}

	private static MyTree generateTree() {
		Node root = new Node(0);
		MyTree myTree = new MyTree();
		myTree.setRoot(root);
		
		Node node1 = root.addChild(new Node(1));
		Node node2 = root.addChild(new Node(2));
		Node node3 = root.addChild(new Node(3));

		node1.addChild(new Node(4));
		node1.addChild(new Node(5));
		node1.addChild(new Node(6));

		node2.addChild(new Node(7));
		node2.addChild(new Node(8));
		node2.addChild(new Node(9));

		node3.addChild(new Node(10));
		node3.addChild(new Node(11));
		node3.addChild(new Node(12));

		return myTree;
	}

	private static void traverseDepthFirst(Node node, String appender) {
		node.getChildren().forEach(each -> traverseDepthFirst(each, appender + appender));
		System.out.println(appender + node.getData());
	}

	private static void breathFirst(Node root) {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node current;
		while (!queue.isEmpty()) {
			current = queue.removeFirst();
			System.out.println(current.getData());	
			current.getChildren().forEach(each -> queue.add(each));
		}

	}

}
