class Solution {
    public int lengthOfLastWord(String s) {
        s= s.trim(); //  sara gap khatam
        int length =0;
        for(int i = s.length()-1;i>=0; i--){ //start from back
            if(s.charAt(i) != ' '){ //break removal
                length++;
            }
            else if(length>0){//jaha break aaya vaha tod dia
                break;
            }
        }
        return length;
    }
}