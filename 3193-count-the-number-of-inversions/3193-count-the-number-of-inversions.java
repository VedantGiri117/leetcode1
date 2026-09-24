import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {

        int[] req = new int[n];
        Arrays.fill(req, -1);

        for (int[] r : requirements) {
            req[r[0]] = r[1];
        }

        // dp[j] = ways to construct current prefix
        // having exactly j inversions
        int[] dp = new int[n * (n - 1) / 2 + 1];
        dp[0] = 1;

        int maxInv = 0;

        for (int i = 0; i < n; i++) {

            // Adding element i can create at most i new inversions
            int newMaxInv = maxInv + i;

            int[] next = new int[dp.length];

            long window = 0;

            for (int j = 0; j <= newMaxInv; j++) {

                // Add dp[j]
                if (j <= maxInv) {
                    window += dp[j];
                }

                // Remove dp[j - i - 1]
                if (j - i - 1 >= 0) {
                    window -= dp[j - i - 1];
                }

                window = (window + MOD) % MOD;

                next[j] = (int) window;
            }

            dp = next;
            maxInv = newMaxInv;

            // Requirement for prefix [0...i]
            if (req[i] != -1) {

                int required = req[i];

                // Impossible requirement
                if (required > maxInv) {
                    return 0;
                }

                // Keep only the required inversion count
                for (int j = 0; j <= maxInv; j++) {
                    if (j != required) {
                        dp[j] = 0;
                    }
                }

                maxInv = required;
            }
        }

        int answer = 0;

        for (int count : dp) {
            answer = (answer + count) % MOD;
        }

        return answer;
    }
}