package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFile {
	private Document d = null;

	public XMLFile(String xmlFileName) {
		init(new File(xmlFileName));
	}

	private void init(File f) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			d = db.parse(f);
			//TODO comment and explain
			//d.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public NodeList getElementsByTagName(String tag) {
		return d.getElementsByTagName(tag);
	}
	
	public Node findSubNode(String name, Node node ) {
		return node;
		//TODO implement
	}
	
	public ArrayList<CD> getCDList() {
		ArrayList<CD> cdList = new ArrayList<CD>();
		NodeList nodeList = d.getDocumentElement().getChildNodes();
		Node node = null;
		CD cd = null;
		for (int i=0; i<nodeList.getLength(); i++) {
			node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                // Get the value of the ID attribute.
                String ID = node.getAttributes().getNamedItem("ID").getNodeValue();

                // Get the value of all sub-elements.
                String firstname = elem.getElementsByTagName("Firstname")
                                    .item(0).getChildNodes().item(0).getNodeValue();

                String lastname = elem.getElementsByTagName("Lastname").item(0)
                                    .getChildNodes().item(0).getNodeValue();

                Integer age = Integer.parseInt(elem.getElementsByTagName("Age")
                                    .item(0).getChildNodes().item(0).getNodeValue());

                Double salary = Double.parseDouble(elem.getElementsByTagName("Salary")
                                    .item(0).getChildNodes().item(0).getNodeValue());

           }
		}
		
		return cdList;
		
		
	}

}
