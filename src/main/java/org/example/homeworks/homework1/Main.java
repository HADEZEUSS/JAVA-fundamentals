package org.example.homeworks.homework1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
////         TASK1:
// //       1.	წრის ფართობის გამოთვლა: დაწერეთ Java პროგრამა, რომელიც მოცემული რადიუსით გამოთვლის წრის ფართობს.
// //       ფორმულა: ფართობი = π * r², სადაც შეგიძლიათ დაახლოებულად გამოიყენოთ π მნიშვნელობა 3.14. დაბეჭდეთ შედეგი.
//
//         Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the radius: ");
//        double r = scanner.nextDouble();
//        double pi = 3.14;
//
//        double area = pi * r * r;
//        System.out.println("Area of circle is " + area);
//
////        TASK2:
////        2.	დაწერეთ Java პროგრამა, რომელიც მიიღებს სამ რიცხვს, გამოთვლის მათ საშუალოს და დაბეჭდავს შედეგს ფორმატში:
////            "The average of num1, num2, and num3 is: average".
//
//        double average;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter first number");
//        double num1 = scanner.nextDouble();
//
//        System.out.println("enter second number");
//        double num2 = scanner.nextDouble();
//
//        System.out.println("enter third number");
//        double num3 = scanner.nextDouble();
//
//        average = (num1 + num2 + num3) / 3;
//
//        System.out.println("The average of " + num1 + ", " + num2 + ", " + num3 + " is: " + average);
//
////        TASK3:
////        3.	სამი რიცხვის შედარება: დაწერეთ Java პროგრამა, რომელიც შეადარებს სამ რიცხვს და დაბეჭდავს ყველაზე დიდს.
//
//        double average;
//        Scanner scanner = new Scanner (System.in);
//        System.out.println("enter first number");
//        double num1 = scanner.nextDouble();
//
//        System.out.println("enter second number");
//        double num2 = scanner.nextDouble();
//
//        System.out.println("enter third number");
//        double num3 = scanner.nextDouble();
//
//        if (num1>num2 && num1>num3){
//            System.out.println("The greatest number is: " + num1);
//        } else if (num2>num1 && num2>num3) {
//            System.out.println("The greatest number is: " + num2);
//        } else {
//            System.out.println("The greatest number is: " + num3) ; }

////        TASK4:
////        4.	დაწერეთ Java პროგრამა, რომელიც ორ მთელ რიცხვს გაყოფს და დაბეჭდავს როგორც ნაწილს, ასევე ნაშთს ფორმატში:
////          "The quotient is: quotient and the remainder is: remainder".
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter first number");
//        int num1 = scanner.nextInt();
//        System.out.println("enter second number");
//        int num2 = scanner.nextInt();
//
//        if (num2 != 0){
//            int quotient = num1/num2;
//            int remainder = num1%num2;
//
//            System.out.println("The quotient is: " +quotient + " and the remainder is: " +remainder);
//        } else{
//            System.out.println("Cannot divide by zero");
//        }

////        TASK5:
////        5.	 დაწერეთ მეთოდი, რომელიც იღებს სტრინგს და ამოწმებს ამ სტრინგის სიგრძე ლუწია თუ კენტი. დაბეჭდეთ შედეგი.
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter a text");
//        String text = scanner.nextLine();
//
//        int counter = 0;
//        for (int i = 0; i < text.length(); i++) {
//            counter ++;
//        }
//        if (counter % 2 == 0) {
//            System.out.println("length of the texts is even");
//        } else{
//            System.out.println("length of the texts is odd");
//        }
//
////        TASK6:
////        6. განსაზღვრეთ სტრინგი და  რიცხვი 0-დან 8-მდე: \
////           ა) გამოიყენეთ if ოპერატორი და დაბეჭდეთ არის თუ არა სტრინგის სიგრძე უფრო მეტი, ვიდრე რიცხვი,
////               ასევე შექმენით ბულიანი რომელშიც შეინახავთ შედეგს.
////        ბ) თუ სტრინგის სიგრძე უფრო დიდი იყო, დააბრუნეთ სტრინგის პირველი n ასო, რათა შეცვლილი სტრინგის სიგრძე გაუტოლდეს რიცხვს,
////            წინააღმდეგ შემთხვევაში, დაამატეთ განსხვავება რიცხვს და ორივე შემთხვევაში დაბეჭდეთ, რომ სტრინგის სიგრძე და რიცხვი ახლა ტოლია,
////            თუ თავიდანვე თანაბარია რიცხვი და სტრინგის სიგრძე დაბეჭდეთ რომ თავიდანვე თანაბარი იყო და ზედმეტ ოპერაციას არ საჭიროებდა.
//
//        String text = "NINO";
//        int number = 5;
//        boolean isLonger = text.length() > number;
//
//        System.out.println("Is text length greater than number? " + isLonger);
//
//        if (isLonger) {
//            text = text.substring(0, number);
//            System.out.println("String was long. Trimmed to: " + text);
//        } else if (text.length() < number) {
//            int diff = number - text.length();
//            text = text + "*".repeat(diff);
//            System.out.println("String was short. Padded to: " + text);
//        } else {
//            System.out.println("Length was already equal to number. No changes made.");
//        }
//
//        System.out.println("Final string: " + text);
    }
}
