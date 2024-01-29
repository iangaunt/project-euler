package jva;

import java.util.Scanner;

public class Answer28 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an int n: ");
        int n = input.nextInt();
        input.close();

        if (n % 2 != 1) {
            System.out.println("N is not odd.");
            return;
        }

        long sum = 1;
        for (int i = 3; i <= n; i += 2) {
            sum += Math.pow(i, 2);
            long mod = (long) (Math.pow(i - 2, 2)) + i - 1;
            sum += mod;

            for (int j = 0; j <= 1; j++) {
                mod += i - 1;
                sum += mod;
            }
        }

        System.out.println(sum);
    }
}