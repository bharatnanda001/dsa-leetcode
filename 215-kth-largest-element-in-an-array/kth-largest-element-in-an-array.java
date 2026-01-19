class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
       /* for(int i =n-k;i>=0;i--){
            if(nums[i]!= nums[n-1]){
                return nums[i];
            }
        }
        return -1;*/
        return nums[n-k]; 
    }
}