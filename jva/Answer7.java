package jva;

import java.util.Scanner;

public class Answer7 {
    public static boolean isPrime(long n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a long n: ");
        long n = input.nextLong();
        input.close();

        long counter = 1;
        long curr = 2;

        while (counter <= n) {
            if (isPrime(curr)) {
                counter++;
            }
            curr++;
        }
        System.out.println(curr - 1);
    }
}