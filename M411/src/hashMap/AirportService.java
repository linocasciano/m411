package hashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author capa
 *
 */
public class AirportService {

	private static HashMap<String, String> airports = null;

	public AirportService(String filename) {
		// singleton
		if (airports == null) {
			airports = new HashMap<String, String>();
			try {
				init(filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @param filename
	 * @throws IOException
	 * 
	 * Initializes the AirportService with a file of the following structure:
	 * <AirportKey>, <Airportname>
	 * Example: JFK,New York John F. Kennedy International
	 */
	private void init(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String inputLine;
		String[] lineParts;
		String separator = ",";
		while ((inputLine = br.readLine()) != null) {
			lineParts = inputLine.split(separator);
			airports.put(lineParts[0], lineParts[1]);
		}
		br.close();
	}

	/**
	 * 
	 * @param airportkey
	 * @return Airport Name
	 */
	public String search(String airportkey) {
		return airports.get(airportkey);

	}
	
	/**
	 * Print all the airports to the console
	 */
	public void printAirports() {
		airports.forEach((k,v) -> System.out.println("[" + k + "]=[" + v + "]"));
		
	}
	
	/**
	 * 
	 * @param airportKey
	 * 
	 * Delete the airport specified by the airportKey
	 */
	public void remove(String airportKey) {
		airports.remove(airportKey);
	}

}
