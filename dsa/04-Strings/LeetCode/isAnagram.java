class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        char[] tChar = t.toCharArray();
        Arrays.sort(tChar);
        for (int i = 0; i < s.length(); i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }

        return true;
    }
}