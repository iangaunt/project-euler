package jva;

public class Answer254 {
    public static int[] factorial;
    public static long[] values;

    public static void main(String[] args) throws Exception {
        factorial = new int[10];
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++){ 
            factorial[i] = factorial[i - 1] * i;
        }

        values = new long[151];
        int notFound = 151;

        for (int i = 0; i < Long.MAX_VALUE; i++) {
            if (i % 10000 == 0) System.out.println(i + " : " + notFound);
            if (i % 10 != 9 && i > 10000) continue;

            long sum = 0;
            String g = Integer.toString(i);
            for (int j = 0; j < g.length(); j++) {
                sum += factorial[Integer.parseInt(g.substring(j, j + 1))];
            }

            g = Long.toString(sum);
            sum = 0;
            for (int j = 0; j < g.length(); j++) {
                sum += Integer.parseInt(g.substring(j, j + 1));
            }

            int s = (int) (sum);
            if (s < values.length && values[s] == 0) {
                values[s] = i;
                notFound--;
            }

            if (notFound == 0) break;
        }

        System.out.println("done");
        long sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
            System.out.println(i + " : " + values[i]);
        }
        System.out.println(sum);
    }
}