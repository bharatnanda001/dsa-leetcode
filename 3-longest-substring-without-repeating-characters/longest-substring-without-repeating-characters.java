class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s== null || s.length()==0)return 0; // base case if values are zero 
        int left =0; // zero se start 
        int maxLength= 0;
        int[] freq =new int[256];//characters
        for(int right=0; right <s.length(); right++){
            char currentChar= s.charAt(right);
            freq[currentChar]++;
            while (freq[currentChar]>1){
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                left++;
            }
            maxLength= Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}