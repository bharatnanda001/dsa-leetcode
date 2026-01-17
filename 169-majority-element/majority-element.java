class Solution {
    public int majorityElement(int[] nums) {
        int cnt =0;
         int candidate =0;
          for(int num: nums){
            if(cnt ==0){
                candidate = num;
                cnt =1;
            }
            else if(num== candidate){
                cnt++;
            }else{
                cnt--;
            }
        }
        return candidate;
    }
}