package Amazon;

public class OA1_1 {
public static class Occurence{
    public static  int countOccurance(int arr[], int value){
        int i=0, j, len = arr.length;
        int count = 0;

        while (i<len){
            if(arr[i]==value){
                count+= 1;

            }
            i++;
        }


        return count;
    }

}
    public static void main(String[] args) {
    int[] i = new int[10];
        for (int ii: i) {  ii = 1;}
        int i1 = Occurence.countOccurance(i, 1);
        System.out.println(i1);

    }
}
