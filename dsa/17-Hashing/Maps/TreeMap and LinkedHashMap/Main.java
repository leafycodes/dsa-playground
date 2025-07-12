import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("B", 300);
        lhm.put("A", 100);
        lhm.put("C", 200); // the order of insertion matters

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("B", 300);
        hm.put("A", 100);
        hm.put("C", 200); // the order of insertion does not matter

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("B", 300);
        tm.put("A", 100);
        tm.put("C", 200); // keys are sorted -> red black trees implementation

        System.out.println(hm); // jumbled
        System.out.println(lhm); // order of insertion
        System.out.println(tm); // sorted as per keys
    }
}