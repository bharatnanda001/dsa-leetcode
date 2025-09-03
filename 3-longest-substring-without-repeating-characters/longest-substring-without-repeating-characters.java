class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0;
        HashSet<Character>set =  new HashSet<>();
        int left =0;
        for(int r =0; r<s.length(); r++){
            char ch = s.charAt(r);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxL= Math.max(maxL,r-left+1);
        }
        return maxL;
    }
}