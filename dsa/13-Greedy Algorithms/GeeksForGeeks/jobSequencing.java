import java.util.ArrayList;
import java.util.Collections;

class Solution {
    class Job {
        int deadline;
        int profit;

        Job(int d, int p) {
            deadline = d;
            profit = p;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) {
            Job job = new Job(deadline[i], profit[i]);
            jobs.add(job);
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        boolean[] slots = new boolean[maxDeadline + 1];
        int maxCount = 0;
        int maxProfit = 0;

        for (Job job : jobs) {
            int j = Math.min(maxDeadline, job.deadline);
            while (j >= 1 && slots[j]) {
                j--;
            }

            if (j >= 1 && !slots[j]) {
                slots[j] = true;
                maxCount++;
                maxProfit += job.profit;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(maxCount);
        res.add(maxProfit);

        return res;
    }
}