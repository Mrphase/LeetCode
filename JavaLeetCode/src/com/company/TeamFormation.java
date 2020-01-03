package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class TeamFormation {
    public static void main(String[] args) {
        int[] input = {9,17,12,10,2,7,2,11,20,8,3,4};
        int total = input[0];
        int team = input[input.length-1];
        int  m = input[input.length-2];
        ArrayList<Integer> left = new ArrayList<Integer>(team+m);
        ArrayList<Integer> right = new ArrayList<Integer>(team+m);
       // System.out.println(m);
//        for(int i = 1; i<input.length-3;i++){
            for (int j = 0;j<team+m;j++) {
                left.add(j, input[1+j]);
                right.add(j, input[input.length - 3 - j]);

            }
            left.addAll(right);
            int out =0;
            int count = 0;

            for(Integer i:left){

                Collections.max(left);
                if(i==Collections.max(left)){
                    System.out.println(i);
                    out+=i;
                    count++;
                    left.remove(i);
                    if(count==3)break;
                }
            }
//        int min = (int) Collections.min(Arrays.asList(right));
            System.out.println(out);



    }
}
