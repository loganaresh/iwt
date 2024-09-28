import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class SmartHomeDOMParser {

    public static void main(String[] args) {
        try {
            File inputFile = new File("smarthome.xml"); // Provide the correct path for the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList roomList = doc.getElementsByTagName("Room");

            for (int i = 0; i < roomList.getLength(); i++) {
                Node roomNode = roomList.item(i);
                if (roomNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element roomElement = (Element) roomNode;
                    System.out.println("Room: " + roomElement.getAttribute("name"));

                    NodeList deviceList = roomElement.getElementsByTagName("Device");
                    for (int j = 0; j < deviceList.getLength(); j++) {
                        Node deviceNode = deviceList.item(j);
                        if (deviceNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element deviceElement = (Element) deviceNode;
                            System.out.println("Device Type: " + deviceElement.getAttribute("type"));
                            System.out.println("Device ID: " + deviceElement.getAttribute("id"));

                            System.out.println("Status: " + deviceElement.getElementsByTagName("Status").item(0).getTextContent());
                            if (deviceElement.getElementsByTagName("Brightness").getLength() > 0) {
                                System.out.println("Brightness: " + deviceElement.getElementsByTagName("Brightness").item(0).getTextContent());
                            }
                            if (deviceElement.getElementsByTagName("Temperature").getLength() > 0) {
                                System.out.println("Temperature: " + deviceElement.getElementsByTagName("Temperature").item(0).getTextContent());
                            }
                            if (deviceElement.getElementsByTagName("Mode").getLength() > 0) {
                                System.out.println("Mode: " + deviceElement.getElementsByTagName("Mode").item(0).getTextContent());
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
