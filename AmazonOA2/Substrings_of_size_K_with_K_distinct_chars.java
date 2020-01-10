package AmazonOA2;

import java.util.*;

/*
Amazon | OA 2019 | Substrings of size K with K distinct chars

Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.

Example 1:

Input: s = "abcabc", k = 3
Output: ["abc", "bca", "cab"]

Example 2:

Input: s = "abacab", k = 3
Output: ["bac", "cab"]

Example 3:

Input: s = "awaglknagawunagwkwagl", k = 4
Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
Explanation:
Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
"wagl" is repeated twice, but is included in the output once.

Constraints:

The input string consists of only lowercase English letters [a-z]
0 ≤ k ≤ 26
 */
public class Substrings_of_size_K_with_K_distinct_chars {
    public class Main {

        public  List<String> kSubstring(String s, int k) {
            Set<Character> window = new HashSet<>();
            Set<String> result = new HashSet<>();
            for (int start = 0, end = 0; end < s.length(); end++) {
                for (; window.contains(s.charAt(end)); start++) {
                    window.remove(s.charAt(start));
                }

                window.add(s.charAt(end));

                if (window.size() == k) {
                    result.add(s.substring(start, end + 1));
                    window.remove(s.charAt(start++));
                }
            }
            return new ArrayList<>(result);
        }

        public  void main(String[] args) {
            System.out.println(kSubstring("awaglknagawunagwkwagl", 4));
        }
    }
}
