import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{

    public static void main(String[] args)
    {

        String str1 = "String 1";
        String str2 = "String 2";
        String str3 = "String 3";

        // Зад 1.
        ArrayList<String> strings = new ArrayList<>();
        strings.add(str1);
        strings.add(str2);
        strings.add(str3);
        strings.trimToSize();

        // Зад 2.
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", 22));
        students.add(new Student("Stoyan", 19));
        //students.forEach((st) -> System.out.println(st));
        students.forEach(System.out::println); // method reference

        // Зад 3.
        ArrayList<String> stringsArrayList = new ArrayList<>();

        stringsArrayList.add(str1);
        stringsArrayList.add(str2);
        stringsArrayList.add(str3);

        Collections.reverse(stringsArrayList);
        System.out.println("Reversed: " + stringsArrayList);

        LinkedList<String> stringsLinkedList = new LinkedList<>();

        stringsLinkedList.add(str1);
        stringsLinkedList.add(str2);
        stringsLinkedList.add(str3);

        Collections.reverse(stringsLinkedList);
        System.out.println("Reversed: " + stringsLinkedList);

        // Зад 4.
        List<String> stringList = new ArrayList<>();
        stringList.add(str1);
        stringList.add(str2);
        stringList.add(str3);
        stringList.add(str2);

        Map<String, Integer> elementsCount = new HashMap<>();
        for(String str : stringList)
        {
            if(!elementsCount.containsKey(str))
            {
                elementsCount.put(str, 1);
            }
            else
            {
                int count = elementsCount.get(str);
                elementsCount.put(str, count ++);
            }
        }

        System.out.println("Elements count: " + elementsCount);

        // Зад 5.
        List<String> stringList1 = new ArrayList<>();
        stringList1.add(str1);

        List<String> stringList2 = new ArrayList<>();
        stringList2.add(str1);
        stringList2.add(str2);

        System.out.print("Are lists equal: " + stringList1.equals(stringList2));

        // Зад 6.
        Set<Student> studentsSet = new HashSet<Student>();

        // По този начин ще бъдат 4, защото при всяко добавяне на елемент, създаваме нов обект (с нов адрес в паметта)
        studentsSet.add(new Student("Pesho", 20));
        studentsSet.add(new Student("Pesho", 21));
        studentsSet.add(new Student("Gosho", 21));
        studentsSet.add(new Student("Pesho", 20));

        System.out.println("Students count: " + studentsSet.size()); // 4

        studentsSet.clear();

        Student pesho = new Student("Pesho", 20);
        Student pesho2 = new Student("Pesho", 21);
        Student gosho = new Student("Gosho", 21);

        // Така ще бъдат 3, защото при добавяне на pesho отново, старата стойност се презаписва (обекта, към който реферира променливата вече е един и същ)
        studentsSet.add(pesho);
        studentsSet.add(pesho2);
        studentsSet.add(gosho);
        studentsSet.add(pesho);

        System.out.println("Students count: " + studentsSet.size()); // 3

        // Зад 7.
        Set<String> stringSet1 = new HashSet<>();
        stringSet1.add(str1);
        stringSet1.add(str2);

        Set<String> stringSet2 = new HashSet<>();
        stringSet2.add(str1);
        stringSet2.add(str3);

        // a)
        Set<String> allStrings = new HashSet<String>() {{
            addAll(stringSet1);
            addAll(stringSet2);
        }};

        System.out.println(allStrings);

        // b)
        Set<String> excludeStrings2 = new HashSet<>(stringSet1);
        excludeStrings2.removeAll(stringSet2);
        System.out.println("--> " + excludeStrings2);

        // c)
        Set<String> outerJoin = new HashSet<>(stringSet1);
        outerJoin.removeAll(stringSet2);

        stringSet2.removeAll(stringSet1);

        outerJoin.addAll(stringSet2);

        System.out.println("Outer join of stringSet1 and stringSet2: " + outerJoin);

        // Зад 8.
        Map<String, Student> students1 = new HashMap<>();
        students1.put("Plovdiv", new Student("Ivan", 23));
        students1.put("Sofia", new Student("Pesho", 22));

        Map<String, Student> students2 = new HashMap<>();
        students2.put("Varna", new Student("Mariya", 24));
        students2.put("Sofia", new Student("Petya", 28));

        Map<Object, List<Object>> allStudents = Stream.of(students1, students2)
                        .flatMap(map -> map.entrySet().stream())
                        .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        // putAll

        System.out.println("Cities with all students in them: " + allStudents);

        // Зад 9.
        Map<String, Float> products1 = new HashMap<>();
        products1.put("Milk", 2.33f);
        products1.put("Bread", 1.25f);
        products1.put("Ice Cream", 3.50f);

        Map<String, Float> products2 = new HashMap<>();
        products2.put("Ice Cream", 3.87f);
        products2.put("Milk", 2.20f);

        Map<String, Float> lowestPriceList = new HashMap<>();

        addProductsToLowestPriceList(lowestPriceList, products1);
        addProductsToLowestPriceList(lowestPriceList, products2);

        System.out.println(lowestPriceList);

    }

//    public static void addStudentsToCityMap(Map<String, List<Student>> allStudentsMap,
//                                            Map<String, Student> studentsMap)
//    {
//        studentsMap.forEach((currentCity, currentStudent) -> {
//            allStudentsMap.computeIfPresent(currentCity, (city, studentsInCity) -> {
//                studentsInCity.add(currentStudent);
//                return studentsInCity;
//            });
//
//            allStudentsMap.putIfAbsent(currentCity, new ArrayList<Student>() {
//                {
//                    add(currentStudent);
//                }
//            });
//        });
//    }

    public static void addProductsToLowestPriceList(Map<String, Float> lowestPriceList,
                                                    Map<String, Float> products)
    {
        products.forEach((currentProduct, currentPrice) -> {
            lowestPriceList.computeIfPresent(currentProduct, (product, currentLowestPrice) -> {
                if(currentLowestPrice > currentPrice) {
                    return currentPrice;
                }

                return currentLowestPrice;
            });

            lowestPriceList.putIfAbsent(currentProduct, currentPrice);
        });
    }

}



