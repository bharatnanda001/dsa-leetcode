class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Every element alone forms LIS of length 1
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int curr = 1; curr < n; curr++) {
            for (int prev = 0; prev < curr; prev++) {

                if (nums[curr] > nums[prev]) {
                    dp[curr] = Math.max(dp[curr], dp[prev] + 1);
                }
            }
            
            maxi = Math.max(maxi, dp[curr]);
        }

        return maxi;
    }
}
