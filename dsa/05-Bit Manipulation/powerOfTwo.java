public class powerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(64));
    }

    private static boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n - 1)) == 0;
    }
}
