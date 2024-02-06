package jva;

import java.util.ArrayList;

public class Answer37 {
    private static ArrayList<Long> primes = new ArrayList<Long>();

    public static boolean isPrime(long n) {
        if (n == 0 || n == 1) return false;
        if (primes.contains(n)) return true;

        for (int k = 0; k < primes.size(); k++) {
            long i = primes.get(k);

            if (n == i) continue;
            if (n % i == 0) return false;
        }
        
        primes.add(n);
        return true;
    }

    public static boolean testForTruncationLeft(long n) {
        if (n < 10) return isPrime(n);
        long truncatedLeft = Long.parseLong(
            Long.toString(n).substring(1));
        
        return isPrime(truncatedLeft) && testForTruncationLeft(truncatedLeft);
    }
    
    public static boolean testForTruncationRight(long n) {
        if (n < 10) return isPrime(n);

        long truncatedRight = Long.parseLong(
            Long.toString(n).substring(
                0, Long.toString(n).length() - 1)
            );

        return isPrime(truncatedRight) && testForTruncationRight(truncatedRight);
    }

    public static void main(String[] args) throws Exception {
        int sum = 0;
        for (long i = 10; i < 800000; i++) {
            if (isPrime(i)) {
                if (!primes.contains(i)) primes.add(i);

                if (testForTruncationLeft(i) && testForTruncationRight(i)) {
                    System.out.println(i);
                    sum += i;
                }
            }
        }

        System.out.println(sum);
    }
}