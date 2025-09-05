class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Change 'Array.sort' to 'Arrays.sort' (Java's sorting method)

        List<List<Integer>> result = new ArrayList<>();  // Fixed typo: 'ArraysList' → 'ArrayList'
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;  // Skip duplicate elements for i
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {  // You need this while loop to move left and right pointers
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates on left
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates on right
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if(sum < 0) {
                    left++;  // If sum too small, increase left pointer
                } else {
                    right--;  // If sum too big, decrease right pointer
                }
            }
        }
        
        return result;  // Return the result list at the end of the function
    }
}
