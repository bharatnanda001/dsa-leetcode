class Solution {
    public int findFinalValue(int[] nums, int original) {
        return helper(nums, original);
    }

    private int helper(int[] nums, int value) {
        for (int num : nums) {
            if (num == value) {
                return helper(nums, value * 2);  
            }
        }
        return value; 
    }
}
