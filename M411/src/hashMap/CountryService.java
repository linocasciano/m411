package hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class CountryService {

	HashMap<String, String> countries = new HashMap<>();

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
			if (lineParts[0].length() < 4) {
				countries.put(lineParts[0], lineParts[1]);
			}
		}
		br.close();
	}

	public String getCountryName(String countryCode) {
		return countries.get(countryCode);
	}

	public void printCountries() {
		// TODO with a classical iteration
		countries.forEach((k, v) -> System.out.println("[" + k + "]=[" + v + "]"));
	}
}
