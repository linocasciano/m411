package stack;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		System.out.println("isEmpty=[" + myStack.isEmpty() + "]");
		myStack.push("to");
		myStack.push("be");
		myStack.push("or");
		myStack.push("not");
		myStack.push("to");
		myStack.push("be");
		System.out.println("isEmpty=[" + myStack.isEmpty() + "]");
		System.out.println(myStack.toString());
		
		System.out.println("Peek [" + myStack.peek() + "]");
		System.out.println("Peek [" + myStack.peek() + "]");
		
	
		
		//iterating with a loop
		while (myStack.hasNext()) {
			System.out.println(myStack.next());
		}
	}

}
