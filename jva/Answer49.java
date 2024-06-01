package jva;

import java.util.Arrays;

public class Answer49 {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPermutation(int a, int b) {
        char[] ac = String.valueOf(a).toCharArray();
        char[] bc = String.valueOf(b).toCharArray();

        Arrays.sort(ac);
        Arrays.sort(bc);

        return new String(ac).equals(new String(bc));
    }

    public static void main(String[] args) throws Exception {
        for (int i = 1000; i < 3300; i++) {
            if (isPrime(i)) {
                if (isPermutation(i, i + 3330) && isPermutation(i, i + 6660) && 
                    isPrime(i + 3330) && isPrime(i + 6660)) {
                    System.out.println(i + " : " + (i + 3330) + " : " + (i + 6660));
                }
            }
        }
    }
}
