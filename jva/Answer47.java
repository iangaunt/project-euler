package jva;

import java.util.ArrayList;

public class Answer47 {
    public static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int countPrimeFactors(int n) {
        int amount = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (n % primes.get(i) == 0) amount++;
        }
        return amount;
    }

    public static String outputPrimeFactors(int n) {
        String k = "";
        for (int i = 0; i < primes.size(); i++) {
            if (n % primes.get(i) == 0) k += primes.get(i) + ", ";
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        int streak = 0;
        int startOfStreak = 0;

        for (int i = 2; i < Long.MAX_VALUE; i++) {
            if (isPrime(i)) {
                primes.add(i);
                streak = 0;
                continue;
            }

            int primeFactors = countPrimeFactors(i);
            if (primeFactors == 4) {
                if (streak == 0) {
                    startOfStreak = i;
                }
                streak++;
                if (streak == 4) {
                    for (int k = startOfStreak; k < startOfStreak + 4; k++){
                        System.out.println(k + ": " + outputPrimeFactors(k));
                    }
                    break;
                }
            } else {
                streak = 0;
            }
        }
    }
}
