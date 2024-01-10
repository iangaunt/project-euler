package jva;

public class Answer4 {
    public static void main(String[] args) throws Exception {
        int largest = 0;

        for (int i = 999; i > 0; i--) {
            for (int j = 999; j > 0; j--) {
                if (i % 11 != 0 && j % 11 != 0) continue;
                int k = i * j;

                String f = Integer.toString(k);
                boolean t = true;

                for (int r = 0; r < f.length() / 2; r++) {
                    if (f.charAt(r) != f.charAt(f.length() - 1 - r)) {
                        t = false;
                        break;
                    }
                }

                if (t && k > largest) largest = k;
            }
        }

        System.out.println(largest);
    }
}
