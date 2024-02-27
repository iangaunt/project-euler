package jva;

public class Answer27 {
    public static boolean isPrime(long n) {
        if (n < 0) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        long highest = 0;
        long product = 0;

        for (long a = -1000; a < 1000; a++) {
            for (long b = -1000; b <= 1000; b++) {
                long n = 0;
                while (isPrime(n * n + a * n + b)) n++;

                if (n > highest) {
                    highest = n;
                    product = a * b;

                    System.out.println(a + " : " + b);
                }
            }
            
            if (a % 100 == 0) System.out.println(a);
        }

        System.out.println(product);
    }
}
