package recusion;

import java.util.Arrays;

import helper.Util;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// binary search needs a sorted array
		// int[] a = Util.fillrand(100000003);
		int[] a = { 1, 4, 6, 88, 123, 456, 900, 1000 };
		int needle = 3;
		// a[0] = needle;
		Arrays.sort(a);
		// Util.printArray(a);
		System.out.println("Searching for [" + needle + "]");
		if (binSearch(needle, a, 0, a.length - 1)) {
			System.out.println("Found!");
		} else {
			System.out.println("Not found!");
		}

	}

	/**
	 * @param needle
	 * @param a
	 * @param low
	 * @param high
	 */
	private static boolean binSearch(int needle, int[] a, int low, int high) {
		System.out.println("low = " + low + ", high=" + high);
		if (low <= high) {
			int i = (low + high) / 2;
			if (a[i] == needle) {
				return true;
			}
			if (a[i] < needle) {
				return binSearch(needle, a, i + 1, high);
			} else {
				return binSearch(needle, a, low, i - 1);
			}
		}
		return false;
	}

}
