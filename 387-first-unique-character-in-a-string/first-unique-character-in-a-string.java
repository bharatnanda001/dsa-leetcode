class Solution {
    public int firstUniqChar(String s) {
        //to knw hat the character is uniue in string
        int[] freq = new int[256]; // the valie of all charachter number define 
        for(char c : s.toCharArray()) freq[c]++; 
        for(int i = 0;i<s.length();i++){// string  
            if(freq[s.charAt(i)]==1){ // agar c 1 hua to vahi vapis same l lia 
                return i;
            }
        }
        return -1;
    }
}