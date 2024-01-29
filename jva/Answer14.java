package jva;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Answer14 {
    public static Map<Long, Long> memo;

    public static long collatz(long n) {
        if (memo.containsKey(n)) return memo.get(n);

        long count = 0;
        if (n % 2 == 0) count = 1 + collatz(n / 2);
        if (n % 2 == 1) count = 1 + collatz(3 * n + 1);

        memo.put(n, count);
        return count;
    }

    public static void main(String[] args) throws Exception {
        memo = new HashMap<Long, Long>();
        memo.put(1L, 1L);

        Scanner input = new Scanner(System.in);
        System.out.println("Input a long n: ");
        long n = input.nextLong();
        input.close();

        long largest = 0;
        long largestCollatz = 0;

        for (long i = 1; i < n; i++) {
            long c = collatz(i);
            if (largestCollatz < c) {
                largest = i;
                largestCollatz = c;
            }
        }

        System.out.println(largest + " : " + largestCollatz);
    }
}
