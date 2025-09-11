import java.util.Arrays;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int dp[][] = new int[n][2];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        Arrays.sort(events, (a, b) -> {
            return a[0] - b[0];
        });

        return helper(0, events, 0, dp);
    }

    private int helper(int i, int job[][], int cnt, int dp[][]) {
        if (i == job.length || cnt == 2) {
            return 0;
        }

        if (dp[i][cnt] != -1) {
            return dp[i][cnt];
        }

        int skip = helper(i + 1, job, cnt, dp);
        int take = job[i][2];
        int endJobi = job[i][1];
        int j = binSearch(i + 1, job.length - 1, endJobi, job);

        if (j != -1) {
            take += helper(j, job, cnt + 1, dp);
        }

        return dp[i][cnt] = Math.max(skip, take);
    }

    private int binSearch(int left, int right, int key, int job[][]) {
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (job[mid][0] > key) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}