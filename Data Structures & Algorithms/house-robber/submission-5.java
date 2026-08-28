class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev1=0;
        int prev2=0;

        for(int i=0;i<nums.length;i++){
            int curr=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}
