package jva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class TriangleNode {
    public int value;
    public TriangleNode left;
    public TriangleNode right;

    public TriangleNode(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}

public class Answer17 {
    public static int getMaximumPath(TriangleNode n, int sum) {
        if (n.left == null || n.right == null) return sum + n.value;
        return Math.max(getMaximumPath(n.left, sum + n.value), getMaximumPath(n.right, sum + n.value));
    }

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("psets/17.txt");
        BufferedReader reader = new BufferedReader(fr);

        ArrayList<ArrayList<TriangleNode>> tree = new ArrayList<ArrayList<TriangleNode>>();

        String line = reader.readLine();
        while (line != null) {
            ArrayList<TriangleNode> row = new ArrayList<TriangleNode>();
            String[] nums = line.split(" ");

            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i].charAt(0) == ' ' ? nums[i].substring(1) : nums[i];
            }

            if (nums.length == 1) {
                TriangleNode o = new TriangleNode(Integer.parseInt(nums[0]));
                row.add(o);
            } else {
                for (int i = 0; i < nums.length; i++) {
                    row.add(new TriangleNode(Integer.parseInt(nums[i])));
                }

                ArrayList<TriangleNode> prev = tree.get(tree.size() - 1);

                for (int i = 0; i < nums.length - 1; i++) {
                    prev.get(i).left = row.get(i);
                    prev.get(i).right = row.get(i + 1);
                }
                prev.get(prev.size() - 1).right = row.get(row.size() - 1);
            }
            tree.add(row);
            line = reader.readLine();
        }

        for (int i = 0; i < tree.size(); i++) {
            System.out.println(tree.get(i).toString());
        }

        System.out.println(getMaximumPath(tree.get(0).get(0), 0));

        reader.close();
    }
}
