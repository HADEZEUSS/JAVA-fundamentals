package org.example.homeworks.homework6.easy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //        easy: ნაწილი 1: List (სია)
        //        task 1 რიცხვების გაფილტვრა (Filtering Numbers)
        //        შექმენით ArrayList<Integer>. დაამატეთ მასში 10-15 სხვადასხვა რიცხვი (დადებითი, უარყოფითი, ნული).
        //        შემდეგ დაწერეთ კოდი, რომელიც დაბეჭდავს მხოლოდ დადებით რიცხვებს ამ სიიდან.
        ArrayList<Integer> numOfList = new ArrayList<>(Arrays.asList(20, 15, -5, -8, -2, 2, 5, 4, 6, -10, 25));
        System.out.print("Task 1: ");
        for (int num : numOfList) {
            if (num > 0) {
                System.out.print(num + ", ");
            }
        }
        System.out.println();
        //-------------------------------------------------------------------------------------------------------------------
        //        task 2: ყველაზე გრძელი სიტყვა (Longest Word)
        //        შექმენით ArrayList<String> და შეავსეთ იგი რამდენიმე სიტყვით. იპოვეთ და დაბეჭდეთ ყველაზე გრძელი სიტყვა ამ სიაში.
        ArrayList<String> stList = new ArrayList<>(Arrays.asList("Hydrogen", "Neutron", "Neutrino", "Star", "hawking", "radiation"));
        String longest = "";
        for (String st : stList) {
            if (st.length() > longest.length()) {
                longest = st;
            }
        }
        System.out.println("Task 2: The longest word is: " + longest);
        //-------------------------------------------------------------------------------------------------------------------
        //    task 3: ელემენტების წაშლა (Removing Elements)
        //    მოცემულია ArrayList<String>. წაშალეთ სიიდან ყველა ის სიტყვა, რომლის სიგრძე 4 სიმბოლოზე ნაკლებია. დაბეჭდეთ მიღებული სია.
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Hi", "No", "Yes", "Atom", "Java", "Newton"));
        //        Iterator<String> it = strList.iterator();
        //        while (it.hasNext()) {
        //            if (it.next().length() < 4) {
        //                it.remove(); // safe remove
        //            }
        //        }

        // safe remove
        strList.removeIf(s -> s.length() < 4);

        System.out.println("Task 3: " + strList);
        //-------------------------------------------------------------------------------------------------------------------
        //        task 4: ორი სიის გაერთიანება (Combining Two Lists)
        //        შექმენით ორი ArrayList<String>. გააერთიანეთ ისინი მესამე, ახალ სიაში ისე,
        //        რომ პირველ რიგში პირველი სიის ელემენტები იყოს, შემდეგ კი – მეორის. დაბეჭდეთ გაერთიანებული სია.

        ArrayList<String> stList1 = new ArrayList<>(Arrays.asList("Hydrogen", "Neutron", "Neutrino"));
        ArrayList<String> stList2 = new ArrayList<>(Arrays.asList("Star", "Planet", "Orbit"));
        ArrayList<String> stList3 = new ArrayList<>(stList1);
        stList3.addAll(stList2);
        System.out.println(stList3);


        //        ნაწილი 2: Set (სიმრავლე):
        //     Task 5: დუბლიკატების მოშორება (Removing Duplicates)
        //     შექმენით ArrayList<Integer>, რომელშიც რამდენიმე რიცხვი მეორდება. მაგ: [1, 5, 2, 8, 5, 1, 9].
        //     HashSet-ის გამოყენებით შექმენით ახალი კოლექცია, რომელიც მხოლოდ უნიკალურ ელემენტებს შეიცავს. დაბეჭდეთ უნიკალური რიცხვები.
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 2, 8, 5, 1, 9));

        HashSet<Integer> intSet = new HashSet<>(intList);
        System.out.println("Task 5: " + intSet);
        //-------------------------------------------------------------------------------------------------------------------
        //        Task 6: უნიკალური სიმბოლოები (Unique Characters)
        //        დაწერეთ პროგრამა, რომელიც მომხმარებლის მიერ შეყვანილ სტრიქონში დაითვლის და
        //        დაბეჭდავს უნიკალური სიმბოლოების რაოდენობას HashSet-ის გამოყენებით.
        //                მაგალითი: სიტყვისთვის "hello" პასუხი უნდა იყოს 4 (h, e, l, o).
        String word1 = "hello";
        LinkedHashSet<Character> chSet = new LinkedHashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            char st = word1.charAt(i);
            chSet.add(st);
        }
        System.out.println("Task 6: " + chSet);
        //-------------------------------------------------------------------------------------------------------------------
        //        Task 7: საერთო ელემენტები (Common Elements)
        //        შექმენით ორი ArrayList<String>. იპოვეთ და დაბეჭდეთ ის ელემენტები, რომლებიც ორივე სიაში ერთდროულად გვხვდება.
        //        გამოიყენეთ HashSet, რომ ეს პროცესი გაამარტივოთ.


        ArrayList<String> stList11 = new ArrayList<>(Arrays.asList("atom", "electron", "quark", "neutrino"));
        ArrayList<String> stList22 = new ArrayList<>(Arrays.asList("neutron", "proton", "quark", "neutrino"));

        HashSet<String> stSet = new HashSet<>(stList11);

        ArrayList<String> stList33 = new ArrayList<>();
        for (String st : stList22) {
            if (stSet.contains(st)) {
                stList33.add(st);
            }
        }

        System.out.println("Task 7: " + stList33);
        System.out.println("Task 8:");


        //    ნაწილი 3: Map (რუკა ან ლექსიკონი)
        //        ამოცანა 8: სტუდენტის ქულები (Student Grades)
        //        შექმენით HashMap<String, Integer>, სადაც გასაღები (String) სტუდენტის სახელია, ხოლო მნიშვნელობა (Integer) – მისი ქულა.
        //        ა) დაამატეთ 5 სტუდენტი და მათი ქულები.
        //        ბ) დაბეჭდეთ კონკრეტული სტუდენტის ქულა მისი სახელის მიხედვით.
        //                გ) დაბეჭდეთ ყველა სტუდენტის სახელი და ქულა.
        HashMap<String, Integer> studentMap = new HashMap<>();
        studentMap.put("Nino", 100);
        studentMap.put("Giorgi", 100);
        studentMap.put("Tamari", 95);
        studentMap.put("Ani", 85);
        studentMap.put("Nika", 77);

        System.out.println("Nino's grade: " + studentMap.get("Nino"));

        for (String st : studentMap.keySet()) {
            System.out.println("Name: " + st + ", score " + studentMap.get(st));
        }

        //-------------------------------------------------------------------------------------------------------------------
        //        ამოცანა 9: სიმბოლოების დათვლა (Character Count)
        //        დაწერეთ პროგრამა, რომელიც დაითვლის თითოეული სიმბოლოს რაოდენობას მოცემულ სტრიქონში
        //        და შეინახავს შედეგს HashMap<Character, Integer>-ში.
        //                მაგალითი: "banana" -> {b=1, a=3, n=2}
        String text = "banana";
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (char ch : text.toCharArray()) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        System.out.println("Task 9: " + charMap);

        //    ნაწილი 4: Stack (სტეკი)
        //        ამოცანა 10: სიტყვის შებრუნება (Reverse a Word)
        //        დაწერეთ მეთოდი, რომელიც იღებს სტრიქონს და აბრუნებს მის შებრუნებულ ვერსიას Stack-ის გამოყენებით.

        Stack<Character> stStack = new Stack<>();
        String word = "reverse";

        for (char ch : word.toCharArray()) {
            stStack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stStack.isEmpty()) {
            reversed.append(stStack.pop());
        }
        System.out.println("Task 10: " + reversed);


        //task 11
        String str = "()bs[";
        System.out.println("task 11: " + areBracketsBalanced(str));


        //-------------------------------------------------------------------------------------------------------------------
        // ამოცანა 12: მოლარის რიგი (Cashier Queue)
        // გააკეთეთ მაღაზიის რიგის სიმულაცია Queue-ს გამოყენებით.
        // ა) შექმენით Queue<String> მომხმარებლების სახელებით.
        // ბ) დაამატეთ რიგში 4-5 მომხმარებელი (add ან offer მეთოდით).
        // გ) სათითაოდ "მოემსახურეთ" მათ, ანუ დაბეჭდეთ და წაშალეთ რიგიდან პირველი მომხმარებელი (remove ან poll მეთოდით), სანამ რიგი არ დაიცლება. დაბეჭდეთ შეტყობინება, მაგ: "ემსახურება: [სახელი]".
        System.out.println("Task 12:");
        Queue<String> customers = new LinkedList<String>();
        customers.add("David");
        customers.add("Alexander");
        customers.add("Maria");
        customers.add("Pablo");
        customers.add("Griselda");

        // while (!customers.isEmpty()) {
        // String served = customers.poll();
        // System.out.println("Serving: " + served);
        // }
        Iterator<String> it = customers.iterator();
        while (it.hasNext()) {
            String c = it.next();
            System.out.println("Serving: " + c);
            it.remove(); // safe
        }

    }
    // ამოცანა 11: ფრჩხილების ბალანსი (Simple Parentheses Balance)
    // დაწერეთ მეთოდი, რომელიც ამოწმებს, არის თუ არა სტრიქონში () ფრჩხილები სწორად დასმული.
    // "()" -> true
    // "(())" -> true
    // ")(" -> false
    // "(()" -> false
    // ალგორითმი: როცა ხსნით ფრჩხილს (, დაამატეთ იგი სტეკში. როცა ხურავთ ), სცადეთ სტეკიდან ელემენტის ამოღება.
    // თუ სტეკი ცარიელია, ან ბოლოს ყველა ფრჩხილი არ დაიხურა, ესე იგი ბალანსი დარღვეულია.

    public static boolean areBracketsBalanced(String st) {
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char ch : st.toCharArray()) {
            if (pairs.containsValue(ch)) { // opening bracket
                stack.push(ch);
            } else if (pairs.containsKey(ch)) { // closing bracket
                if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
