package xml;

import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLFileTest {

	public static void main(String[] args) {

		//TODO create the xml file on the file system
		XMLFile xmlFile = new XMLFile("/users/capa/music.xml");
		
		
		NodeList nodeList = xmlFile.generateNodeList();
		
		Node node = null;
		for (int i=0; i<nodeList.getLength(); i++) {
			node = findSubNode("COUNTRY", nodeList.item(i));
			NodeList textList = node.getChildNodes();
			System.out.println("Country = " + textList.item(0).getNodeValue());
		}
		
		
/*		ArrayList<CD> cdList = xmlFile.getCDList();
		cdList.forEach((cd)->System.out.println(cd));*/
		
	}

	public static Node findSubNode(String name, Node node) {
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

}
