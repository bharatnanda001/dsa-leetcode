class Solution {
     public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int dp[] = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            int Max = 0; 
            int best = 0;
            for (int k = 1; k <= K && i - k >= 0; ++k) {
                Max = Math.max(Max, A[i - k]);
                best = Math.max(best, dp[i - k] + Max * k);
            }
            dp[i] = best;
        }
        return dp[N];
    }
}