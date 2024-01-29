package jva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Answer21 {
    public static Map<Integer, ArrayList<Integer>> factorSumPairs;

    public static int sumOfFactors(int n) {
        int sum = 0;
        for (double i = 1.0; i < n; i++) {
            if ((double) (n) % i == 0.0) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        factorSumPairs = new HashMap<Integer, ArrayList<Integer>>();

        Scanner input = new Scanner(System.in);
        System.out.println("Input an int n: ");
        int n = input.nextInt();
        input.close();

        ArrayList<Integer> amicables = new ArrayList<Integer>();
        
        for (int i = 1; i <= n; i++) {
            int iFacSum = sumOfFactors(i);
            
            ArrayList<Integer> nums;
            if (factorSumPairs.containsKey(iFacSum)) {
                nums = factorSumPairs.get(iFacSum);
            } else {
                nums = new ArrayList<Integer>();
            }
            nums.add(i);
            factorSumPairs.put(iFacSum, nums);

            if (factorSumPairs.containsKey(i) && factorSumPairs.get(i).contains(iFacSum) && i != iFacSum) {
                System.out.println(i + " : " + iFacSum);
                if (!amicables.contains(i)) amicables.add(i);
                if (!amicables.contains(iFacSum)) amicables.add(iFacSum);
            }
        }

        Collections.sort(amicables);

        System.out.println("--");
        long sum = 0;
        for (int i = 0; i < amicables.size(); i++) {
            sum += amicables.get(i);
        }
        System.out.println(sum);
    }
}
