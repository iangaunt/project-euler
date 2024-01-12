package jva;

import java.util.Scanner;

public class Answer5 {
    public static long hcf(long a, long b) {
        for (long i = b; i > 1; i--) {
            if (a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a long n: ");
        long n = input.nextLong();
        input.close();

        long product = 1;
        for (int i = 2; i <= n; i++) {
            product = i * product / hcf(product, i);
        }

        System.out.println(product);
    }
}
