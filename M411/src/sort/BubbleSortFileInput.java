package sort;


import helper.Util;

public class BubbleSortFileInput {

	public static void main(String[] args) {
		try {
			int[] a = Util.fileToArray("/users/capa/numberInput.txt");
			BubbleSort.bubbleSort(a);
			Util.printArray(a);

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	

}
