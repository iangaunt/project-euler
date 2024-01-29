package jva;

import java.io.FileReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Answer22 {
    
    public static void main(String[] args) throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<String>();
        FileReader fr = new FileReader("psets/22.txt");

        int c = fr.read();
        String currentName = "";
        while (c != -1) {
            char ch = (char) c;
            if (ch == '"') {
                queue.add(currentName);
                currentName = "";
            } else if (Character.isAlphabetic(ch)) {
                currentName += ch;
            }
            c = fr.read();
        }
        fr.close();

        while (queue.peek().length() < 1) queue.remove();

        BigInteger sum = new BigInteger("0");
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int count = 1;
        while (!queue.isEmpty()) {
            String name = queue.remove();
            long nameSum = 0;

            for (int i = 0; i < name.length(); i++) {
                nameSum += letters.indexOf(name.charAt(i)) + 1;
            }
            
            sum = sum.add(new BigInteger(Long.toString(nameSum * count)));
            count++;
        }
        System.out.println(sum);
    }
}
