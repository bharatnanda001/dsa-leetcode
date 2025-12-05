class Solution {
    public int countPartitions(int[] nums) {
        int count =0;
        int prefix =0;
        for(int i =0; i <nums.length-1; i++){
            prefix+= nums[i];
            int sum =0;
            for(int j = i +1; j< nums.length; j++){
                sum+= nums[j];
            }
            if(Math.abs(prefix-sum)%2 ==0) count++;
        }
        return count;
    }
}