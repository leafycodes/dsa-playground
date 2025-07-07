import java.util.Scanner;

public class Type {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        System.out.println("hello, " + name);

        int x = sc.nextInt();
        System.out.println("you entered: " + x);
        sc.close();
    }
}
