package jva;

import java.math.BigInteger;
import java.util.Scanner;

public class Answer16 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an int n: ");
        int n = input.nextInt();
        input.close();

        BigInteger two = BigInteger.TWO;
        BigInteger power = two.pow(n);

        String p = power.toString();
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            sum += Integer.parseInt(p.substring(i, i + 1));
        }
        
        System.out.println(sum);
    }
}
