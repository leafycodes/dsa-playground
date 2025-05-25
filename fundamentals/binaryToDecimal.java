public class binaryToDecimal {
    public static void main(String[] args) {
        int temp, binNum;
        binNum = temp = 10101011;
        int pow = 0;
        int decNum = 0;

        while (binNum != 0) {
            int digit = binNum % 10;
            decNum = decNum + digit * (int) Math.pow(2, pow);
            pow++;
            binNum /= 10;
        }

        System.out.printf("bin(%d): dec(%d)", temp, decNum);
    }
}
