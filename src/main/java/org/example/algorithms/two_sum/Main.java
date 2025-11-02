package org.example.algorithms.two_sum;

import java.util.HashMap;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Example test case
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = Solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Expected: [0, 1]
    }

    class Solution {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int complement = target - num;

                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(num, i);
            }
            return new int[0]; // no result found
        }

        // public static int[] twoSum(int[] nums, int target) {
        //     int i = 0;
        //     int[] indices = new int[2];

        //     while (i < nums.length) {
        //         int j = i + 1;

        //         while (j < nums.length) {
        //             if (nums[i] + nums[j] == target) {
        //                 indices[0] = i;
        //                 indices[1] = j;
        //                 return indices;
        //             }
        //             j++;
        //         }
        //         i++;
        //     }

        //     return indices;
        // }
    }
}