class Solution {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }

        int write = 0;
        int read = 0;
        int n = chars.length;

        while (read < n) {
            char currentChar = chars[read];
            Integer count = 0;

            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write++] = currentChar;

            if (count > 1) {
                for (char c : count.toString().toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}