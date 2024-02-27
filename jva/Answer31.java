package jva;

public class Answer31 {
    public static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};

    public static long getCoinSum(int amount, int index) {
        if (amount == 0) return 1;
        if (index <= 0) return 0;

        long sum = getCoinSum(amount, index - 1);
        if (amount - coins[index - 1] >= 0) sum += getCoinSum(amount - coins[index - 1], index);
        
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getCoinSum(200, coins.length));
    }
}
