import java.util.*;

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Create a list of jobs and sort them in descending order of profit
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(deadline[i], profit[i]));
        }

        // Sort jobs by profit in descending order
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline to know how many time slots we have
        int maxDeadline = 0;
        for (int d : deadline) {
            if (d > maxDeadline) {
                maxDeadline = d;
            }
        }

        // Array to keep track of free time slots
        boolean[] slot = new boolean[maxDeadline + 1];

        int totalProfit = 0;
        int jobsDone = 0;

        // Assign jobs to the latest possible free slot
        for (Job job : jobs) {
            // Find the latest possible slot for this job
            for (int j = Math.min(maxDeadline, job.deadline); j >= 1; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += job.profit;
                    jobsDone++;
                    break;
                }
            }
        }

        result.add(jobsDone);
        result.add(totalProfit);
        return result;
    }

    class Job {
        int deadline;
        int profit;

        public Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}