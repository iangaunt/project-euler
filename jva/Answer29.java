package jva;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Answer29 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an int a: ");
        int a = input.nextInt();
        input.nextLine();

        System.out.println("Input an int b: ");
        int b = input.nextInt();
        input.close();

        ArrayList<String> numbers = new ArrayList<String>();
        for (int i = 2; i <= a; i++) {
            for (int j = 2; j <= b; j++) {
                BigInteger iB = new BigInteger(Integer.toString(i));
                iB = iB.pow(j);

                if (!numbers.contains(iB.toString())) {
                    numbers.add(iB.toString());
                }
            }
        }

        System.out.println(numbers.size());
    }
}
