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
	File f = null;

	public XMLFile(String xmlFileName) {
		f = new File(xmlFileName);
	}

	public NodeList generateNodeList() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			d = db.parse(f);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		d.getDocumentElement().normalize();
		NodeList cdElements = d.getElementsByTagName("CD");
		return cdElements;
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
                
                String artist = elem.getElementsByTagName("ARTIST")
                        .item(0).getChildNodes().item(0).getNodeValue();
                
                String title = elem.getElementsByTagName("TITLE")
                        .item(0).getChildNodes().item(0).getNodeValue();
                
                
                String country = elem.getElementsByTagName("COUNTRY")
                        .item(0).getChildNodes().item(0).getNodeValue();
                
                String year = elem.getElementsByTagName("YEAR")
                        .item(0).getChildNodes().item(0).getNodeValue();
                

                cd = new CD(title, country, artist, Integer.parseInt(year));
                cdList.add(cd);

           }
		}
		
		return cdList;
		
		
	}

}
