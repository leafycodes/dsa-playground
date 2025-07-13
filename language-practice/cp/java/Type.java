import java.util.*;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count = 0;
        int j = 0;
        for (int i = 0; i < players.length; i++) {
            while (j < trainers.length && players[i] > trainers[j]) {
                j++;
            }

            if (j < trainers.length && players[i] <= trainers[j]) {
                count++;
                j++;
            }
        }

        return count;
    }
}