package recusion;

import java.util.Scanner;

public class CountLetters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		
		System.out.print( "Geben Sie das zu überprüfende Wort ein:" );

		String word = scan.nextLine();
		
		System.out.println();
		
		System.out.print( "Geben Sie den Buchstaben an, nach dem gesucht werden soll:" );
		
		System.out.println();

		String line = scan.nextLine();
		
		System.out.println("Searching for [" + line.charAt(0) + "] in [" + word + "]");
		
		int counter = charCount(line.charAt(0), word, 0);
		
		System.out.println(line.charAt(0) + " found " + counter + " times.");
		
		 
		scan.close();

	}

	private static int charCount(char charValue, String word, int pos) {
		int counter = 0;
		if (pos >= word.length()) { return counter ; }
		if (charValue == word.charAt(pos)) {
			counter++;
		}
		counter += charCount(charValue, word, pos+1);
		return counter;
	}
	
	private static int charCount(char charValue, String word, int pos, int counter) {
		if (pos >= word.length()) { return counter ; }
		if (charValue == word.charAt(pos)) {
			counter++;
		}
		counter = charCount(charValue, word, pos+1, counter);
		return counter;
	}

}
