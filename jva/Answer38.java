package jva;

public class Answer38 {
    public static boolean isPandigital(String st) {
        if (st.length() != 9) return false;

        for (int i = 1; i <= 9; i++) {
            if (st.indexOf("" + i) == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int largest = 0;

        for (int i = 1; i < 10000; i++) {
            String k = "";
            int m = 1;

            while (k.length() < 9) {
                k += i * m;
                m++;
            }

            if (isPandigital(k)) {
                System.out.println(k);
                largest = Math.max(largest, Integer.parseInt(k));
            }
        }

        System.out.println();

        System.out.println("Largest: " + largest);
    }
}
