class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        for(String word : words){
            int totalWeight=0;
            for(int i =0; i<word.length();i++){
                char ch = word.charAt(i);
                totalWeight +=weights[ch -'a'];
            }
            int remi = totalWeight%26;
            char mappedChar = (char)('z'- remi);
            result.append(mappedChar);
        }
        return result.toString();
    }
}