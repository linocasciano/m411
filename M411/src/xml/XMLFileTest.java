package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFileTest {

	public static void main(String[] args) throws SAXException, IOException {

		String filename = "/users/capa/music.xml";
	
		DocumentBuilder db = XMLUtil.newDocumentBuilder();

		Document d = db.parse(new File(filename));
		NodeList nodeList = d.getElementsByTagName("CD");

		Node node = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			node = XMLUtil.findSubNode("COUNTRY", nodeList.item(i));
			NodeList textList = node.getChildNodes();
			System.out.println("Country = " + textList.item(0).getNodeValue());
		}

		/*
		 * ArrayList<CD> cdList = xmlFile.getCDList();
		 * cdList.forEach((cd)->System.out.println(cd));
		 */

	}

}
