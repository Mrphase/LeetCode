package Amazon;

public class OA1_4 {


    public  int[] removeElement(int arr[], int index) {
        int len = arr.length;
        if (index < len) {


            int rarr[] = new int[len - 1];
            for (int i = 0; i < index-1; i++)
                rarr[i] = arr[i];
            for (int j = index-1 ; j < len - 1; j++) {
                rarr[j] = arr[j+1];
            }
            return rarr;
        } else {
            return arr;
        }
    }


    public static void printArr(int arr[]) {
        for (int i : arr) System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input;
        input = new int[20];
        for (int i = input.length-1; i > 10; i--) {
            input[i] = i;
        }
        printArr(input);
        ShortArray SA = new ShortArray();
        OA1_4 SA2 = new OA1_4();
        int[] ints2 = SA2.removeElement(input, 18);
        int[] ints = SA.removeElement(input, 18);
        printArr(ints);
    }
}
  class ShortArray {

    public  int[] removeElement(int arr[], int index) {
        int len = arr.length;
        if (index < len) {


            int rarr[] = new int[len - 1];
            for (int i = 0; i < index-1; i++)
                rarr[i] = arr[i];
            for (int j = index-1 ; j < len - 1; j++) {
                rarr[j] = arr[j+1];
            }
            return rarr;
        } else {
            return arr;
        }
    }}