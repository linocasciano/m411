package json;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import helper.WebServiceClient;

public class SwissTransportRestAPITest {
	
	public static void main(String[] args) throws IOException {
		String host = "http://transport.opendata.ch/";
		String ressource = "v1/locations";
		String query = "?query=Zürich";
		URL url = new URL(host + ressource + query);
		WebServiceClient wsc = new WebServiceClient(url);
		
		InputStream is = wsc.getInputStream();
		JSONTokener jt = new JSONTokener(is);
		JSONObject jo = (JSONObject)jt.nextValue();
		JSONArray ja = (JSONArray) jo.get("stations");
		JSONObject station = (JSONObject) ja.get(0);
		System.out.println(station.get("coordinate"));
	}

}
