public class xToThePowerOfN {
    public static void main(String[] args) {
        System.out.println(pow(2, 10));
        System.out.println(optimizedPow(2, 10));
    }

    private static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    private static int optimizedPow(int x, int n) {

        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPow(x, n / 2);
        int halfPowerSquare = halfPower * halfPower;
        if ((n & 1) == 1) {
            halfPowerSquare *= x;
        }

        return halfPowerSquare;
    }
}
