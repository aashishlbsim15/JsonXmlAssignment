import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
public class SaxParse {




        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

            try {

                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                SaxHandler handler = new SaxHandler();
                saxParser.parse(ClassLoader.getSystemResourceAsStream("Employee.xml"), handler);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

