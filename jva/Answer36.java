package jva;

public class Answer36 {
    public static boolean isPalindrome(String k) {
        return k.equals(new StringBuilder(k).reverse().toString());
    }

    public static String convertToBinary(int n) {
        int max = 1;
        while (max < n) {
            max *= 2;
        }
        if (max != n) max /= 2;

        String bin = "";
        while (max > 0) {
            if (n >= max) {
                bin += "1";
                n -= max;
            } else {
                bin += "0";
            }
            max /= 2;
        }
        return bin;
    }

    public static void main(String[] args) throws Exception {
        int max = 1000000;
        int sum = 0;
        
        for (int i = 0; i <= max; i++) {
            String bin = convertToBinary(i);

            if (isPalindrome(Integer.toString(i)) && isPalindrome(bin)) {
                sum += i;
                System.out.println(i + " : " + bin);
            }
        }

        System.out.println(sum);
    }
}
