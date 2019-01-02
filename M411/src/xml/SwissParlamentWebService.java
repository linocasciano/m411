package xml;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import helper.WebServiceClient;

public class SwissParlamentWebService {

	public static void main(String[] args) throws SAXException, IOException {
		// Not working since the endpoint does not return a plain xml but rather a normal HTML page.
		// TODO Auto-generated method stub
		String host = "http://ws-old.parlament.ch/";
		String path = "sessions";
		String query = "?format=xml&lang=de";
		URL url = new URL(host + path +  query);
		WebServiceClient wsc = new WebServiceClient(url);
		
		System.out.println("Processing...");
		//Document d = wsc.getDocument();
		DocumentBuilder db = XMLUtil.newDocumentBuilder();
		System.out.println("Calling " + url.toString());
		Document d = db.parse(url.openStream());
		
		Element root = d.getDocumentElement();
		XMLUtil.parseRecursive(root);
		


	}

}
