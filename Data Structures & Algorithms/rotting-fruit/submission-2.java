class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int row=grid.length;
        int col=grid[0].length;
        int fresh=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1)fresh++;
            }
        }

        if(fresh==0)return 0;

        int time=0;
        
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            boolean isRotten=false;

            int size=q.size();

            for(int i=0;i<size;i++){
                int[] node=q.poll();
                int ro=node[0];
                int co=node[1];

                for(int[] d:dir){
                    int r1=ro+d[0];
                    int c1=co+d[1];

                    if(r1<0 || c1<0 ||r1>=row ||c1>=col)continue;

                    if(grid[r1][c1]==1){
                        grid[r1][c1]=2;
                        fresh--;

                        q.add(new int[]{r1,c1});

                        isRotten=true;
                    }
                }
            }

            if(isRotten)time++;
        }

        return (fresh==0)?time:-1;
    }
}
