public class clearRange {
    public static void main(String[] args) {
        System.out.println("after clearing range: " + clearBitsInRange(10, 2, 4));
    }

    private static int clearBitsInRange(int num, int low, int high) {
        int bitMask = /* left bitMask */ ((~0) << (high + 1)) | /* right bitMask */ ((1 << low) - 1);

        num &= bitMask;
        return num;
    }
}
