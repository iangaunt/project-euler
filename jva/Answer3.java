package jva;

import java.util.Scanner;

public class Answer3 {
    public static boolean isPrime(int n) {
        for (int i = 2; i < (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an integer n: ");

        long n = input.nextLong();
        long f = n;
        input.close();

        for (int i = 2; i <= (int) Math.ceil(f / 2); i++) {
            if (isPrime(i)) {
                while (n % i == 0) {
                    n /= i;

                    if (n == 1) {
                        return;
                    }
                }
            }
        }
    }
}
