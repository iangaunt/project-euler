package jva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Answer67 {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("psets/67.txt");
        BufferedReader reader = new BufferedReader(fr);

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        
        String c = reader.readLine();
        while (c != null) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            String[] nums = c.split(" ");

            for (String num : nums) {
                row.add(Integer.parseInt(num));
            }

            triangle.add(row);
            c = reader.readLine();
        }

        for (int i = triangle.size() - 2; i > -1; i--) {
            ArrayList<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) { 
                row.set(j, row.get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        System.out.println(triangle);

        System.out.println(triangle.get(0).get(0));
        reader.close();
    }
}
