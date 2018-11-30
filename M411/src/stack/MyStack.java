package stack;

import java.util.Iterator;

public class MyStack implements Iterator {

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

	private Node first = null;
	private int counter = 0;
	private Node iterator = null;

	public MyStack() {

	}

	public void push(Object item) {
		Node current = first;
		first = new Node(item);
		first.setNext(current);
		counter++;

	}

	public Object pop() {
		Object item = first.getItem();
		first = first.getNext();
		counter--;
		return item;

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node current = first;
		while (current != null) {
			sb.append(current.getItem());
			current = current.getNext();
			if (current != null) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	boolean isEmpty() {
		return counter == 0;
	}

	public Object peek() {
		return first.getItem();
	}
	
	public int size() {
		return this.counter;
	}

	@Override
	public boolean hasNext() {
		if (iterator == null) {
			iterator = new Node(null,first);
			
		}
		return (iterator.getNext() != null);
	}

	@Override
	public Object next() {
		iterator = iterator.getNext();
		return iterator.getItem();
	}

}
