class Solution {
    String ans;
    Set<String> seen = new HashSet<>();
    public String findLexSmallestString(String s, int a, int b) {
        ans = s;
        dfs(s,a,b);
        return ans;
    }
    private void dfs(String s, int a,int b){
        if(seen.contains(s))return;
        seen.add(s);
        if(s.compareTo(ans)<0) ans=s;
        char[] arr =s.toCharArray();
        for(int i = 1; i<arr.length;i+=2){
            int newDigit =((arr[i]-'0')+a)%10;
            arr[i]=(char)(newDigit+'0');
        }
        dfs(new String(arr),a,b);
        String rotated= s.substring(s.length()-b)+(s.substring(0,s.length()-b));
        dfs(rotated,a,b);
    }
}