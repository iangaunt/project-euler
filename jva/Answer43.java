package jva;

import java.math.BigInteger;
import java.util.ArrayList;

public class Answer43 {
    public static ArrayList<Integer> n = new ArrayList<Integer>();
    public static int[] primes = {2, 3, 5, 7, 11, 13, 17};

    public static BigInteger count = new BigInteger("0");

    public static void buildPermutations(ArrayList<Integer> p, String running) {
        if (n.size() == 0) {
            int starting = 1;

            for (int i = 0; i < primes.length; i++) {
                String sub = running.substring(starting, starting + 3);
                if (Integer.parseInt(sub) % primes[i] != 0) return;
                starting++;
            }

            count = count.add(new BigInteger(running));
            System.out.println(running);
            return;
        }

        for (int i = 0; i < n.size(); i++) {
            int k = p.get(i); 
            p.remove(i);

                buildPermutations(p, running + k);
            p.add(i, k);
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            n.add(i);
        }

        buildPermutations(n, "");
        System.out.println(count);
    }
}