class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }

        int numStones = stones.length;
        int targetCapacity = totalSum / 2;

        int[][] dp = new int[numStones + 1][targetCapacity + 1];

        for (int i = 1; i <= numStones; i++) {
            for (int j = 0; j <= targetCapacity; j++) {
                dp[i][j] = dp[i - 1][j];
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], 
                                        dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }

        return totalSum - dp[numStones][targetCapacity] * 2;
    }
}
