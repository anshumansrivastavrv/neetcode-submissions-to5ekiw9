class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)return -1;

        int l=0;
        int r=height.length-1;
        int lftmx=height[l];
        int rhtmx=height[r];

        int res=0;

        while(l<r){
            if(lftmx<rhtmx){
                l++;
                lftmx=Math.max(lftmx,height[l]);
                res+=lftmx-height[l];
            }
            else{
                r--;
                rhtmx=Math.max(rhtmx,height[r]);
                res+=rhtmx-height[r];
            }
        }

        return res;
    }
}
