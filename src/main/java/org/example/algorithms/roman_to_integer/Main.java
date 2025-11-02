package org.example.algorithms.roman_to_integer;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Test the romanToInt method
        System.out.println(Solution.romanToInt("III"));     // 3
        System.out.println(Solution.romanToInt("IV"));      // 4
        System.out.println(Solution.romanToInt("IX"));      // 9
        System.out.println(Solution.romanToInt("LVIII"));   // 58
        System.out.println(Solution.romanToInt("MCMXCIV")); // 1994
        System.out.println(Solution.romanToInt("XLII"));    // 42
    }
}

class Solution {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanAndInt = new HashMap<>();
        romanAndInt.put('I', 1);
        romanAndInt.put('V', 5);
        romanAndInt.put('X', 10);
        romanAndInt.put('L', 50);
        romanAndInt.put('C', 100);
        romanAndInt.put('D', 500);
        romanAndInt.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = romanAndInt.get(s.charAt(i));

            if (i + 1 < s.length() && value < romanAndInt.get(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }
        }

        return sum;
    }
}
