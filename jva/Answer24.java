package jva;

import java.util.ArrayList;
import java.util.Scanner;

public class Answer24 {
    public static ArrayList<Integer> n = new ArrayList<Integer>();

    public static int count = 0;
    public static int upperBound = 0;

    public static boolean rec = true;

    public static void buildPermutations(ArrayList<Integer> p, String running) {
        if (!rec) return;
        
        if (n.size() == 0) count++;
        if (count == upperBound) {
            System.out.println(running);
            rec = false;
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
        upperBound = input.nextInt();
        input.close();

        for (int i = 0; i < 10; i++) {
            n.add(i);
        }

        buildPermutations(n, "");
    }
}
