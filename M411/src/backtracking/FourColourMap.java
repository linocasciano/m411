package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FourColourMap {

	HashMap<Integer,ArrayList> map = new HashMap<Integer,ArrayList>();
	
	public FourColourMap() {
		initMap();
	}
	
	private void initMap() {
		ArrayList<Integer> zero = new ArrayList<Integer>();
		zero.add(1);
		zero.add(3);
		zero.add(4);
		map.put(0, zero);
		
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(0);
		first.add(2);
		first.add(3);
		first.add(4);
		first.add(5);
		map.put(1, first);
		
		ArrayList<Integer> second = new ArrayList<Integer>();
		second.add(1);
		second.add(4);
		second.add(5);
		map.put(2, second);
		
		ArrayList<Integer> third = new ArrayList<Integer>();
		third.add(0);
		third.add(1);
		third.add(4);
		map.put(3, third);
		
		ArrayList<Integer> fourth = new ArrayList<Integer>();
		fourth.add(0);
		fourth.add(1);
		fourth.add(2);
		fourth.add(3);
		fourth.add(5);
		map.put(4, fourth);
		
		ArrayList<Integer> fifth = new ArrayList<Integer>();
		fifth.add(1);
		fifth.add(2);
		fifth.add(4);
		map.put(5, fifth);
	}
	
	public void solve() {
		int[] a = new int[map.size()];
		// initially the map is not coloured
		for (int i=0; i<a.length; i++) {
			a[i] = -1;
		}
		solve(a, 0);
	}
	
	private void solve(int[] a, int i) {
		if (a.length == i) { 
			printMap(a);
			return; 
	    }
		for (int j=0; j<4; j++) {
			a[i] = j; 
			if (isConsitent(a,i)) {
				solve(a,i+1);
			}
		}
		
	}
	

	private boolean isConsitent(int[] a, int i) {
		ArrayList<Integer> neighbours;
		for (int j = 0; j<=i; j++) {
			neighbours = map.get(j);
			int neighbour = 0;
			for (int k=0; k<neighbours.size(); k++) {				
				neighbour = neighbours.get(k);
				if (j==neighbour) { continue; }
				if (a[j] == a[neighbour]) { return false; }
			}			
		}
		return true;
	}

	private void printMap(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]);
			if (i<a.length-1) { System.out.print(","); }
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		FourColourMap fourColourMap = new FourColourMap();
		fourColourMap.solve();
		
	}

}
