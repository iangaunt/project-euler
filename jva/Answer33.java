package jva;

import java.util.ArrayList;

public class Answer33 {
    public static void main(String[] args) throws Exception {
        int n = 100;

        ArrayList<Integer> numerators = new ArrayList<Integer>();
        ArrayList<Integer> denominators = new ArrayList<Integer>();

        for (int i = 10; i < n; i++) {
            for (int j = 10; j < n; j++) {
                if (i % 10 == 0 && j % 10 == 0) continue;
                if (i % 11 == 0 && j % 11 == 0) continue;

                double frac = (double) (i) / j;

                if (frac >= 1) continue;
                if (i % 10 != (j - j % 10) / 10) continue;

                int f = i;
                f -= f % 10;
                f /= 10;

                int g = j % 10;

                double fracCut = (double) (f) / g;
                if (frac == fracCut) {
                    System.out.println(i + "/" + j + " : " + f + "/" + g);
                    numerators.add(i);
                    denominators.add(j);
                }
            }
        }

        long num = 1;
        long denom = 1;

        for (int i : numerators) {
            num *= i;
        }

        for (int j : denominators) {
            denom *= j;
        }

        System.out.println(num + " / " + denom);
    }
}
