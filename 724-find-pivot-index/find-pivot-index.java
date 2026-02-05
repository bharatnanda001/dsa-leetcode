class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum= 0;
        int total =0;
        for(int i : nums){
            total = total+i;
        }
        for(int j =0;j<nums.length;leftSum += nums[j++]){
            if(leftSum*2 ==total - nums[j]){
                return j;
            }
        }
        return -1;
    }
}