class Solution {
    public int missingNumber(int[] nums) {
        int sum =0;
        int ans =0;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
        }
        ans = (nums.length*(nums.length+1)/2);
        return ans-sum;
    }
}