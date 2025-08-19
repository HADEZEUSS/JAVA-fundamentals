package org.example.homeworks.homework2;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        //number1
////        Write a program that asks for a user’s name and age, then prints "Hello, Alice! You’ll be 30 next year."
//
//        Scanner scannerStr = new Scanner(System.in);
//        System.out.println("enter name:");
//        String name = scannerStr.nextLine();
//
//        Scanner scannerInt = new Scanner(System.in);
//        System.out.println("enter age:");
//        int age = scannerInt.nextInt();
//
//        System.out.println("Hello, " + name + "! You'll be " + (age + 1) + " next year.");

////        number2: ------------------------------------------------------------
////        Print the first n squares (1² … n²). n is read from input.

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter a number:");
//        int n = scanner.nextInt();
//
//        for (int i=0; i<=n; i++){
//            System.out.println(i*n);
//        }

////        number3: -----------------------------------------------------------
////        Keep reading integers until the user enters 0; output their sum and average.
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter number (0 to stop):");
//        int n = scanner.nextInt();
//
//        int sum = 0;
//        double average = 0;
//        int counter =0;
//
//        while (n!=0){
//            System.out.println("enter number:");
//             sum += n;
//             counter += 1;
//
//            n = scanner.nextInt();
//        }
//
//        average= (double)sum / counter;
//        System.out.println("sum: " + sum + ", average: " + average);


////        number4: ------------------------------------------------------------
////        Implement static int factorial(int n) using a loop. Call it from main and print the result.
//
//        int n = 4;
//        int result = factorial(n);
//        System.out.println("Factorial of " + n + " is " + result);

////        number5: ----------------------------------------------------------
////        Implement static boolean isPrime(int n) and test it on numbers 2 … 100 in a loop. Print all primes.
//          for (int i = 2; i <= 100; i++){
//              if (isPrime(i)){
//                  System.out.println(i);
//              }
//          }
//          number6: ----------------------------------------------------------------
////        Read 10 numbers into an int array, then write static double average(int[] arr) and print the average.
//
//        Scanner scanner = new Scanner(System.in);
//        int[] arr = new int[10];
//        System.out.println("Enter 10 numbers:");
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        double avg = average(arr);
//        System.out.println("Average is: " + avg);

//        number7: -----------------------------------------------------------------
////        Re-use prev exercise but catch InputMismatchException to guard against non-numeric input; prompt again until valid.
//
//        Scanner scanner = new Scanner(System.in);
//        int[] arr = new int[10];
//        System.out.println("Enter 10 numbers:");
//
//        for (int i = 0; i < arr.length; ) {
//            System.out.print("Enter number " + (i + 1)  + ": ");
//            try {
//                arr[i] = scanner.nextInt();
//                i++;
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input! Please enter a valid integer.");
//                scanner.next();
//            }
//        }
//        double avg = average(arr);
//        System.out.println("Average is: " + avg);


////---------------------------------------------------------------------------------------

////First homework

//        boolean b = true;
//        String str = "a";
//
//        if (str.isEmpty()){
//            if(b) {
//                System.out.println("Correct!");
//            } else{
//                System.out.println("Who knows?!");
//            }
//        } else if  (str.length()%2==0){
//            System.out.println((str.length()*str.length()%5));
//        }else if  ( str.length()%2==0 && b==true){
//            b=false;
//        } else if  (str.length()==7){
//            System.out.println("jackpot");
//        } else {
//            System.out.println(b+str);
//        }
//------------------------------------------
//        String day="Monday";
//        switch (day){
//            case "Monday":
//                System.out.println("Fixing bugs at work");
//                break;
//            case "Tuesday":
//                System.out.println("Code Transfer");
//                break;
//            case "Wednesday":
//                System.out.println("Fun with friends");
//                break;
//            case "Thursday":
//                System.out.println("Writing Code");
//                break;
//            case "Friday":
//                System.out.println("Patches");
//                break;
//            case "Saturday":
//                System.out.println("Watching Inception");
//                break;
//            case "Sunday":
//                System.out.println("skiing");
//                break;
//        }

