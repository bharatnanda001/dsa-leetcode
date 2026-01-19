class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
       /* int x =n;
        for(int i=0;i<n;i++){
            x=x^i^nums[i];
        }
        return x;*/
        int sum = n*(n+1)/2;
        for(int x :nums){
            sum -=x;
        }
        return sum;
    }
}