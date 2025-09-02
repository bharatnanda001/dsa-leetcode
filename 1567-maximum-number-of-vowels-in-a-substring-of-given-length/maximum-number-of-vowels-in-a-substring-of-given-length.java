class Solution {
    public int maxVowels(String s, int k) {
        int maxVowel =  0;
        int currentCount = 0;
        for (int i = 0; i<s.length(); i++){
            if(inVowel(s.charAt(i))) {
               currentCount++;

           }
            if(i>=k){
                if(inVowel(s.charAt(i-k))){
                    currentCount--;
                }
           }
            maxVowel=Math.max(maxVowel,currentCount);

        }
        return maxVowel;
    }

    private boolean inVowel(char c){
        return c =='a'|| c =='e'|| c =='i'||c =='o'||c =='u';

    }
        
    
}