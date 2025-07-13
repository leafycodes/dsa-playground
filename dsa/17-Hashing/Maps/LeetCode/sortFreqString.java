import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll().getKey();
            int val = map.get(ch);

            while (val != 0) {
                res.append(ch);
                val--;
            }
        }
        return res.toString();
    }
}