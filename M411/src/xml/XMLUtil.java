package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtil {

	public static Node findSubNode(String name, Node node) {
		NodeList list = node.getChildNodes();
		Node subnode;
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

	public static void parseRecursive(Node n) {
		if (n.hasChildNodes()) {
			NodeList children = n.getChildNodes();
			Node child = null;
			for (int i = 0; i < children.getLength(); i++) {
				child = children.item(i);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					//System.out.println("NodeType [" + child.getNodeType() + "]");
					System.out.println("NodeName[" + child.getNodeName() + "]");
					parseRecursive(child);
				}
			}
		}
	}

	public static void iterate(Node p) {
		// System.out.println("Iterating...");
		NodeList childNodes = p.getChildNodes();
		Node c = null;
		for (int i = 0; i < childNodes.getLength(); i++) {
			c = childNodes.item(i);
			// iterate(c);
			// System.out.println(c);
			if (c.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) c;

				if (c.getNodeName().equals("description")) {
					System.out.println("description");
					NodeList tmpList = e.getChildNodes();
					for (int j = 0; j < tmpList.getLength(); j++) {
						System.out.print("\t[" + tmpList.item(j).getNodeName() + "] = ");
						System.out.println("\t[" + tmpList.item(j).getTextContent() + "]");
					}
				}
				iterate(c);
			}
		}
	}

}
