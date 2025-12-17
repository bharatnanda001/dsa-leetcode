class Solution {
    public long maximumProfit(int[] prices, int k) {
        long NEG = Long.MIN_VALUE / 4;

        long[][] dp = new long[k + 1][3];

        for (int t = 0; t <= k; t++) {
            dp[t][0] = 0;      // FLAT
            dp[t][1] = NEG;   // LONG
            dp[t][2] = NEG;   // SHORT
        }

        for (int price : prices) {
            long[][] next = new long[k + 1][3];

            for (int t = 0; t <= k; t++) {
                // Stay FLAT
                next[t][0] = dp[t][0];

                // Enter LONG or SHORT (no transaction completed yet)
                next[t][1] = Math.max(dp[t][1], dp[t][0] - price);
                next[t][2] = Math.max(dp[t][2], dp[t][0] + price);

                // Close LONG
                if (t > 0) {
                    next[t][0] = Math.max(next[t][0], dp[t - 1][1] + price);
                    next[t][0] = Math.max(next[t][0], dp[t - 1][2] - price);
                }
            }
            dp = next;
        }

        long ans = 0;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[t][0]);
        }
        return ans;
    }
}

