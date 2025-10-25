class Solution {
    public int totalMoney(int n) {
        final int weeks = n/7;
        final int firstWeek = trap(1,7);
        final int lastFullWeek = trap(1+weeks-1, 7+weeks-1);
        final int remainingDays = trap(1+weeks, n%7+weeks);
        return(firstWeek+lastFullWeek)*weeks/2+remainingDays;
        
    }
    private int trap(int a, int b){
        return(a+b)*(b-a+1)/2;
    }
}