class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=0;

        for(int p:piles){
            r=Math.max(r,p);
        }

        int ans=r;

        while(l<=r){
            int mid=(l+r)/2;

            if(canfinish(piles,h,mid)){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }

        return ans;
    }

    private boolean canfinish(int[] piles,int h,int k){
        int hrs=0;

        for(int p:piles){
            hrs+=(p+k-1)/k;
        }

        return hrs<=h;
    }
}
