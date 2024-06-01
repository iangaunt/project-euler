package jva;

import java.util.ArrayList;

public class Answer32 {
    public static boolean isPandigital(String st) {
        if (st.length() != 9) return false;

        for (int i = 1; i <= 9; i++) {
            if (st.indexOf("" + i) == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> products = new ArrayList<Integer>();
        for (int i = 12; i < 98; i++) {
            if (i % 10 == 0 && i % 11 == 0) continue;

            for (int j = 123; j <= 987; j++) {
                if (j % 10 == 0) continue;
                
                int product = i * j;
                if (isPandigital("" + i + j + product) && !products.contains(product)) {
                    System.out.println(i + " : " + j + " : " + product);
                    products.add(product);
                }
            }
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1234; j <= 9876; j++) {
                if (j % 10 == 0) continue;
                
                int product = i * j;
                if (isPandigital("" + i + j + product) && !products.contains(product)) {
                    System.out.println(i + " : " + j + " : " + product);
                    products.add(product);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < products.size(); i++) sum += products.get(i);
        System.out.println(sum);
    }
}
