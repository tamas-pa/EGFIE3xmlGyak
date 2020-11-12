import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DomEGFIE3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document document = documentBuilder.parse(new File("szemelyek.xml"));
			
			document.getDocumentElement().normalize();
			
			Element rootElement = document.getDocumentElement();
			System.out.println("Gy�k�r elem: "+ rootElement.getNodeName());
			
			NodeList childNodes = rootElement. getChildNodes();
			
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if (node.getNodeType()== Node.ELEMENT_NODE) {
					Element element = (Element)node;
					String id = element.getAttribute("id");
					System.out.println("id : " + id);
					
					Node actualNode=element.getFirstChild();
					while (actualNode != null) {
						if (actualNode.getNodeType() == Node.ELEMENT_NODE) {
							Element actualElement = (Element)actualNode;
							System.out.println("  "+actualElement.getNodeName() + " : " +actualElement.getTextContent());
						}
						actualNode = actualNode.getNextSibling();
						
					}
					System.out.println();
				}
				
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
