package LinkedList;

import java.util.Scanner;

public class MyLinkedListTest2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int size = 3;
		MyLinkedList myLinkedList = new MyLinkedList();
		// read in the user's input
		for (int i = 0; i < size ; i++) {
			myLinkedList.add(scanner.nextInt(), 0);
		}

		scanner.close();
		
		myLinkedList.showItems();

	}

}
