class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int max=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                max=Math.max(max,dfs(grid,i,j));
            }
        }

        return max;
    }

    private int dfs(int[][] grid,int i,int j){
        int row=grid.length;
        int col=grid[0].length;

        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]==0)return 0;

        grid[i][j]=0;

        int ar=1;
        ar+=dfs(grid,i+1,j);
        ar+=dfs(grid,i,j+1);
        ar+=dfs(grid,i-1,j);
        ar+=dfs(grid,i,j-1);

        return ar;
    }
}
