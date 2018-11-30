package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
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
			d.getDocumentElement().normalize();
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

}
