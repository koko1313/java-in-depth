package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main
{

    public static void main(String[] args)
    {
        Student[] studentsArray = {
            new Student("Ann", 20),
            new Student("Alice", 20),
            new Student("John", 21),
            new Student("Robert", 24),
            new Student("Jaime", 17),
            new Student("Rose", 26),
            new Student("Natalie", 26),
            new Student("Rose", 19),
            new Student("Nick", 18),
            new Student("John", 23),
            new Student("Tom", 19),
            new Student("Nick", 21),
            new Student("John", 21),
            new Student("Jack", 22),
            new Student("Jess", 21),
        };

        List<Student> studentsList = new ArrayList<>();
        Collections.addAll(studentsList, studentsArray);

        // Зад 1.
        Set<Student> studentsBetween20And24 = new HashSet<>();

        studentsList.forEach(stu -> {
            if(stu.getAge() >= 20 && stu.getAge() <= 24) {
                studentsBetween20And24.add(stu);
            }
        });

        System.out.println("Students between 20 and 24: " + studentsBetween20And24);

        // Зад 2.
        List<Student> studentsBetween18and20BeginningWithA = new ArrayList<>();

        studentsList.forEach(stu -> {
            if(stu.getName().charAt(0) == 'A' && stu.getAge() >= 18 && stu.getAge() <= 20) {
                studentsBetween18and20BeginningWithA.add(stu);
            }
        });

        // sort by natural ordering
        //Collections.sort(studentsBetween18and20BeginningWithA);

        // sort by lambda comparator
        Collections.sort(studentsBetween18and20BeginningWithA, (st1, st2) -> {
            // sort descending
            int sortedByAge = st2.getAge() - st1.getAge();

            if(sortedByAge != 0) {
                return sortedByAge;
            }

            int sortedByName = st1.getName().compareTo(st2.getName());

            return sortedByName;
        });

        System.out.println("Students between 18 and 20 with name beginning with 'A': " + studentsBetween18and20BeginningWithA);

        // Зад 3.
        Collections.reverse(studentsBetween18and20BeginningWithA);
        System.out.println("Reversed: " + studentsBetween18and20BeginningWithA);

        // Зад 4.
        Map<String, Integer> recurringNames = new HashMap<>();

        studentsList.forEach(stu -> {
            recurringNames.computeIfPresent(stu.getName(), (name, count) -> {
               return count + 1;
            });

            recurringNames.putIfAbsent(stu.getName(), 1);
        });

        System.out.println(recurringNames);

        // Зад 5.
        final String FILE_NAME = "Students.txt";

        // try with resources - the writer will be closed automatically
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME)))
        {
            for(Student stu : studentsBetween20And24) {
                writer.write(stu.getName() + '\t' + stu.getAge());
                writer.newLine();
            }

            writer.write(studentsBetween20And24.size() + "");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Зад 6.
        File file = new File(FILE_NAME);

        try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader);)
        {
            String lastFileLine = "";

            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                lastFileLine = fileLine;
            }

            System.out.println("File name: " + file.getName() + " Total results: " + lastFileLine);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}