public class towerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoiSteps(n, "A", "B", "C");
    }

    private static void towerOfHanoiSteps(int n, String src, String helper, String dest) {
        if (n == 0) {
            return;
        }

        towerOfHanoiSteps(n - 1, src, dest, helper);
        System.out.println("move disk " + n + " from " + src + " to " + dest);
        towerOfHanoiSteps(n - 1, helper, src, dest);
    }
}
