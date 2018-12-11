package stack;

import helper.Util;

public class InvertString {

	public static void main(String[] args) {
		String str = Util.getUserInput();
		MyStack myStack = new MyStack();
		char[] charArray = str.toCharArray();
		for (int i=0; i<charArray.length; i++) {
			myStack.push(charArray[i]);
		}
		while (!myStack.isEmpty()) {
			System.out.print(myStack.pop());
		}
		System.out.println();
	}

}
