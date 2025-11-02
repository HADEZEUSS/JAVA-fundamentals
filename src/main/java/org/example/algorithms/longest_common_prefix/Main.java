package org.example.algorithms.longest_common_prefix;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // "fl"
        System.out.println(Solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));   // ""
        System.out.println(Solution.longestCommonPrefix(new String[]{"interspecies", "interstellar", "interstate"})); // "inters"
        System.out.println(Solution.longestCommonPrefix(new String[]{"throne", "throne"})); // "throne"
        System.out.println(Solution.longestCommonPrefix(new String[]{"a"})); // "a"
        System.out.println(Solution.longestCommonPrefix(new String[]{"", "b"})); // ""
    }
}

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (String st : strs) {
            while (!st.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
