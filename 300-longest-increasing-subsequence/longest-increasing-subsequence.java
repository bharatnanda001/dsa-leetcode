class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {

                int nonTake = dp[curr + 1][prev + 1];
                int take = 0;

                if (prev == -1 || nums[curr] > nums[prev]) {
                    take = 1 + dp[curr + 1][curr + 1];
                }

                dp[curr][prev + 1] = Math.max(take, nonTake);
            }
        }
        return dp[0][0];
    }
}
