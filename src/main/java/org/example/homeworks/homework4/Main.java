package org.example.homeworks.homework4;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String word = "Oppenheimer";
        String sentence = "Now i am become Death, the destroyer of worlds";
        String str = "Hello World";

        //testing...
        System.out.println("length of the string is " + lengthOfString(word));
        System.out.println("first and last characters: " + firstAndLast(word));
        System.out.println("es empty? " + isEmpty(sentence));
        System.out.println("are equal? " + isEquals(word, sentence));
        System.out.println("Upper case: " + toUpperCase(word));
        System.out.println("lower case: " + toLowerCase(word));
        System.out.println("Without whitespaces: " + withoutWhiteSpace(sentence));
        System.out.println("Does it starts with www.? " + strStartsWith(sentence));
        System.out.println("Does it ends with .com? " + strEnsWith(sentence));
        System.out.println("Does it contain 'Java'? " + strContains(sentence));
        System.out.println("replace 'a' to '*': " + strReplace(sentence));
        System.out.println("string from index 3 to 7: " + strSubstring(word));
        System.out.println("From sentence to words: " + wordsInArray(sentence));
        String[] words = wordsInArray(sentence);
        System.out.println(java.util.Arrays.toString(words));
        System.out.println("numbers 1 to 50: " + strOfNumbers1());
        System.out.println("numbers 1 to 50: " + strOfNumbers2());
        System.out.println("Reverse string: " + reverseString3(word));
        System.out.println("joined words from array: " + arrayInStr());
        System.out.println("is palindrome? " + isPolindrome(word));
        System.out.println("Add Java after Hello: " + addString(str));
        System.out.println("delete index 5 to 10: " + strDelete(sentence));
        System.out.println("Occurrences of 'a': " + countChar(sentence, 'a'));
        System.out.println("Sentence with each word capitalized: " + firstUpperCase(sentence));

    }

    //დაწერეთ ფუნქცია, რომელიც იღებს სტრიქონს და აბრუნებს მის სიგრძეს.
    public static int lengthOfString(String str) {
        return str.length();
    }

    //დაწერეთ ფუნქცია, რომელიც იღებს სტრიქონს და აბრუნებს მის პირველ და ბოლო სიმბოლოს.
    public static String firstAndLast(String str) {
        return str.substring(0, 1) + str.substring(str.length() - 1, str.length());
    }

    //დაწერეთ ფუნქცია, რომელიც ამოწმებს, არის თუ არა სტრიქონი ცარიელი (isEmpty).
    public static boolean isEmpty(String str) {
        return str == null;
    }

    //შექმენით ფუნქცია, რომელიც მიიღებს ორ სტრიქონს და დაადგენს, არის თუ არა ისინი ერთმანეთის ტოლი (equals).
    public static boolean isEquals(String str1, String str2) {
        return str1.equals(str2);
    }

    //დაწერეთ ფუნქცია, რომელიც იღებს სტრიქონს და მთლიანად გადაყავს მაღალ რეგისტრში (toUpperCase).
    public static String toUpperCase(String str) {
        return str.toUpperCase(Locale.ROOT);
    }

    //დაწერეთ ფუნქცია, რომელიც იღებს სტრიქონს და მთლიანად გადაყავს დაბალ რეგისტრში (toLowerCase).
    public static String toLowerCase(String str) {
        return str.toLowerCase(Locale.ROOT);
    }

    //შექმენით ფუნქცია, რომელიც სტრიქონს ორივე მხრიდან აშორებს ზედმეტ ჰარებს (whitespace-ებს).
    public static String withoutWhiteSpace(String str) {
        return str.trim();
    }

    //დაწერეთ ფუნქცია, რომელიც ამოწმებს, იწყება თუ არა სტრიქონი კონკრეტული პრეფიქსით, მაგალითად, "www." (startsWith).
    public static boolean strStartsWith(String str) {
        return str.startsWith("www.");
    }

    //დაწერეთ ფუნქცია, რომელიც ამოწმებს, მთავრდება თუ არა სტრიქონი კონკრეტული სუფიქსით, მაგალითად, ".com" (endsWith).
    public static boolean strEnsWith(String str) {
        return str.endsWith(".com");
    }

    //შექმენით ფუნქცია, რომელიც ამოწმებს, შეიცავს თუ არა სტრიქონი სიტყვას "Java" (contains).
    public static boolean strContains(String str) {
        return str.contains("Java");
    }

    //დაწერეთ ფუნქცია, რომელიც სტრიქონში ცვლის ყველა 'a' სიმბოლოს '*' სიმბოლოთი (replace).
    public static String strReplace(String str) {
        return str.replace('a', '*');
    }

    //დაწერეთ ფუნქცია, რომელიც მიიღებს სტრიქონს და ამოჭრის მისგან ქვესტრიქონს მე-3 ინდექსიდან მე-7 ინდექსამდე (substring).
    public static String strSubstring(String str) {
        try {
            return str.substring(3, 7);
        } catch (IndexOutOfBoundsException e) {
            return "Invalid substring range";
        } catch (NullPointerException e) {
            return "String is null";
        }
    }

    //დაწერეთ ფუნქცია, რომელიც წინადადებას დაშლის სიტყვებად მასივში, გამყოფად გამოიყენეთ ჰარი (split).
    public static String[] wordsInArray(String str) {
        if (str == null || str.isEmpty()) {
            return new String[0];
        }
        String[] wordsArray = str.split("\\s+");
        return wordsArray;
    }

    //შექმენით ფუნქცია, რომელიც ციკლის გამოყენებით 1-დან 50-მდე რიცხვებს ერთ სტრიქონში გააერთიანებს. გამოიყენეთ String-ის + ოპერატორი.
    public static String strOfNumbers1() {
        String numbers = "";
        for (int i = 1; i < 50; i++) {
            numbers += i;
        }
        return numbers;
    }

    //იგივე StringBuilder-ის გამოყენებით:
    public static String strOfNumbers2() {
        StringBuilder numbersStr = new StringBuilder();
        for (int i = 1; i < 50; i++) {
            numbersStr.append(i);
        }
        return numbersStr.toString();
    }

    //დაწერეთ ფუნქცია StringBuilder-ის გამოყენებით, რომელიც მიიღებს სტრიქონს და შეაბრუნებს მას (reverse).
    public static String reverseString1(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }

    public static String reverseString2(String str) {
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }

    public static String reverseString3(String str) {
        StringBuilder reverseStr = new StringBuilder(str);
        return reverseStr.reverse().toString();
    }

    //დაწერეთ ფუნქცია, რომელიც ამოწმებს, არის თუ არა სიტყვა პალინდრომი (იკითხება თუ არა ერთნაირად თავიდან ბოლომდე და ბოლოდან თავისკენ). გადაწყვიტეთ, რომელი კლასი (String თუ StringBuilder) არის ამ ამოცანისთვის უკეთესი.

    public static boolean isPolindrome(String str) {
        StringBuilder reverseStr = new StringBuilder(str);
        return str.equals(reverseStr.reverse().toString());
    }

    //მოცემულია სტრიქონი "Hello World". StringBuilder-ის გამოყენებით ჩასვით სიტყვა "Java" სიტყვა "Hello"-ს შემდეგ (insert).
    public static String addString(String str) {
        StringBuilder result = new StringBuilder(str);
        return result.insert(6, "Java ").toString();
    }

    //მოცემულია გრძელი სტრიქონი. StringBuilder-ის გამოყენებით წაშალეთ სიმბოლოები მე-5 ინდექსიდან მე-10 ინდექსის ჩათვლით (delete).
    public static String strDelete(String str) {
        StringBuilder finalWorld = new StringBuilder(str);
        return finalWorld.delete(5, 10).toString();
    }

    //მოცემულია სტრინგების მასივი: {"Java", "is", "fun"}. String.join მეთოდის გამოყენებით, გააერთიანეთ ეს სიტყვები ერთ წინადადებაში, სადაც სიტყვები ერთმანეთისგან გამოყოფილი იქნება ტირეთი "-".
    public static String arrayInStr() {
        String[] arr = {"Java", "is", "fun"};
        return String.join("-", arr);
    }

    //დაწერეთ ფუნქცია, რომელიც ითვლის, რამდენჯერ გვხვდება მოცემული სიმბოლო სტრიქონში.
    public static int countChar(String text, char ch) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    //შექმენით ფუნქცია, რომელიც მიიღებს წინადადებას და თითოეული სიტყვის პირველ ასოს გადაიყვანს მაღალ რეგისტრში. გადაწყვიტეთ რომელი კლასი (String თუ StringBuilder) არის უკეთესი საბოლოო შედეგის ასაწყობად.
    public static String firstUpperCase(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}
