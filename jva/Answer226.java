package jva;

public class Answer226 {
    public static double s(double x) {
        return Math.abs(Math.floor(x + 0.5) - x);
    }

    public static double blancmange(double x, double n) {
        double sum = 0.0;
        for (double i = 0; i <= n; i++) {
            double pow = Math.pow(2, i);
            sum += s(x * pow) / pow;
        }

        return sum;
    }

    public static double circle(double x) {
        double top = 4 - Math.sqrt(-64 * x * x + 32 * x);
        return top / 8;
    }

    public static void main(String[] args) throws Exception {
        double sum = 0.0;
        double step = 0.000001;
        for (double i = 0; i < 0.5; i += step) {
            double blancmange = blancmange(i, 500);
            double circle = circle(i);

            if (blancmange > circle) sum += ((blancmange - circle) * step);
        }
        System.out.println(sum);
    }
}