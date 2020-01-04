package Amazon;

import com.sun.jdi.Value;

public class OA1_2 {
    public static class  ArrayOperation{
        public static int[] replaceValues (int arr[]){
            int len = arr.length;
            if (len%2 ==0){

                for (int i = 0; i < len; i++) {
                    arr[i] =0;}}
                else{
                    for (int j = 0; j < len; j++) {
                        arr[j] = 1;
                    }
                }
                return  arr;
                    }
                }






    public static void main(String[] args) {
        int[] i = new int[10];
        for (int ii: i) {  ii = 1;}
        int[] ints = ArrayOperation.replaceValues(i);
    System.out.println(ints[1]);
    }

}

