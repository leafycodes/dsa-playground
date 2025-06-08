public class oddOrEven {
    public static void main(String[] args) {
        int bitMask = 1;
        int nums = 193;

        if ((nums & bitMask) == 1) {
            System.out.println("odd");
        } else {
            System.out.println("even");
        }
    }
}
