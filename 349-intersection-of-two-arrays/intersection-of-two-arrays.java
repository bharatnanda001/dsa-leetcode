class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> n1 = new HashSet<>();
        for(int x: nums1)n1.add(x);
        HashSet<Integer>arr= new HashSet<>();
        for(int x:nums2){
            if(n1.contains(x))arr.add(x);
        }
        int size= arr.size();
        int[] ans = new int[size];
        int write=0;
        for(int x: arr){
            ans[write++]= x;
        }
        return ans;
    }
}