import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // HashSet<Integer> set = new HashSet<>();

        // set.add(1);
        // set.add(2);
        // set.add(4);
        // set.add(2);
        // set.add(1);

        // set.remove(4);
        // System.out.println(set);
        // System.out.println(set.contains(2));
        // System.out.println(set.contains(5));
        // System.out.println(set.size());
        // set.clear();
        // System.out.println(set);
        // System.out.println(set.isEmpty());

        // // iteration on set elements
        // // -> using iterators
        // System.out.println();

        // HashSet<String> city = new HashSet<>();
        // city.add("Delhi");
        // city.add("Mumbai");
        // city.add("Noida");
        // city.add("Bengaluru");

        // Iterator it = city.iterator(); // not dependent on insertion order
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }
        // // -> using for loops

        // System.out.println();
        // for (String c : city) {
        // System.out.println(c);
        // }

        HashSet<String> city = new HashSet<>();
        city.add("Delhi");
        city.add("Mumbai");
        city.add("Noida");
        city.add("Bengaluru");

        LinkedHashSet<String> city2 = new LinkedHashSet<>();
        city2.add("Delhi");
        city2.add("Mumbai");
        city2.add("Noida");
        city2.add("Bengaluru"); // insertion order preserved
        // all otehr operations same

        TreeSet<String> city3 = new TreeSet<>();
        city3.add("Delhi");
        city3.add("Mumbai");
        city3.add("Noida");
        city3.add("Bengaluru"); // sorted in ascending order

        System.out.println(city);
        System.out.println(city2);
        System.out.println(city3);
    }
}
