package recusion;

import java.util.Arrays;

import helper.Util;

public class BinarySearch {

	public static void main(String[] args) {
		// binary search needs a sorted array
		// int[] a = Util.fillrand(100000003);
		int[] a = { 1, 4, 6, 88, 123, 456, 1000 };
		int needle = 100;
		// a[0] = needle;
		Arrays.sort(a);
		// Util.printArray(a);
		System.out.println("Searching for " + needle);
		binSearch(needle, a, 0, a.length - 1);

	}

	private static void binSearch(int needle, int[] a, int low, int high) {
		System.out.println("low = " + low + ", high=" + high);
		if (low < high) {
			int i = (low + high) / 2;
			if (a[i] == needle) {
				System.out.println("Found!");
				return;
			}
			if (a[i] < needle) {
				binSearch(needle, a, i + 1, high);
			} else {
				binSearch(needle, a, low, i - 1);
			}
		}

	}

}
