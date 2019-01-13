package hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CountryService {
	
	public CountryService() {
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void init() throws IOException {
		String filename = "/resources/countries_simplified.csv";
		InputStream is = CountryService.class.getResourceAsStream(filename);
		InputStreamReader sr = new InputStreamReader(is, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(sr);
		String inputLine;
		String[] lineParts;
		String separator = ",";
		while ((inputLine = br.readLine()) != null) {
			lineParts = inputLine.split(separator);
			System.out.println(inputLine);
			
		}
		br.close();
	}

}
