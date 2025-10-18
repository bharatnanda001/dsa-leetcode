class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0 ;
        int pre = Integer.MIN_VALUE;
        for(int x : nums){
            int cur = Math.max(x-k, pre+1);
           
            if(cur <= x + k){ 
                ans++;
                pre = cur;
            }

        }
        return ans;
    }
}
