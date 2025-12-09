class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return solve(coins.length - 1, amount, coins, dp);
    }

    private int solve(int idx, int amount, int[] coins, Integer[][] dp) {
        if (amount == 0) return 1;
        if (idx < 0) return 0;

        if (dp[idx][amount] != null) return dp[idx][amount];

        int ways = solve(idx - 1, amount, coins, dp);

        if (amount >= coins[idx]) {
            ways += solve(idx, amount - coins[idx], coins, dp);
        }

        return dp[idx][amount] = ways;
    }
}
