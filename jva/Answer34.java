package jva;

import java.util.HashMap;
import java.util.Map;

public class Answer34 {
    public static Map<Integer, Long> factorials = new HashMap<Integer, Long>();

    public static long getFactorial(int n) {
        if (factorials.containsKey(n)) return factorials.get(n);

        long fac = getFactorial(n - 1) * n;
        if (!factorials.containsKey(n)) factorials.put(n, fac);
        return fac;
    }

    public static void main(String[] args) {
        factorials.put(0, 1L);

        long sum = 0;
        for (int i = 10; i < 362880; i++) {
            long factorialDigits = 0;
            
            int k = i;
            while (k > 0) {
                int l = k % 10;
                k -= l; 
                k /= 10;

                factorialDigits += getFactorial(l);
            }

            if (factorialDigits == i) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
