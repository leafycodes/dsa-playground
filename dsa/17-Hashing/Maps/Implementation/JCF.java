import java.util.HashMap;
import java.util.Set;

public class JCF {
    public static void main(String[] args) {
        HashMap<String, Integer> mp = new HashMap<>();

        mp.put("Anish", 1);
        mp.put("Anwesha", 2);
        mp.put("Anagh", 3);
        mp.put("Anagh", 4);

        System.out.println(mp.get("Anwesha"));
        System.out.println(mp.containsKey("Anish"));
        System.out.println(mp.containsKey("Verstappen"));
        System.out.println(mp.remove("Anish"));

        // iterating on hashmap - using entrySet
        // for (HashMap.Entry<String, Integer> entry : mp.entrySet()) {
        // System.out.println(entry.getKey() + " : " + entry.getValue());
        // }

        // with keySet
        Set<String> keys = mp.keySet();
        for (String k : keys) {
            System.out.println("key: " + k + " : value: " + mp.get(k));
        }
    }
}