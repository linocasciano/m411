package xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebServiceClientTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String host = "https://earthquake.usgs.gov/";
	    String path = "fdsnws/event/1/";
		String query = "query?format=xml&starttime=2016-09-29&endtime=2016-09-30&minmagnitude=5";
		URL url = new URL(host + path + query);
		WebServiceClient wsc = new WebServiceClient(url);
		BufferedReader in = wsc.getBufferedReader();
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
	}

}
