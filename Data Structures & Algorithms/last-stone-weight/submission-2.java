class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s:stones){
            pq.offer(-s);
        }

        while(pq.size()>1){
            int f=pq.poll();
            int s=pq.poll();
            if(s>f)pq.offer(f-s);
        }

        pq.offer(0);
        return Math.abs(pq.peek());
    }
}
