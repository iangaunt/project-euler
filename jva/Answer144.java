package jva;

public class Answer144 {
    /** m is the slope of the line between the two processed points. */
    public static double getM(double a, double b, double j, double k) {
        return (b - k) / (a - j);
    }

    /** n is the slope of the line reflected over the normal line at point (a, b). */
    public static double getN(double a, double b, double m) {
        double numerator = 
            -16 * m * Math.pow(a, 2) + 
            m * Math.pow(b, 2) + 
            8 * a * b;

        double denominator = 
            16 * Math.pow(a, 2) -
            Math.pow(b, 2) +
            8 * a * b * m;

        return numerator / denominator;
    }

    /** "Solutions" to the reflection problem are solutions to the quadratic
     * formula found when solving for the intersection of the reflection
     * line and the ellipse.
     */
    public static double getSolution(double a, double b, double n) {
        double sqrtTerm = 2 * Math.sqrt(
            25 * Math.pow(n, 2) - 
            Math.pow(a, 2) * Math.pow(n, 2) +
            2 * a * b * n + 
            100 - 
            Math.pow(b, 2)
        );

        double numTerm = a * Math.pow(n, 2) - b * n;
        double denomTerm = Math.pow(n, 2) + 4;

        double pSol = (numTerm + sqrtTerm) / denomTerm;
        double nSol = (numTerm - sqrtTerm) / denomTerm;

        return Math.abs(pSol - a) > Math.abs(nSol - a) ? pSol : nSol;
    }

    /** Fetches the intersection of the reflection line and the ellipse at (x, ???). */
    public static double getYFromX(double x, double a, double b, double n) {
        return n * (x - a) + b;
    }
    

    public static void main(String[] args) throws Exception {
        int count = 1;

        double a = 1.4;
        double b = -9.6;

        double j = 0.0;
        double k = 10.1;

        /* Keeps generating new points of reflection until the 
        laser bounces back to the top (+- 0.01, > + 9.9) */
        while (true) {
            double m = getM(a, b, j, k);
            double n = getN(a, b, m);

            double solution = getSolution(a, b, n);
            double newB = getYFromX(solution, a, b, n);

            j = a;
            k = b;

            a = solution;
            b = newB;
            count++;

            if (Math.abs(a) <= 0.01 && b > 0) break;
        }
        count--;

        System.out.println(a + " : " + b);
        System.out.println(count);
    }
}
