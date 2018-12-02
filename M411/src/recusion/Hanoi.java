package recusion;

import java.util.ArrayList;

public class Hanoi {
	

	public static void main(String[] args) {
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		ArrayList<Integer> third = new ArrayList<Integer>();
		int size = 10;
		for (int i=0; i<size; i++) {
			first.add(i);
		}

		System.out.println("Printing first, second, third...");
		print(first, second, third);
		System.out.println("Done.");
		
		System.out.println("Starting....");

		move(size, first, third, second);
		System.out.println("Done.");
		
		System.out.println("Printing first, second, third...");
		print(first, second, third);
		System.out.println("Done.");

	}
	
	public static void move(int size, 
			ArrayList<Integer> source, 
			ArrayList<Integer> target, 
			ArrayList<Integer> other) {
		
		//TODO use a stack
		if (size > 0) {
			move(size-1, source, other, target);
			
			target.add(source.remove(source.size()-1));
		
			move(size-1, other, target, source);
		}
	
	}
	
	public static void print(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
		System.out.print("First [");
		a.forEach((i)->System.out.print(i));
		System.out.println("]");
		System.out.print("Second [");
		b.forEach((i)->System.out.print(i));
		System.out.println("]");
		System.out.print("Third [");
		c.forEach((i)->System.out.print(i));
		System.out.println("]");
	}

}
