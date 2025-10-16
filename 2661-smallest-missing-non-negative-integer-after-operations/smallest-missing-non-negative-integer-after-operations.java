class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer > freq = new HashMap<>();
        for(int num : nums){
            int rem =((num%value)+value)%value;
            freq.put(rem, freq.getOrDefault(rem,0)+1);
        }
        int i =0;
        while(true){
            int r = i%value;
            int count = freq.getOrDefault(r,0);
            if(count>0){
                freq.put(r,count-1);
            }else{
                return i;
            }
        i++;
        }
        
    }
}