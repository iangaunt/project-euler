package jva;

public class Answer142 {
    public static boolean isSquare(double n) {
        double k = Math.sqrt(n);
        return (int) (k) == k;
    }

    public static void main(String[] args) throws Exception {
        final int SUM = 1000000;

        for (double k = 1; k < SUM; k++) {
            if (k % 1000 == 0) System.out.println(k);
            for (double i = 1; i < k / 2; i++) {
                double j = (2 * i * k - k * k) / (2 * i - 2 * k);

                if ((double) (Math.round(j)) != j) continue;

                int x = (int) (Math.sqrt(i * i + j * j));
                int y = (int) Math.max(i, j);
                int z = (int) Math.min(i, j);

                // System.out.println(x + " : " + y + " : " + z);

                if (isSquare(x + y) && isSquare(x - y) && isSquare(x + z) && isSquare(x - z) && isSquare(y - z)) {
                    System.out.println(i + " : " + j + " : " + k);
                    return;
                }
            }
        }
    }
}
