package jva;

import java.lang.StringBuilder;

public class Answer145 {
    public static boolean hasOdds(long f) {
        while (f > 0) {
            long k = f % 10; 
            if (k % 2 == 0) return false;

            f -= k;
            f /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        long count = 0;
        final int BILLION = 1000000000;

        for (int i = 1; i < BILLION / 10; i += 2) {
            if (i % 1000000 == 0) System.out.println(i);

            String reversed = new StringBuilder(Integer.toString(i)).reverse().toString();
            if (reversed.charAt(0) == '0') continue;

            long k = i + Long.parseLong(reversed);
            if (k % 2 == 0) continue;

            if (hasOdds(k)) count++;
        }

        System.out.println(count * 2);
    }
}
