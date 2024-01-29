package jva;

import java.util.Scanner;

public class Answer9 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a long n: ");
        final long SUM = input.nextLong();
        input.close();

        for (double i = 1; i < SUM / 2; i++) {
            double j = (2 * i * SUM - SUM * SUM) / (2 * i - 2 * SUM);
            if ((double) (Math.round(j)) != j) continue;

            if (i + j + Math.sqrt(i * i + j * j) == SUM) {
                System.out.println(i + " : " + j + " : " + (SUM - i - j));
                return;
            }
        }

        System.out.println("No triple found.");
    }
}
