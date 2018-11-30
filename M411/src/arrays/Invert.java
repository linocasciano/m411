package arrays;

import java.util.Scanner;

/**
 * 
 * @author capa
 * 
 * M411: basic array operations
 * 
 * Read in a string from the user an revert its order
 *
 */
public class Invert {

	public static void main(String[] args) {

		// read in a user entered word
		char[] word;
		Scanner scanner = new Scanner(System.in);
		word = scanner.nextLine().toCharArray();
		scanner.close();
		
		// invert the word
		char[] iword = new char[word.length];
		int j = 0;
		for (int i=word.length-1; i>=0; i--) {
			iword[j] = word[i];
			j++;
		}
		
		// Output the inverted word
		for (int i=0; i<iword.length; i++) {
			System.out.print(iword[i]);
		}


	}

}
