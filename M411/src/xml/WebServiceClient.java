package xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class WebServiceClient {
	
	private URL url;

	public WebServiceClient(URL url) {
		super();
		this.url = url;
	}
	
	public InputStream getInputStream() throws IOException {
		return url.openStream();
	}
	
	public BufferedReader getBufferedReader() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		return in;
	}
	
	public Document getDocument() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document d = null;
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			d = db.parse(url.toString());
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
		
	}

}
