package jva;

import java.lang.StringBuffer;
import java.math.BigInteger;

public class Answer55 {
    public static void main(String[] args) throws Exception {
        int lychrel = 0;

        for (int i = 0; i < 10000; i++) {
            BigInteger num = new BigInteger(Integer.toString(i));
            
            boolean isLychrel = true;
            for (int j = 0; j < 50; j++) {
                StringBuffer sb = new StringBuffer(num.toString());
                num = num.add(new BigInteger(sb.reverse().toString()));

                if (new StringBuffer(num.toString()).reverse().toString().equals(num.toString())) {
                    isLychrel = false;
                    break;
                }
            }

            if (isLychrel) lychrel++;
        }

        System.out.println(lychrel);
    }
}
