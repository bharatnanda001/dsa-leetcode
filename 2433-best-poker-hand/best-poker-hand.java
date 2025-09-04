class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if(isFlush(suits)) return "Flush";
        int same = sameRank(ranks);
        if(same>=3){
            return "Three of a Kind";
        }else if(same ==2){
            return "Pair";
        }else{
            return "High Card";

        }
    }
    private boolean isFlush (char[] suits){
        char c = suits[0];
            for(int i= 1; i <5;++i){
                if(c!=suits[i]) return false;
            }
            return true;
    }
    private int sameRank(int[] ranks){
        int[] arr = new int[14];
        for(int i : ranks){
            arr[i]++;
        }
        int max = 1;
        for(int i:arr){
            max=Math.max(max,i);
        }
        return max;
    }
}