class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< address.length(); i++){
            char ch = address.charAt(i);
            if(ch !='.'){
                sb.append(ch);
            }else{
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
}