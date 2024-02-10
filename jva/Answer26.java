package jva;

import java.math.BigInteger;

public class Answer26 {
    public static int decimalPart(int size, int divisor) {
        if (size == 1000) return 0;

        String zeroes = "";
        for (int i = 0; i < size; i++) zeroes += "0";

        BigInteger b = new BigInteger("1" + zeroes);
        b = b.divide(new BigInteger(Integer.toString(divisor)));

        String v = b.toString();

        String firstHalf = v.substring(0, v.length() / 2);
        String secondHalf = v.substring(v.length() / 2);

        if (firstHalf.equals(secondHalf)) {
            return v.length() / 2;
        } else {
            return decimalPart(size + 1, divisor);
        }
    }

    public static boolean isPrime(long n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int largest = 0;
        int largestSubstring = 0;

        for (int i = 1; i < 1000; i++) {
            if (isPrime(i)) {
                int d = decimalPart(1, i);
                if (d > largestSubstring) {
                    largest = i;
                    largestSubstring = d;
                }
            }
        }

        System.out.println(largest);
    }
}
