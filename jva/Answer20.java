package jva;

import java.math.BigInteger;
import java.util.Scanner;

public class Answer20 {
    public static void main (String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an int n: ");
        int n = input.nextInt();
        input.close();

        BigInteger fac = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            BigInteger v = new BigInteger(Integer.toString(i));
            fac = fac.multiply(v);
        }

        long sum = 0;
        String value = fac.toString();
        for (int i = 0; i < value.length(); i++) {
            sum += Integer.parseInt(value.substring(i, i + 1));
        }

        System.out.println(sum);
    }
}
