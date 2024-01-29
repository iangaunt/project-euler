package jva;

import java.util.Scanner;

public class Answer10 {
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

        long sum = 0;
        for (long i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
