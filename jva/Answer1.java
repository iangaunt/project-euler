package jva;

import java.util.Scanner;

public class Answer1 {
    public static int sumsOfMultiples(int n, int mod) {
        return (n / mod) * (n / mod + 1) / 2;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an integer n: ");

        int n = input.nextInt();
        input.close();

        System.out.println(3 * sumsOfMultiples(n, 3) + 5 * sumsOfMultiples(n, 5) - 15 * sumsOfMultiples(n, 15) - n);
    }
}
