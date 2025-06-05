class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder res = new StringBuilder();
        int start = 0;

        for (int i = 0; i <= title.length(); i++) {
            if (i == title.length() || title.charAt(i) == ' ') {
                String word = title.substring(start, i);
                if (word.length() <= 2) {
                    res.append(word.toLowerCase());
                } else {
                    res.append(Character.toUpperCase(word.charAt(0)));
                    res.append(word.substring(1).toLowerCase());
                }
                if (i != title.length()) {
                    res.append(" ");
                }
                start = i + 1;
            }
        }

        return res.toString();
    }
}