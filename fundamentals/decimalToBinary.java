public class decimalToBinary {
    public static void main(String[] args) {
        int decNum, temp;
        decNum = temp = 171;

        int binNum = 0, pow = 0;

        while (decNum != 0) {
            int rem = decNum % 2;
            binNum = binNum + rem * (int) Math.pow(10, pow++);
            ;
            decNum /= 2;
        }

        System.out.printf("dec(%d): bin(%d)", temp, binNum);
    }
}
