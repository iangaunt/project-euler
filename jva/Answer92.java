package jva;

import java.util.HashMap;
import java.util.Map;

public class Answer92 {
    public static Map<Integer, Integer> paths = new HashMap<Integer, Integer>();

    public static int getSquaredDigitSum(int k) {
        int digitSum = 0;
        String t = Integer.toString(k);

        for (int i = 0; i < t.length(); i++) {
            int v = Integer.parseInt(t.substring(i, i + 1));
            digitSum += v * v;
        }

        return digitSum;
    }

    public static int getNextElement(int k) {
        if (k == 1 && k == 89) return k;
        if (paths.containsKey(k)) return paths.get(k);

        int next = getSquaredDigitSum(k);
        int ending = getNextElement(next);
        if (ending == k) return 0;

        paths.put(k, ending);

        return ending;
    }

    public static void main(String[] args) throws Exception {
        paths.put(1, 1);
        paths.put(89, 89);

        int total = 0;
        for (int i = 1; i < 10000000; i++) {
            if (i % 1000000 == 0) System.out.println(i);
            
            if (getNextElement(i) == 89) total++;
        }

        System.out.println(total);
    }
}
