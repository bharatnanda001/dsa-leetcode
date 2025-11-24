class Solution {
    public int lastRemaining(int n) {
        return helper(1,1,n, true);   
    }
     public int helper(int head, int step, int remain, boolean left){
        if(remain ==1)
            return head;
        if(left || remain%2 ==1)
            head= head +step;
        remain =remain/2;
        step = step*2;
        return helper(head,step,remain,!left);
    }
}