package jva;

public class Answer86 {
    public static double getOptimalIntersection(double l, double w, double h) {
        return l * h / (h + w);
    }

    public static boolean checkForIntSolution(double l, double w, double h) {
        double x = getOptimalIntersection(l, w, h);
        
        double bottomTerm = Math.sqrt(Math.pow(l - x, 2) + w * w);
        double topTerm = Math.sqrt(x * x + h * h);

        double distance = bottomTerm + topTerm;
        // System.out.println(l + " : " + w + " : " + h + " :: " + distance);
        return distance == (int) (distance);
    }

    public static void main(String[] args) throws Exception {
        long integerSolutions = 0;

        for (int m = 1; m <= 100; m++) {
            System.out.println(m - 1 + " : " + integerSolutions);
            integerSolutions = 0;

            for (int l = 1; l <= m; l++) {
                for (int w = l; w <= m; w++) {
                    for (int h = l; h <= m; h++) {
                        boolean isInt = checkForIntSolution(l, w, h);
                        if (isInt) integerSolutions++;
                    }
                }
            }
        }
    }
}