package com.company;

import java.util.*;
//import java.*;

public class TwoSum {

    public static void main(String[] args) {

        int[] inp1 = new int[]{2, 7, 4, 6, 3};
        int inp2 = 9;
        Solution S = new Solution();
        S.twoSum(inp1, inp2);
        System.out.println(S.twoSum(inp1, inp2)[0]);
        System.out.println(S.twoSum(inp1, inp2)[1]);

    }

    static class Solution {
        int[] Result = new int[]{0, 0};
        ;

        public int[] twoSum(int[] nums, int target) {
            if (nums.length == 0) {
                return Result;
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (target - nums[i] == nums[j]) {
                        Result[0] = i;
                        Result[1] = j;
                        // System.out.println(Result[0]+Result[1]);
                        return Result;

                    }

                }

            }
            System.out.println(Result);

            return Result;
        }
    }
}