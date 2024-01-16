package jva;

public class Answer18 {
    public static void main(String[] args) throws Exception {
        long days = 0;
        for (int i = 1901; i <= 2000; i++) {
            days += 365;
            if (i % 4 == 0) days++;
            if (i % 100 == 0) {
                days--;
                if (i % 400 == 0) days++;
            }
        }

        days -= 6;
        System.out.println(days / 7);
    }
}
