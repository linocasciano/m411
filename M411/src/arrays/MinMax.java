package arrays;

import helper.Util;

/**
 * 
 * @author capa
 *
 * M411: Basic operations with arrays
 * 
 */

public class MinMax {

	public static void main(String[] args) {
		int a[] = Util.fillrand(1000000);
		// search for the minimum and maximum
		int min = a[0];
		int max = a[0];
		for (int i=1; i<100; i++) {
			if (a[i] > max) {
				max = a[i];
			} 
			if (a[i] < min) {
				min = a[i];
			}
		}
		
		// print the result
		System.out.println("The maximums is [" + max + "]");
		System.out.println("The minimum is [" + min + "]");
	}

}
