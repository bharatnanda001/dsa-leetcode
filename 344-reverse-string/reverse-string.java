class Solution {
    public void reverseString(char[] s) {
        //2pointers
        int left = 0;
        int right = s.length-1;
        while(left<right){
            //swap character in left  and right pter
            char temp =s[left];
            s[left]= s[right];
            s[right]=temp;
            left++;
            right--;
        }
        
    }
}