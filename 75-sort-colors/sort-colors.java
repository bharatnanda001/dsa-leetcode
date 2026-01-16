class Solution {
    public void sortColors(int[] nums) {
        int red =0;
        int white=0;
        for(int i : nums){
            if(i ==0){
                red++;
            }else if(i ==1){
                white++;
            }
        }
        for(int i =0; i<nums.length;i++){
            if(red>0){
                nums[i]=0;
                red--;
            }else if(white>0){
                nums[i]=1;
                white--;
            }else{
                nums[i]=2;
            }
        }
        

        
    }
}