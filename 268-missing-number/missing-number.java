class Solution {
    public int missingNumber(int[] nums) {
        int missingN = 0;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= nums.length; i++) {
            missingN ^= i;
        }

        // XOR with all elements of nums
        for (int i = 0; i < nums.length; i++) {
            missingN ^= nums[i];
        }

        return missingN;
    }
}