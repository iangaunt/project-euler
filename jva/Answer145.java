package jva;

import java.lang.StringBuilder;

public class Answer145 {
    public static final String[] odds = {"2", "4", "6", "8", "0"};;

    public static boolean hasOdds(long f) {
        String s = Long.toString(f);
        for (int i = 0; i < odds.length; i++) {
            if (s.indexOf(odds[i]) != -1) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        long count = 0;

        for (int i = 1; i < 1000000000; i++) {
            if (i % 100000000 == 0) System.out.println(i);

            String reversed = new StringBuilder(Integer.toString(i)).reverse().toString();
            if (reversed.charAt(0) == '0') continue;

            long k = i + Long.parseLong(reversed);
            if (hasOdds(k)) count++;
        }

        System.out.println(count);
    }
}
