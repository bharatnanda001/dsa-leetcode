class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        boolean r = true;
        while(r){
            r =false;
            int len = sb.length();
            for(int i =0; i<len; i++){
                for(int j =i+1;j<=i+k && j<len ;j++){
                    if(sb.charAt(i)==sb.charAt(j)){
                        sb.deleteCharAt(j);
                            r = true;
                            break;
                    }
                }
                if(r)break;
            }
        }
        return sb.toString();
    }
}