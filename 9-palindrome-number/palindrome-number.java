class Solution {
    public boolean isPalindrome(int x) {
        int original=x;
        int result=0;
        while(x>0){
            int lastdigit=x%10;
            x/=10;
            result = result * 10 + lastdigit;
        }
        if(result==original){
            return true;
        }
        return false;
    }
}