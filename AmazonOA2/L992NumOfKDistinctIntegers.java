package AmazonOA2;
/*
Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.
(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
Return the number of good subarrays of A.

Example 1:
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
Example 2:
Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */
import java.util.*;

public class L992NumOfKDistinctIntegers {
    class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
            Window window1 = new Window();
            Window window2 = new Window();
            int ans = 0, left1 = 0, left2 = 0;

            for (int right = 0; right < A.length; ++right) {
                int x = A[right];
                window1.add(x);
                window2.add(x);

                while (window1.different() > K)
                    window1.remove(A[left1++]);
                while (window2.different() >= K)
                    window2.remove(A[left2++]);

                ans += left2 - left1;
            }

            return ans;
        }
    }

    class Window {
        Map<Integer, Integer> count;
        int nonzero;

        Window() {
            count = new HashMap();
            nonzero = 0;
        }

        void add(int x) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1)
                nonzero++;
        }

        void remove(int x) {
            count.put(x, count.get(x) - 1);
            if (count.get(x) == 0)
                nonzero--;
        }

        int different() {
            return nonzero;
        }
    }
}
