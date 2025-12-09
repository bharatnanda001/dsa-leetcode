class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        int ans = solve(coins.length - 1, amount, coins, dp);
        return ans >= 1e9 ? -1 : ans;
    }

    int solve(int i, int amt, int[] coins, Integer[][] dp) {
        if (amt == 0) return 0;
        if (i < 0) return (int)1e9;

        if (dp[i][amt] != null) return dp[i][amt];

        int notTake = solve(i - 1, amt, coins, dp);
        int take = (int)1e9;

        if (coins[i] <= amt)
            take = 1 + solve(i, amt - coins[i], coins, dp);

        return dp[i][amt] = Math.min(take, notTake);
    }
}

