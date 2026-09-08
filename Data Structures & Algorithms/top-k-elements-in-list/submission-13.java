class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map =new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] bucket=new List[nums.length+1];

        for(int num:map.keySet()){
            int freq=map.get(num);

            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        int[] res=new int[k];
        int idx=0;

        for(int f=bucket.length-1;f>0;f--){
            if(bucket[f]!=null){
                for(int num:bucket[f]){
                    res[idx++]=num;
                    if(idx==k)return res;
                }
            }
        }

        return new int[]{};
    }
}
