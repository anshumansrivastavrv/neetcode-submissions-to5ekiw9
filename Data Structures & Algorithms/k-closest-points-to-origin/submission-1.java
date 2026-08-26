class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(
            b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]
        ));

        int[][] res=new int[k][2];

        for(int[] point:points){
            pq.offer(point);
            if(pq.size()>k)pq.poll();
        }

        int idx=0;

        while(!pq.isEmpty()){
            res[idx++]=pq.poll();
        }

        return res;
    }
}
