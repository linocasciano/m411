package helper;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import arrays.Shift;

public class Util {

	public static int getLineCount(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		// count the lines in the file
		int linecount = 0;
		while (br.readLine() != null) {
			linecount++;
		}
		br.close();
		return linecount;

	}

	public static int[] fillrand(int size) {
		// Initialize variables
		int a[] = new int[size];
		Random rand = new Random();

		// populate the array with random numbers
		for (int i = 0; i < size; i++) {
			a[i] = rand.nextInt(1000);
		}
		return a;
	}
	
	public static ArrayList<Integer> fillrandArrayList(int size) {
		// Initialize variables
		ArrayList<Integer> aL = new ArrayList<>();
		Random rand = new Random();

		// populate the array with random numbers
		for (int i = 0; i < size; i++) {
			aL.add(rand.nextInt(1000));
		}
		return aL;
	}
	
	public static int[] fillUniqueRand(int size) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=0; i<size; i++) {
			al.add(i);
		}
		Collections.shuffle(al);
		int[] a = new int[size];
		for (int i=0; i<size; i++) {
			a[i] = al.get(i);
		}
		return a;
		
	}	
	public static void printArray(int[] a) {
		for (int l=0; l<a.length; l++) {
			System.out.println(a[l]);
		}
	}
	
	public static int[] fileToArray(String fileName) throws IOException, FileNotFoundException {
		int linecount = Util.getLineCount(fileName);
		
		// initialize an array and populate it
		int[] a = new int[linecount];
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String inputLine;
		int i=0;
		while ((inputLine = br.readLine()) != null) {
			System.out.println(inputLine);
			a[i] = Integer.valueOf(inputLine);
			i++;
		}
		br.close();
		
		System.out.println("File contained [" + linecount + "] numbers");
		return a;
	}
	

	public static int[] getUserInput(int size) {
		int a[] = new int[size];
		Scanner scanner = new Scanner(System.in);
		
		//read in the user's input
		for (int i=0; i<size; i++) {
			Shift.shift(a);
			a[0] = scanner.nextInt();
		}
		
		scanner.close();
		return a;
	}
	
	public static String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		return str;
	}
	

}
