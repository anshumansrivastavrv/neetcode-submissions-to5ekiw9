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

    private int dfs(int[][] grid,int r,int c){
        int m=grid.length;
        int n=grid[0].length;
        int ar=1;

        if(r<0||c<0||r>=m || c>=n || grid[r][c]==0)return 0;

        grid[r][c]=0;

        ar+=dfs(grid,r-1,c); 
        ar+=dfs(grid,r,c-1); 
        ar+=dfs(grid,r+1,c); 
        ar+=dfs(grid,r,c+1); 

        return ar;       
    }
}
