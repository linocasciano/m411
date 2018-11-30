package sort;

import helper.Util;

public class BubbleSortRandomArray {

	public static void main(String[] args) {
		try {
			int[] a = Util.fillUniqueRand(100000);
			long startTime = System.currentTimeMillis();
			BubbleSort.bubbleSort(a);
			long endTime = System.currentTimeMillis();
			
			System.out.println("Time elapsed [" + (endTime - startTime) + "] ms");
			//Util.printArray(a);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
