package arrays;

/**
 * 
 * @author capa
 * 
 * M411: Basic array operations
 * 
 * Print the prime numbers up to a specific number using erasthosthenes sieve
 *
 */

public class ErastosthenesSieve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// populate the array with the natural numbers from 3 to size
		int size = 100;
		int[] n = new int[size+1];
		for (int i=0; i<n.length; i++) {
			n[i] = i;
		}
		
		for (int i=0; i<n.length; i++) {
			if (n[i] < 2) { 
				n[i] = 0; 
				continue;
			}
			if (n[i] == 2) {
				continue;
			}
			for (int j=2; j<n[i]; j++) {
				if (n[i] % j == 0) {
					n[i] = 0;
					break;
				}
			}
		}
		
		// print the array
		for (int i=0; i<n.length; i++) {
			System.out.println(n[i]);
		}
		

	}

}
