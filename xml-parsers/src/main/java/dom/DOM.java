package dom;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.Student;

public class DOM
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        Set<Student> studentsSet = new HashSet<>();

        DocumentBuilderFactory documentBuildFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuildFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("students.xml");

        NodeList nodes = document.getElementsByTagName("student");

        for (int i = 0; i < nodes.getLength(); i++)
        {
            Node node = nodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                String name = element.getElementsByTagName("name").item(0).getTextContent();
                int schoolClass = Integer.parseInt(element.getElementsByTagName("class").item(0).getTextContent());

                studentsSet.add(new Student(name, schoolClass));
            }
        }

        studentsSet.forEach(System.out::println);
    }
}



