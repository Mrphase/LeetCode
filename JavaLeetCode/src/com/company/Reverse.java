package com.company;

public class Reverse {
    public static void main(String[] args) {
        char[] inp1 = new char[]{'a','b','c','d','e','f'};
        char[] s  = inp1;
        final int ii = s.length;
        int count = ii-1;
        for (int i =0; i<ii/2; i++ ){

                char temp = s[i];
                s[i] = s[count-i];
                s[count-i] = temp;
           // System.out.println(i);

        }
        for (char i:inp1 )
        System.out.println(i);


    }
    class Solution {

        public void reverseString(char[] s) {
            final int ii = s.length;
            for (int i =0; i<ii/2; i++ ){
                for (int j = ii; j>ii/2;j--){
                    char temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;

                }
            }

        }
    }
}
