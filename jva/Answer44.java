package jva;

import java.util.ArrayList;

public class Answer44 {
    public static boolean isPentagonal(int n) {
        double penta = (1 + Math.sqrt(1 + 24 * n)) / 6;
        return ((int) (penta) == penta);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> pentagonalSeries = new ArrayList<Integer>();
        pentagonalSeries.add(1);

        for (int i = 2; i < 10000; i++) {
            for (int j = 1; j < i; j++) {
                int iPenta;
                int jPenta;

                if (pentagonalSeries.size() <= i) {
                    int p = (i * (3 * i - 1)) / 2;
                    if (!pentagonalSeries.contains(p)) pentagonalSeries.add(p);
                }
                iPenta = pentagonalSeries.get(i - 1);
                jPenta = pentagonalSeries.get(j - 1);

                if (isPentagonal(iPenta + jPenta) && isPentagonal(iPenta - jPenta)) {
                    System.out.println(iPenta - jPenta);
                    return;
                }
            }
        }
    }
}
