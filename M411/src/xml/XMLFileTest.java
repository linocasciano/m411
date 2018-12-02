package xml;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLFileTest {

	public static void main(String[] args) throws SAXException, IOException {

		String filename = "/resources/music.xml";
		DocumentBuilder db = XMLUtil.newDocumentBuilder();
		InputSource source = new InputSource(XMLFileTest.class.getResourceAsStream(filename));
		
		Document d = db.parse(source);

		NodeList nodeList = d.getElementsByTagName("CD");

		Node node = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			node = XMLUtil.findSubNode("TITLE", nodeList.item(i));
			NodeList textList = node.getChildNodes();
			System.out.println("Country = " + textList.item(0).getNodeValue());
		}
		
		System.out.println(d.getDocumentElement().getNodeName());
		XMLUtil.parseRecursive(d.getDocumentElement());

	}

	public ArrayList<CD> getCDList(Document d) {
		ArrayList<CD> cdList = new ArrayList<CD>();
		NodeList nodeList = d.getDocumentElement().getChildNodes();
		Node node = null;
		CD cd = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;

				String artist = elem.getElementsByTagName("ARTIST").item(0).getChildNodes().item(0).getNodeValue();

				String title = elem.getElementsByTagName("TITLE").item(0).getChildNodes().item(0).getNodeValue();

				String country = elem.getElementsByTagName("COUNTRY").item(0).getChildNodes().item(0).getNodeValue();

				String year = elem.getElementsByTagName("YEAR").item(0).getChildNodes().item(0).getNodeValue();

				cd = new CD(title, country, artist, Integer.parseInt(year));
				cdList.add(cd);

			}
		}

		return cdList;

	}

}
