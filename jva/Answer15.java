package jva;

import java.math.BigInteger;
import java.util.Scanner;

public class Answer15 {
    public static BigInteger factorial(BigInteger n) {
        if (n.intValue() == 0 || n.intValue() == 1 ) {
            BigInteger one = new BigInteger("1");
            return one;
        }

        return n.multiply(factorial(new BigInteger(Integer.toString(n.intValue() - 1))));
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a long m: ");
        long m = input.nextLong();
        input.nextLine();
        
        System.out.println("Input a long n: ");
        long n = input.nextLong();
        input.close();

        BigInteger mFac = factorial(new BigInteger(Long.toString(m)));
        BigInteger nFac = factorial(new BigInteger(Long.toString(n)));
        BigInteger mnFac = factorial(new BigInteger(Long.toString(m + n)));

        System.out.println(mnFac.divide(mFac.multiply(nFac)));
    }
}
