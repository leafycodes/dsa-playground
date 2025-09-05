// asked for TRILOGY INNOVATIONS, BANGALORE for SDE 1/4 - was able to do 2, 1 TLE, so maybe did 1

// two strings are equal when ->
// 1. same length of both strings
// 2. all corresponding characters are same
// "cat" == "cat" -> true, "bat" != "cat" -> false

// question is NOT about equal, it is ALMOST EQUAL
// two strings are almost equal if->
// 1. both strings are of same length
// 2. they only differ in only one character, rest all corresponding characters are same

// "bat" almost equal to "cat" -> why?
// same length, and only character that differs is "b/c"

// "bat" is not almost equal to "act" ->why?
// although same length, but CORRESPONDING CHARACTER IS NOT SAME -> two characters differing b/a, a/c

// we are given a String s, and an integer k.
// find out the number of pairs of substrings of s that are almost equal where the differing character is at kth position (0th indexing).

class countAlmostEqual {
    public static void main(String[] args) {
        String str = "abacaba";
        int k = 1;

        System.out.println(countae(str, k));
    }

    public static int countae(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int len = k + 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                String str1 = s.substring(i, i + len);
                for (int j = i + 1; j <= n - len; j++) {
                    String str2 = s.substring(j, j + len);

                    int diff = 0; // count of differernt corresponding words
                    int posDiff = -1; // index at which there is a change
                    String str3 = "";
                    for (int curr = 0; curr < len; curr++) {
                        if (str1.charAt(curr) != str2.charAt(curr)) {
                            diff++;
                            posDiff = curr;
                            str3 = str2;

                            if (diff > 1) {
                                break;
                            }
                        }
                    }

                    if (diff == 1 && posDiff == k) {
                        // count++; // count once if unordered pairs are mentioned OR if UNIQUE pairs is
                        // mentioned
                        count += 2;// count twice if ordered pairs are mentioned OR if nothing is mentioned
                        System.out.println(str1 + " " + str3);
                        System.out.println(str3 + " " + str1);
                    }
                }
            }
        }

        return count;
    }
}