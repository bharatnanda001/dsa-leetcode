class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (n == 0) return ans;

        Arrays.sort(nums); 

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxi = 1;
        int lastIndex = 0;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if ( maxi <dp[i] ) {
                maxi = dp[i];
                lastIndex   = i;
            }
        }
        while (lastIndex  != -1) {
            ans.add(nums[lastIndex ]);
            lastIndex = parent[lastIndex ];
        }
        Collections.reverse(ans);
        return ans;
    }
}