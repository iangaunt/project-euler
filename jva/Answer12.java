package jva;

import java.util.Scanner;

public class Answer12 {
    public static int countDivisors(long n) {
        int divisorCount = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) divisorCount += (i == Math.sqrt(n) ? 1 : 2);
        }

        return divisorCount;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a long n: ");
        long n = input.nextLong();
        input.close();

        long counter = 2;
        long tri = 1;

        while (tri < Long.MAX_VALUE - 1) {
            tri += counter;
            counter++;

            if (countDivisors(tri) > n) {
                System.out.println(tri);
                break;
            }
        }
    }
}
