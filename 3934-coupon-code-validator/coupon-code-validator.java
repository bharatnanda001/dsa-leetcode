
class Solution {
    
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        // Store indices of valid coupons
        List<Integer> validIndices = new ArrayList<>();
      
        // Define allowed business lines
        Set<String> allowedBusinessLines = new HashSet<>(
            Arrays.asList("electronics", "grocery", "pharmacy", "restaurant")
        );

        // Iterate through all coupons to find valid ones
        for (int i = 0; i < code.length; i++) {
            // Check if coupon is active, business line is allowed, and code format is valid
            if (isActive[i] && 
                allowedBusinessLines.contains(businessLine[i]) && 
                isValidCouponCode(code[i])) {
                validIndices.add(i);
            }
        }

        // Sort valid coupon indices by business line first, then by coupon code
        validIndices.sort((index1, index2) -> {
            // Compare business lines alphabetically
            int businessLineComparison = businessLine[index1].compareTo(businessLine[index2]);
            if (businessLineComparison != 0) {
                return businessLineComparison;
            }
            // If business lines are the same, compare coupon codes alphabetically
            return code[index1].compareTo(code[index2]);
        });

        // Build result list with sorted coupon codes
        List<String> sortedCouponCodes = new ArrayList<>();
        for (int index : validIndices) {
            sortedCouponCodes.add(code[index]);
        }
      
        return sortedCouponCodes;
    }

    private boolean isValidCouponCode(String couponCode) {
        // Empty codes are invalid
        if (couponCode.isEmpty()) {
            return false;
        }
      
        for (char character : couponCode.toCharArray()) {
            if (!Character.isLetterOrDigit(character) && character != '_') {
                return false;
            }
        }
      
        return true;
    }
}
