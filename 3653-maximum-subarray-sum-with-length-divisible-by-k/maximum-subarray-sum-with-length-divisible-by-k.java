class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long Prefix = 0;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix , Long.MAX_VALUE/2);
        minPrefix[k-1]=0;
        for(int i =0;i<nums.length;++i)
        {
            Prefix += nums[i];
            ans =Math.max(ans, Prefix - minPrefix[i%k]);
            minPrefix[i%k]= Math.min(minPrefix[i%k], Prefix);
        }
        return ans;

        
    }
}