class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left =0;
        int right = n-1;
        int max =0;
        while(left<right){
            int width = right-left; // check level of water 
            int area = Math.min(height[left],height[right])*width; //max * width
            max = Math.max(max,area);
            if(height[left]<= height[right]){
                left++; //---> side go in array 
            }else{
                right--;
            }


        }
        return max;
    }
}