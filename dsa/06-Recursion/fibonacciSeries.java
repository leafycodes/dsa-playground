public class fibonacciSeries {
    public static void main(String[] args) {
        System.out.println(NthOfFibSeries(26));
    }

    private static int NthOfFibSeries(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return NthOfFibSeries(n - 1) + NthOfFibSeries(n - 2);
    }
}
