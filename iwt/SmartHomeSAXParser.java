import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SmartHomeSAXParser {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SmartHomeHandler handler = new SmartHomeHandler();
            saxParser.parse("smarthome.xml", handler); // Provide the correct path for the XML file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SmartHomeHandler extends DefaultHandler {
    private String currentElement;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("Room")) {
            System.out.println("Room: " + attributes.getValue("name"));
        } else if (qName.equalsIgnoreCase("Device")) {
            System.out.println("Device Type: " + attributes.getValue("type"));
            System.out.println("Device ID: " + attributes.getValue("id"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (value.length() == 0) return;  // ignore white space
        if (currentElement.equalsIgnoreCase("Status")) {
            System.out.println("Status: " + value);
        } else if (currentElement.equalsIgnoreCase("Brightness")) {
            System.out.println("Brightness: " + value);
        } else if (currentElement.equalsIgnoreCase("Temperature")) {
            System.out.println("Temperature: " + value);
        } else if (currentElement.equalsIgnoreCase("Mode")) {
            System.out.println("Mode: " + value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }
}
