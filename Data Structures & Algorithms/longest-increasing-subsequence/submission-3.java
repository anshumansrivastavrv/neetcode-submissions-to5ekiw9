class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails=new int[nums.length];
        int size=0;

        for(int num:nums){
            int l=0;
            int r=size;

            while(l<r){
                int mid=l+(r-l)/2;

                if(tails[mid]<num)l=mid+1;
                else r=mid;
            }

            tails[l]=num;

            if(l==size)size++;
        }

        return size;
    }
}