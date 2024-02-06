package jva;

public class Answer40 {
    public static String fraction;

    public static void main(String[] args) {
        int pow = 0;
        int product = 1;
        long current = 1;

        fraction = "";

        while (pow < 6) {
            fraction += current;
            current++;

            if (fraction.length() >= Math.pow(10, pow)) {
                int index = (int) (Math.pow(10, pow) - 1);
                product *= Integer.parseInt(fraction.substring(index, index + 1));
                pow++;
                
                System.out.println(product);
            }
        }
    }
}
