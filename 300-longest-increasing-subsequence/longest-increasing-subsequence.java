class Solution {
    public int lengthOfLIS(int[] nums) {

      ArrayList<Integer> lis = new ArrayList<>();
      lis.add(nums[0]);

      for(int i = 1 ; i< nums.length; i++){
        if(nums[i]> lis.get(lis.size()-1)){
            lis.add(nums[i]);
        }else{
            lis.set(LowerBound(lis,nums[i]),nums[i]);
        }
      }

      return lis.size();
    }
    public int LowerBound(ArrayList<Integer> lis, int target) {
    
        int left = 0;
        int right = lis.size()-1;

        while(left <= right){
           int mid = left +(right-left)/2;

           if(lis.get(mid)== target){
            return mid;
           }else if( lis.get(mid)> target){
            right = mid -1;
           }else{
            left = mid+1;
           }
        }
        return left;
    }
}