class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer>SeenNumber= new HashSet<>();
        for(int num : nums){
            if(SeenNumber.contains(num)){
                return true;
            }
            SeenNumber.add(num);
        }
        return false;
    }
}