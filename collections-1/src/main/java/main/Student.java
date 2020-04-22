package main;


public class Student implements Comparable<Student>
{
    private String name;
    private int age;

    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return this.name + " " + this.age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public int compareTo(Student student)
    {
        // sort descending
        int sortedByAge = student.getAge() - this.age;

        if(sortedByAge != 0) {
            return sortedByAge;
        }

        int sortedByName = this.getName().compareTo(student.getName());

        return sortedByName;
    }
}



