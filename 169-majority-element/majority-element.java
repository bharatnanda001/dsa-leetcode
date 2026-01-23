class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int s = nums.length/2;
        int a = nums[s];
        return a;

    }
}