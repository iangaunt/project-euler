package jva;

import java.util.Scanner;

public class Answer1 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an integer n: ");

        int n = input.nextInt();
        input.close();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
