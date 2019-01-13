package recusion;

import java.util.Scanner;

public class CountLetters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		
		System.out.println( "Geben Sie das zu überprüfende Wort ein:" );

		String word = scan.nextLine();
		
		System.out.println( "Geben Sie den Buchstaben an, nach dem gesucht werden soll:" );

		String line = scan.nextLine();
		
		System.out.println("Searching for [" + line.charAt(0) + "] in [" + word + "]");
		
		Integer counter = 0;
		charCount(line.charAt(0), word, 0, counter);
		
		System.out.println(line.charAt(0) + " found " + counter + " times.");
		scan.close();

	}

	private static void charCount(char charValue, String word, int pos, Integer counter) {
		if (pos >= word.length()) { return; }
		if (charValue == word.charAt(pos)) {
			counter = counter + 1;
		}
		charCount(charValue, word, pos+1, counter);		
	}

}
