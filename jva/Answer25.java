package jva;

import java.math.BigInteger;
import java.util.Scanner;

public class Answer25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a long n: ");
        long n = input.nextLong();
        input.close();

        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("0");

        int i = 0;

        while (one.toString().length() < n && two.toString().length() < n) {
            BigInteger temp;
            if (two.compareTo(one) == 1) {
                temp = one;
                one = two;
                two = two.add(temp);
            } else {
                temp = two;
                two = one;
                one = one.add(temp);
            }
            i++;
        }
        
        System.out.println(i + 1);
    }
}
