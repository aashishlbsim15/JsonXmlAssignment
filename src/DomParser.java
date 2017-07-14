import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class DomParser {
    public static void main(String[] args) throws ParserConfigurationException {

        try {
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbfactory.newDocumentBuilder();
            Document document = builder.parse(ClassLoader.getSystemResourceAsStream("Employee.xml"));
            document.getDocumentElement().normalize();

            //Root element
            System.out.println("\n Root : " + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("Employee");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                System.out.println("\nCurrent Element :" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Employee name: " + element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Employee email : " + element.getElementsByTagName("email").item(0).getTextContent());

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}