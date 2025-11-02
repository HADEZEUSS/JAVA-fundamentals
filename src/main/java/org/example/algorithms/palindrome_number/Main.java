package org.example.algorithms.palindrome_number;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(121));    // true
        System.out.println(Solution.isPalindrome(-121));   // false
        System.out.println(Solution.isPalindrome(10));     // false
        System.out.println(Solution.isPalindrome(0));      // true
        System.out.println(Solution.isPalindrome(12321));  // true
        System.out.println(Solution.isPalindrome(123));    // false
    }

    class Solution {
        public static boolean isPalindrome(int x) {
            if (x < 0) return false;

            int original = x;
            int reversed = 0;

            while (x != 0) {
                int digit = x % 10;
                reversed = reversed * 10 + digit;
                x = x / 10;
            }

            return original == reversed;
        }

//     public static boolean isPalindrome(int x) {
//         String num = String.valueOf(x);
//         char[] numbers = num.toCharArray();
//
//         for (int i = 0; i < num.length() / 2; i++) {
//             if (numbers[i] != numbers[num.length() - 1 - i]) {
//                 return false;
//             }
//         }
//         return true;
//     }
    }
}