////Second homework
//        //task1:
//        int sum = 0;
//        for (int i = 1; i <= 100; i++){
//            if ( i % 2 == 0 && i != 16){
//                sum += i;
//                System.out.println(i);
//            }
//        }
//        System.out.println("sum is: " + sum);

//        //task2:
//        int i = 1;
//        while(i < 50){
//            if(i % 6 == 0){
//                System.out.println(i);
//            };
//            i++;
//        }

//        int guess = 5;
//        Random random = new Random();
//        int randomNumber = random.nextInt(10);
//        while ( guess != randomNumber){
//            randomNumber = random.nextInt(10);
//                System.out.println(randomNumber);
//        }


////       task3:
//        addition(10, 5);
//        difference(10, 5);
//        Multiplication(10, 5);
//        Division(10, 5);
//        squareOfNum1(10);
//        squareRootOfNum2(5);


        //task4:
        boolean val = isEven(4);
        System.out.println(val);

        int[] numbers = {5, 9, 2, 15, 7};
        System.out.println("Max value: " + maxValue(numbers));

        char ch = 'a';
        System.out.println("is character vowel? : " + isVowel(ch));

        String str = "Hello";
        System.out.println("string have: " + numVowels(str) + " vowels");

        System.out.println("string without vowels: " + withoutVowels(str));

        String input = "abcseamoaiommeeer";
        System.out.println(clearString(input));
    }


    //    methods:
    public static int factorial(int n) {
        int count = 1;
        for (int i = 2; i <= n; i++) {
            count *= i;
        }
        return count;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double average(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return (double) sum / arr.length;
    }

    //     task3:
    public static int addition(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println("Sum: " + sum);
        return sum;
    }

    public static int difference(int num1, int num2) {
        int difference = num1 - num2;
        System.out.println("Difference: " + difference);
        return difference;
    }

    public static int Multiplication(int num1, int num2) {
        int product = num1 * num2;
        System.out.println("Product: " + product);
        return product;
    }


    public static double Division(int num1, int num2) {
        double quotient = 0;
        if (num2 != 0) {
            quotient = (double) num1 / num2;
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Cannot divide by zero");
        }
        return quotient;
    }


    public static int squareOfNum1(int num1) {
        int squareNum1 = num1 * num1;
        System.out.println("Square of num1: " + squareNum1);
        return squareNum1;
    }


    public static double squareRootOfNum2(int num2) {
        double sqrtNum2 = 0;
        if (num2 >= 0) {
            sqrtNum2 = Math.sqrt(num2);
            System.out.println("Square root of num2: " + sqrtNum2);
        } else {
            System.out.println("Cannot find square root of negative number");
        }
        return sqrtNum2;
    }

    //task4:
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int numberOfDisviders(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum += 1;
            }
        }
        return sum;
    }

    public static int maxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static boolean isVowel(char ch) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        boolean vowelBool = false;
        for (char vowel : vowels) {
            if (ch == vowel) {
                vowelBool = true;
                break;
            }
        }
        return vowelBool;
    }

    public static int numVowels(String str) {
        int num = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < str.length(); i++) {
            for (char vowel : vowels) {
                if (str.charAt(i) == vowel) {
                    num++;
                }
            }
        }
        return num;
    }

    public static String withoutVowels(String str) {
        StringBuilder withoutVowelsTemplate = new StringBuilder();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < str.length(); i++) {
            boolean isVowel = false;

            for (char vowel : vowels) {
                if (str.charAt(i) == vowel) {
                    isVowel = true;
                    break;
                }
            }

            if (!isVowel) {
                withoutVowelsTemplate.append(str.charAt(i));
            }
        }

        return withoutVowelsTemplate.toString();
    }


    public static String clearString(String str) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (vowels.indexOf(c) != -1) {
                count++;
                if (count % 2 != 0) {
                    result.append(c);
                }
            } else {
                count = 0;
                result.append(c);
            }
        }
        return result.toString();
    }


}