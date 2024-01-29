package jva;

import java.util.Scanner;

public class Answer30 {
    public static int fifthPowerOfDigits(int n) {
        int sum = 0;
        String str = Integer.toString(n);

        for (int i = 0; i < str.length(); i++) {
            sum += Math.pow(Integer.parseInt(str.substring(i, i + 1)), 5);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an int n: ");
        int n = input.nextInt();
        input.close();

        int sum = 0;
        for (int i = 10; i < n; i++) {
            if (i == fifthPowerOfDigits(i)) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
