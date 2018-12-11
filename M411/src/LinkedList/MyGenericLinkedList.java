package LinkedList;

public class MyGenericLinkedList<T> {

	private class Node<T> {

		private T item;
		private Node<T> next;

		public Node(T item) {
			this.next = null;
			this.item = item;
		}

		public Node(T item, Node<T> next) {
			this.next = next;
			this.item = item;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}

	private Node<T> head;
	private int count;

	public MyGenericLinkedList() {
		head = new Node<T>(null);
		count = 0;
	}

	public void append(T item) {
		Node<T> newNode = new Node<T>(item);
		Node<T> current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newNode);
		count++;
	}
	
	public void add(T item, int pos) {
		if (pos > count) { return; }
		//add a new element at the beginning
		
		if (pos == 0) {
			Node<T> newNode = new Node<T>(item);
			newNode.setNext(head.getNext());
			head.setNext(newNode);
			count++;
			return;
		}
		Node<T> current = head;
		Node<T> previous = head;
		int currentPos = 0;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
			currentPos++;
			if (currentPos == pos) {
				Node<T> newNode = new Node<T>(item);
				newNode.setNext(current.getNext());
				current.setNext(newNode);
			}
			
		}
	}

	public void remove(int pos) {
		if (pos > count) { return; }
		Node<T> current = head;
		Node<T> previous = head;
		int currentPos = 0;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
			currentPos++;
			if (currentPos == pos) {
				previous.setNext(current.getNext());
			}
			
		}
		
	}
	public void showItems() {
		Node<T> current = head;
		while (current.next != null) {
			current = current.getNext();
			System.out.println(current.getItem());
		}
	}

	public void showItemsReversed() {
		MyGenericLinkedList<T> reversed = new MyGenericLinkedList<T>();
		Node<T> current = head;
		while (current.getNext() != null) {
			current = current.getNext();
			reversed.add(current.getItem(), 0);
		}
		reversed.showItems();
	}
	
	public void insertAfter(Node posNode, Node addNode) {
		//TODO
	}

	public void remove(T item) {
		Node<T> current = head;
		Node<T> previous = head;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
			if (current.getItem() != null) {
				if (current.getItem().equals(item)) {
					previous.setNext(current.getNext());
				}

			}

		}
	}

}
