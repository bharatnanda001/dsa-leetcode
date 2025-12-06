class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length, MOD = 1_000_000_007;

        long[] dp = new long[n + 1];     
        long[] pref = new long[n + 1];   
        dp[0] = pref[0] = 1;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int left = 0;

        for (int i = 1; i <= n; i++) {

            int x = nums[i - 1];

            while (!maxQ.isEmpty() && maxQ.peekLast() < x) maxQ.pollLast();
            maxQ.offerLast(x);

            while (!minQ.isEmpty() && minQ.peekLast() > x) minQ.pollLast();
            minQ.offerLast(x);

            while (maxQ.peekFirst() - minQ.peekFirst() > k) {
                if (nums[left] == maxQ.peekFirst()) maxQ.pollFirst();
                if (nums[left] == minQ.peekFirst()) minQ.pollFirst();
                left++;
            }

            
            long ways = pref[i - 1] - (left > 0 ? pref[left - 1] : 0);
            ways = (ways % MOD + MOD) % MOD;

            dp[i] = ways;
            pref[i] = (pref[i - 1] + dp[i]) % MOD;
        }

        return (int) dp[n];
    }
}
