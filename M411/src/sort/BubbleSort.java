package sort;

import helper.Util;

/**
 * @author capa
 *
 */
public class BubbleSort {

	/**
	 * @param a
	 * 
	 * Sorts an array of integer with the bubble sort algorithm
	 */
	public static void bubbleSort(int[] a) {
		System.out.println("Sorting the array with bubble sort...");
		System.out.println("Array contains [" + a.length + "] elements.");
		
		int tmp;
		int passes = 0;
		long swappes = 0;
		boolean swapped;
		for (int j=0; j<a.length; j++) {
			swapped = false;
			for (int k=0; k<a.length-1-j; k++) {
				if (a[k] > a[k+1]) {
					swappes++;
					tmp = a[k];
					a[k] = a[k+1];
					a[k+1] = tmp;
					swapped = true;
				}
			}
			passes++;
			Util.printArray(a);
			if (!swapped) { break; }
		}
		
		System.out.println("Array sorted in [" + passes + "] passes");
		System.out.println("Array sorted with [" + swappes + "] swapps.");
	}

}
