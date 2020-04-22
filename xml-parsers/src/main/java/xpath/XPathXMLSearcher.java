package xpath;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathXMLSearcher
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse("students.xml");

        XPath xPath = XPathFactory.newInstance().newXPath();

        NodeList nodeList = (NodeList)xPath.compile("//student").evaluate(xmlDocument, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node currentNode = nodeList.item(i);

            Element element = (Element) currentNode;

            String name = element.getElementsByTagName("name").item(0).getTextContent();
            int schoolClass = Integer.parseInt(element.getElementsByTagName("class").item(0).getTextContent());

            System.out.println(name + " " + schoolClass);
        }
    }
}



