class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int[][] qs = new int[queries.length][2];

        for(int i=0;i<queries.length;i++){
            qs[i][0]=queries[i];
            qs[i][1]=i;
        }

        Arrays.sort(qs,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        int[] res=new int[queries.length];
        int i=0;

        for(int[] q:qs){
            int val=q[0];
            int oi=q[1];
            
            while(i<intervals.length && intervals[i][0]<=val){
                int left=intervals[i][0];
                int right=intervals[i][1];

                int size=right-left+1;

                pq.offer(new int[]{size,right});

                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1]<val)pq.poll();

            if(pq.isEmpty())res[oi]=-1;
            else res[oi]=pq.peek()[0];
        }

        return res;
    }
}
