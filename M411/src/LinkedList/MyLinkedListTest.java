package LinkedList;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.append("Hello,");
		myLinkedList.append("Arnold,");
		myLinkedList.append("how");
		myLinkedList.append("are");
		myLinkedList.append("you,");
		myLinkedList.append("doing?");
		myLinkedList.append("are");
		
		myLinkedList.showItems();
		
		myLinkedList.remove("are");
		//myLinkedList.remove(5);
		//myLinkedList.add("Huber", 2);
		
		myLinkedList.showItems();
		//myLinkedList.showItemsReversed();
	}

}
