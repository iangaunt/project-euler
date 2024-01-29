package jva;

/*
 * n=\frac{1+\sqrt{1-4\left(2m-2m^{2}\right)}}{2}
 */

public class Answer100 {
    public static double findTotalDiscs(long m) {
        double mi = (double) m;
        return (1.0 + Math.sqrt(1 - 4 * (2 * mi - 2 * mi * mi))) / 2.0;
    }

    public static void main(String[] args) {
        long trillion = (long) (Math.pow(10, 12));
        System.out.println(trillion);

        for (long i = 0; i < Long.MAX_VALUE; i++) {
            double total = findTotalDiscs(i);
            if (total == (int) (total)) {
                System.out.println(i);
                // break;
            }
        }
    }
}
