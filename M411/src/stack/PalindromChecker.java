package stack;

import helper.Util;

public class PalindromChecker {

	public static void main(String[] args) {

		String str = Util.getUserInput();

		if (isPalindrom(str)) {
			System.out.println(str + " is a palindrom ");
		} else {
			System.out.println(str + " is not a palindrom ");
		}

	}

	private static boolean isPalindrom(String str) {
		String lowercase = str.toLowerCase();
		MyStack stack = new MyStack();
		for (char c : lowercase.toCharArray()) {
			stack.push(c);
		}
		boolean isPalindrom = true;
		for (char c : lowercase.toCharArray()) {
			if (!stack.pop().equals(c)) {
				isPalindrom = false;
				break;
			}
		}
		return isPalindrom;
	}

}
