package Amazon;

public class OA1_5 {

    public static void main(String[] args) {
        Digits D = new Digits();
      // int a = D.countDigits(43);
        D.countDigits(4);
    }
}

class Digits {
    public static int countDigits(int num) {
        int count = 0;
        int muns = num;
        while (muns != 0) {
            muns = muns / 10;
            count++;
        }
        return (num % count);
    }
}