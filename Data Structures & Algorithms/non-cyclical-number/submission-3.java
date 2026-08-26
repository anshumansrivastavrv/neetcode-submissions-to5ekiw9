class Solution {
    public boolean isHappy(int n) {
       int slow=n,fast = sos(n);

       while(slow!=fast){
        fast=sos(sos(fast));
        slow=sos(slow);
       } 

       return fast==1;
    }

    private int sos(int n){
        int res=0;
        while(n!=0){
            res+=(n%10)*(n%10);
            n=n/10;
        }

        return res;
    }
}
