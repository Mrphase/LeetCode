package AmazonOA2;

import java.util.HashMap;
import java.util.Map;
/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class L1TwoSum {
    public static void main(String[] args) {


        class Solution {
            public int[] twoSum(int[] nums, int target) {
                Map<Integer ,Integer> map = new HashMap<>();
                for(int i = 0; i<nums.length; i++){
                    int contains = target-nums[i];
                    if(map.containsKey(contains))
                        return new int[] { map.get(contains), i };//如果有重复，map.get得到第一个， i 为第二个

                    map.put(nums[i], i);
                }

                return new int[]{111,2222};//[]不能有东西
            }
        }
        Solution s = new Solution();
        int[] out = s.twoSum(new int[]{3,3},6);
System.out.println(out.toString());
}}

