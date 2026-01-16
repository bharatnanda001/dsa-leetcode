class Solution {
    func isPalindrome(_ x: Int) -> Bool {
        var temp = x
        var reversed = 0
        while temp > 0 {
            let lastDigit = temp % 10
            reversed = reversed * 10 + lastDigit
            temp = temp / 10

        }
        return reversed == x

        
    }
}