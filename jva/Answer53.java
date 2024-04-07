package jva;

import java.util.List;
import java.util.ArrayList;

public class Answer53 {
    static int millionCounter = 0;
    
    public static void main(String[] args) throws Exception {
        List<List<Integer>> pascal = generate(101);
        int millionCounter = 0;

        for (int i = 0; i < pascal.size(); i++) {
            for (int j = 0; j < pascal.get(i).size(); j++) {
                if (pascal.get(i).get(j) >= 1000000) {
                    millionCounter += pascal.get(i).size() - 2 * j;;
                    break;
                }
            }
        }

        System.out.println(millionCounter);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            pascal.add(getRow(i));
        }

        return pascal;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> memo = new ArrayList<Integer>();
        memo.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> copy = new ArrayList<Integer>();
            copy.add(1);

            for (int j = 1; j < i; j++) {
                copy.add(memo.get(j) + memo.get(j - 1));
            }

            copy.add(1);
            memo = copy;
        }
        return memo;
    }
}
