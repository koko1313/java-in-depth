package sax;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import main.Student;

public class SAX
{

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler handler = new MyHandler();

        saxParser.parse(new File("students.xml"), handler);

        Set<Student> students = handler.getStudentsSet();
        students.forEach(System.out::println);
    }

}



