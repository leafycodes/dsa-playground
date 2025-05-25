public class sumOfNOrFactorial {
    public static long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    public static int sumOfNums(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(factorial(7));
        System.out.println(sumOfNums(7));
    }
}
