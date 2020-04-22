package main;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main
{

    public static void main(String[] args)
    {
        // Зад 1.
        List<Integer> integerList = new ArrayList<>();

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(14);
        integerList2.add(18);

        integerList.add(2);
        integerList.add(0, 1);
        // integerList.addAll(integerList2);
        integerList.addAll(0, integerList2);

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(4);
        integerSet.add(3);

        // integerSet.addAll(integerSet2);

        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1, null);
        integerStringMap.putIfAbsent(1, "One");
        integerStringMap.put(18, null);
        integerStringMap.put(13, null);
        // integerStringMap.putAll(integerStringMap2);

        // Зад 2.
        // List
        System.out.println("List forEach method:");
        integerList.forEach(n -> System.out.println(n)); // lambda
        integerList.forEach(System.out::println); // method reference

        System.out.println("List Iterator:");
        Iterator<Integer> listIterator = integerList.iterator();

        while (listIterator.hasNext())
        {
            System.out.println(listIterator.next());
        }

        // Set
        System.out.println("Set forEach method:");
        integerSet.forEach(n -> System.out.println(n)); // lambda
        integerSet.forEach(System.out::println); // method reference

        System.out.println("Set Iterator:");
        Iterator<Integer> setIterator = integerSet.iterator();
        while (setIterator.hasNext())
        {
            System.out.println(setIterator.next());
        }

        // Map
        System.out.println("Map forEach method:");
        integerStringMap.forEach((key, value) -> System.out.println(key + "=" + value));

        System.out.println("Map Iterator");
        Iterator<Map.Entry<Integer, String>> mapIterator = integerStringMap.entrySet().iterator();
        while (mapIterator.hasNext())
        {
            System.out.println(mapIterator.next());
        }

        // Зад 3.
        // List
        System.out.println("Get element from List: " + integerList.get(0));

        // Map
        System.out.println("Get element from Map: " + integerStringMap.get(1));

        // Зад 4.
        // List
        integerList.set(0, 4);
        Collections.replaceAll(integerList, 4, -1);
        System.out.println("List with replaced value: " + integerList);

        // Map
        integerStringMap.replace(1, "One!");
        System.out.println(integerStringMap);

        // Зад 5.
        // List
        System.out.println("Does List contains object: " + integerList.contains(2));

        // binary search
        int found = Collections.binarySearch(integerList, 2);
        System.out.println("Does List contains object: " + (found > -1 ? true : false));

        // Set
        System.out.println("Does Set contains object: " + integerSet.contains(3));

        // Map
        System.out.println("Does Map contains key: " + integerStringMap.containsKey(1));
        System.out.println("Does Map contains value: " + integerStringMap.containsValue("One!"));

        // Зад 6.
        // List
        Collections.sort(integerList);
        System.out.println("Sorted List: " + integerList);

        // Set
        Set<Integer> integerSetSorted = new TreeSet<>(integerSet);
        System.out.println("Sorted Set: " + integerSetSorted);

        // Map
        System.out.println(integerStringMap);
        Map<Integer, String> integerStrindMapSorted = new TreeMap<>(integerStringMap);
        System.out.println(integerStrindMapSorted);

        // Зад 7.
        Student ivan = new Student("Ivan", 22);
        Student pesho = new Student("Pesho", 44);
        Student asen = new Student("Asen", 18);
        Student gosho = new Student("Gosho", 20);
        Student anna = new Student("Anna", 18);
        Student mariya = new Student("Mariya", 20);
        Student plamen = new Student("Plamen", 23);
        Student stoyan = new Student("Stoyan", 24);

        // List
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(ivan);
        studentsList.add(pesho);
        studentsList.add(asen);
        studentsList.add(gosho);
        studentsList.add(anna);
        studentsList.add(mariya);
        studentsList.add(plamen);
        studentsList.add(stoyan);

        System.out.println("Unsorted List: " + studentsList);
        Collections.sort(studentsList);
        System.out.println("Sorted List (natural): " + studentsList);

        // Sort by using Collections.sort with lambda comparator
        Collections.sort(studentsList, (st1, st2) -> {
            // sort descending
            int sortedByAge = st2.getAge() - st1.getAge();

            if (sortedByAge != 0)
            {
                return sortedByAge;
            }

            int sortedByName = st1.getName().compareTo(st2.getName());

            return sortedByName;
        });

        System.out.println("Sorted List (lambda): " + studentsList);

        // Set
        Set<Student> studentsSet = new HashSet<>();
        studentsSet.add(ivan);
        studentsSet.add(pesho);
        studentsSet.add(gosho);

        System.out.println("Unsorted Set: " + studentsSet);
        Set<Student> studentsSetSorted = new TreeSet<>(studentsSet);
        System.out.println("Sorted Set: " + studentsSetSorted);

        // Map
        Map<Student, Integer> studentGradesMap = new HashMap<>();
        studentGradesMap.put(ivan, 5);
        studentGradesMap.put(pesho, 4);
        studentGradesMap.put(gosho, 6);

        System.out.println("Unsorted Map: " + studentGradesMap);
        Map<Student, Integer> studentGradesMapSorted = new TreeMap<>(studentGradesMap);
        System.out.println("Sorted Map: " + studentGradesMapSorted);

        // Зад 8. a)
        Set<Student> studentsBetween20and24 = new HashSet<>();

        studentsList.forEach(stu -> {
            if (stu.getAge() >= 20 && stu.getAge() <= 24)
            {
                studentsBetween20and24.add(stu);
            }
        });

        System.out.println("Students between 20 and 24: " + studentsBetween20and24);

        // Зад 8. b)
        List<Student> studentsBetween18and20BeginningWithA = new ArrayList<>();
        studentsList.forEach(stu -> {
            if (stu.getName().charAt(0) == 'A' && stu.getAge() >= 18 && stu.getAge() <= 20)
            {
                studentsBetween18and20BeginningWithA.add(stu);
            }
        });

        System.out.println("Students between 18 and 20 with name beginning with 'A': " + studentsBetween18and20BeginningWithA);

        // Зад 8. c)
        Collections.reverse(studentsBetween18and20BeginningWithA);
        System.out.println("Reversed List: " + studentsBetween18and20BeginningWithA);

        // Зад 9.
        System.out.println("Before swap: " + studentsList);
        Collections.swap(studentsList, 3, 5);
        System.out.println("After swap: " + studentsList);

        // Зад 10.
        List<Student> subList = new ArrayList<>(studentsList.subList(3, 8));
        System.out.println("Sublist: " + subList);

        // Зад 11.
        List<Student> studentsList1 = new ArrayList<>();
        studentsList1.add(new Student("Pesho", 26));
        studentsList1.add(new Student("Gosho", 18));

        List<Student> studentsList2 = new ArrayList<>();
        studentsList2.add(new Student("Anna", 24));
        studentsList2.add(new Student("Mariya", 29));

        List<Student> allStudents = new ArrayList<>();
        allStudents.addAll(studentsList1);
        allStudents.addAll(studentsList2);

        System.out.println("All students: " + allStudents);
    }

}
