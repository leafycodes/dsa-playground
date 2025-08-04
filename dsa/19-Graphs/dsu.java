// a better way to implement disjoint set union / union find / merge DS
// maintaining a rank array
public class dsu {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] == rank[py]) {
            par[py] = px;
            rank[px]++;
        } else if (rank[px] < rank[py]) {
            par[px] = py;
        } else {
            par[py] = px;
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}