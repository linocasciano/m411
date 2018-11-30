package arrays;

import helper.Util;

/**
 * 
 * @author capa
 * 
 * M411: Basic array operations
 * 
 * Read 10 numbers form a user and add the at the beginning of an array.
 *
 */
public class Shift {

	public static void main(String[] args) {
		// initialize variable
		int[] a = Util.getUserInput(10);
		
		//print the array
		for (int i=0; i<a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
		

	}

	public static void shift(int[] a) {
		for (int i=a.length-1; i>0; i--) {
			a[i] = a[i-1];
			
		}
	}

}
