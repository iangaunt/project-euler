package jva;

import java.io.BufferedReader;
import java.io.FileReader;

public class Answer11 {
    public static long largest = 0;
    public static int[] largestNums;

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("psets/11.txt");
        BufferedReader reader = new BufferedReader(fr);
        
        String c = reader.readLine();
        int[][] grid = new int[20][20];

        int currentRow = 0;

        while (c != null) {
            String[] spl = c.split(" ");
            for (int i = 0; i < spl.length; i++) {
                grid[currentRow][i] = Integer.parseInt(spl[i].charAt(0) == '0' ? spl[i].substring(1) : spl[i]);
            }
            currentRow++;
            c = reader.readLine();
        }
        reader.close();

        for (int i = 3; i < grid.length - 3; i++) {
            for (int j = 3; j < grid[i].length - 3; j++) {
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (k == 0 && l == 0) continue;

                        int[] numbers = {grid[i][j], grid[i + k][j + l], grid[i + 2 * k][j + 2 * l], grid[i + 3 * k][j + 3 * l]};
                        checkProduct(numbers);
                    }
                }
            }
        }

        System.out.println(largest);
        System.out.println("{" + largestNums[0] + ", " + largestNums[1] + ", " + largestNums[2] + ", " + largestNums[3] + "}");
    }

    public static void checkProduct(int[] nums) {
        long prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
        }

        largest = Math.max(prod, largest);
        if (largest == prod) largestNums = nums;
    }
}

