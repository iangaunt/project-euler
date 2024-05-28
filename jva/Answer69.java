package jva;

import java.util.ArrayList;

public class Answer69 {
    public static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static boolean isPrime(int n) {
        if (n == 0) return false;
        if (primes.contains(n)) return true;

        for (int k = 0; k < primes.size(); k++) {
            int i = primes.get(k);
            if (i == 1) continue;

            if (n % i == 0) return false;
        }
        
        primes.add(n);
        return true;
    }

    public static double calculateTotient(int n) {
        double totient = n;

        for (int i = 1; i < primes.size(); i++) {
            int p = primes.get(i);
            
            if (p > n) return totient;

            if (n % p == 0) totient *= (1.0 - (1.0 / p));
        }

        return totient;
    }

    public static void main(String[] args) {
        primes.add(1);
        
        double maxTotient = 0.0;
        int max = 0;

        // Alternative solution with brute force, which is not that efficient (~30 seconds)
        /*
        for (int i = 2; i <= 1000000; i++) {
            if (i % 100000 == 0) System.out.println(i);
            double tot = 0.0;
            
            if (isPrime(i)) {
                tot = (double) (i) / (i - 1);
            } else {
                double t = calculateTotient(i);
                tot = i / t;
            }

            if (tot > maxTotient) {
                max = i;
                maxTotient = tot;
            }
        }
        */

        // Simpler algorithm which multiplies smallest prime factors up until ceiling
        // thanks to the way that the totient is calculated 
        int prod = 1;
        for (int i = 1; i < 10000; i++) {
            if (isPrime(i)) {
                if (prod > 100000) {
                    break;
                } else {
                    prod *= i;
                }
            }
        }

        System.out.println(prod);
    }
}
