package jva;

import java.util.Scanner;

public class Answer39 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a long n: ");
        final long SUM = input.nextLong();
        input.close();

        long greatest = 0;
        long greatestTriples = 0;

        for (long k = 1; k < SUM; k++) {
            int tripleCounter = 0;

            for (double i = 1; i < k / 2; i++) {
                double j = (2 * i * k - k * k) / (2 * i - 2 * k);
                if ((double) (Math.round(j)) != j) continue;
    
                if (i + j + Math.sqrt(i * i + j * j) == k) {
                    System.out.println(i + " : " + j + " : " + (k - i - j));
                    tripleCounter++;
                }
            }

            if (tripleCounter > greatestTriples) {
                greatest = k;
                greatestTriples = tripleCounter;
                System.out.println(k);
            }
        }

        System.out.println(greatest);

        /* 

        for (double i = 1; i < SUM / 2; i++) {
            double j = (2 * i * SUM - SUM * SUM) / (2 * i - 2 * SUM);
            if ((double) (Math.round(j)) != j) continue;

            if (i + j + Math.sqrt(i * i + j * j) == SUM) {
                System.out.println(i + " : " + j + " : " + (SUM - i - j));
                return;
            }
        }

        System.out.println("No triple found.");
        */
    }
}
