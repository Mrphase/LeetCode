package Amazon;

public class OA1_3 {

    public static class GradingSystem {
        public static void printArr(int arr[]) {
            for (int i : arr) System.out.print(i+" ");
        }

        public static int[] sortArray(int arr[]) {
            int len = arr.length;
            int small, pos, temp;
            for (int i = 0; i <= len - 1; i++) {
                temp = 0;
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] < arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                    }
                }


            }


            return arr;
        }
    }

    public static void main(String[] args) {
        int[] input;
        input = new int[20];
        for (int i = input.length-1; i > 10; i--) {
            input[i] = i;
        }
        GradingSystem.printArr(input);
        System.out.println();
        GradingSystem.sortArray(input);
        GradingSystem.printArr(input);
    }

}
