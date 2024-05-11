package jva;

import java.util.ArrayList;

public class Answer50 {
    public static ArrayList<Long> primes = new ArrayList<Long>();

    public static boolean isPrime(long n, boolean add) {
        if (primes.contains(n)) return true;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        if (add) primes.add(n);
        return true;
    }

    public static void main(String[] args) throws Exception {
        long sum = 0;
        
        for (int i = 2; i < 4000; i++) {
            if (isPrime(i, true)) sum += i;
        }

        long[][] memo = new long[primes.size()][primes.size()];
        memo[0][0] = sum;

        System.out.println("size: " + primes.size());

        long most = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j <= i - 1; j++) {
                long sub = memo[i - 1][j] - primes.get(primes.size() - i + j);
                memo[i][j] = sub;
                if (isPrime(sub, false) && sub < 1000000) most = Math.max(most, sub);
            }

            long sub = memo[i - 1][i - 1] - primes.get(i - 1);
            memo[i][i] = sub;
            if (isPrime(sub, false) && sub < 1000000) most = Math.max(most, sub);
        }

        for (int i = 0; i < 10; i++) {
            String k = "";
            for (int j = 0; j < 10; j++) {
                k += memo[i][j] + " ";
            }
            System.out.println(k);
        }

        System.out.println(most);
    }
}
