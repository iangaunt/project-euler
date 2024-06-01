package jva;

public class Answer58 {
    public static boolean isPrime(long n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int primes = 0;
        int total = 1;

        for (int i = 3; i < 100000; i += 2) {
            int sq = i * i;
            for (int j = 0; j < 4 * (i - 1); j += (i - 1)) {
                total++;
                if (isPrime(sq - j)) primes++;
            } 

            double q = (double) (primes) / total;
            System.out.println(i + " : " + q);

            if (q <= 0.1) {
                System.out.println(i);
                break;
            }
        }
    }
}
