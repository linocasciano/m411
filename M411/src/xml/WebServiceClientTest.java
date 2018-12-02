package xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WebServiceClientTest {

	public static void main(String[] args) throws IOException, SAXException {
		// TODO Auto-generated method stub
		String host = "https://earthquake.usgs.gov/";
		String path = "fdsnws/event/1/";
		String format = "xml";
		String query = "query?format=" + format + "&starttime=2016-09-29&endtime=2016-09-30&minmagnitude=5";
		URL url = new URL(host + path + query);
		WebServiceClient wsc = new WebServiceClient(url);

		if (format.equals("geojson")) {
			System.out.println("Processing " + format + "...");
			InputStream is = wsc.getInputStream();
			JSONTokener jt = new JSONTokener(is);
			JSONObject jo = new JSONObject(jt);
			JSONArray ja = jo.getJSONArray("features");
			// ja.forEach((j)-> System.out.println(j));
			for (int i = 0; i < ja.length(); i++) {
				JSONObject tmp = (JSONObject) ja.get(i);
				JSONObject o = (JSONObject) tmp.get("geometry");
				System.out.println(o);
			}
		}
		
		if (format.equals("xml")) {
			System.out.println("Processing " + format + "...");
			//Document d = wsc.getDocument();
			DocumentBuilder db = XMLUtil.newDocumentBuilder();
			System.out.println("Calling " + url.toString());
			Document d = db.parse(url.openStream());
			XMLUtil.iterate(d.getDocumentElement());
			
/*			Node r = d.getDocumentElement();
			XMLUtil.iterate(r);
		    System.out.println("Done.");
			print(url);*/
			
		}
		

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
