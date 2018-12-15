package LinkedList;

public class MyLinkedList {

	private class Node {

		private Object item;
		private Node next;

		public Node(Object item) {
			this.next = null;
			this.item = item;
		}

		public Node(Object item, Node next) {
			this.next = next;
			this.item = item;
		}

		public Object getItem() {
			return item;
		}

		public void setItem(Object item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	private Node head;
	private int count;

	public MyLinkedList() {
		head = new Node(null);
		count = 0;
	}

	public void append(Object item) {
		Node newNode = new Node(item);
		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newNode);
		count++;
	}
	
	public void add(Object item, int pos) {
		if (pos > count) { return; }
		
		//add a new element at the beginning
		if (pos == 0) {
			Node newNode = new Node(item);
			newNode.setNext(head.getNext());
			head.setNext(newNode);
			count++;
			return;
		}
		Node current = head;
		Node previous = head;
		int currentPos = 0;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
			currentPos++;
			if (currentPos == pos) {
				Node newNode = new Node(item);
				newNode.setNext(current.getNext());
				current.setNext(newNode);
			}
			
		}
	}

	public void remove(int pos) {
		if (pos > count) { return; }
		Node current = head;
		Node previous = head;
		int currentPos = 0;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
			currentPos++;
			if (currentPos == pos) {
				previous.setNext(current.getNext());
				count--;
			}
		}	
	}
	
	/**
	 * Removes the last element of the list
	 */
	public void remove() {
		this.remove(count);
	}
	
	
	public void showItems() {
		Node current = head;
		while (current.next != null) {
			current = current.getNext();
			System.out.println(current.getItem());
		}
	}

	public void showItemsReversed() {
		MyLinkedList reversed = new MyLinkedList();
		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
			reversed.add(current.getItem(), 0);
		}
		reversed.showItems();
	}
	
	public void insertAfter(Object pos, Object add) {
		Node current = head;
		Node previous = head;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
			if (current.getItem().equals(pos)) {
				Node node = new Node(add);
				node.setNext(current.getNext());
				current.setNext(node);
			}
		}
	}

	public void remove(Object item) {
		Node current = head;
		Node previous = head;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
			if (current.getItem() != null) {
				if (current.getItem().equals(item)) {
					previous.setNext(current.getNext());
					count--;
				}

			}

		}
	}

}
