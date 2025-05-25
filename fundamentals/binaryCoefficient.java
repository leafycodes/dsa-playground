public class binaryCoefficient {

    // valid for smaller inputs as factorail grows very quickly
    public static long factorial(int num) {
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }

        return res;
    }

    public static long binCo(int n, int r) {

        if (r < 0 || r > n) {
            return 0;
        }
        long numerator = factorial(n);
        long denominator = factorial(r) * factorial(n - r);

        long res = numerator / denominator;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(binCo(8, 4));
    }
}
