package jva;

import java.io.FileReader;
import java.util.ArrayList;

public class Answer42 {
    static ArrayList<Integer> triangles;
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws Exception {
        triangles = new ArrayList<Integer>();
        for (int i = 1; i < 20; i++) {
            triangles.add(i * (i + 1) / 2);
        }

        System.out.println(triangles);

        FileReader fr = new FileReader("psets/42.txt");

        int triangleWords = 0;

        int c = fr.read();
        String currentName = "";
        while (c != -1) {
            if (c != ',') {
                char ch = (char) c;
                if (ch == '"' && currentName != "") {
                    triangleWords += isTriangleWord(currentName);
                    currentName = "";
                } else if (Character.isAlphabetic(ch)) {
                    currentName += ch;
                }
            }
            c = fr.read();
        }
        fr.close();

        System.out.println(triangleWords);
    }

    public static int isTriangleWord(String k) {
        k = k.toLowerCase();
        int count = 0;

        for (int i = 0; i < k.length(); i++) {
            count += alphabet.indexOf(k.charAt(i)) + 1;
        }
        System.out.println(k + " : " + count);

        return triangles.contains(count) ? 1 : 0;
    }
}