class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        int mxln=0;

        for(int i=0;i<n;i++){
            set.add(nums[i]); 
        }

        int len=0;

        for(int num:nums){
            if(!set.contains(num-1)){
                len=1;
                while(set.contains(num+len))len++;
            }
            mxln=Math.max(mxln,len);
        }
        return mxln;
    }
}
