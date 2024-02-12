package jva;

import java.util.ArrayList;

/* this solution sucks very hard but i do not know a more efficient method */

public class Answer23 {
    public static ArrayList<Integer> abundants = new ArrayList<Integer>();
    public static ArrayList<Integer> possibleSums = new ArrayList<Integer>();

    public static int findSumOfFactors(int n) {
        double sum = 0;
        for (double i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != Math.sqrt(n)) sum += n / i;
            }
        }
        sum -= n;

        return (int) (sum);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Long> values = new ArrayList<Long>();
        for (long i = 1; i <= 28123; i++) values.add(i);

        for (int i = 0; i < 28123; i++) {
            if (i % 1000 == 0) System.out.println(i);
            if (findSumOfFactors(i) > i) {
                abundants.add(i);
                for (int j = 0; j < abundants.size(); j++) {
                    values.remove((long) (abundants.get(j) + i));
                }
            }
        }

        System.out.println(values.size());
        long k = 0;
        for (int i = 0; i < values.size(); i++) {
            k += values.get(i);
        }
        System.out.println(k);
    }
}
