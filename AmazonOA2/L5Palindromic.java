package AmazonOA2;

public class L5Palindromic {
    class Solution {
        public String longestPalindrome(String s) {

            if (s == null || s.length() < 1) return "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }
        private int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }




//
//    class Solution {
//        private int expandAroundCenter(String s, int left, int right) {
//            int L = left, R = right;
//            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//                L--;
//                R++;
//            }
//            return R - L - 1;
//        }
//
//        public String longestPalindrome(String s) {
//            if(s == null|| s.length()<1) return "";
//            int start = 0, end = 0, len1 = 0, len2 = 0;
//            for(int i = 0; i< s.length(); i++){
//                if( i+1< s.length()-1 &&s.charAt(i)==s.charAt(i+1) ){
//                    len1 = expandAroundCenter(s, i, i+1);
//                }
//
//                if(i+1< s.length()-1 && i>0&& s.charAt(i-1) ==s.charAt(i+1)){
//                    len2 = expandAroundCenter(s, i, i);
//                }
//                int len = Math.max(len1, len2);
//
//                //refresh here
//                if(len > end - start){
//                    start = i - (len - 1) / 2;
//                    end = i + len / 2;
//                }
//
//            }
//
//            return s.substring(start, end + 1);
//        }
//    }
}
