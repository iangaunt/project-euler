package jva;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Answer62 {
    public static String sortDigits(long n) {
        char[] arr = Long.toString(n).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static boolean isCube(long n) {
        for (int i = 1; i <= Math.cbrt(n); i++) {
            if (i * i * i == n) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Integer> digitsCounter = new HashMap<String, Integer>();
        Map<String, Long> cubeMap = new HashMap<String, Long>();

        ArrayList<String> solutions = new ArrayList<String>();

        for (long i = 1; i < 1000000; i++) {
            String digits = sortDigits(i * i * i);

            if (!cubeMap.containsKey(digits)) cubeMap.put(digits, i);

            if (digitsCounter.containsKey(digits)) {
                digitsCounter.put(digits, digitsCounter.get(digits) + 1);
            } else {
                digitsCounter.put(digits, 1);
            }
            
            if (digitsCounter.get(digits) == 5) {
                solutions.add(digits);
            }
        }

        long smallest = Long.MAX_VALUE;
        for (int i = 0; i < solutions.size(); i++) {
            long sol = cubeMap.get(solutions.get(i));

            if (digitsCounter.get(solutions.get(i)) == 5) {
                if (isCube(sol)) smallest = Math.min(smallest, sol);
            }
        }

        System.out.println(smallest);
    }
}
