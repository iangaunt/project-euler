package jva;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Answer14 {
    public static Map<Long, Long> m;

    public static long collatz(long i) {
        if (i == 1) return 1;
        if (m.containsKey(i)) return 1 + m.get(i);

        long count = 0;
        if (i % 2 == 0) {
            count = collatz(i / 2);
        } else {
            count = collatz(3 * i + 1);
        }

        m.put(i, count);
        return count;
    }

    public static void main(String[] args) throws Exception {
        m = new HashMap<Long, Long>();
        m.put(1L, 1L);

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

        System.out.println(largest);
    }
}
