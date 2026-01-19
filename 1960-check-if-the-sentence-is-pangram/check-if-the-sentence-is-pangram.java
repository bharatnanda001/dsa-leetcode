class Solution {
    public boolean checkIfPangram(String sentence) {
        String s = sentence;
        boolean[] seen = new boolean[26];
        s = s.toLowerCase();
        for(char c: s.toCharArray())
            if(c>= 'a' && c<= 'z')
                seen[c-'a']=true;
        for(boolean b :seen)
            if(!b)return false; 
        return true;
    }
}