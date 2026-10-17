class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<=1)return nums[0];

        return Math.max(func(nums,0,n-1),func(nums,1,n));
    }

    private int func(int[] nums,int x,int y){
        int prev2=0;
        int prev1=0;

        for(int i=x;i<y;i++){
            int curr=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}