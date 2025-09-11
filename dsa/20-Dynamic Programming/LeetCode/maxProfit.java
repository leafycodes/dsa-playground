import java.util.Arrays;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int job[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        Arrays.sort(job, (a, b) -> {
            return a[0] - b[0];
        });

        return helper(0, job, dp);
    }

    private int helper(int i, int job[][], int dp[]) {
        if (i == job.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int skip = helper(i + 1, job, dp);
        int take = job[i][2];
        int endJobi = job[i][1];
        int j = binSearch(i + 1, job.length - 1, endJobi, job);

        if (j != -1) {
            take += helper(j, job, dp);
        }

        return dp[i] = Math.max(skip, take);
    }

    private int binSearch(int left, int right, int key, int job[][]) {
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (job[mid][0] >= key) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}