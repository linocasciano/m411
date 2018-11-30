package files;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 
 * @author capa
 * 
 * M411: basic file handling
 * 
 * Read in a files with a number on each row (preparation for bubble sort)
 *
 */

public class ReadinFile {

	public static void main(String[] args) {

		try {
			String filename = "/users/capa/numberInput.txt";
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
