class Solution {
    public String convertToTitle(int columnNumber) {
        int n=columnNumber;
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0,(char)('A'+n%26));
            n /= 26;
        }
        return result.toString();
    }
}