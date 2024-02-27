package jva;

import java.math.BigInteger;
import java.util.ArrayList;

// https://math.stackexchange.com/questions/124408/finding-a-primitive-root-of-a-prime-number
// Using Euler's totient function to find primitive roots of prime numbers under 1000

public class Answer26 {
    public static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static boolean isPrime(int n) {
        if (primes.contains(n)) return true;

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        if (!primes.contains(n)) primes.add(n);
        return true;
    }

    public static ArrayList<Integer> getPrimeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 1; i < primes.size(); i++) {
            if (n % primes.get(i) == 0) factors.add(i);
        }
        return factors;
    }

    public static void main(String[] args) throws Exception {
        int largest = 0;

        for (int i = 0; i < 1000; i++) {
            if (isPrime(i)) {
                BigInteger bigI = new BigInteger(Integer.toString(i));

                int s = i - 1;
                boolean primitiveRoot = true;

                ArrayList<Integer> factors = getPrimeFactors(s);

                for (int j = 0; j < factors.size(); j++) {
                    if (factors.get(j) == 1) continue;

                    BigInteger a = new BigInteger("10");
                    a = a.pow(s / factors.get(j));
                    
                    if (Integer.parseInt(a.mod(bigI).toString()) == 1) {
                        primitiveRoot = false;
                        break;
                    }
                }

                if (primitiveRoot && largest < i) {
                    largest = i;
                }
            }
        }

        System.out.println(largest);
    }
}
