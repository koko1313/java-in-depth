package main;


public class Student
{
    private String name;
    private int schoolClass;

    public Student()
    {
        // empty constructor so we can create the object and set the values using getters and setters
    }

    public Student(String name, int schoolClass)
    {
        this.name = name;
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString()
    {
        return name + " " + schoolClass;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSchoolClass()
    {
        return schoolClass;
    }

    public void setSchoolClass(int schoolClass)
    {
        this.schoolClass = schoolClass;
    }

}



