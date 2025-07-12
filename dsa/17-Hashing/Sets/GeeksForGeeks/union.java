import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            set.add(b[i]);
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            res.add(it.next());
        }

        return res;
    }
}