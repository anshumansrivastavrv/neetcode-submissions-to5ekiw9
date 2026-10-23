class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++)set.add(nums[i]);

        int mxln=0;

        for(int num:set){
            int len=0;

            if(!set.contains(num-1)){
                while(set.contains(num+len))len++;
            }

            mxln=Math.max(mxln,len);
        }

        return mxln;
    }
}
