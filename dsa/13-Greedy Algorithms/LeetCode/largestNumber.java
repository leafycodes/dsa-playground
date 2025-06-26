class Solution {
    public String largestNumber(int[] nums) {
        String numString[] = new String[nums.length];
        for (int i = 0; i < numString.length; i++) {
            numString[i] = "" + nums[i];
        }

        Arrays.sort(numString, (a, b) -> {
            String x = a + b;
            String y = b + a;

            if (x.compareTo(y) > 0) {
                return -1;
            } else if (x.compareTo(y) < 0) {
                return +1;
            } else {
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : numString) {
            sb.append(s);
        }
        return sb.length() == 0 || sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}