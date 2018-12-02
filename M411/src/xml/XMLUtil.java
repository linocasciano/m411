package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtil {
	
	public static Node findSubNode(String name, Node node ) {
		NodeList list = node.getChildNodes();
		Node subnode;;
		for (int i = 0; i < list.getLength(); i++) {
			subnode = list.item(i);
			if (subnode.getNodeType() == Node.ELEMENT_NODE) {
				if (subnode.getNodeName().equals(name)) {
					return subnode;
				}
			}
		}
		return null;
	}
	
	public static DocumentBuilder newDocumentBuilder() throws SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return db;
	}
	
	public static void iterate(Node n) {
		System.out.println("Iterating...");
		NodeList nodeList = n.getChildNodes();
		Node o = null;
		for (int i=0; i<nodeList.getLength(); i++) {
			o = nodeList.item(i);
			if (o!=null) {
				iterate(n);
			}
			if (o.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println(o);
			}
		}
		
	}

}
