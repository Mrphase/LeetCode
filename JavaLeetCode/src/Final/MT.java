package Final;

public class MT {
    public static void main(String[] args) {
        int[] data = new int[8];
        data[0] = 3;
        data[7]=-15;
        for (int i = data.length-2; i > 0; i--)
            data[i] = data[i+1];
        for (int i = 0; i < data.length-1; i++)
            data[i+1]= data[i];
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i]);
        System.out.println();
    }
}
