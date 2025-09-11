import java.util.Arrays;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long dp[] = new long[rides.length];
        Arrays.fill(dp, -1);
        Arrays.sort(rides, (a, b) -> {
            return a[0] - b[0];
        });

        return helper(0, rides, dp);
    }

    private long helper(int i, int rides[][], long dp[]) {
        if (i == rides.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        long skip = helper(i + 1, rides, dp);
        long take = rides[i][1] - rides[i][0] + rides[i][2];
        int endRidei = rides[i][1];
        int j = binSearch(i + 1, rides.length - 1, endRidei, rides);

        if (j != -1) {
            take += helper(j, rides, dp);
        }

        return dp[i] = Math.max(skip, take);
    }

    private int binSearch(int left, int right, int key, int rides[][]) {
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (rides[mid][0] >= key) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}