package AmazonOA2;
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
import java.util.*;

public class L22GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left: generateParenthesis(c))
                        for (String right: generateParenthesis(n-1-c))
                            ans.add("(" + left + ")" + right);
            }
            return ans;
        }
    }
}
