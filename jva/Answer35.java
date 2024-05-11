package jva;

import java.util.ArrayList;

public class Answer35 {
    public static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        if (primes.contains(n)) return true;

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        if (!primes.contains(n)) primes.add(n);
        return true;
    }

    public static boolean checkRotations(int n) {
        String st = Integer.toString(n);

        for (int i = 0; i < st.length(); i++) {
            char k = st.charAt(st.length() - 1);
            st = k + st.substring(0, st.length() - 1);

            if (!isPrime(Integer.parseInt(st))) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        int max = 1000000;
        int circular = 0;

        for (int i = 1; i <= max; i += 2) {
            if (checkRotations(i)) {
                System.out.println(i);
                circular++;
            }
        }

        System.out.println(circular);
    }
}
