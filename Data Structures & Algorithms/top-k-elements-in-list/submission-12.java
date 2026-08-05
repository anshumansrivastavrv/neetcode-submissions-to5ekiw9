class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(int num:map.keySet()){
            int freq=map.get(num);
            if(bucket[freq]==null)bucket[freq]=new ArrayList<>();
            bucket[freq].add(num);
        }

        int[] res = new int[k];
        int idx=0;

        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int n:bucket[i]){
                    res[idx++]=n;
                    if(idx==k)return res;
                }
            }
        }

        return res;
    }
}
