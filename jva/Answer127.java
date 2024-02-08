package jva;

import java.util.ArrayList;

public class Answer127 {
    public static ArrayList<Double> primes = new ArrayList<Double>();

    public static boolean isPrime(double n) {
        if (primes.contains(n)) return true;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        primes.add(n);
        return true;
    }

    public static double gcf(double a, double b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static boolean getRadical(double n, double bound) {
        double prod = 1.0;
        for (int i = 2; i < (int) Math.sqrt(n); i++) {
            if (isPrime(i) && n % i == 0) prod *= i;
            if (bound <= prod) return false;
        }
        return prod < bound;
    }

    public static boolean checkIfAnyPrimes(double a, double b, double c) {
        return isPrime(a) || isPrime(b) || isPrime(c);
    }

    public static boolean checkIfAnySquares(double a, double b, double c) {
        return (
            Math.sqrt(a) == (int) (Math.sqrt(a)) ||
            Math.sqrt(b) == (int) (Math.sqrt(b)) ||
            Math.sqrt(c) == (int) (Math.sqrt(c)) 
        );
    }

    public static void main(String[] args) throws Exception {
        double sum = 0.0;

        for (double c = 2; c < 1000; c++) {
            for (double a = 2; a < c / 2; a++) {
                double b = c - a;
                if (!checkIfAnyPrimes(a, b, c) && !checkIfAnySquares(a, b, c)) continue;
                if (gcf(a, b) > 1 || gcf(a, c) > 1) continue;
                
                if (getRadical(a * b * c, c)) {
                    System.out.println(a + " : " + b + " : " + c);
                    sum += c;
                } 
            }
        }
        System.out.println(sum);
    }
}
