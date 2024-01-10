package jva;

public class Answer2 {
    public static void main(String[] args) throws Exception {
        final int MAXIMUM = 4000000;

        int one = 0;
        int two = 1;
        int sum = 0;

        while (one < MAXIMUM && two < MAXIMUM) {
            int temp = 0;
            if (one < two) {
                temp = one;
                one = two;
                two += temp;

                if (one % 2 == 0) sum += one;
            } else {
                temp = two;
                two = one;
                one += temp;

                if (two % 2 == 0) sum += two;
            }
        }

        System.out.println(sum);
    }
}
