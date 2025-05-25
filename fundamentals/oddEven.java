import java.util.Scanner;

public class oddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() % 2 == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        sc.close();
    }
}
