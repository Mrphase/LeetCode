package AmazonOA2;
/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.
Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
 */
import java.util.*;

public class L340_slidWindow_longestStrHasKChar {
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int n = s.length();
            if (n*k == 0) return 0;

            // sliding window left and right pointers
            int left = 0;
            int right = 0;
            // hashmap character -> its rightmost position
            // in the sliding window
            HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

            int max_len = 1;

            while (right < n) {
                // add new character and move right pointer
                hashmap.put(s.charAt(right), right++);

                // slidewindow contains 3 characters
                if (hashmap.size() == k + 1) {
                    // delete the leftmost character
                    int del_idx = Collections.min(hashmap.values());
                    hashmap.remove(s.charAt(del_idx));
                    // move left pointer of the slidewindow
                    left = del_idx + 1;
                }

                max_len = Math.max(max_len, right - left);
            }
            return max_len;
        }
    }
}
