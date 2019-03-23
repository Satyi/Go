package Sel;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Ch {

  public static String[] met() {
String[]arr=new String[5];
    try {

	File fXmlFile = new File("C:\\Users\\Satyam\\workspace\\Check1\\src\\Copy of Data.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("staff");
			
	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

	arr[0]=	eElement.getAttribute("id");
	arr[1]=		eElement.getElementsByTagName("firstname").item(0).getTextContent();
	arr[2]=		eElement.getElementsByTagName("lastname").item(0).getTextContent();
	arr[3]=	eElement.getElementsByTagName("nickname").item(0).getTextContent();
			arr[4]=	 eElement.getElementsByTagName("salary").item(0).getTextContent();

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    return arr;
  }

}
