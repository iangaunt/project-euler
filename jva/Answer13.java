package jva;

import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.FileReader;

public class Answer13 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("psets/13.txt");
        BufferedReader reader = new BufferedReader(fr);
        
        String c = reader.readLine();
        BigInteger i = null;

        while (c != null) {
            if (i == null) {
                i = new BigInteger(c);
            } else {
                i = i.add(new BigInteger(c));
            }
            c = reader.readLine();
        }

        reader.close();
        System.out.println(i.toString().substring(0, 10));
    }
}
