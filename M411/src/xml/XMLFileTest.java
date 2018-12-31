package xml;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLFileTest {

	public static void main(String[] args) throws SAXException, IOException {

		String filename = "/resources/music.xml";
		// create a document builder
		DocumentBuilder db = XMLUtil.newDocumentBuilder();
		InputSource source = new InputSource(XMLFileTest.class.getResourceAsStream(filename));
		
		// get a reference to the whole document
		Document d = db.parse(source);

		// get all the nodes by the name of 'CD'
		NodeList nodeList = d.getElementsByTagName("CD");

		Node node = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			// the attributes of an element are considered nodes too
			node = XMLUtil.findSubNode("TITLE", nodeList.item(i));
			System.out.println("Textcontent = [" + node.getTextContent() + "]");
			NodeList textList = node.getChildNodes();
			// Could there be a second item? What happens if its empty? --> Empty string?
			// There is only one text element in this example.
			System.out.println("Number of text elements [" + textList.getLength() + "]");
			// there are no attributes in this example.
			NamedNodeMap nnm = node.getAttributes();
			System.out.println("Printing attributes...");
			for (int j=0; j<nnm.getLength(); j++) {
				System.out.println(nnm.item(j));
			}
			System.out.println("TITLE = " + textList.item(0).getNodeValue());
		}
		
		/*
		 * System.out.println("Parsing the document..."); Element root =
		 * d.getDocumentElement();
		 * 
		 * System.out.println("root=[" + root.getNodeName() + "]");
		 * XMLUtil.parseRecursive(d.getDocumentElement());
		 */

	}

	public ArrayList<CD> getCDList(Document d) {
		ArrayList<CD> cdList = new ArrayList<CD>();
		// assumes that the CDs are on the first level
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
