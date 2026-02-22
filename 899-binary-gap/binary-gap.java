class Solution {
    public int binaryGap(int n) {
        int last=-1;
        int pos=0;
        int max_gap=0;
        while(n!=0){
            if((n&1)==1){
                if(last!=-1){
                    max_gap= Math.max(max_gap,pos-last);
                }   
                last=pos;
            }
            n>>=1;
            pos++;
        }
        return max_gap;
    }
}