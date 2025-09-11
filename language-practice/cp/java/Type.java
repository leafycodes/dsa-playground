import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Type {
    public static String sortVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        // TLe for n^2 approach, so i try to use two lists to store and sort (won't go
        // TLE)
        ArrayList<Character> vow = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vow.add(ch);
                pos.add(i);
            }
        }

        Collections.sort(vow); // will sort the char and then i can put them in the earlier positions
        for (int i = 0; i < pos.size(); i++) {
            sb.setCharAt(pos.get(i), vow.get(i));
        }

        return sb.toString();
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(sortVowels(s));
    }
}