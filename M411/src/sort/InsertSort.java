package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import helper.Util;

/**
 * 
 * @author capa
 * 
 *         M411: Basic Sorting algorithm: insert sort
 *
 */
public class InsertSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String filename = "/users/capa/numberInput.txt";

			int linecount = Util.getLineCount(filename);
			// initialize an array and populate it
			int[] a = new int[linecount];
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String inputLine;
			int i = 0;
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
				a[i] = Integer.valueOf(inputLine);
				i++;
			}
			br.close();

			System.out.println("Sorting the array with insert sort...");
			// insert sort
			long startTime = System.nanoTime();
			for (int j = 1; j < a.length; j++) {
				insertSort(a, j, a[j]);
			}
			long endTime = System.nanoTime();

			System.out.println("Time elapsed [" + (endTime - startTime) + "] ns.");

			// print the sorted array
			for (int l = 0; l < a.length; l++) {
				System.out.println(a[l]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void insertSort(int[] a, int pos, int value) {
		int i = pos - 1;
		while (i >= 0 && a[i] > value) {
			a[i + 1] = a[i];
			i--;
		}
		a[i + 1] = value;

	}
}
