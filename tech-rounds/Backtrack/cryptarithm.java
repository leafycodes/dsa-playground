// TRILOGY INNOVATIONS, BENGALORE FOR SDE ROLE 2/4 - rest two couldn't read and solve (time constraint)

// find total number of valid solutions for the given cryptarithm, where crypt[0] + crypt[1] = crypt[2];
// leading letters cannot be assigned 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class cryptarithm {
    public static void main(String[] args) {
        String crypt[] = { "SEND", "MORE", "MONEY" };
        System.out.println(count(crypt));
    }

    private static int count(String[] crypt) {
        HashSet<Character> set = new HashSet<>();
        for (String word : crypt) {
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
        }

        if (set.size() > 10) {
            return 0; // no solutions
        }

        ArrayList<Character> letters = new ArrayList<>(set);
        boolean used[] = new boolean[10]; // shows which digit has been used
        HashMap<Character, Integer> map = new HashMap<>();
        // letter -> digit key-value pairs

        return helper(crypt, letters, map, used, 0);
    }

    private static int helper(String crypt[], ArrayList<Character> letters, HashMap<Character, Integer> map,
            boolean[] used, int curr) {
        if (curr == letters.size()) {
            return isSafe(crypt, map) ? 1 : 0;
        }

        int count = 0;
        char ch = letters.get(curr);
        for (int digit = 0; digit <= 9; digit++) {
            if (!used[digit]) {
                used[digit] = true;
                map.put(ch, digit);
                count += helper(crypt, letters, map, used, curr + 1);

                // backtrack
                used[digit] = false;
                map.remove(ch);
            }
        }

        return count;
    }

    private static boolean isSafe(String[] crypt, HashMap<Character, Integer> map) {
        int nums[] = new int[3];
        for (int i = 0; i < 3; i++) {
            String word = crypt[i];

            if (word.length() > 1 && map.get(word.charAt(0)) == 0) {
                return false;
            }

            int val = 0;
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                val = val * 10 + map.get(ch);
            }

            nums[i] = val;
        }

        return nums[0] + nums[1] == nums[2];
    }
}
