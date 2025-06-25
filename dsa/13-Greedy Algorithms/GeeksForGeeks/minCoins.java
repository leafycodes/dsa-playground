// User function Template for Java

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> minPartition(int N) {
        // code here
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

        List<Integer> res = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= N) {
                while (coins[i] <= N) {
                    res.add(coins[i]);
                    N -= coins[i];
                }

                if (N == 0) {
                    break;
                }
            }
        }

        return res;
    }
}