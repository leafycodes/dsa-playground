import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            printMinCost(sc);
        }

        sc.close();
    }

    private static void printMinCost(Scanner sc) {
        int m = sc.nextInt(), n = sc.nextInt();
        Integer costHor[] = new Integer[m - 1], costVer[] = new Integer[n - 1];

        for (int i = 0; i < m - 1; i++) {
            costHor[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            costVer[i] = sc.nextInt();
        }

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] < costHor[h]) {
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println(cost);
    }
}