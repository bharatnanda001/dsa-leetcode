class Solution {
    public int removeDuplicates(int[] nums) {
       /* int idx =1;
        for(int i =1;i<nums.length;i++){
            if(nums[i] != nums[i-1])
                nums[idx++]= nums[i];
        }
        return idx;*/
        if(nums.length ==0)return 0;
        int i =0;
        for(int j =1; j <nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i]= nums[j];
            }
        }
        return i+1;
    }
}