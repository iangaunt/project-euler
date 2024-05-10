package jva;

import java.util.ArrayList;
import java.util.Scanner;

public class Answer41 {
    public static ArrayList<Integer> n = new ArrayList<Integer>();
    public static int largest = 0;

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void buildPermutations(ArrayList<Integer> p, String running) {
        if (p.size() == 0) {
            int num = Integer.parseInt(running);
            if (isPrime(num)) {
                largest = Math.max(num, 0);
            }
        }

        for (int i = 0; i < n.size(); i++) {
            int k = p.get(i); 
            p.remove(i);

                buildPermutations(p, running + k);
            p.add(i, k);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an int n: ");
        input.close();

        for (int i = 1; i < 8; i++) {
            n.add(i);
        }

        buildPermutations(n, "");

        System.out.println(largest);
    }
}
