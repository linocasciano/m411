package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 * @author capa
 * 
 *         M411: Basic sort algorithm: Quicksort
 *
 */

public class QuickSort {

	public static void main(String[] args) {
		try {
			String filename = "/users/capa/numberInput.txt";

			// initialize an array and populate it
			ArrayList<Integer> a = new ArrayList<Integer>();
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String inputLine;
			@SuppressWarnings("unused")
			int i = 0;
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
				a.add(Integer.valueOf(inputLine));
				i++;
			}
			br.close();

			System.out.println("Sorting the array with quick sort...");
			long startTime = System.nanoTime();
			// quick sort
			quickSort(a);
			long endTime = System.nanoTime();

			System.out.println("Time elapsed [" + (endTime - startTime) + "] ns.");
			// print the sorted array
			for (int l = 0; l < a.size(); l++) {
				System.out.println(a.get(l));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void quickSort(ArrayList<Integer> a) {
		if (a.size() < 2)
			return;
		int pivot = getPivot(a);
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> e = new ArrayList<Integer>();
		ArrayList<Integer> g = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) < pivot) {
				l.add(a.get(i));
			} else if (a.get(i) > pivot) {
				g.add(a.get(i));
			} else {
				e.add(a.get(i));
			}
		}
		quickSort(l);
		quickSort(g);

		a.clear();

		for (int i = 0; i < l.size(); i++) {
			a.add(l.get(i));
		}
		for (int i = 0; i < e.size(); i++) {
			a.add(e.get(i));
		}
		for (int i = 0; i < g.size(); i++) {
			a.add(g.get(i));
		}

	}

	public static Integer getPivot(ArrayList<Integer> a) {
		return a.get(0);
	}

}
