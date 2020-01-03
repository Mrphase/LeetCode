package leetcode;

public class L242 {
    static class Solution {
        public  boolean isAnagram(String s, String t) {
            if(s.length()!=t.length()) return false;

            char[] s_char = s.toCharArray();
            char[]  t_char = t.toCharArray();
            int[] temp = new int[100];
            for (int i = 0; i< s_char.length; i ++){
                temp[s_char[i]-96] +=1;
                temp[t_char[i]-96] -=1;
            }
            int sum = 0;
            for(int i:temp){
                if (i!=0) return false;
            }
            return true;
        }}

    public static void main(String[] args) {
        String s = "ac";
        String t = "bb";

        int temp = s.toCharArray()[0]-t.toCharArray()[0];
        System.out.println(temp);

        Solution S = new Solution();

        System.out.println(S.isAnagram(s,t));
    }
}
