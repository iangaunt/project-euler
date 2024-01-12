package jva;

import java.util.Scanner;

public class Answer6 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a long n: ");
        long n = input.nextLong();
        input.close();

        long sumOfSquares = 0;
        for (int i = 1; i <= n; i++) {
            sumOfSquares += Math.pow(i, 2);
        }
        long squareOfSum = (long) Math.pow((n + 1) * n / 2, 2);

        System.out.println(squareOfSum - sumOfSquares);
    }
}