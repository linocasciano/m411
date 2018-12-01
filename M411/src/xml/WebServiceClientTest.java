package xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

public class WebServiceClientTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String host = "https://earthquake.usgs.gov/";
	    String path = "fdsnws/event/1/";
	    String format = "geojson";
		String query = "query?format=" + format + "&starttime=2016-09-29&endtime=2016-09-30&minmagnitude=5";
		URL url = new URL(host + path + query);
		print(url);
		
		
	}
	
	public static void print(URL url) throws IOException {
		WebServiceClient wsc = new WebServiceClient(url);
		BufferedReader in = wsc.getBufferedReader();
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
	}

}
