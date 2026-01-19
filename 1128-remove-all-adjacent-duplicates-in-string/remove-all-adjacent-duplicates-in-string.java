class Solution {
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int i =0;
        for(int j =0;j<arr.length;j++){
            arr[i]= arr[j];
            if(i>0 && arr[i]==arr[i-1]){
                i--;
            }else{
                i++;
            }
        }
        return new String(arr,0,i);
    }
}