package xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

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

}
