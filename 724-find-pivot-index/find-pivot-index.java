class Solution {
    public int pivotIndex(int[] nums) {
        int Lsum =0;
        int total =0;
        for(int i :nums){
            total = total+i;
        }    
        for(int j =0; j<nums.length;Lsum+= nums[j++]){
            if(Lsum *2 == total - nums[j]){
                return j;
            }
            
        }
        return -1;
    }
}