package stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import main.Student;

public class StAX
{

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException
    {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("students.xml"));

        Student student = null;
        Set<Student> students = new HashSet<>();

        while (reader.hasNext())
        {
            XMLEvent nextEvent = reader.nextEvent();

            if (nextEvent.isStartElement())
            {
                // opening tag
                StartElement startElement = nextEvent.asStartElement();

                // opening tag name
                switch (startElement.getName().getLocalPart())
                {
                    case "student" :
                        student = new Student();
                        break;
                    case "name" :
                        nextEvent = reader.nextEvent(); // get the <name> value
                        String name = nextEvent.asCharacters().getData();
                        student.setName(name);
                        break;
                    case "class" :
                        nextEvent = reader.nextEvent(); // get the <class> value
                        int schoolClass = Integer.parseInt(nextEvent.asCharacters().getData());
                        student.setSchoolClass(schoolClass);
                }
            }

            // closing tag
            if (nextEvent.isEndElement())
            {
                EndElement endElement = nextEvent.asEndElement();
                if(endElement.getName().getLocalPart().equals("student"))
                {
                    students.add(student);
                }
            }
        }

        students.forEach(System.out::println);
    }

}



