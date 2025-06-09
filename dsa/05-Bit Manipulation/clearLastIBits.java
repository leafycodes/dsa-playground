public class clearLastIBits {
    public static void main(String args[]) {
        int num = 15, i = 2;
        int bitMask = ((~0) << i); // -1 or ~0

        num &= bitMask;
        System.out.println(num);
    }
}