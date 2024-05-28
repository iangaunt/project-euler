package jva;

import java.util.Arrays;

public class Answer52 {
    public static String sortNumber(String k) {
        char[] t = k.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }

    public static void main(String[] args) throws Exception {
        for (long i = 125874; i < Long.MAX_VALUE; i++) {
            String sort = sortNumber(Long.toString(i));

            boolean working = true;
            for (int j = 1; j <= 6; j++) {
                if (!sortNumber(Long.toString(i * j)).equals(sort)) {
                    working = false;
                    break;
                }
            }

            if (working) {
                System.out.println(i);
                return;
            }
        }
    }
}
