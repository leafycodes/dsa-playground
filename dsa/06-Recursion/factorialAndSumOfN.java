public class factorialAndSumOfN {
    public static void main(String[] args) {
        System.out.println(fact(6));
        System.out.println(sumOfN(6));
    }

    private static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    private static int sumOfN(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfN(n - 1);
    }
}