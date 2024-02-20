package jva;

import java.util.ArrayList;

public class Answer46 {
    public static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static ArrayList<Integer> squares = new ArrayList<Integer>();

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isSquare(int n) {
        double k = Math.sqrt(n);
        return (int) (k) == k;
    }

    public static void main(String[] args) throws Exception {
        for (int n = 1; n < Integer.MAX_VALUE; n++) {
            if (isSquare(n)) {
                squares.add(n);
            }

            if (n % 2 == 0) continue;

            if (isPrime(n)) {
                primes.add(n);
                continue;
            }

            boolean sumFound = false;
            for (int i = 0; i < primes.size(); i++) {
                if (sumFound) break;

                for (int j = 0; j < squares.size(); j++) {
                    int p = primes.get(i);
                    int q = 2 * squares.get(j);

                    if (p + q == n) {
                        sumFound = true;
                    }
                }
            }

            if (!sumFound) {
                System.out.println(n);
                // System.out.println(squares);
                // System.out.println(primes);
                return;
            }
        }
    }
}
