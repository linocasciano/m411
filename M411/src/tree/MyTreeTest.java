package tree;

public class MyTreeTest {

	public static void main(String[] args) {
		Node root = generateTree();
		traverseBreathFirst(root, " ");

	}

	private static Node generateTree() {
		Node root = new Node(0);
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

		return root;
	}

	private static void traverseBreathFirst(Node node, String appender) {
		System.out.println(appender + node.getData());
		node.getChildren().forEach(each -> traverseBreathFirst(each, appender + appender));
	}

}
