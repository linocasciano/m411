package hashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PLZService {
	
	private static HashMap<Integer, String> plzMap = null;

	public PLZService(String filename) {
		// singleton
		if (plzMap == null) {
			plzMap = new HashMap<Integer, String>();
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
	 * Initializes the PLZService with a file of the following structure:
	 * see specs from the swiss post
	 */
	private void init(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String inputLine;
		String[] lineParts;
		String separator = ";";
		// skip the header
		br.readLine();
		while ((inputLine = br.readLine()) != null) {
			lineParts = inputLine.split(separator);
			plzMap.put(Integer.parseInt(lineParts[4]), lineParts[8]);
			
		}
		br.close();
	}
	
	/**
	 * 
	 * @param plz
	 * @return place
	 */
	public String search(Integer plz) {
		return plzMap.get(plz);

	}

	public int count() {
		return plzMap.size();
	}


}
