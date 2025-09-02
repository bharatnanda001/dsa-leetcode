class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        
        if (pLen > sLen) return new ArrayList<>();
        
        List<Integer> anagramIndices = new ArrayList<>();
        int[] pMap = new int[26];
        int[] sMap = new int[26];
        
        // Fill pMap with frequency of characters in p
        for (int i = 0; i < pLen; i++) {
            pMap[p.charAt(i) - 'a']++;
            sMap[s.charAt(i) - 'a']++;
        }
        
        // Check the first window
        if (Arrays.equals(pMap, sMap)) {
            anagramIndices.add(0);
        }
        
        // Slide the window over s
        for (int i = pLen; i < sLen; i++) {
            // Remove the character going out of the window
            sMap[s.charAt(i - pLen) - 'a']--;
            // Add the new character coming into the window
            sMap[s.charAt(i) - 'a']++;
            
            if (Arrays.equals(pMap, sMap)) {
                anagramIndices.add(i - pLen + 1);
            }
        }
        
        return anagramIndices;
    }
}
