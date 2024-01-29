package jva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Answer17 {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> numbers = new HashMap<Integer, String>();
        numbers.put(1000, "onethousand");
        numbers.put(900, "ninehundred");
        numbers.put(800, "eighthundred");
        numbers.put(700, "sevenhundred");
        numbers.put(600, "sixhundred");
        numbers.put(500, "fivehundred");
        numbers.put(400, "fourhundred");
        numbers.put(300, "threehundred");
        numbers.put(200, "twohundred");
        numbers.put(100, "onehundred");

        numbers.put(90, "ninety");
        numbers.put(80, "eighty");
        numbers.put(70, "seventy");
        numbers.put(60, "sixty");
        numbers.put(50, "fifty");
        numbers.put(40, "forty");
        numbers.put(30, "thirty");
        numbers.put(20, "twenty");

        numbers.put(19, "nineteen");
        numbers.put(18, "eighteen");
        numbers.put(17, "seventeen");
        numbers.put(16, "sixteen");
        numbers.put(15, "fifteen");
        numbers.put(14, "fourteen");
        numbers.put(13, "thirteen");
        numbers.put(12, "twelve");
        numbers.put(11, "eleven");

        numbers.put(10, "ten");
        numbers.put(9, "nine");
        numbers.put(8, "eight");
        numbers.put(7, "seven");
        numbers.put(6, "six");
        numbers.put(5, "five");
        numbers.put(4, "four");
        numbers.put(3, "three");
        numbers.put(2, "two");
        numbers.put(1, "one");

        ArrayList<Integer> numberOrder = new ArrayList<Integer>();
        for (int key : numbers.keySet()) {
            numberOrder.add(key);
        }

        Collections.sort(numberOrder);
        Collections.reverse(numberOrder);

        long charSum = 0;
        for (int i = 1; i <= 1000; i++) {
            int n = i;
            String f = "";

            while (n > 0) {
                for (int j = 0; j < numberOrder.size(); j++) {
                    if (n >= numberOrder.get(j)) {
                        int s = numberOrder.get(j);

                        n -= s;
                        f += numbers.get(s);

                        if (n + s > 100 && i % 100 != 0) f += "and";
                        break;
                    }
                }
            }

            charSum += f.length();
            System.out.println(f);
        }

        System.out.println(charSum);
    }
}
