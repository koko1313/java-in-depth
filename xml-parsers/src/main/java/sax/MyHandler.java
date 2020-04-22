package sax;


import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import main.Student;


public class MyHandler extends DefaultHandler2
{
    private Set<Student> students = new HashSet<>();
    private Student student = null;
    private StringBuilder data = null;

    private boolean bName = false;
    private boolean bClass = false;

    // сетва флаг, когато намери отварящ таг
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        switch (qName)
        {
            case "student" :
                student = new Student();
                break;
            case "name" :
                bName = true;
                break;
            case "class" :
                bClass = true;
                break;
        }

        data = new StringBuilder(); // инициализираме си нов StringBuilder, в който ще пазим стойността
    }

    // когато намерим затварящ таг
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        // ако има отворен таг за име, значи и затварящия е за име
        if (bName)
        {
            String name = data.toString();
            student.setName(name);
            bName = false;
        }

        // ...
        if (bClass)
        {
            int schoolClass = Integer.parseInt(data.toString());
            student.setSchoolClass(schoolClass);
            bClass = false;
        }

        // ако затварящия таг е student, добавяме student-а в колекцията
        if (qName.equals("student"))
        {
            students.add(student);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        // прикачваме си стойността (ch ни пази целия xml, start и length ни служат, за да го отрежем)
        data.append(new String(ch, start, length));
    }

    public Set<Student> getStudentsSet()
    {
        return students;
    }

}
