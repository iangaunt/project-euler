package jva;

import java.util.Scanner;

public class Answer8 {
    public static long findProductOfString(String n) {
        long product = 1;
        for (int i = 0; i < n.length(); i++) {
            product *= Integer.parseInt(n.substring(i, i + 1));
            if (product == 0) return 0;
        }

        return product;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Input a string of digits: ");
        String digits = input.nextLine();

        System.out.println("Input the amount of digits in a row to check: ");
        int count = input.nextInt();

        input.close();

        long max = 0;
        String best = "";
        
        for (int i = 0; i < digits.length() - count; i++) {
            String cut = digits.substring(i, i + count);
            if (cut.indexOf("0") > -1) {
                i += cut.indexOf("0") + 1;
                continue;
            }

            long product = findProductOfString(cut);
            max = product > max ? product : max;
            if (max == product) best = cut;
        }

        System.out.println(max + " : " + best);
    }
}