package xml;

import org.w3c.dom.NodeList;

public class XMLFileTest {

	public static void main(String[] args) {

		//TODO create the xml file on the file system
		XMLFile xmlFile = new XMLFile("/users/capa/music.xml");
		NodeList cdElements = xmlFile.getElementsByTagName("CD");
	}

}
