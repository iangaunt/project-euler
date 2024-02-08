package jva;

import java.util.ArrayList;

public class Answer45 {
    public static ArrayList<Long> triangular = new ArrayList<Long>();
    public static ArrayList<Long> pentagonal = new ArrayList<Long>();
    public static ArrayList<Long> hexagonal = new ArrayList<Long>();

    public static void main(String[] args) throws Exception {
        for (long i = 0; i < 100000; i++) {
            long tri = i * (i + 1) / 2;

            triangular.add(tri);
            pentagonal.add(i * (3 * i - 1) / 2);
            hexagonal.add(i * (2 * i - 1));

            if (pentagonal.contains(tri)) {
                if (hexagonal.contains(tri)) {
                    System.out.println(i + " : " + tri);
                }
            }
        }
    }
}
