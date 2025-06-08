public class operations {
    public static void main(String[] args) {
        System.out.println("ith bit is: " + getIthBit(10, 3));
        System.out.println("set ith bit: " + setIthBit(10, 2));
        System.out.println("clear ith bit: " + clearIthBit(10, 1));
        System.out.println("update ith bit: " + updateIthbit(10, 3, 0));
    }

    private static int getIthBit(int num, int i) {
        int bitMask = 1 << i;
        if ((num & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    private static int setIthBit(int num, int i) {
        int bitMask = 1 << i;

        num |= bitMask;
        return num;
    }

    private static int clearIthBit(int num, int i) {
        int bitMask = ~(1 << i);

        num &= bitMask;
        return num;
    }

    private static int updateIthbit(int num, int i, int value) {
        // if (value == 0) {
        // clearIthBit(num, i);
        // } else {
        // setIthBit(num, i);
        // }

        num = clearIthBit(num, i);
        int bitMask = value << i;
        num |= bitMask;

        return num;
    }
}
