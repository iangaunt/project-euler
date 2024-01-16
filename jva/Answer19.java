package jva;

public class Answer19 {
    public static void main(String[] args) throws Exception {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int year = 1901;
        int currentDay = 1;
        int sundays = 0;

        while (year < 2000) {
            boolean isLeapYear = year % 4 == 0;
            if (year % 100 == 0 && year % 400 != 0) isLeapYear = false;

            for (int i = 0; i < months.length; i++) {
                if (isLeapYear) months[1]++;

                for (int j = 0; j < months[i]; j++) {
                    if (currentDay == 0 && j == 0) sundays++;

                    currentDay++;
                    if (currentDay == 7) currentDay = 0;
                }

                if (isLeapYear) months[1]--;
            }
            year++;
        }

        System.out.println(sundays);
    }
}
