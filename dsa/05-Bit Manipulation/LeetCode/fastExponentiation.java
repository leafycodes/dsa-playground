class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            // we computed 1/(x^(n+1)) so we divide by x again to make it 1/(x^n).

            // when n=Integer.MIN_VALUE; directly converting it to positive would overflow.
            // so we add 1 and then make t negative. as:
            // min value = -2^31
            // max value = 2^31 - 1

            // so we first add 1 t o-2^31, then turn it into positive. to avoid overflow.

            // while doing so, we multiply x one mroe time, so we divide it to adjust the
            // correct value
            return (double) 1 / fastExp(x, -(n + 1)) / x;
        } else {
            return fastExp(x, n);
        }
    }

    private double fastExp(double x, int n) {
        double res = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }

        return res;
    }
}