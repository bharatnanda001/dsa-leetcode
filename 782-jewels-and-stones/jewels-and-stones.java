class Solution {
    public int numJewelsInStones(String j, String s) {
        Set<Character> set = new HashSet<>();
        for(char c : j.toCharArray()) set.add(c);
        int ans = 0;
        for(char c : s.toCharArray()) if(set.contains(c)) ans++;
        return ans;
    }
}
