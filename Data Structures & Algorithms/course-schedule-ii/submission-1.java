class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<numCourses;i++)res.add(new ArrayList<>());

        for(int[] pre:prerequisites){
            res.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.add(i);
        }

        int[] ans=new int[numCourses];
        int idx=0;

        while(!q.isEmpty()){
            int node=q.poll();
            ans[idx++]=node;

            for(int n:res.get(node)){
                indegree[n]--;
                if(indegree[n]==0)q.add(n);
            }
        }

        if(numCourses==idx)return ans;
        return new int[0];
    }
}
