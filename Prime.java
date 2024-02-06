public class Prime {
    public static void prime(long n) {
        for (double i = 2.0; i <= Math.ceil(Math.sqrt(n)); i++) {
            if (n == i) continue;
            if (n % i == 0) return;
        }
        System.out.println(n);
    }

    public static void main(String[] args) throws Exception {
        for (long i = 2; i < 100; i++) {
            prime(i);
        }
    }
}
