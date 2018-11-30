package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;

/**
 * 
 * @author capa
 * 
 * M411: Basic file processing
 * 
 * Read in a CSV files with the structure
 * 
 * <surname>;<name>;<yearOfBirt>
 * Huber;Peter;1950
 *
 */

public class ProcessCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String filename = "/users/capa/namelist.txt";
			String separator = ";";
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String inputLine;
			String[] lineParts;
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int birthyear;
			int age;
			while ((inputLine = br.readLine()) != null) {
				lineParts = inputLine.split(separator);
				birthyear = Integer.parseInt(lineParts[2]);
				age = year - birthyear;
				System.out.println(inputLine + ";" + age);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
