package org.example.homeworks.homework5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("------Task1------");
        ArrayList<String> cities = new ArrayList<String>();

        cities.add("Alamogordo");
        cities.add("Berkeley");
        cities.add("Princeton");
        cities.add("London");

        for (String city : cities) {
            System.out.println(city);
        }
        System.out.println("------Task2------");
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("The square of " + numbers.get(i) + " is " + numbers.get(i) * numbers.get(i));
        }

        System.out.println("------Task3------");
        LinkedList<String> students = new LinkedList<String>();

        students.add("Robert Oppenheimer");
        students.add("Stephen Hawking");
        students.add("Maria Sklodowska-Curie");
        students.add("Pierre Curie");

        students.set(1, "Albert Einstein");
        students.removeFirst();

        System.out.println(students);

        System.out.println("------Task4------");
        HashSet<String> fruits = new HashSet<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");
        fruits.add("Banana");
        fruits.add("Pineapple");
        fruits.add("Banana");

        System.out.println(fruits.size());
        System.out.println(fruits);

        System.out.println("------Task5------");
        HashSet<Integer> number = new HashSet<Integer>();
        number.add(10);
        number.add(20);
        number.add(30);

        System.out.println("Does Set contain the number 20? " + number.contains(20));
        number.remove(10);
        if (number.contains(10) == false) {
            System.out.println(number + " does not contain the number 10");
        } else {
            System.out.println(number + " contains the number 10");
        }

        System.out.println("------Task6------");
        List<Integer> evenAndOdd = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            evenAndOdd.add(rand.nextInt(1000));
        }

        for (Integer num : evenAndOdd) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }

        System.out.println("List: " + evenAndOdd);
        System.out.println("Even List: " + evenList);
        System.out.println("Odd List: " + oddList);

        System.out.println("------Task7------");
        System.out.println(findLongestString(students));
        System.out.println(findLongestString(cities));

        System.out.println("------Task8------");
        List<String> duplicatedList = new ArrayList<>();
        Collections.addAll(duplicatedList, "Java", "Python", "Java", "C#", "Python");
        System.out.println("Original list: " + duplicatedList);

        Set<String> uniqueSet = new LinkedHashSet<>(duplicatedList);
        System.out.println("Unique set: " + uniqueSet);

        System.out.println("------Task9------");
        TreeSet<String> unicProducts = new TreeSet<>();
        Collections.addAll(unicProducts, "Laptop", "Phone", "Tablet", "Mouse", "Keyboard");
        System.out.println("Unique products: " + unicProducts);

        List<String> unicProducts1 = new ArrayList<>(unicProducts);
        System.out.println("Unique product: " + unicProducts1.get(2));

        System.out.println("------Task10------");
        List<String> costumers = new ArrayList<>();
        Collections.addAll(costumers, "Alice", "Bob", "Charlie", "David", "Eve", "Frank");
        System.out.println("All costumers: " + costumers);

        Set<String> forbiddenNames = new HashSet<>();
        forbiddenNames.add("David");
        forbiddenNames.add("Bob");
        System.out.println("Forbidden names: " + forbiddenNames);
        List<String> allowedCostumers = new ArrayList<>();

        for (String name : costumers) {
            if (!forbiddenNames.contains(name)) {
                allowedCostumers.add(name);
            }
        }
        System.out.println("Allowed costumers: " + allowedCostumers);
    }

    public static String findLongestString(List<String> list) {
        String longest = list.get(0);
        for (String s : list) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }
}
