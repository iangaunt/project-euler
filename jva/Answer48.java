package jva;

import java.math.BigInteger;

public class Answer48 {
    public static void main(String[] args) throws Exception {
        BigInteger n = new BigInteger("1");
        for (int i = 2; i <= 1000; i++) {
            n = n.add(new BigInteger(Integer.toString(i)).pow(i));
        }

        String num = n.toString();
        System.out.println(num.substring(num.length() - 10));
    }
}
