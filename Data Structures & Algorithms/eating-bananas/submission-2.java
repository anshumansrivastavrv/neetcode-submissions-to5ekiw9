class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=0;

        for(int i=0;i<n;i++){
            max=Math.max(max,piles[i]);
        }

        int l=1;
        int r=max;
        int ans=0;

        while(l<=r){
            int mid=(l+r)/2;
            if(helper(piles,h,mid)){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }

        return ans;
    }

    private boolean helper(int[] piles,int h,int mid){
        long hrs=0;

        for(int i=0;i<piles.length;i++){
            hrs+=(piles[i]+mid-1)/mid;
        }

        return hrs<=h;
    }
}