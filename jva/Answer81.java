package jva;

import java.io.FileReader;
import java.io.BufferedReader;

public class Answer81 {
    public static void main(String[] args) throws Exception {
        long[][] grid = new long[80][80];

        FileReader fr = new FileReader("psets/81.txt");
        BufferedReader reader = new BufferedReader(fr);
        
        String c = reader.readLine();
        int f = 0;
        while (c != null) {
            String[] arr = c.split(",");
            for (int i = 0; i < arr.length; i++) {
                grid[f][i] = Long.parseLong(arr[i]);
            }
            f++;
            c = reader.readLine();
        }
        reader.close();

        long[][] memo = new long[grid.length][grid[0].length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = 0;
            }
        }

        memo[0][0] = grid[0][0];

        for (int k = 1; k < grid.length + grid[0].length - 1; k++) {
            for (int i = 0; i <= k; i++) {
                int j = k - i;
                
                long top = checkIfValid(grid, i, j - 1) ? memo[i][j - 1] : Integer.MAX_VALUE - 200;
                long left = checkIfValid(grid, i - 1, j) ? memo[i - 1][j] : Integer.MAX_VALUE - 200;

                if (checkIfValid(grid, i, j)) {
                    memo[i][j] = Math.min(top + grid[i][j], left + grid[i][j]);
                }
            }
        }

        System.out.println(memo[grid.length - 1][grid[0].length - 1]);
    }

    public static boolean checkIfValid(long[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
